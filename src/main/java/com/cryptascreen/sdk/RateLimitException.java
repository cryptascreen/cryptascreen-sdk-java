package com.cryptascreen.sdk;

import java.time.Duration;
import java.time.Instant;

/**
 * Thrown on a 429 rate limit (after the automatic retries). NOT the monthly quota: see {@link QuotaExceededException}.
 */
public class RateLimitException extends CryptaScreenException {

    private final Instant resetAt;
    private final long retryAfterMs;

    /**
     * Creates the exception.
     *
     * @param resetAt      when the limit is expected to reset (now + Retry-After)
     * @param retryAfterMs milliseconds to wait (Retry-After seconds, default 60000)
     * @param requestId    the request id
     */
    public RateLimitException(Instant resetAt, long retryAfterMs, String requestId) {
        this(resetAt, retryAfterMs, requestId, Duration.ofMillis(retryAfterMs));
    }

    /**
     * Creates the exception with the parsed {@code Retry-After} header (null when absent or not an integer: the retry
     * loop then falls back to exponential backoff, as the TypeScript SDK does).
     *
     * @param resetAt           when the limit is expected to reset
     * @param retryAfterMs      milliseconds to report
     * @param requestId         the request id
     * @param retryAfterHeader  the parsed header or null
     */
    public RateLimitException(Instant resetAt, long retryAfterMs, String requestId, Duration retryAfterHeader) {
        super("Rate limit exceeded. Resets at " + resetAt, 429, "RATE_LIMIT_EXCEEDED", requestId, retryAfterHeader);
        this.resetAt = resetAt;
        this.retryAfterMs = retryAfterMs;
    }

    /** Returns when the limit is expected to reset. */
    public Instant resetAt() {
        return resetAt;
    }

    /** Returns the milliseconds to wait before retrying. */
    public long retryAfterMs() {
        return retryAfterMs;
    }
}
