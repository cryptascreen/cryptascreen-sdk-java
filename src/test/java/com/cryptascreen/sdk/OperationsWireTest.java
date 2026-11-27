// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.cryptascreen.sdk.WireServer.Resp;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Every SDK method hits the (method, path) of the operation table: each {@link Operations#ALL} entry is invoked by
 * reflection against a recording server and the raw request line is compared (path-table test of the TypeScript SDK).
 */
@DisplayName("Operation table: every method makes exactly the request it declares")
class OperationsWireTest {

    private static final ObjectMapper M = new ObjectMapper();
    private static final String ADDR = "0x" + "ab".repeat(20);
    private static final Map<String, String> VALUES = Map.ofEntries(Map.entry("chain", "ethereum"), Map.entry("address", ADDR),
            Map.entry("jobId", "job-1"), Map.entry("evaluationId", "ev-1"), Map.entry("screeningId", "sc-1"),
            Map.entry("caseId", "case-1"), Map.entry("id", "7"), Map.entry("webhookId", "wh-1"), Map.entry("vaspId", "v1"));

    private static JsonNode spec(String res, String ts) throws Exception {
        try (InputStream in = OperationsWireTest.class.getResourceAsStream("/ops_spec.json")) {
            for (JsonNode o : M.readTree(in).get(res)) {
                if (o.get("ts").asText().equals(ts)) {
                    return o;
                }
            }
        }
        throw new AssertionError(res + "." + ts);
    }

    private static Object resource(CryptaScreen c, String res) throws Exception {
        return CryptaScreen.class.getMethod(res).invoke(c);
    }

    private static Object defaultFor(Class<?> t, String name, Map<String, String> values) throws Exception {
        if (t == String.class) {
            return values.getOrDefault(name, "x");
        }
        if (t == Long.class) {
            return 5L;
        }
        if (t == com.cryptascreen.sdk.model.Dac8ReportRequest.class) {
            return com.cryptascreen.sdk.model.Dac8ReportRequest.builder().taxYear(2026L).jurisdiction("LU")
                    .operator(com.cryptascreen.sdk.model.Dac8OperatorInfo.builder().build()).users(List.of()).build();
        }
        if (t == com.cryptascreen.sdk.model.ScreenAddressRequest.class) {
            return com.cryptascreen.sdk.model.ScreenAddressRequest.builder().address("x").chain("ethereum").build();
        }
        if (t.isRecord()) {
            return t.getMethod("builder").invoke(null).getClass().getMethod("build").invoke(t.getMethod("builder").invoke(null));
        }
        return null;
    }

    @Test
    void everyOperationMakesItsDeclaredRequest() throws Exception {
        int checked = 0;
        for (Operations.Operation op : Operations.ALL) {
            if (op.httpMethod() == null) {
                continue;
            }
            JsonNode spec = spec(op.resource(), op.method());
            List<String> pathParams = new ArrayList<>();
            spec.get("p").forEach(n -> pathParams.add(n.asText()));
            AtomicReference<Class<?>> ret = new AtomicReference<>();
            try (WireServer s = new WireServer(req -> Resp.json(200, "{}"))) {
                CryptaScreen c = CryptaScreen.builder().apiKey("csk_test").baseUrl(s.baseUrl()).maxRetries(0).build();
                Object res = resource(c, op.resource());
                Method m = Arrays.stream(res.getClass().getMethods()).filter(x -> x.getName().equals(op.method()))
                        .min(Comparator.comparingInt(Method::getParameterCount)).orElseThrow(() -> new AssertionError(op));
                ret.set(m.getReturnType());
                Object[] args = new Object[m.getParameterCount()];
                for (int i = 0; i < args.length; i++) {
                    String name = i < pathParams.size() ? pathParams.get(i) : "x";
                    args[i] = defaultFor(m.getParameterTypes()[i], name, VALUES);
                }
                // list-returning methods get an array from the server
                if (List.class.isAssignableFrom(m.getReturnType())) {
                    try (WireServer s2 = new WireServer(req -> Resp.json(200, "[]"))) {
                        CryptaScreen c2 = CryptaScreen.builder().apiKey("csk_test").baseUrl(s2.baseUrl()).maxRetries(0).build();
                        m.invoke(resource(c2, op.resource()), args);
                        assertRequest(op, s2.last(), pathParams);
                    }
                } else {
                    m.invoke(res, args);
                    assertRequest(op, s.last(), pathParams);
                }
                checked++;
            }
        }
        assertEquals(61, checked, "every request-making operation was exercised");
    }

    private static void assertRequest(Operations.Operation op, WireServer.Req req, List<String> pathParams) {
        String expected = "/api/v1" + op.path();
        for (String p : pathParams) {
            expected = expected.replace("{" + p + "}", VALUES.getOrDefault(p, "x"));
        }
        assertEquals(op.httpMethod(), req.method(), op.toString());
        assertEquals(expected, req.rawPath(), op.toString());
    }

    @Test
    void tableHasOneEntryPerTypeScriptMethodAndTheThreeLocalOnes() {
        assertEquals(64, Operations.ALL.size());
        List<String> noRequest = Operations.ALL.stream().filter(o -> o.httpMethod() == null).map(o -> o.resource() + "." + o.method()).toList();
        assertEquals(List.of("screening.screenBulkAndWait", "intelligence.getEntityLabel", "intelligence.getVaspInfo"), noRequest);
    }
}
