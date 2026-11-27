// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.http;

import com.cryptascreen.sdk.*;
import com.cryptascreen.sdk.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * HTTP client wrapper for the CryptaScreen API.
 *
 * <p>Wraps {@link java.net.http.HttpClient}: authenticated requests, JSON parsing, the retry policy and the mapping of
 * error responses to typed exceptions ({@code toSdkError} of {@code @cryptascreen/sdk}).</p>
 */
public final class HttpClient {

    private static final Map<String, String> VERSION_HEADER = Map.of("User-Agent", "cryptascreen-sdk-java/0.2.1");
    private static final List<String> PLAN_LIMIT_CODES = List.of("SEAT_LIMIT_REACHED", "API_KEY_LIMIT_REACHED",
            "MONITORED_WALLET_LIMIT_REACHED", "BULK_LIMIT_REACHED", "feature_not_in_plan");

    private final java.net.http.HttpClient httpClient;
    private final CryptaScreenConfig config;
    private final ObjectMapper mapper;
    private final RetryHandler retryHandler;

    /**
     * Creates a new HttpClient with the given configuration.
     *
     * @param config the SDK configuration
     */
    public HttpClient(CryptaScreenConfig config) {
        this.config = config;
        this.mapper = JsonUtils.mapper();
        this.retryHandler = new RetryHandler(config);
        this.httpClient = java.net.http.HttpClient.newBuilder().connectTimeout(config.connectTimeout()).build();
    }

