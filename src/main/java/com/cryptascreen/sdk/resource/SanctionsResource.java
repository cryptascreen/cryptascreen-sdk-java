package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.CryptaScreenException;
import com.cryptascreen.sdk.ValidationException;
import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.cryptascreen.sdk.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for sanctions operations (mirrors the sanctions endpoints of @cryptascreen/sdk).
 */
public final class SanctionsResource {

    private final HttpClient http;

    /**
     * Creates a new SanctionsResource.
     *
     * @param http the HTTP client
     */
    public SanctionsResource(HttpClient http) {
        this.http = http;
    }

    /**
     * GET /sanctions/check/{chain}/{address}
     *
     * @param chain the chain
     * @param address the address
     * @return the result
     */
    public SanctionsCheckResponse check(String chain, String address) {
        return http.request("GET", "/api/v1/sanctions/check/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address), null, null, null, new TypeReference<SanctionsCheckResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #check}.
     *
     * @param chain the chain
     * @param address the address
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<SanctionsCheckResponse> checkAsync(String chain, String address) {
        return http.requestAsync("GET", "/api/v1/sanctions/check/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address), null, null, null, new TypeReference<SanctionsCheckResponse>() {});
    }

    /**
     * GET /sanctions/status
     *
     * @return the result
     */
    public SanctionsStatusResponse getStatus() {
        return http.request("GET", "/api/v1/sanctions/status", null, null, null, new TypeReference<SanctionsStatusResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #getStatus}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<SanctionsStatusResponse> getStatusAsync() {
        return http.requestAsync("GET", "/api/v1/sanctions/status", null, null, null, new TypeReference<SanctionsStatusResponse>() {});
    }

    private static Map<String, Object> optionsToQuery(Object options) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (options != null) {
            JsonUtils.toMap(options).forEach((k, v) -> {
                if (v != null) {
                    q.put(k, v);
                }
            });
        }
        return q;
    }
}
