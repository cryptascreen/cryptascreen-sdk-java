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
 * Resource for compliance operations (mirrors the compliance endpoints of @cryptascreen/sdk).
 */
public final class ComplianceResource {

    private final HttpClient http;

    /**
     * Creates a new ComplianceResource.
     *
     * @param http the HTTP client
     */
    public ComplianceResource(HttpClient http) {
        this.http = http;
    }

    /**
     * POST /compliance/travel-rule/check
     *
     * @param request the request
     * @return the result
     */
    public TravelRuleCheckResult checkTravelRule(TravelRuleCheckRequest request) {
        return http.request("POST", "/api/v1/compliance/travel-rule/check", null, request, null, new TypeReference<TravelRuleCheckResult>() {});
    }

    /**
     * Asynchronous variant of {@link #checkTravelRule}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<TravelRuleCheckResult> checkTravelRuleAsync(TravelRuleCheckRequest request) {
        return http.requestAsync("POST", "/api/v1/compliance/travel-rule/check", null, request, null, new TypeReference<TravelRuleCheckResult>() {});
    }

    /**
     * POST /compliance/travel-rule/payload
     *
     * @param request the request
     * @return the result
     */
    public TravelRulePayload buildTravelRulePayload(TravelRulePayloadRequest request) {
        return http.request("POST", "/api/v1/compliance/travel-rule/payload", null, request, null, new TypeReference<TravelRulePayload>() {});
    }

    /**
     * Asynchronous variant of {@link #buildTravelRulePayload}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<TravelRulePayload> buildTravelRulePayloadAsync(TravelRulePayloadRequest request) {
        return http.requestAsync("POST", "/api/v1/compliance/travel-rule/payload", null, request, null, new TypeReference<TravelRulePayload>() {});
    }

    /**
     * GET /compliance/travel-rule/vasp/identify/{chain}/{address}
     *
     * @param chain the chain
     * @param address the address
     * @return the result
     */
    public VaspIdentification identifyVasp(String chain, String address) {
        return http.request("GET", "/api/v1/compliance/travel-rule/vasp/identify/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address), null, null, null, new TypeReference<VaspIdentification>() {});
    }

    /**
     * Asynchronous variant of {@link #identifyVasp}.
     *
     * @param chain the chain
     * @param address the address
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<VaspIdentification> identifyVaspAsync(String chain, String address) {
        return http.requestAsync("GET", "/api/v1/compliance/travel-rule/vasp/identify/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address), null, null, null, new TypeReference<VaspIdentification>() {});
    }

    /**
     * Deprecated: DAC8 reporting is deferred (unvalidated draft, not a filing). A request missing taxYear/jurisdiction/operator/users throws ValidationException client-side.
     *
     * @param request the request
     * @return the result
     */
    public Dac8ReportResult generateDac8Report(Dac8ReportRequest request) {
        Map<String, List<String>> missing = new LinkedHashMap<>();
        if (request == null || request.taxYear() == null) missing.put("taxYear", List.of("required"));
        if (request == null || request.jurisdiction() == null) missing.put("jurisdiction", List.of("required"));
        if (request == null || request.operator() == null) missing.put("operator", List.of("required"));
        if (request == null || request.users() == null) missing.put("users", List.of("required"));
        if (!missing.isEmpty()) {
            throw new ValidationException("DAC8 report request requires " + String.join(", ", missing.keySet()) + " (DAC8 is deferred; see CHANGELOG)", missing, null, "DAC8_REQUEST_SHAPE", null);
        }
        return http.request("POST", "/api/v1/compliance/dac8/report", null, request, null, new TypeReference<Dac8ReportResult>() {});
    }

    /**
     * Asynchronous variant of {@link #generateDac8Report}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Dac8ReportResult> generateDac8ReportAsync(Dac8ReportRequest request) {
        return CompletableFuture.supplyAsync(() -> generateDac8Report(request));
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
