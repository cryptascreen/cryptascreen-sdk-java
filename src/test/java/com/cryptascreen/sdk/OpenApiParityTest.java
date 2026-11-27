// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Every SDK method maps to an operation (HTTP method + path) of the customer API contract - fails if not.
 *
 * <p>{@code customer-operations.json} lists method and path of each operation of the contract (no descriptions or
 * schemas). A new SDK method that is not in it fails {@link #everyOperationIsInTheContract()}; a new contract operation
 * that is neither wrapped nor listed with a reason in {@link #NOT_WRAPPED} fails
 * {@link #contractOperationsTheSdkDoesNotWrapAreTheKnownList()}.</p>
 */
@DisplayName("API parity: SDK operations vs the customer API contract")
class OpenApiParityTest {

    /** Contract operations the SDK does not wrap, each with the reason. */
    static final Map<String, String> NOT_WRAPPED = new TreeMap<>(Map.ofEntries(
            Map.entry("PUT /settings/score-thresholds", "tenant administrator session only"),
            Map.entry("DELETE /settings/score-thresholds", "tenant administrator session only"),
            Map.entry("PUT /settings/name-matching", "tenant administrator session only"),
            Map.entry("DELETE /settings/name-matching", "tenant administrator session only"),
            Map.entry("POST /settings/name-lists", "tenant administrator session only"),
            Map.entry("DELETE /settings/name-lists/{}", "tenant administrator session only"),
            Map.entry("PUT /settings/vendor-keys/{}", "signed-in tenant administrator session only"),
            Map.entry("PATCH /settings/vendor-keys/{}", "signed-in tenant administrator session only"),
            Map.entry("DELETE /settings/vendor-keys/{}", "signed-in tenant administrator session only"),
            Map.entry("POST /settings/vendor-keys/{}/test", "signed-in tenant administrator session only")));

    private static final ObjectMapper M = new ObjectMapper();

    private static String norm(String p) {
        return p.replaceAll("\\{[^}]+}", "{}");
    }

    private static Set<String> openapi() throws Exception {
        try (InputStream in = OpenApiParityTest.class.getResourceAsStream("/customer-operations.json")) {
            JsonNode root = M.readTree(in);
            Set<String> out = new TreeSet<>();
            for (JsonNode n : root.get("openapi")) {
                String[] parts = n.asText().split(" ", 2);
                out.add(parts[0] + " " + norm(parts[1]));
            }
            assertEquals(0, root.get("customerRoutesNotYetInOpenapi").size(), "no known gaps remain");
            return out;
        }
    }

    @Test
    void everyOperationIsInTheContract() throws Exception {
        Set<String> oa = openapi();
        List<String> failures = new ArrayList<>();
        for (Operations.Operation op : Operations.ALL) {
            if (op.httpMethod() == null) {
                continue;
            }
            String key = op.httpMethod() + " " + norm(op.path());
            if (!oa.contains(key)) {
                failures.add(op.resource() + "." + op.method() + " " + key + " is not an operation of the customer API contract");
            }
        }
        assertTrue(failures.isEmpty(), String.join("\n", failures));
    }

    @Test
    void aNonContractOperationWouldFail() throws Exception {
        assertFalse(openapi().contains("POST /webhooks"), "webhook registration is session-only and not in the contract");
        assertFalse(openapi().contains("GET /not-in-the-contract"));
    }

    @Test
    void contractOperationsTheSdkDoesNotWrapAreTheKnownList() throws Exception {
        Set<String> sdk = new TreeSet<>();
        for (Operations.Operation op : Operations.ALL) {
            if (op.httpMethod() != null) {
                sdk.add(op.httpMethod() + " " + norm(op.path()));
            }
        }
        Set<String> unwrapped = openapi();
        unwrapped.removeAll(sdk);
        assertEquals(NOT_WRAPPED.keySet(), unwrapped);
        NOT_WRAPPED.values().forEach(reason -> assertFalse(reason.isBlank()));
    }
}
