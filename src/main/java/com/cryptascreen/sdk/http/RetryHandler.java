package com.cryptascreen.sdk.http;

import com.cryptascreen.sdk.CryptaScreenConfig;
import com.cryptascreen.sdk.CryptaScreenException;
import com.cryptascreen.sdk.QuotaExceededException;
import com.cryptascreen.sdk.RateLimitException;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Retry policy with exponential backoff - the same as {@code @cryptascreen/sdk}.
 *
 * <p>Retried: 429 rate limit and every 5xx (501 included, as in the TypeScript SDK), up to {@code maxRetries}.
 * Never retried: 400, 401, 402, 403, 404, 429 {@code quota_exceeded}, and failures without an HTTP response.
 * Delay: the response's {@code Retry-After} (integer seconds) when present, otherwise {@code 1s * 2^attempt}, capped at
 * 30s.</p>
 */
public final class RetryHandler {

    private static final long MAX_DELAY_MS = 30_000;

    private final int maxRetries;
    private final Duration baseDelay;
    private final boolean autoRetryRateLimit;

    /**
     * Creates a RetryHandler from the given configuration.
     *
     * @param config the SDK configuration
     */
    public RetryHandler(CryptaScreenConfig config) {
        this.maxRetries = config.maxRetries();
        this.baseDelay = config.retryBaseDelay();
        this.autoRetryRateLimit = config.autoRetryRateLimit();
    }

    /**
     * Executes the given operation with retry logic.
     *
     * @param <T>       the result type
     * @param operation the operation to execute
     * @return the result
     * @throws CryptaScreenException if retries are exhausted or the error is not retryable
     */
    public <T> T executeWithRetry(Supplier<T> operation) {
        for (int attempt = 0; ; attempt++) {
            try {
                return operation.get();
            } catch (CryptaScreenException e) {
                if (!shouldRetry(e, attempt)) {
                    throw e;
                }
                sleep(computeDelay(e, attempt));
            }
        }
    }

    /**
     * Executes the given async operation with retry logic.
     *
     * @param <T>       the result type
     * @param operation the async operation to execute
     * @return a CompletableFuture with the result
     */
    public <T> CompletableFuture<T> executeWithRetryAsync(Supplier<CompletableFuture<T>> operation) {
        return executeWithRetryAsync(operation, 0);
    }

    private <T> CompletableFuture<T> executeWithRetryAsync(Supplier<CompletableFuture<T>> operation, int attempt) {
        return operation.get().exceptionallyCompose(throwable -> {
            Throwable cause = throwable instanceof java.util.concurrent.CompletionException
                    ? throwable.getCause() : throwable;
            if (cause instanceof CryptaScreenException e && shouldRetry(e, attempt)) {
                Duration delay = computeDelay(e, attempt);
                return CompletableFuture.supplyAsync(() -> null,
                                CompletableFuture.delayedExecutor(delay.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS))
                        .thenCompose(ignored -> executeWithRetryAsync(operation, attempt + 1));
            }
            return CompletableFuture.failedFuture(cause);
        });
    }

    boolean shouldRetry(CryptaScreenException e, int attempt) {
        if (attempt >= maxRetries) {
            return false;
        }
        if (e instanceof QuotaExceededException) {
            return false;
        }
        if (e instanceof RateLimitException) {
            return autoRetryRateLimit;
        }
        return e.statusCode() >= 500;
    }

    Duration computeDelay(CryptaScreenException e, int attempt) {
        if (e.retryAfter() != null) {
            return e.retryAfter();
        }
        long delayMs = baseDelay.toMillis() * (1L << Math.min(attempt, 20));
        return Duration.ofMillis(Math.min(delayMs, MAX_DELAY_MS));
    }

    private void sleep(Duration duration) {
        try {
            Thread.sleep(Math.max(0, duration.toMillis()));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new CryptaScreenException("Request interrupted during retry backoff", ie);
        }
    }
}
