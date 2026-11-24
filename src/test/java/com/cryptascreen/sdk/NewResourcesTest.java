package com.cryptascreen.sdk;

import com.cryptascreen.sdk.WireServer.Resp;
import com.cryptascreen.sdk.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Account, capabilities, settings (read) and monitoring resources; webhook read models")
class NewResourcesTest {

    private static final ObjectMapper M = new ObjectMapper();
    private static final String ADDR = "0x" + "ab".repeat(20);

    private static CryptaScreen client(WireServer s) {
        return CryptaScreen.builder().apiKey("csk_test").baseUrl(s.baseUrl()).maxRetries(0).build();
    }

    @Test
    void authMeAndCapabilitiesAreTyped() throws Exception {
        try (WireServer s = new WireServer(
                Resp.json(200, "{\"email\":\"a@example.test\",\"authMethod\":\"API_KEY\",\"tenantId\":\"9\",\"tier\":\"PROFESSIONAL\",\"unknownNew\":1}"),
                Resp.json(200, "{\"chains\":[{\"chain\":\"ethereum\",\"displayName\":\"Ethereum\",\"onChain\":\"COVERED\",\"sanctionsScreenable\":true}],"
                        + "\"layers\":[{\"layer\":\"SANCTIONS\",\"state\":\"ON\",\"status\":\"COMPLETE\",\"sources\":[\"OFAC_SDN\"]}]}"))) {
            CryptaScreen c = client(s);
            AuthMe me = c.auth().me();
            assertEquals("API_KEY", me.authMethod());
            assertEquals("9", me.tenantId());
            Capabilities caps = c.capabilities().get();
            assertEquals("COVERED", caps.chains().get(0).onChain());
            assertEquals(List.of("OFAC_SDN"), caps.layers().get(0).sources());
            assertEquals("GET /api/v1/auth/me", s.requests.get(0).method() + " " + s.requests.get(0).rawPath());
            assertEquals("/api/v1/capabilities", s.requests.get(1).rawPath());
        }
    }

    @Test
    void settingsReadsAndLimitQuery() throws Exception {
        try (WireServer s = new WireServer(
                Resp.json(200, "{\"reviewAt\":40,\"blockAt\":70,\"source\":\"DEFAULT\",\"defaults\":{\"reviewAt\":40,\"blockAt\":70}}"),
                Resp.json(200, "{\"items\":[{\"actor\":\"user:1\",\"action\":\"SET\",\"current\":{\"reviewAt\":30,\"blockAt\":60}}]}"),
                Resp.json(200, "{\"items\":[]}"),
                Resp.json(200, "{\"items\":[]}"),
                Resp.json(200, "[{\"vendor\":\"CHAINALYSIS\",\"configured\":false}]"))) {
            CryptaScreen c = client(s);
            ScoreThresholdSettings t = c.settings().getScoreThresholds();
            assertEquals(40, t.reviewAt());
            assertEquals(70, t.defaults().blockAt());
            ScoreThresholdAuditPage page = c.settings().getScoreThresholdAudit(5);
            assertEquals("SET", page.items().get(0).action());
            assertEquals("limit=5", s.requests.get(1).rawQuery());
            c.settings().getNameListAudit();
            assertNull(s.requests.get(2).rawQuery());
            c.settings().getNameMatchingAudit(null);
            assertNull(s.requests.get(3).rawQuery());
            List<VendorKeyView> keys = c.settings().listVendorKeys();
            assertEquals("CHAINALYSIS", keys.get(0).vendor());
        }
    }

