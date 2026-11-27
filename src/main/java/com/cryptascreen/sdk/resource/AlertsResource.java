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
 * Resource for alerts operations (mirrors the alerts endpoints of @cryptascreen/sdk).
 */
public final class AlertsResource {

    private final HttpClient http;

    /**
     * Creates a new AlertsResource.
     *
     * @param http the HTTP client
     */
    public AlertsResource(HttpClient http) {
        this.http = http;
    }

    /**
     * GET /alerts/{id}
     *
     * @param id the id
     * @return the result
     */
    public AlertDetail get(String id) {
        return http.request("GET", "/api/v1/alerts/" + PathSegments.encode(id), null, null, null, new TypeReference<AlertDetail>() {});
    }

    /**
     * Asynchronous variant of {@link #get}.
     *
     * @param id the id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<AlertDetail> getAsync(String id) {
        return http.requestAsync("GET", "/api/v1/alerts/" + PathSegments.encode(id), null, null, null, new TypeReference<AlertDetail>() {});
    }

    /**
     * Acknowledges an alert (idempotent; a repeat returns the stored acknowledgement).
     *
     * @param id the id
     * @param note the note
     * @return the result
     */
    public AlertDetail acknowledge(String id, String note) {
        Object body = note != null && !note.isBlank() ? Map.of("note", note.strip()) : Map.of();
        return http.request("POST", "/api/v1/alerts/" + PathSegments.encode(id) + "/acknowledge", null, body, null, new TypeReference<AlertDetail>() {});
    }

    /**
     * Asynchronous variant of {@link #acknowledge}.
     *
     * @param id the id
     * @param note the note
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<AlertDetail> acknowledgeAsync(String id, String note) {
        return CompletableFuture.supplyAsync(() -> acknowledge(id, note));
    }

    /**
     * Acknowledges an alert without a note.
     *
     * @param id the id
     * @return the result
     */
    public AlertDetail acknowledge(String id) {
        return acknowledge(id, null);
    }

    /**
     * Asynchronous variant of {@link #acknowledge}.
     *
     * @param id the id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<AlertDetail> acknowledgeAsync(String id) {
        return CompletableFuture.supplyAsync(() -> acknowledge(id));
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
