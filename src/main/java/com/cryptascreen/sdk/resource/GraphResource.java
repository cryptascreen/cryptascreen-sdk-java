// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
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
 * Resource for graph operations (mirrors the graph endpoints of @cryptascreen/sdk).
 */
public final class GraphResource {

    private final HttpClient http;

    /**
     * Creates a new GraphResource.
     *
     * @param http the HTTP client
     */
    public GraphResource(HttpClient http) {
        this.http = http;
    }

    /**
     * POST /investigate/graph
     *
     * @param request the request
     * @return the result
     */
    public GraphResponse buildGraph(GraphRequest request) {
        return http.request("POST", "/api/v1/investigate/graph", null, request, null, new TypeReference<GraphResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #buildGraph}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<GraphResponse> buildGraphAsync(GraphRequest request) {
        return http.requestAsync("POST", "/api/v1/investigate/graph", null, request, null, new TypeReference<GraphResponse>() {});
    }

    /**
     * Exports a flow-of-funds graph: a JsonNode for {@code json}, the raw bytes for {@code csv}.
     *
     * @param request the request
     * @param format the format
     * @return the result
     */
    public Object exportGraph(GraphRequest request, String format) {
        String f = format == null ? "json" : format;
        Map<String, Object> q = Map.of("format", f);
        return "json".equals(f) ? http.requestAny("POST", "/api/v1/investigate/graph/export", q, request) : http.requestBytes("POST", "/api/v1/investigate/graph/export", q, request);
    }

    /**
     * Asynchronous variant of {@link #exportGraph}.
     *
     * @param request the request
     * @param format the format
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Object> exportGraphAsync(GraphRequest request, String format) {
        return CompletableFuture.supplyAsync(() -> exportGraph(request, format));
    }

    /**
     * Exports the graph as JSON.
     *
     * @param request the request
     * @return the result
     */
    public Object exportGraph(GraphRequest request) {
        return exportGraph(request, "json");
    }

    /**
     * Asynchronous variant of {@link #exportGraph}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Object> exportGraphAsync(GraphRequest request) {
        return CompletableFuture.supplyAsync(() -> exportGraph(request));
    }

    /**
     * POST /investigate/trace
     *
     * @param request the request
     * @return the result
     */
    public GraphResponse trace(GraphRequest request) {
        return http.request("POST", "/api/v1/investigate/trace", null, request, null, new TypeReference<GraphResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #trace}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<GraphResponse> traceAsync(GraphRequest request) {
        return http.requestAsync("POST", "/api/v1/investigate/trace", null, request, null, new TypeReference<GraphResponse>() {});
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
