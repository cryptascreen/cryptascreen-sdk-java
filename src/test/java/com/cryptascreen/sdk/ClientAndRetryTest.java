// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.cryptascreen.sdk.WireServer.Resp;
import com.cryptascreen.sdk.model.SanctionsStatusResponse;
import com.cryptascreen.sdk.model.ScreenAddressRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Client construction, error mapping and the retry policy (same as @cryptascreen/sdk)")
class ClientAndRetryTest {

    private static final String OK_STATUS = "{\"total_active\":3,\"by_source\":{\"OFAC_SDN\":3},\"last_checked\":\"t\"}";

    private static CryptaScreen client(WireServer s, int retries) {
        return CryptaScreen.builder().apiKey("csk_test").baseUrl(s.baseUrl()).maxRetries(retries)
                .retryBaseDelay(Duration.ofMillis(1)).build();
    }

    // ---- construction ---------------------------------------------------------------------------------------

    @Test
    void apiKeyIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> CryptaScreen.builder().build());
        assertThrows(IllegalArgumentException.class, () -> CryptaScreen.builder().apiKey(" ").build());
    }

    @Test
    void oneHostRoutesByTheKeysDataRegion() {
        assertEquals("https://api.cryptascreen.com", CryptaScreen.builder().apiKey("csk_eu_synthetic").build().config().baseUrl());
        assertEquals("https://api.cryptascreen.com", CryptaScreen.builder().apiKey("csk_us_synthetic").build().config().baseUrl());
        assertEquals("http://localhost:1", CryptaScreen.builder().apiKey("k").baseUrl("http://localhost:1").build().config().baseUrl());
    }

    @Test
    void sendsAuthAndUserAgentHeaders() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, OK_STATUS))) {
            SanctionsStatusResponse r = client(s, 0).sanctions().getStatus();
            assertEquals(3L, r.total_active());
            assertEquals("csk_test", s.last().header("X-API-Key"));
            assertEquals("application/json", s.last().header("Accept"));
            assertTrue(s.last().header("User-Agent").startsWith("cryptascreen-sdk-java/"));
        }
    }

    // ---- error mapping ----------------------------------------------------------------------------------------

    private static CryptaScreenException fail(int status, String body) throws Exception {
        try (WireServer s = new WireServer(Resp.withHeader(status, body, "X-Request-Id", "rid-1"))) {
            return assertThrows(CryptaScreenException.class, () -> client(s, 0).sanctions().getStatus());
        }
    }

    @Test
    void mapsEveryStatusToItsClass() throws Exception {
        assertInstanceOf(AuthenticationException.class, fail(401, "{\"message\":\"bad key\"}"));
        NotFoundException nf = assertInstanceOf(NotFoundException.class, fail(404, "{\"resource\":\"Case\",\"id\":\"c1\"}"));
        assertEquals("Case not found: c1", nf.getMessage());
        PlanLimitException pl = assertInstanceOf(PlanLimitException.class,
                fail(403, "{\"error\":\"BULK_LIMIT_REACHED\",\"message\":\"m\",\"used\":1,\"limit\":1,\"plan\":\"STARTER\"}"));
        assertEquals("BULK_LIMIT_REACHED", pl.errorCode());
        assertEquals("STARTER", pl.plan());
        assertInstanceOf(SeatLimitReachedException.class, fail(403, "{\"error\":\"SEAT_LIMIT_REACHED\",\"message\":\"m\"}"));
        assertInstanceOf(ApiKeyLimitReachedException.class, fail(403, "{\"error\":\"API_KEY_LIMIT_REACHED\",\"message\":\"m\"}"));
        CryptaScreenException csrf = fail(403, "{\"error\":\"CSRF_TOKEN_INVALID\",\"message\":\"m\"}");
        assertEquals(CryptaScreenException.class, csrf.getClass());
        assertEquals("CSRF_TOKEN_INVALID", csrf.errorCode());
        ServicePausedException sp = assertInstanceOf(ServicePausedException.class,
                fail(402, "{\"code\":\"SERVICE_PAUSED\",\"message\":\"pay\",\"subscriptionStatus\":\"past_due\",\"billing_url\":\"u\",\"reason\":\"PAST_DUE\"}"));
        assertEquals("past_due", sp.subscriptionStatus());
        assertEquals("PAYMENT_REQUIRED", fail(402, "{\"message\":\"x\"}").errorCode());
        QuotaExceededException q = assertInstanceOf(QuotaExceededException.class,
                fail(429, "{\"error\":\"quota_exceeded\",\"message\":\"cap\",\"resets_at\":\"R\",\"upgrade_url\":\"U\"}"));
        assertEquals("R", q.resetsAt());
        assertEquals("U", q.upgradeUrl());
        assertEquals("QUOTA_EXCEEDED", q.errorCode());
        CryptaScreenException conflict = fail(409, "{\"code\":\"JOB_ALREADY_TERMINAL\",\"message\":\"done\"}");
        assertEquals("JOB_ALREADY_TERMINAL", conflict.errorCode());
        assertEquals(409, conflict.statusCode());
        assertEquals("UNKNOWN_ERROR", fail(418, "{}").errorCode());
        assertEquals("rid-1", fail(401, "{}").requestId());
    }

    @Test
    void validationErrorCarriesFieldErrorsAndBulkItems() throws Exception {
        String body = "{\"message\":\"bad item\",\"code\":\"INVALID_BULK_ITEMS\",\"field\":\"addresses\",\"items\":"
                + "[{\"index\":2,\"field\":\"addresses\",\"code\":\"INVALID_CHECKSUM\",\"message\":\"checksum\"}]}";
        ValidationException v = assertInstanceOf(ValidationException.class, fail(400, body));
        assertEquals("INVALID_BULK_ITEMS", v.validationCode());
        assertEquals(List.of("bad item"), v.fieldErrors().get("addresses"));
        assertEquals(List.of("checksum"), v.fieldErrors().get("addresses[2]"));
        assertEquals("INVALID_CHECKSUM", v.items().get(0).get("code").asText());
        assertEquals("VALIDATION_ERROR", v.errorCode());
    }

    // ---- retry policy -----------------------------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(ints = {429, 500, 501, 502, 503, 504})
    void retriesRateLimitAndEvery5xxThenSucceeds(int status) throws Exception {
        try (WireServer s = new WireServer(Resp.withHeader(status, "{}", "Retry-After", "0"), Resp.json(status, "{}"),
                Resp.json(200, OK_STATUS))) {
            client(s, 3).sanctions().getStatus();
            assertEquals(3, s.requests.size());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {400, 401, 402, 403, 404})
    void neverRetriesClientErrors(int status) throws Exception {
        try (WireServer s = new WireServer(Resp.json(status, "{}"))) {
            assertThrows(CryptaScreenException.class, () -> client(s, 3).sanctions().getStatus());
            assertEquals(1, s.requests.size());
        }
    }

    @Test
    void quotaExceededIsNeverRetried() throws Exception {
        try (WireServer s = new WireServer(Resp.json(429, "{\"error\":\"quota_exceeded\"}"))) {
            assertThrows(QuotaExceededException.class, () -> client(s, 3).sanctions().getStatus());
            assertEquals(1, s.requests.size());
        }
        try (WireServer s = new WireServer(Resp.json(429, "{\"code\":\"QUOTA_EXCEEDED\"}"))) {
            assertThrows(QuotaExceededException.class, () -> client(s, 3).sanctions().getStatus());
            assertEquals(1, s.requests.size());
        }
    }

    @Test
    void givesUpAfterMaxRetries() throws Exception {
        try (WireServer s = new WireServer(Resp.withHeader(429, "{}", "Retry-After", "0"))) {
            RateLimitException e = assertThrows(RateLimitException.class, () -> client(s, 2).sanctions().getStatus());
            assertEquals(3, s.requests.size());
            assertEquals(0L, e.retryAfterMs());
            assertEquals("RATE_LIMIT_EXCEEDED", e.errorCode());
        }
        try (WireServer s = new WireServer(Resp.json(503, "{\"message\":\"down\"}"))) {
            CryptaScreenException e = assertThrows(CryptaScreenException.class, () -> client(s, 2).sanctions().getStatus());
            assertEquals(3, s.requests.size());
            assertEquals(503, e.statusCode());
        }
    }

    @Test
    void rateLimitWithoutHeaderReportsSixtySeconds() throws Exception {
        try (WireServer s = new WireServer(Resp.json(429, "{}"))) {
            RateLimitException e = assertThrows(RateLimitException.class, () -> client(s, 0).sanctions().getStatus());
            assertEquals(60_000L, e.retryAfterMs());
        }
    }

    @Test
    void connectionFailureIsUnknownErrorStatusZeroAndNotRetried() {
        CryptaScreen c = CryptaScreen.builder().apiKey("k").baseUrl("http://127.0.0.1:1").maxRetries(3)
                .retryBaseDelay(Duration.ofMillis(1)).build();
        CryptaScreenException e = assertThrows(CryptaScreenException.class, () -> c.sanctions().getStatus());
        assertEquals(0, e.statusCode());
        assertEquals("UNKNOWN_ERROR", e.errorCode());
    }

    @Test
    void asyncVariantsFollowTheSamePolicy() throws Exception {
        try (WireServer s = new WireServer(Resp.json(500, "{}"), Resp.json(200, OK_STATUS))) {
            client(s, 3).sanctions().getStatusAsync().get();
            assertEquals(2, s.requests.size());
        }
        try (WireServer s = new WireServer(Resp.json(401, "{}"))) {
            var ex = assertThrows(java.util.concurrent.ExecutionException.class, () -> client(s, 3).sanctions().getStatusAsync().get());
            assertInstanceOf(AuthenticationException.class, ex.getCause());
            assertEquals(1, s.requests.size());
        }
    }

    @Test
    void screenAddressSendsTheCamelCaseBody() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            client(s, 0).screening().screenAddress(ScreenAddressRequest.builder().address("0xab").chain("ethereum").forceRefresh(true).build());
            assertEquals("{\"address\":\"0xab\",\"chain\":\"ethereum\",\"forceRefresh\":true}", s.last().body());
            assertEquals("POST", s.last().method());
            assertEquals("/api/v1/screen/address", s.last().rawPath());
        }
    }
}
