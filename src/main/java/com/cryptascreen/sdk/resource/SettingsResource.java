package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for the settings operations (an API key is enough).
 */
public final class SettingsResource {

    private final HttpClient http;

    /**
     * Creates a new SettingsResource.
     *
     * @param http the HTTP client
     */
    public SettingsResource(HttpClient http) {
        this.http = http;
    }

    /**
     * Review / block thresholds of the calling tenant (defaults 40 / 70 until changed; paid plans).
     *
     * @return the result
     */
    public ScoreThresholdSettings getScoreThresholds() {
        return http.request("GET", "/api/v1" + "/settings/score-thresholds", null, null, null, new TypeReference<ScoreThresholdSettings>() {});
    }

    /**
     * Asynchronous variant of {@link #getScoreThresholds}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScoreThresholdSettings> getScoreThresholdsAsync() {
        return http.requestAsync("GET", "/api/v1" + "/settings/score-thresholds", null, null, null, new TypeReference<ScoreThresholdSettings>() {});
    }

    /**
     * Change history of the thresholds, newest first.
     *
     * @param limit maximum number of entries (null = server default)
     * @return the result
     */
    public ScoreThresholdAuditPage getScoreThresholdAudit(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.request("GET", "/api/v1" + "/settings/score-thresholds/audit", q, null, null, new TypeReference<ScoreThresholdAuditPage>() {});
    }

    /**
     * Asynchronous variant of {@link #getScoreThresholdAudit}.
     *
     * @param limit maximum number of entries (null = server default)
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScoreThresholdAuditPage> getScoreThresholdAuditAsync(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.requestAsync("GET", "/api/v1" + "/settings/score-thresholds/audit", q, null, null, new TypeReference<ScoreThresholdAuditPage>() {});
    }

    /**
     * Change history of the thresholds, newest first. (server default limit)
     *
     * @return the result
     */
    public ScoreThresholdAuditPage getScoreThresholdAudit() {
        return getScoreThresholdAudit(null);
    }

    /**
     * Asynchronous variant of {@link #getScoreThresholdAudit()}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScoreThresholdAuditPage> getScoreThresholdAuditAsync() {
        return getScoreThresholdAuditAsync(null);
    }

    /**
     * Name-matching strength of the calling tenant (default CONSERVATIVE; paid plans).
     *
     * @return the result
     */
    public NameMatchingStrength getNameMatching() {
        return http.request("GET", "/api/v1" + "/settings/name-matching", null, null, null, new TypeReference<NameMatchingStrength>() {});
    }

    /**
     * Asynchronous variant of {@link #getNameMatching}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<NameMatchingStrength> getNameMatchingAsync() {
        return http.requestAsync("GET", "/api/v1" + "/settings/name-matching", null, null, null, new TypeReference<NameMatchingStrength>() {});
    }

    /**
     * Change history of the matching strength, newest first.
     *
     * @param limit maximum number of entries (null = server default)
     * @return the result
     */
    public ItemsResponse getNameMatchingAudit(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.request("GET", "/api/v1" + "/settings/name-matching/audit", q, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #getNameMatchingAudit}.
     *
     * @param limit maximum number of entries (null = server default)
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ItemsResponse> getNameMatchingAuditAsync(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.requestAsync("GET", "/api/v1" + "/settings/name-matching/audit", q, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Change history of the matching strength, newest first. (server default limit)
     *
     * @return the result
     */
    public ItemsResponse getNameMatchingAudit() {
        return getNameMatchingAudit(null);
    }

    /**
     * Asynchronous variant of {@link #getNameMatchingAudit()}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ItemsResponse> getNameMatchingAuditAsync() {
        return getNameMatchingAuditAsync(null);
    }

    /**
     * Allow / block list entries of the calling tenant (exact identifiers, applied before fuzzy matching).
     *
     * @return the result
     */
    public ItemsResponse getNameLists() {
        return http.request("GET", "/api/v1" + "/settings/name-lists", null, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #getNameLists}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ItemsResponse> getNameListsAsync() {
        return http.requestAsync("GET", "/api/v1" + "/settings/name-lists", null, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Audit of allow / block entries (added, removed, applied), newest first.
     *
     * @param limit maximum number of entries (null = server default)
     * @return the result
     */
    public ItemsResponse getNameListAudit(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.request("GET", "/api/v1" + "/settings/name-lists/audit", q, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #getNameListAudit}.
     *
     * @param limit maximum number of entries (null = server default)
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ItemsResponse> getNameListAuditAsync(Integer limit) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (limit != null) {
            q.put("limit", limit);
        }
        return http.requestAsync("GET", "/api/v1" + "/settings/name-lists/audit", q, null, null, new TypeReference<ItemsResponse>() {});
    }

    /**
     * Audit of allow / block entries (added, removed, applied), newest first. (server default limit)
     *
     * @return the result
     */
    public ItemsResponse getNameListAudit() {
        return getNameListAudit(null);
    }

    /**
     * Asynchronous variant of {@link #getNameListAudit()}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ItemsResponse> getNameListAuditAsync() {
        return getNameListAuditAsync(null);
    }

    /**
     * The vendors with their configured state (last4 and fingerprint only; never the key).
     *
     * @return the result
     */
    public List<VendorKeyView> listVendorKeys() {
        return http.request("GET", "/api/v1" + "/settings/vendor-keys", null, null, null, new TypeReference<List<VendorKeyView>>() {});
    }

    /**
     * Asynchronous variant of {@link #listVendorKeys}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<VendorKeyView>> listVendorKeysAsync() {
        return http.requestAsync("GET", "/api/v1" + "/settings/vendor-keys", null, null, null, new TypeReference<List<VendorKeyView>>() {});
    }
}
