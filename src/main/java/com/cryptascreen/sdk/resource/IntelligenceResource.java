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
 * Resource for intelligence operations (mirrors the intelligence endpoints of @cryptascreen/sdk).
 */
public final class IntelligenceResource {

    private final HttpClient http;

    /**
     * Creates a new IntelligenceResource.
     *
     * @param http the HTTP client
     */
    public IntelligenceResource(HttpClient http) {
        this.http = http;
    }

    /**
     * Returns all entity attributions for an address (empty list = no label known; NOT a clean verdict).
     *
     * @param chain the chain
     * @param address the address
     * @return the result
     */
    public List<EntityLabel> getEntityLabels(String chain, String address) {
        Object d = http.requestAny("GET", "/api/v1/intelligence/entity/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address), null, null);
        if (d instanceof JsonNode n && n.isArray()) {
            return JsonUtils.mapper().convertValue(n, new TypeReference<List<EntityLabel>>() {});
        }
        return List.of();
    }

    /**
     * Asynchronous variant of {@link #getEntityLabels}.
     *
     * @param chain the chain
     * @param address the address
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<EntityLabel>> getEntityLabelsAsync(String chain, String address) {
        return CompletableFuture.supplyAsync(() -> getEntityLabels(chain, address));
    }

    /**
     * Deprecated: the first entity attribution or null; use getEntityLabels.
     *
     * @param address the address
     * @param chain the chain
     * @return the result
     */
    public EntityLabel getEntityLabel(String address, String chain) {
        List<EntityLabel> labels = getEntityLabels(chain, address);
        return labels.isEmpty() ? null : labels.get(0);
    }

    /**
     * Asynchronous variant of {@link #getEntityLabel}.
     *
     * @param address the address
     * @param chain the chain
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<EntityLabel> getEntityLabelAsync(String address, String chain) {
        return CompletableFuture.supplyAsync(() -> getEntityLabel(address, chain));
    }

    /**
     * Deprecated: there is no VASP profile endpoint; throws without making a request.
     *
     * @param vaspId the vaspId
     * @return the result
     */
    public VaspInfo getVaspInfo(String vaspId) {
        throw new CryptaScreenException("getVaspInfo(" + vaspId + ") is not available: the API has no VASP profile endpoint. Use compliance().identifyVasp(chain, address).", 0, "ENDPOINT_NOT_AVAILABLE", null);
    }

    /**
     * Asynchronous variant of {@link #getVaspInfo}.
     *
     * @param vaspId the vaspId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<VaspInfo> getVaspInfoAsync(String vaspId) {
        return CompletableFuture.supplyAsync(() -> getVaspInfo(vaspId));
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
