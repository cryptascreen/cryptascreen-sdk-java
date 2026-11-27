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
 * Resource for the auth operations (an API key is enough).
 */
public final class AuthResource {

    private final HttpClient http;

    /**
     * Creates a new AuthResource.
     *
     * @param http the HTTP client
     */
    public AuthResource(HttpClient http) {
        this.http = http;
    }

    /**
     * The calling identity. With an API key this is the key's tenant owner (authMethod API_KEY).
     *
     * @return the result
     */
    public AuthMe me() {
        return http.request("GET", "/api/v1" + "/auth/me", null, null, null, new TypeReference<AuthMe>() {});
    }

    /**
     * Asynchronous variant of {@link #me}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<AuthMe> meAsync() {
        return http.requestAsync("GET", "/api/v1" + "/auth/me", null, null, null, new TypeReference<AuthMe>() {});
    }
}
