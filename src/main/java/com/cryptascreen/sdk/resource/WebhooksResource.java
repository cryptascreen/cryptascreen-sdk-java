package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Read access to webhook endpoints with an API key. Registering, deleting and test-sending an endpoint need a signed-in
 * user in the CryptaScreen app (an API key gets 403 SESSION_REQUIRED), so this SDK does not offer them. Verify deliveries
 * with {@link com.cryptascreen.sdk.webhook.WebhookSignature}.
 */
public final class WebhooksResource {

    private final HttpClient http;

    /**
     * Creates a new WebhooksResource.
     *
     * @param http the HTTP client
     */
    public WebhooksResource(HttpClient http) {
        this.http = http;
    }

    /**
     * GET /webhooks
     *
     * @return the webhook endpoints of the calling tenant
     */
    public List<WebhookConfig> list() {
        return http.request("GET", "/api/v1/webhooks", null, null, null, new TypeReference<List<WebhookConfig>>() {});
    }

    /**
     * Asynchronous variant of {@link #list}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<WebhookConfig>> listAsync() {
        return http.requestAsync("GET", "/api/v1/webhooks", null, null, null, new TypeReference<List<WebhookConfig>>() {});
    }

    /**
     * GET /webhooks/{webhookId}/deliveries: the last 50 deliveries of an endpoint, newest first.
     *
     * @param webhookId the webhook endpoint id
     * @return the deliveries
     */
    public List<WebhookDelivery> getDeliveries(String webhookId) {
        return http.request("GET", "/api/v1/webhooks/" + PathSegments.encode(webhookId) + "/deliveries", null, null, null,
                new TypeReference<List<WebhookDelivery>>() {});
    }

    /**
     * Asynchronous variant of {@link #getDeliveries}.
     *
     * @param webhookId the webhook endpoint id
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<WebhookDelivery>> getDeliveriesAsync(String webhookId) {
        return http.requestAsync("GET", "/api/v1/webhooks/" + PathSegments.encode(webhookId) + "/deliveries", null, null, null,
                new TypeReference<List<WebhookDelivery>>() {});
    }
}
