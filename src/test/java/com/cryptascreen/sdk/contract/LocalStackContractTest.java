package com.cryptascreen.sdk.contract;

import com.cryptascreen.sdk.*;
import com.cryptascreen.sdk.model.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contract tests against a LOCAL two-region CryptaScreen stack (never production). Needs {@code CS_CONTRACT_US},
 * {@code CS_CONTRACT_EU}, {@code CS_CONTRACT_KEY_US}, {@code CS_CONTRACT_KEY_EU}, {@code CS_CONTRACT_KEY_RL}; skipped when
 * absent. Data: the local stack's SYNTHETIC OFAC-SDN-shaped list only (positive-control address 0xc501...0001, listed name
 * "Synthia00003 QWERTYSON 00003"); clean addresses are well-formed placeholders. No real client data.
 */
@Tag("contract")
@DisplayName("Contract: SDK against the local two-region stack")
class LocalStackContractTest {

    private static final String LISTED = "0xc501000000000000000000000000000000000001";
    private static final String CLEAN = "0x1111111111111111111111111111111111111111";
    private static final String CLEAN2 = "0x2222222222222222222222222222222222222222";
    private static final String LISTED_NAME = "Synthia00003 QWERTYSON 00003";

    private static String env(String n) {
        String v = System.getenv(n);
        Assumptions.assumeTrue(v != null && !v.isBlank(), "no local stack (" + n + " not set)");
        return v;
    }

