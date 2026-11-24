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
 * Resource for names operations (mirrors the names endpoints of @cryptascreen/sdk).
 */
public final class NamesResource {

    private final HttpClient http;

    /**
     * Creates a new NamesResource.
     *
     * @param http the HTTP client
     */
    public NamesResource(HttpClient http) {
        this.http = http;
    }

    /**
     * Screens one name. An invalid request is a 400 (ValidationException) and is not counted.
     *
     * @param request the request
     * @param idempotencyKey the idempotencyKey
     * @return the result
     */
    public NameScreenResponse screen(NameScreenRequest request, String idempotencyKey) {
        Map<String, String> headers = idempotencyKey != null && !idempotencyKey.isEmpty() ? Map.of("Idempotency-Key", idempotencyKey) : null;
        return http.request("POST", "/api/v1/screen/name", null, request, headers, new TypeReference<NameScreenResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #screen}.
     *
     * @param request the request
     * @param idempotencyKey the idempotencyKey
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<NameScreenResponse> screenAsync(NameScreenRequest request, String idempotencyKey) {
        return CompletableFuture.supplyAsync(() -> screen(request, idempotencyKey));
    }

    /**
     * Screens one name.
     *
     * @param request the request
     * @return the result
     */
    public NameScreenResponse screen(NameScreenRequest request) {
        return screen(request, null);
    }

    /**
     * Asynchronous variant of {@link #screen}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<NameScreenResponse> screenAsync(NameScreenRequest request) {
        return CompletableFuture.supplyAsync(() -> screen(request));
    }

    /**
     * GET /screen/name/{screeningId}
     *
     * @param screeningId the screeningId
     * @return the result
     */
    public NameScreenResponse get(String screeningId) {
        return http.request("GET", "/api/v1/screen/name/" + PathSegments.encode(screeningId), null, null, null, new TypeReference<NameScreenResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #get}.
     *
     * @param screeningId the screeningId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<NameScreenResponse> getAsync(String screeningId) {
        return http.requestAsync("GET", "/api/v1/screen/name/" + PathSegments.encode(screeningId), null, null, null, new TypeReference<NameScreenResponse>() {});
    }

    /**
     * GET /screen/name/history
     *
     * @param limit the limit
     * @return the result
     */
    public List<NameScreeningHistoryItem> history(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("limit", limit != null ? limit : 50);
        return http.request("GET", "/api/v1/screen/name/history", q, null, null, new TypeReference<List<NameScreeningHistoryItem>>() {});
    }

    /**
     * Asynchronous variant of {@link #history}.
     *
     * @param limit the limit
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<NameScreeningHistoryItem>> historyAsync(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("limit", limit != null ? limit : 50);
        return http.requestAsync("GET", "/api/v1/screen/name/history", q, null, null, new TypeReference<List<NameScreeningHistoryItem>>() {});
    }

    /**
     * POST /screen/name/decisions
     *
     * @param request the request
     * @return the result
     */
    public NameMatchDecision decide(NameDecisionRequest request) {
        return http.request("POST", "/api/v1/screen/name/decisions", null, request, null, new TypeReference<NameMatchDecision>() {});
    }

    /**
     * Asynchronous variant of {@link #decide}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<NameMatchDecision> decideAsync(NameDecisionRequest request) {
        return http.requestAsync("POST", "/api/v1/screen/name/decisions", null, request, null, new TypeReference<NameMatchDecision>() {});
    }

    /**
     * GET /screen/name/decisions/audit
     *
     * @param format the format
     * @return the result
     */
    public Object decisionAudit(String format) {
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("format", format != null ? format : "json");
        return http.requestAny("GET", "/api/v1/screen/name/decisions/audit", q, null);
    }

    /**
     * Asynchronous variant of {@link #decisionAudit}.
     *
     * @param format the format
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Object> decisionAuditAsync(String format) {
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("format", format != null ? format : "json");
        return CompletableFuture.supplyAsync(() -> decisionAudit(format));
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