    /**
     * Sends a request synchronously (with retries) and deserializes the JSON response.
     *
     * @param <T>          the response type
     * @param method       GET, POST, PUT or DELETE
     * @param path         the API path (already encoded)
     * @param query        query parameters (null values are dropped; may be null)
     * @param body         the JSON body (a record, map or JsonNode; null = no body)
     * @param headers      extra headers (may be null)
     * @param responseType the type to deserialize into; {@code Void} ignores the body
     * @return the deserialized response
     * @throws CryptaScreenException on any error
     */
    public <T> T request(String method, String path, Map<String, ?> query, Object body, Map<String, String> headers,
                         TypeReference<T> responseType) {
        HttpRequest request = buildRequest(method, path, query, body, headers);
        return retryHandler.executeWithRetry(() -> {
            try {
                return handle(httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray()), responseType);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CryptaScreenException("Request interrupted", e);
            } catch (IOException e) {
                throw new CryptaScreenException("Request failed: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Sends a request asynchronously (with retries).
     *
     * @param <T>          the response type
     * @param method       GET, POST, PUT or DELETE
     * @param path         the API path (already encoded)
     * @param query        query parameters (may be null)
     * @param body         the JSON body (may be null)
     * @param headers      extra headers (may be null)
     * @param responseType the type to deserialize into
     * @return a CompletableFuture with the deserialized response
     */
    public <T> CompletableFuture<T> requestAsync(String method, String path, Map<String, ?> query, Object body,
                                                 Map<String, String> headers, TypeReference<T> responseType) {
        HttpRequest request = buildRequest(method, path, query, body, headers);
        return retryHandler.executeWithRetryAsync(() -> httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofByteArray())
                .handle((response, error) -> {
                    if (error != null) {
                        Throwable cause = error instanceof java.util.concurrent.CompletionException && error.getCause() != null
                                ? error.getCause() : error;
                        throw new CryptaScreenException("Request failed: " + cause.getMessage(), cause);
                    }
                    return handle(response, responseType);
                }));
    }

    /**
     * Sends a request and returns the body as a JSON tree when the response is JSON, otherwise as text.
     *
     * @param method  the HTTP method
     * @param path    the API path
     * @param query   query parameters (may be null)
     * @param body    the JSON body (may be null)
     * @return a {@link JsonNode}, a {@link String}, or null for an empty body
     */
    public Object requestAny(String method, String path, Map<String, ?> query, Object body) {
        HttpRequest request = buildRequest(method, path, query, body, null);
        return retryHandler.executeWithRetry(() -> {
            try {
                HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
                ensureSuccess(response);
                byte[] bytes = response.body();
                if (bytes == null || bytes.length == 0) {
                    return null;
                }
                String type = response.headers().firstValue("Content-Type").orElse("");
                String text = new String(bytes, StandardCharsets.UTF_8);
                return type.contains("json") ? (Object) mapper.readTree(text) : text;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CryptaScreenException("Request interrupted", e);
            } catch (IOException e) {
                throw new CryptaScreenException("Request failed: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Sends a request and returns the raw body bytes.
     *
     * @param method the HTTP method
     * @param path   the API path
     * @param query  query parameters (may be null)
     * @param body   the JSON body (may be null)
     * @return the response bytes
     */
    public byte[] requestBytes(String method, String path, Map<String, ?> query, Object body) {
        HttpRequest request = buildRequest(method, path, query, body, null);
        return retryHandler.executeWithRetry(() -> {
            try {
                HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
                ensureSuccess(response);
                return response.body();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CryptaScreenException("Request interrupted", e);
            } catch (IOException e) {
                throw new CryptaScreenException("Request failed: " + e.getMessage(), e);
            }
        });
    }

    private HttpRequest buildRequest(String method, String path, Map<String, ?> query, Object body,
                                     Map<String, String> headers) {
        HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.noBody();
        if (body != null) {
            try {
                publisher = HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body));
            } catch (JsonProcessingException e) {
                throw new CryptaScreenException("Failed to serialize request body", e);
            }
        }
        HttpRequest.Builder b = HttpRequest.newBuilder()
                .uri(URI.create(buildUrl(path, query)))
                .method(method, publisher)
                .header("X-API-Key", config.apiKey())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("User-Agent", VERSION_HEADER.get("User-Agent"))
                .timeout(config.requestTimeout());
        if (headers != null) {
            headers.forEach(b::header);
        }
        return b.build();
    }

    private String buildUrl(String path, Map<String, ?> queryParams) {
        StringBuilder sb = new StringBuilder(config.baseUrl());
        sb.append(path);
        if (queryParams != null && !queryParams.isEmpty()) {
            String query = queryParams.entrySet().stream()
                    .filter(e -> e.getValue() != null)
                    .map(e -> URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8) + "="
                            + URLEncoder.encode(String.valueOf(e.getValue()), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));
            if (!query.isEmpty()) {
                sb.append("?").append(query);
            }
        }
        return sb.toString();
    }

    private <T> T handle(HttpResponse<byte[]> response, TypeReference<T> responseType) {
        ensureSuccess(response);
        byte[] bytes = response.body();
        if (responseType.getType() == Void.class || bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return mapper.readValue(bytes, responseType);
        } catch (IOException e) {
            throw new CryptaScreenException("Failed to parse response: " + e.getMessage(), e);
        }
    }

    private void ensureSuccess(HttpResponse<byte[]> response) {
        int status = response.statusCode();
        if (status >= 200 && status < 300) {
            return;
        }
        throw toSdkError(response);
    }

    /** Maps an error response to a typed exception (see {@code toSdkError} in the TypeScript client). */
    CryptaScreenException toSdkError(HttpResponse<byte[]> response) {
        int status = response.statusCode();
        JsonNode body = null;
        try {
            byte[] raw = response.body();
            if (raw != null && raw.length > 0) {
                JsonNode n = mapper.readTree(raw);
                body = n != null && n.isObject() ? n : null;
            }
        } catch (IOException ignored) {
            // not JSON: fall back to the status text
        }
        String requestId = response.headers().firstValue("X-Request-Id").orElse(null);
        String message = text(body, "message");
        if (message == null) {
            message = "Request failed with status code " + status;
        }
        Duration retryAfter = parseRetryAfter(response.headers().firstValue("Retry-After").orElse(null));

        switch (status) {
            case 401:
                return new AuthenticationException(message, requestId);
            case 404: {
                String resource = text(body, "resource");
                String id = text(body, "id");
                return new NotFoundException(resource == null ? "Resource" : resource, id == null ? "" : id, requestId);
            }
            case 400: {
                Map<String, List<String>> fieldErrors = new LinkedHashMap<>();
                if (body != null && body.has("fieldErrors") && body.get("fieldErrors").isObject()) {
                    Iterator<Map.Entry<String, JsonNode>> it = body.get("fieldErrors").fields();
                    while (it.hasNext()) {
                        Map.Entry<String, JsonNode> e = it.next();
                        List<String> msgs = new ArrayList<>();
                        e.getValue().forEach(m -> msgs.add(m.asText()));
                        fieldErrors.put(e.getKey(), msgs);
                    }
                }
                String field = text(body, "field");
                if (field != null) {
                    fieldErrors.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
                }
                JsonNode items = body != null && body.has("items") && body.get("items").isArray() ? body.get("items") : null;
                if (items != null) {
                    for (JsonNode it : items) {
                        String key = text(it, "field") + "[" + (it.has("index") ? it.get("index").asText() : "null") + "]";
                        fieldErrors.computeIfAbsent(key, k -> new ArrayList<>()).add(text(it, "message"));
                    }
                }
                return new ValidationException(message, fieldErrors, requestId, text(body, "code"), items);
            }
            case 403: {
                String code = text(body, "error") != null ? text(body, "error") : text(body, "code");
                if (code != null && PLAN_LIMIT_CODES.contains(code)) {
                    Long used = longOf(body, "used");
                    Long limit = longOf(body, "limit");
                    String plan = text(body, "plan");
                    if (code.equals("SEAT_LIMIT_REACHED")) {
                        return new SeatLimitReachedException(message, requestId, used, limit, plan);
                    }
                    if (code.equals("API_KEY_LIMIT_REACHED")) {
                        return new ApiKeyLimitReachedException(message, requestId, used, limit, plan);
                    }
                    return new PlanLimitException(message, code, requestId, used, limit, plan);
                }
                String c = text(body, "code") != null ? text(body, "code") : text(body, "error");
                return new CryptaScreenException(message, 403, c == null ? "FORBIDDEN" : c, requestId);
            }
            case 402:
                if ("SERVICE_PAUSED".equals(text(body, "code")) || "service_paused".equals(text(body, "error"))) {
                    return new ServicePausedException(message, requestId, text(body, "subscriptionStatus"),
                            text(body, "billing_url"), text(body, "reason"));
                }
                return new CryptaScreenException(message, 402, text(body, "code") != null ? text(body, "code") : "PAYMENT_REQUIRED", requestId);
            case 429: {
                if ("quota_exceeded".equals(text(body, "error")) || "QUOTA_EXCEEDED".equals(text(body, "code"))) {
                    return new QuotaExceededException(message, requestId, text(body, "resets_at"), text(body, "upgrade_url"));
                }
                long ms = retryAfter != null ? retryAfter.toMillis() : 60_000;
                return new RateLimitException(Instant.now().plusMillis(ms), ms, requestId, retryAfter);
            }
            default: {
                String code = text(body, "code");
                return new CryptaScreenException(message, status, code == null ? "UNKNOWN_ERROR" : code, requestId, retryAfter);
            }
        }
    }

    private static String text(JsonNode n, String field) {
        if (n == null || !n.has(field) || n.get(field).isNull()) {
            return null;
        }
        return n.get(field).asText();
    }

    private static Long longOf(JsonNode n, String field) {
        return n != null && n.has(field) && n.get(field).isNumber() ? n.get(field).asLong() : null;
    }

    /** JavaScript {@code parseInt(value, 10)} seconds: the leading integer, else null (HTTP-dates fall back). */
    static Duration parseRetryAfter(String value) {
        if (value == null) {
            return null;
        }
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("^\\s*([+-]?\\d+)").matcher(value);
        if (!m.find()) {
            return null;
        }
        long seconds = Long.parseLong(m.group(1));
        return Duration.ofSeconds(Math.max(0, seconds));
    }
}
