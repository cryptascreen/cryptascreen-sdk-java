package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for the capabilities operations (an API key is enough).
 */
public final class CapabilitiesResource {

    private final HttpClient http;

    /**
     * Creates a new CapabilitiesResource.
     *
     * @param http the HTTP client
     */
    public CapabilitiesResource(HttpClient http) {
        this.http = http;
    }

    /**
     * Chains the screening API accepts (on-chain COVERED / UNAVAILABLE) and the live layer state (ON / OFF).
     *
     * @return the result
     */
    public Capabilities get() {
        return http.request("GET", "/api/v1" + "/capabilities", null, null, null, new TypeReference<Capabilities>() {});
    }

    /**
     * Asynchronous variant of {@link #get}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<Capabilities> getAsync() {
        return http.requestAsync("GET", "/api/v1" + "/capabilities", null, null, null, new TypeReference<Capabilities>() {});
    }
}
