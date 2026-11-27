// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.webhook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/** The shared cross-SDK vectors ({@code webhook_vectors.json}, identical in the Python and Java SDKs). */
@DisplayName("Webhook signature: shared vectors")
class WebhookSignatureTest {

    private static final ObjectMapper M = new ObjectMapper();

    private static JsonNode vectors() throws Exception {
        try (InputStream in = WebhookSignatureTest.class.getResourceAsStream("/webhook_vectors.json")) {
            return M.readTree(in);
        }
    }

    @TestFactory
    List<DynamicTest> signVectors() throws Exception {
        List<DynamicTest> out = new ArrayList<>();
        int i = 0;
        for (JsonNode v : vectors().get("sign")) {
            final int idx = i++;
            out.add(DynamicTest.dynamicTest("sign-" + idx, () -> {
                Long ts = v.get("timestamp").isNull() ? null : v.get("timestamp").asLong();
                assertEquals(v.get("hex").asText(), WebhookSignature.compute(v.get("secret").asText(), v.get("body").asText(), ts));
            }));
        }
        return out;
    }

    @TestFactory
    List<DynamicTest> verifyVectors() throws Exception {
        List<DynamicTest> out = new ArrayList<>();
        for (JsonNode v : vectors().get("verify")) {
            out.add(DynamicTest.dynamicTest(v.get("name").asText(), () -> {
                Map<String, String> headers = new LinkedHashMap<>();
                v.get("headers").fields().forEachRemaining(e -> headers.put(e.getKey(), e.getValue().asText()));
                byte[] body = v.get("body").asText().getBytes(StandardCharsets.UTF_8);
                Runnable call = () -> WebhookSignature.verify(v.get("secret").asText(), body, headers, v.get("tolerance").asLong(),
                        v.get("allowLegacy").asBoolean(), v.get("now").asDouble());
                if (v.get("expect").get("ok").asBoolean()) {
                    call.run();
                } else {
                    WebhookSignature.SignatureException e = assertThrows(WebhookSignature.SignatureException.class, call::run);
                    assertEquals(v.get("expect").get("code").asText(), e.code());
                }
            }));
        }
        return out;
    }

    @Test
    void constructEventParsesTheVerifiedBody() throws Exception {
        JsonNode v = null;
        for (JsonNode n : vectors().get("verify")) {
            if (n.get("name").asText().equals("valid-v2-simple")) {
                v = n;
            }
        }
        assertNotNull(v);
        Map<String, String> headers = new LinkedHashMap<>();
        v.get("headers").fields().forEachRemaining(e -> headers.put(e.getKey(), e.getValue().asText()));
        // the vector's timestamp is fixed in 2026: verify with an explicit clock, then parse
        byte[] body = v.get("body").asText().getBytes(StandardCharsets.UTF_8);
        assertTrue(WebhookSignature.verify(v.get("secret").asText(), body, headers, 300, false, v.get("now").asDouble()));
        assertEquals("screening.flagged", M.readTree(body).get("type").asText());
        // and with the real clock the old timestamp is refused
        assertThrows(WebhookSignature.SignatureException.class, () -> WebhookSignature.constructEvent(v0Secret(), body, headers));
    }

    private static String v0Secret() {
        return "test-webhook-secret-not-real";
    }
}
