package com.cryptascreen.sdk.http;

import com.cryptascreen.sdk.CryptaScreenConfig;
import com.cryptascreen.sdk.CryptaScreenException;
import com.cryptascreen.sdk.QuotaExceededException;
import com.cryptascreen.sdk.RateLimitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/** Attempt counts and delays, asserted on the number of attempts (not on the exception thrown). */
@DisplayName("RetryHandler: which statuses are transient, and the delay between attempts")
class RetryDelayTest {

    private static RetryHandler handler(int max, long baseMs) {
        return new RetryHandler(builder().maxRetries(max).retryBaseDelay(Duration.ofMillis(baseMs)).build());
    }

    private static CryptaScreenConfig.Builder builder() {
        // the Builder's constructor is package-private by design; go through CryptaScreen
        return TestConfigs.builder();
    }

    private static int attempts(int status, int max) {
        AtomicInteger n = new AtomicInteger();
        assertThrows(CryptaScreenException.class, () -> handler(max, 1).executeWithRetry(() -> {
            n.incrementAndGet();
            throw new CryptaScreenException("boom", status, null, null, Duration.ZERO);
        }));
        return n.get();
    }

    @Test
    void notImplemented501IsRetriedLikeAnyOther5xx() {
        assertEquals(4, attempts(501, 3));
    }

    @Test
    void permanentStatusesAreTriedOnce() {
        for (int s : new int[] {400, 401, 402, 403, 404}) {
            assertEquals(1, attempts(s, 3), "status " + s);
        }
    }

    @Test
    void quotaIsTriedOnce() {
        AtomicInteger n = new AtomicInteger();
        assertThrows(QuotaExceededException.class, () -> handler(3, 1).executeWithRetry(() -> {
            n.incrementAndGet();
            throw new QuotaExceededException("cap", null, null, null);
        }));
        assertEquals(1, n.get());
    }

    @Test
    void delayIsRetryAfterElseExponentialCappedAt30s() {
        RetryHandler h = handler(10, 1000);
        CryptaScreenException plain = new CryptaScreenException("x", 503, null, null);
        assertEquals(Duration.ofSeconds(1), h.computeDelay(plain, 0));
        assertEquals(Duration.ofSeconds(2), h.computeDelay(plain, 1));
        assertEquals(Duration.ofSeconds(4), h.computeDelay(plain, 2));
        assertEquals(Duration.ofSeconds(30), h.computeDelay(plain, 5));
        assertEquals(Duration.ofSeconds(30), h.computeDelay(plain, 9));
        CryptaScreenException withHeader = new CryptaScreenException("x", 503, null, null, Duration.ofSeconds(7));
        assertEquals(Duration.ofSeconds(7), h.computeDelay(withHeader, 3));
        RateLimitException rl = new RateLimitException(Instant.now(), 60_000, null, null);
        assertEquals(Duration.ofSeconds(1), h.computeDelay(rl, 0), "a non-integer Retry-After falls back to backoff");
    }

    @Test
    void retryAfterParsingIsParseIntLike() {
        assertEquals(Duration.ofSeconds(5), HttpClient.parseRetryAfter("5"));
        assertEquals(Duration.ofSeconds(5), HttpClient.parseRetryAfter("5.9"));
        assertEquals(Duration.ZERO, HttpClient.parseRetryAfter("0"));
        assertNull(HttpClient.parseRetryAfter("Wed, 21 Oct 2026 07:28:00 GMT"));
        assertNull(HttpClient.parseRetryAfter(null));
    }
}