    @Test
    void monitoringWalletNameAndBreachCalls() throws Exception {
        try (WireServer s = new WireServer(
                Resp.json(200, "{\"id\":3,\"address\":\"" + ADDR + "\",\"chain\":\"ethereum\",\"label\":\"t\"}"),
                Resp.json(200, "{\"deleted\":true}"),
                Resp.json(201, "{\"id\":5}"),
                Resp.json(200, "{\"removed\":true}"),
                Resp.json(200, "{\"names\":[],\"wallets\":[],\"nameHits\":[{\"item_id\":1}]}"),
                Resp.json(200, "[{\"id\":1,\"severity\":\"HIGH\"}]"),
                Resp.json(200, "{\"unacknowledgedCount\":2,\"bySeverity\":{\"HIGH\":2},\"totalBreaches\":2}"),
                Resp.json(200, "{\"id\":1,\"acknowledgedAt\":\"2026-11-23T00:00:00Z\"}"))) {
            CryptaScreen c = client(s);
            MonitoredWallet w = c.monitoring().addWallet(AddMonitoredWalletRequest.builder().address(ADDR).chain("ethereum").label("t").build());
            assertEquals(3L, w.id());
            assertEquals("t", M.readTree(s.requests.get(0).body()).get("label").asText());
            assertTrue(c.monitoring().removeWallet("3").deleted());
            c.monitoring().addName(NameScreenRequest.builder().name("Test Name").build());
            assertEquals("Test Name", M.readTree(s.requests.get(2).body()).get("name").asText());
            assertTrue(c.monitoring().removeName("5").removed());
            MonitoringOverview ov = c.monitoring().getOverview();
            assertEquals(1, ov.nameHits().size());
            assertEquals("HIGH", c.monitoring().listBreaches().get(0).severity());
            BreachSummary sum = c.monitoring().getBreachSummary();
            assertEquals(2L, sum.bySeverity().get("HIGH"));
            assertNotNull(c.monitoring().acknowledgeBreach("1").acknowledgedAt());
            List<String> calls = s.requests.stream().map(r -> r.method() + " " + r.rawPath()).toList();
            assertEquals(List.of("POST /api/v1/monitoring/wallets", "DELETE /api/v1/monitoring/wallets/3",
                    "POST /api/v1/monitoring/names", "DELETE /api/v1/monitoring/names/5", "GET /api/v1/monitoring/overview",
                    "GET /api/v1/monitoring/breaches", "GET /api/v1/monitoring/breaches/summary",
                    "POST /api/v1/monitoring/breaches/1/acknowledge"), calls);
        }
    }

    @Test
    void idIsUrlEncodedAndADuplicateWalletIsAnError() throws Exception {
        try (WireServer s = new WireServer(Resp.json(400, "{\"error\":\"DUPLICATE\",\"message\":\"Wallet is already being monitored\"}"),
                Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            CryptaScreenException e = assertThrows(CryptaScreenException.class,
                    () -> c.monitoring().addWallet(AddMonitoredWalletRequest.builder().address(ADDR).chain("ethereum").build()));
            assertEquals(400, e.statusCode());
            c.monitoring().removeWallet("a/b");
            assertEquals("/api/v1/monitoring/wallets/a%2Fb", s.last().rawPath());
        }
    }

    @Test
    void asyncVariantsHitTheSameOperations() throws Exception {
        try (WireServer s = new WireServer(Resp.json(200, "{}"))) {
            CryptaScreen c = client(s);
            c.auth().meAsync().get();
            c.settings().getNameMatchingAuditAsync(3).get();
            c.monitoring().acknowledgeBreachAsync("4").get();
            assertEquals(List.of("/api/v1/auth/me", "/api/v1/settings/name-matching/audit", "/api/v1/monitoring/breaches/4/acknowledge"),
                    s.requests.stream().map(WireServer.Req::rawPath).toList());
            assertEquals("limit=3", s.requests.get(1).rawQuery());
        }
    }

    @Test
    void webhookReadModelsMatchTheApiAndManagementIsNotOffered() throws Exception {
        try (WireServer s = new WireServer(
                Resp.json(200, "[{\"id\":1,\"url\":\"https://example.test/h\",\"secret\":\"whsec_…ab12\",\"events\":[\"CRITICAL\"],\"isActive\":true,\"description\":\"d\",\"createdAt\":\"2026-11-23T00:00:00Z\"}]"),
                Resp.json(200, "[{\"id\":\"6f0c1c2e-0000-4000-8000-000000000001\",\"webhookConfigId\":1,\"eventType\":\"CRITICAL\",\"status\":\"DELIVERED\",\"attemptCount\":1,\"responseCode\":204}]"))) {
            CryptaScreen c = client(s);
            List<WebhookConfig> hooks = c.webhooks().list();
            assertTrue(hooks.get(0).isActive());
            assertEquals(1L, hooks.get(0).id());
            List<WebhookDelivery> d = c.webhooks().getDeliveries(String.valueOf(hooks.get(0).id()));
            assertEquals("DELIVERED", d.get(0).status());
            assertEquals(204, d.get(0).responseCode());
            assertEquals("/api/v1/webhooks/1/deliveries", s.last().rawPath());
            assertNull(s.last().rawQuery());
        }
        for (java.lang.reflect.Method m : com.cryptascreen.sdk.resource.WebhooksResource.class.getDeclaredMethods()) {
            assertFalse(List.of("create", "createAsync", "delete", "deleteAsync", "test", "testAsync").contains(m.getName()), m.getName());
        }
    }
}
