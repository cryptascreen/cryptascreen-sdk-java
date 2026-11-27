// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for the monitoring operations (an API key is enough).
 */
public final class MonitoringResource {

    private final HttpClient http;

    /**
     * Creates a new MonitoringResource.
     *
     * @param http the HTTP client
     */
    public MonitoringResource(HttpClient http) {
        this.http = http;
    }

    /**
     * Monitored wallets of the calling tenant.
     *
     * @return the result
     */
    public List<MonitoredWallet> listWallets() {
        return http.request("GET", "/api/v1" + "/monitoring/wallets", null, null, null, new TypeReference<List<MonitoredWallet>>() {});
    }

    /**
     * Asynchronous variant of {@link #listWallets}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<MonitoredWallet>> listWalletsAsync() {
        return http.requestAsync("GET", "/api/v1" + "/monitoring/wallets", null, null, null, new TypeReference<List<MonitoredWallet>>() {});
    }

    /**
     * Adds a wallet to monitoring (plan-limited; a duplicate is a 400 DUPLICATE).
     *
     * @param request the request
     * @return the result
     */
    public MonitoredWallet addWallet(AddMonitoredWalletRequest request) {
        return http.request("POST", "/api/v1" + "/monitoring/wallets", null, request, null, new TypeReference<MonitoredWallet>() {});
    }

    /**
     * Asynchronous variant of {@link #addWallet}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<MonitoredWallet> addWalletAsync(AddMonitoredWalletRequest request) {
        return http.requestAsync("POST", "/api/v1" + "/monitoring/wallets", null, request, null, new TypeReference<MonitoredWallet>() {});
    }

    /**
     * Removes a wallet from monitoring.
     *
     * @param id the id
     * @return the result
     */
    public DeletedResponse removeWallet(String id) {
        return http.request("DELETE", "/api/v1" + "/monitoring/wallets/" + PathSegments.encode(id), null, null, null, new TypeReference<DeletedResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #removeWallet}.
     *
     * @param id the id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<DeletedResponse> removeWalletAsync(String id) {
        return http.requestAsync("DELETE", "/api/v1" + "/monitoring/wallets/" + PathSegments.encode(id), null, null, null, new TypeReference<DeletedResponse>() {});
    }

    /**
     * Monitored names of the calling tenant and how many the plan has used.
     *
     * @return the result
     */
    public MonitoredNamesResponse listNames() {
        return http.request("GET", "/api/v1" + "/monitoring/names", null, null, null, new TypeReference<MonitoredNamesResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #listNames}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<MonitoredNamesResponse> listNamesAsync() {
        return http.requestAsync("GET", "/api/v1" + "/monitoring/names", null, null, null, new TypeReference<MonitoredNamesResponse>() {});
    }

    /**
     * Saves a name to the monitored list (plan-limited like monitored wallets).
     *
     * @param request the request
     * @return the result
     */
    public Map<String, Object> addName(NameScreenRequest request) {
        return http.request("POST", "/api/v1" + "/monitoring/names", null, request, null, new TypeReference<Map<String, Object>>() {});
    }

    /**
     * Asynchronous variant of {@link #addName}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Map<String, Object>> addNameAsync(NameScreenRequest request) {
        return http.requestAsync("POST", "/api/v1" + "/monitoring/names", null, request, null, new TypeReference<Map<String, Object>>() {});
    }

    /**
     * Removes a name from the monitored list.
     *
     * @param id the id
     * @return the result
     */
    public RemovedResponse removeName(String id) {
        return http.request("DELETE", "/api/v1" + "/monitoring/names/" + PathSegments.encode(id), null, null, null, new TypeReference<RemovedResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #removeName}.
     *
     * @param id the id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<RemovedResponse> removeNameAsync(String id) {
        return http.requestAsync("DELETE", "/api/v1" + "/monitoring/names/" + PathSegments.encode(id), null, null, null, new TypeReference<RemovedResponse>() {});
    }

    /**
     * Names and wallets on the monitored list, with the last known hits of each name.
     *
     * @return the result
     */
    public MonitoringOverview getOverview() {
        return http.request("GET", "/api/v1" + "/monitoring/overview", null, null, null, new TypeReference<MonitoringOverview>() {});
    }

    /**
     * Asynchronous variant of {@link #getOverview}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<MonitoringOverview> getOverviewAsync() {
        return http.requestAsync("GET", "/api/v1" + "/monitoring/overview", null, null, null, new TypeReference<MonitoringOverview>() {});
    }

    /**
     * All breach detections of the calling tenant, newest first.
     *
     * @return the result
     */
    public List<BreachDetection> listBreaches() {
        return http.request("GET", "/api/v1" + "/monitoring/breaches", null, null, null, new TypeReference<List<BreachDetection>>() {});
    }

    /**
     * Asynchronous variant of {@link #listBreaches}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<BreachDetection>> listBreachesAsync() {
        return http.requestAsync("GET", "/api/v1" + "/monitoring/breaches", null, null, null, new TypeReference<List<BreachDetection>>() {});
    }

    /**
     * Counts of breach detections (unacknowledged, by severity, total).
     *
     * @return the result
     */
    public BreachSummary getBreachSummary() {
        return http.request("GET", "/api/v1" + "/monitoring/breaches/summary", null, null, null, new TypeReference<BreachSummary>() {});
    }

    /**
     * Asynchronous variant of {@link #getBreachSummary}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<BreachSummary> getBreachSummaryAsync() {
        return http.requestAsync("GET", "/api/v1" + "/monitoring/breaches/summary", null, null, null, new TypeReference<BreachSummary>() {});
    }

    /**
     * Acknowledges a breach detection (a second acknowledge is a 400 ALREADY_ACKNOWLEDGED).
     *
     * @param id the id
     * @return the result
     */
    public BreachDetection acknowledgeBreach(String id) {
        return http.request("POST", "/api/v1" + "/monitoring/breaches/" + PathSegments.encode(id) + "/acknowledge", null, null, null, new TypeReference<BreachDetection>() {});
    }

    /**
     * Asynchronous variant of {@link #acknowledgeBreach}.
     *
     * @param id the id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<BreachDetection> acknowledgeBreachAsync(String id) {
        return http.requestAsync("POST", "/api/v1" + "/monitoring/breaches/" + PathSegments.encode(id) + "/acknowledge", null, null, null, new TypeReference<BreachDetection>() {});
    }
}