    private static CryptaScreen client(String region) {
        return CryptaScreen.builder().apiKey(env("CS_CONTRACT_KEY_" + region.toUpperCase()))
                .baseUrl(env("CS_CONTRACT_" + region.toUpperCase())).maxRetries(0).build();
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void listedAddressHitsTheSeededEntryAndCleanOneDoesNot(String region) {
        CryptaScreen c = client(region);
        ScreeningResponse hit = c.screening().screenAddress(ScreenAddressRequest.builder().address(LISTED).chain("ethereum").build());
        assertEquals(Boolean.TRUE, hit.sanctionsMatch());
        assertEquals("CRITICAL", hit.riskLevel());
        assertNotNull(hit.evaluationId());
        assertEquals(Boolean.TRUE, c.sanctions().check("ethereum", LISTED).match());
        ScreeningResponse clean = c.screening().screenAddress(ScreenAddressRequest.builder().address(CLEAN).chain("ethereum").build());
        assertEquals(Boolean.FALSE, clean.sanctionsMatch());
        assertNotEquals("CRITICAL", clean.riskLevel());
        assertEquals(Boolean.FALSE, c.sanctions().check("ethereum", CLEAN).match());
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void historyEvaluationsAndExposureSections(String region) {
        CryptaScreen c = client(region);
        ScreeningResponse r = c.screening().screenAddress(ScreenAddressRequest.builder().address(LISTED).chain("ethereum").build());
        assertNotNull(c.screening().getHistory("ethereum", LISTED).address());
        c.screening().listEvaluations("ethereum", LISTED, PageOptions.builder().page(0L).size(5L).build());
        assertEquals(r.evaluationId(), c.screening().getEvaluation(r.evaluationId()).evaluationId());
        c.screening().getExposurePaths("ethereum", LISTED, WalletSectionOptions.builder().days(30L).build());
        c.screening().getCounterparties("ethereum", LISTED, WalletCounterpartyOptions.builder().page(0L).size(5L).build());
        c.screening().getTransactions("ethereum", LISTED, WalletTransactionOptions.builder().page(0L).size(5L).build());
        assertTrue(c.sanctions().getStatus().total_active() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void bulkSyncKeepsOrderAndAsyncJobCompletes(String region) {
        CryptaScreen c = client(region);
        List<ScreeningResponse> res = c.screening().screenBulk(
                BulkScreeningRequest.builder().addresses(List.of(LISTED, CLEAN, CLEAN2)).chains(List.of("ethereum", "ethereum", "ethereum")).build());
        assertEquals(3, res.size());
        assertEquals(List.of(true, false, false), res.stream().map(ScreeningResponse::sanctionsMatch).toList());
        ScreeningJob job = c.screening().screenBulkAndWait(
                BulkScreeningRequest.builder().addresses(List.of(LISTED, CLEAN)).chains(List.of("ethereum", "ethereum")).build(),
                Duration.ofMillis(500), Duration.ofSeconds(60), null);
        assertTrue(List.of("COMPLETED", "PARTIAL").contains(job.status()), job.status());
        ScreeningJobResultsPage page = c.screening().getJobResults(job.jobId(), PageOptions.builder().page(0L).size(10L).build());
        assertEquals(2L, page.totalItems());
        assertEquals(2, page.items().size());
        assertTrue(c.screening().listJobs().stream().anyMatch(j -> job.jobId().equals(j.jobId())));
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void nameScreeningListedAndClean(String region) {
        CryptaScreen c = client(region);
        NameScreenResponse hit = c.names().screen(NameScreenRequest.builder().name(LISTED_NAME).type("PERSON").build());
        assertTrue(List.of("REVIEW", "CONFIRMED_MATCH").contains(hit.outcome()), hit.outcome());
        NameScreenResponse clean = c.names().screen(NameScreenRequest.builder().name("Unrelated Person Zq-contract").type("PERSON").build());
        assertEquals("CLEAR", clean.outcome());
        assertEquals(hit.screeningId(), c.names().get(hit.screeningId()).screeningId());
        assertTrue(c.names().history(20).stream().anyMatch(x -> hit.screeningId().equals(x.screeningId())));
    }

    // ---- error cases ---------------------------------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void wrongKeyIs401(String region) {
        CryptaScreen c = CryptaScreen.builder().apiKey("csk_" + region + "_ffffffffffffffffffffffffffffffff")
                .baseUrl(env("CS_CONTRACT_" + region.toUpperCase())).maxRetries(0).build();
        AuthenticationException e = assertThrows(AuthenticationException.class, () -> c.sanctions().getStatus());
        assertEquals(401, e.statusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "eu"})
    void invalidInputIs400(String region) {
        CryptaScreen c = client(region);
        ValidationException chain = assertThrows(ValidationException.class,
                () -> c.screening().screenAddress(ScreenAddressRequest.builder().address(LISTED).chain("no-such-chain").build()));
        assertEquals(400, chain.statusCode());
        assertEquals("UNKNOWN_CHAIN", chain.validationCode());
        ValidationException addr = assertThrows(ValidationException.class,
                () -> c.screening().screenAddress(ScreenAddressRequest.builder().address("0x123").chain("ethereum").build()));
        assertTrue(List.of("INVALID_ADDRESS_FORMAT", "INVALID_CHECKSUM").contains(addr.validationCode()), addr.validationCode());
        ValidationException bulk = assertThrows(ValidationException.class, () -> c.screening().screenBulk(
                BulkScreeningRequest.builder().addresses(List.of(CLEAN, "0xbad", "0xbad2")).chains(List.of("ethereum", "ethereum", "ethereum")).build()));
        assertEquals("INVALID_BULK_ITEMS", bulk.validationCode());
        assertEquals(2, bulk.items().size());
        assertTrue(bulk.fieldErrors().keySet().containsAll(List.of("address[1]", "address[2]"))); // bulk item keys use the item field name
    }

    @Test
    void unknownJobIsATypedError() {
        CryptaScreen c = client("us");
        CryptaScreenException e = assertThrows(CryptaScreenException.class,
                () -> c.screening().pollJob("00000000-0000-4000-8000-000000000000"));
        assertTrue(e.statusCode() == 400 || e.statusCode() == 404, "status " + e.statusCode());
    }

    @Test
    void rateLimitIsRaisedAfterTheKeyBudgetIsUsed() throws Exception {
        CryptaScreen c = CryptaScreen.builder().apiKey(env("CS_CONTRACT_KEY_RL")).baseUrl(env("CS_CONTRACT_US")).maxRetries(0).build();
        ExecutorService pool = Executors.newFixedThreadPool(16);
        List<Future<Boolean>> results = new ArrayList<>();
        for (int i = 0; i < 1300; i++) {
            results.add(pool.submit(() -> {
                try {
                    c.sanctions().getStatus();
                    return false;
                } catch (RateLimitException e) {
                    assertEquals(429, e.statusCode());
                    assertEquals("RATE_LIMIT_EXCEEDED", e.errorCode());
                    return true;
                }
            }));
        }
        boolean saw429 = false;
        for (Future<Boolean> f : results) {
            saw429 |= f.get();
        }
        pool.shutdown();
        assertTrue(saw429, "no 429 after 1300 requests");
    }

    @Test
    void webhookEndpointsAreReadableWithAnApiKey() {
        assertNotNull(client("us").webhooks().list());
    }
}
