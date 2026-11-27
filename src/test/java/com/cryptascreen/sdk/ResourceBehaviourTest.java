// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.cryptascreen.sdk.WireServer.Resp;
import com.cryptascreen.sdk.model.*;
import com.cryptascreen.sdk.resource.PathSegments;
import com.cryptascreen.sdk.resource.ScreeningResource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Special methods of @cryptascreen/sdk: forced flags, idempotency, paging normalisation, validation")
class ResourceBehaviourTest {

    private static final ObjectMapper M = new ObjectMapper();
    private static final String ADDR = "0x" + "ab".repeat(20);

    private static CryptaScreen client(WireServer s) {
        return CryptaScreen.builder().apiKey("csk_test").baseUrl(s.baseUrl()).maxRetries(0).build();
    }

    private static BulkScreeningRequest bulk(Boolean async) {
        return BulkScreeningRequest.builder().addresses(List.of(ADDR)).chains(List.of("ethereum")).async(async).build();
    }

    @Test
    void bulkSyncForcesAsyncFalseAndAsyncJobForcesTrueWithIdempotencyKey() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "[]"), Resp.json(200, "{\"jobId\":\"j\",\"status\":\"PENDING\"}"),
                Resp.json(200, "{\"jobId\":\"j\",\"status\":\"PENDING\"}"))) {
            CryptaScreen c = client(s);
            c.screening().screenBulk(bulk(true));
            assertFalse(M.readTree(s.requests.get(0).body()).get("async").asBoolean());
            assertNull(s.requests.get(0).header("Idempotency-Key"));
            c.screening().screenBulkAsync(bulk(false), "idem-1");
            assertTrue(M.readTree(s.requests.get(1).body()).get("async").asBoolean());
            assertEquals("idem-1", s.requests.get(1).header("Idempotency-Key"));
            c.screening().screenBulkAsync(bulk(null));
            assertEquals(36, s.requests.get(2).header("Idempotency-Key").length());
        }
    }

    @Test
    void bulkAsyncKeepsOneKeyAcrossRetries() throws Exception {
        try (WireServer s = new WireServer(Resp.json(503, "{}"), Resp.json(200, "{\"jobId\":\"j\"}"))) {
            CryptaScreen c = CryptaScreen.builder().apiKey("k").baseUrl(s.baseUrl()).maxRetries(2).retryBaseDelay(Duration.ofMillis(1)).build();
            c.screening().screenBulkAsync(bulk(null));
            assertEquals(2, s.requests.size());
            assertEquals(s.requests.get(0).header("Idempotency-Key"), s.requests.get(1).header("Idempotency-Key"));
        }
    }

    @Test
    void jobResultsNormalisesASpringPageAndDefaults() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{\"content\":[{\"address\":\"a\"}],\"number\":3,\"totalElements\":9,\"totalPages\":2}"),
                Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            ScreeningJobResultsPage p = c.screening().getJobResults("job-1", PageOptions.builder().page(3L).size(5L).build());
            assertEquals("job-1", p.jobId());
            assertEquals(3L, p.page());
            assertEquals(5L, p.size());
            assertEquals(9L, p.totalItems());
            assertEquals(2L, p.totalPages());
            assertEquals(1, p.items().size());
            assertEquals("page=3&size=5", s.requests.get(0).rawQuery());
            ScreeningJobResultsPage d = c.screening().getJobResults("job-1");
            assertEquals(List.of(), d.items());
            assertEquals(0L, d.page());
            assertEquals(100L, d.size());
            assertEquals(0L, d.totalItems());
            assertEquals(1L, d.totalPages());
        }
    }

    @Test
    void bulkAndWaitPollsUntilTerminalAndIgnoresUnknownStatuses() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{\"jobId\":\"j1\",\"status\":\"PENDING\"}"),
                Resp.json(200, "{\"jobId\":\"j1\",\"status\":\"PROCESSING\"}"), Resp.json(200, "{\"jobId\":\"j1\",\"status\":\"SOMETHING_NEW\"}"),
                Resp.json(200, "{\"jobId\":\"j1\",\"status\":\"COMPLETED\"}"))) {
            ScreeningJob job = client(s).screening().screenBulkAndWait(bulk(null), Duration.ofMillis(1), Duration.ofSeconds(5), null);
            assertEquals("COMPLETED", job.status());
            assertEquals(4, s.requests.size());
            assertEquals("POST", s.requests.get(0).method());
            assertEquals("/api/v1/screen/jobs/j1", s.requests.get(3).rawPath());
        }
    }

    @Test
    void bulkAndWaitTimesOut() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{\"jobId\":\"j1\",\"status\":\"PENDING\"}"))) {
            CryptaScreenException e = assertThrows(CryptaScreenException.class,
                    () -> client(s).screening().screenBulkAndWait(bulk(null), Duration.ofMillis(1), Duration.ofMillis(50), null));
            assertEquals("JOB_TIMEOUT", e.errorCode());
        }
    }

    @Test
    void queryParamsAreCamelCaseBooleansLowercaseNullsDropped() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            client(s).screening().getCounterparties("ethereum", ADDR,
                    WalletCounterpartyOptions.builder().page(1L).listedOnly(true).build());
            assertEquals("page=1&listedOnly=true", s.last().rawQuery());
        }
    }

    @Test
    void pathSegmentsAreUrlEncoded() throws Exception {
        assertEquals("a%2Fb%20c", PathSegments.encode("a/b c"));
        assertEquals("..%2F..%2Fadmin", PathSegments.encode("../../admin"));
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            client(s).cases().get("a/b c");
            assertEquals("/api/v1/cases/a%2Fb%20c", s.last().rawPath());
        }
    }

    @Test
    void nameScreenIdempotencyHeaderHistoryLimitAndAudit() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"), Resp.json(200, "[]"), Resp.json(200, "{}"), Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            c.names().screen(NameScreenRequest.builder().name("Test Name").build(), "k1");
            assertEquals("k1", s.last().header("Idempotency-Key"));
            c.names().history(null);
            assertEquals("limit=50", s.last().rawQuery());
            c.names().decisionAudit("csv");
            assertEquals("format=csv", s.last().rawQuery());
        }
    }

    @Test
    void acknowledgeTrimsTheNoteOrSendsAnEmptyObject() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            c.alerts().acknowledge("7", "  looked at it ");
            assertEquals("{\"note\":\"looked at it\"}", s.last().body());
            c.alerts().acknowledge("7", "   ");
            assertEquals("{}", s.last().body());
            c.alerts().acknowledge("7");
            assertEquals("{}", s.last().body());
            assertEquals("/api/v1/alerts/7/acknowledge", s.last().rawPath());
        }
    }

    @Test
    void assigneeNullAndLinkEvaluationBodies() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            c.cases().setAssignee("c1", null);
            assertEquals("{\"userId\":null}", s.last().body());
            c.cases().setAssignee("c1", 5L);
            assertEquals("{\"userId\":5}", s.last().body());
            c.cases().linkEvaluation("c1", "ev");
            assertEquals("{\"evaluationId\":\"ev\"}", s.last().body());
        }
    }

    @Test
    void dac8OldShapeIsRejectedClientSideWithoutARequest() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            ValidationException e = assertThrows(ValidationException.class,
                    () -> client(s).compliance().generateDac8Report(Dac8ReportRequest.builder().build()));
            assertEquals("DAC8_REQUEST_SHAPE", e.validationCode());
            assertEquals(java.util.Set.of("taxYear", "jurisdiction", "operator", "users"), e.fieldErrors().keySet());
            assertTrue(s.requests.isEmpty());
        }
    }

    @Test
    void vaspInfoUnavailableAndEntityLabels() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{\"not\":\"a list\"}"))) {
            CryptaScreen c = client(s);
            CryptaScreenException e = assertThrows(CryptaScreenException.class, () -> c.intelligence().getVaspInfo("v1"));
            assertEquals("ENDPOINT_NOT_AVAILABLE", e.errorCode());
            assertEquals(0, e.statusCode());
            assertTrue(s.requests.isEmpty());
            assertEquals(List.of(), c.intelligence().getEntityLabels("ethereum", ADDR));
            assertNull(c.intelligence().getEntityLabel(ADDR, "ethereum"));
            assertEquals("/api/v1/intelligence/entity/ethereum/" + ADDR, s.last().rawPath());
        }
    }

    @Test
    void webhookManagementThatNeedsASignedInUserIsNotOffered() {
        for (java.lang.reflect.Method m : com.cryptascreen.sdk.resource.WebhooksResource.class.getMethods()) {
            assertFalse(java.util.Set.of("create", "createAsync", "delete", "deleteAsync", "test", "testAsync").contains(m.getName()), m.getName());
        }
    }

    @Test
    void screeningHelpers() {
        assertTrue(ScreeningResource.isTerminalJobStatus("CANCELLED"));
        assertFalse(ScreeningResource.isTerminalJobStatus("SOMETHING_NEW"));
        assertFalse(ScreeningResource.isTerminalJobStatus(null));
        assertEquals(36, ScreeningResource.generateIdempotencyKey().length());
    }

    @Test
    void screenAddressRequiresChain() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            for (String chain : new String[] {null, "", "   "}) {
                ValidationException e = assertThrows(ValidationException.class, () -> c.screening()
                        .screenAddress(ScreenAddressRequest.builder().address(ADDR).chain(chain).build()));
                assertEquals("CHAIN_REQUIRED", e.validationCode());
                assertEquals(400, e.statusCode());
            }
            var f = c.screening().screenAddressAsync(ScreenAddressRequest.builder().address(ADDR).build());
            var ex = assertThrows(java.util.concurrent.ExecutionException.class, f::get);
            assertEquals("CHAIN_REQUIRED", ((ValidationException) ex.getCause()).validationCode());
            assertTrue(s.requests.isEmpty(), "nothing is sent without a chain");
        }
    }

    @Test
    void bulkRequiresChainPerItem() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "[]"))) {
            CryptaScreen c = client(s);
            var two = List.of(ADDR, ADDR);
            List<List<String>> bad = new java.util.ArrayList<>();
            bad.add(null);
            bad.add(List.of());
            bad.add(List.of(""));
            bad.add(List.of("ethereum", " "));
            for (List<String> chains : bad) {
                BulkScreeningRequest r = BulkScreeningRequest.builder().addresses(two).chains(chains).build();
                assertEquals("CHAIN_REQUIRED", assertThrows(ValidationException.class, () -> c.screening().screenBulk(r)).validationCode());
                assertEquals("CHAIN_REQUIRED", assertThrows(ValidationException.class, () -> c.screening().screenBulkAsync(r)).validationCode());
                assertEquals("CHAIN_REQUIRED", assertThrows(ValidationException.class,
                        () -> c.screening().screenBulkAndWait(r, Duration.ofMillis(1), Duration.ofMillis(10), null)).validationCode());
            }
            assertTrue(s.requests.isEmpty(), "nothing is sent without a chain");
        }
    }

    @Test
    void serverChainRequiredIsMappedAndExplicitChainIsSentUnchanged() throws Exception {
        String body = "{\"error\":\"VALIDATION_ERROR\",\"code\":\"CHAIN_REQUIRED\",\"field\":\"chain\","
                + "\"message\":\"chain is required: an address does not identify its network\"}";
        try (WireServer s = new WireServer(Resp.json(400, body), Resp.json(200, "{}"), Resp.json(200, "[]"))) {
            CryptaScreen c = client(s);
            ValidationException e = assertThrows(ValidationException.class, () -> c.screening()
                    .screenAddress(ScreenAddressRequest.builder().address(ADDR).chain("ethereum").build()));
            assertEquals("CHAIN_REQUIRED", e.validationCode());
            c.screening().screenAddress(ScreenAddressRequest.builder().address(ADDR).chain("polygon").build());
            assertEquals("polygon", M.readTree(s.requests.get(1).body()).get("chain").asText());
            c.screening().screenBulk(BulkScreeningRequest.builder().addresses(List.of(ADDR, ADDR)).chains(List.of("polygon", "arb")).build());
            assertEquals("arb", M.readTree(s.requests.get(2).body()).get("chains").get(1).asText());
        }
    }
}
