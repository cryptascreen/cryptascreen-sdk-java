// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import java.time.Duration;

/**
 * Configuration for the CryptaScreen SDK client.
 *
 * <p>Use {@link CryptaScreen#builder()} to create a configuration via the builder pattern.</p>
 */
public final class CryptaScreenConfig {

    /** The one public host; it routes every request to the data region of the API key (csk_us_... / csk_eu_...). */
    public static final String DEFAULT_BASE_URL = "https://api.cryptascreen.com";

    private final String apiKey;
    private final String baseUrl;
    private final Duration connectTimeout;
    private final Duration requestTimeout;
    private final int maxRetries;
    private final Duration retryBaseDelay;
    private final boolean autoRetryRateLimit;

    CryptaScreenConfig(Builder builder) {
        this.apiKey = builder.apiKey;
        this.baseUrl = builder.baseUrl;
        this.connectTimeout = builder.connectTimeout;
        this.requestTimeout = builder.requestTimeout;
        this.maxRetries = builder.maxRetries;
        this.retryBaseDelay = builder.retryBaseDelay;
        this.autoRetryRateLimit = builder.autoRetryRateLimit;
    }

    /** Returns the API key used for authentication. */
    public String apiKey() {
        return apiKey;
    }

    /** Returns the base URL for the CryptaScreen API. */
    public String baseUrl() {
        return baseUrl;
    }

    /** Returns the connection timeout duration. */
    public Duration connectTimeout() {
        return connectTimeout;
    }

    /** Returns the request timeout duration. */
    public Duration requestTimeout() {
        return requestTimeout;
    }

    /** Returns the maximum number of retries on 429 (not quota) and 5xx. */
    public int maxRetries() {
        return maxRetries;
    }

    /** Returns the base delay between retries (exponential backoff: 1s, 2s, 4s ... capped at 30s). */
    public Duration retryBaseDelay() {
        return retryBaseDelay;
    }

    /** Returns whether automatic retry on rate-limit (429) responses is enabled. */
    public boolean autoRetryRateLimit() {
        return autoRetryRateLimit;
    }

    /**
     * Builder for {@link CryptaScreenConfig}.
     */
    public static final class Builder {
        private String apiKey;
        private String baseUrl;
        private Duration connectTimeout = Duration.ofSeconds(10);
        private Duration requestTimeout = Duration.ofSeconds(30);
        private int maxRetries = 3;
        private Duration retryBaseDelay = Duration.ofSeconds(1);
        private boolean autoRetryRateLimit = true;

        Builder() {}

        /**
         * Sets the API key for authentication.
         *
         * @param apiKey the API key ({@code csk_...})
         * @return this builder
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * Sets the base URL for the CryptaScreen API.
         *
         * @param baseUrl the base URL (default: https://api.cryptascreen.com)
         * @return this builder
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Sets the connection timeout.
         *
         * @param connectTimeout the connection timeout (default: 10s)
         * @return this builder
         */
        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        /**
         * Sets the request timeout.
         *
         * @param requestTimeout the request timeout (default: 30s)
         * @return this builder
         */
        public Builder requestTimeout(Duration requestTimeout) {
            this.requestTimeout = requestTimeout;
            return this;
        }

        /**
         * Sets the maximum number of retries for failed requests.
         *
         * @param maxRetries the maximum retries (default: 3)
         * @return this builder
         */
        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        /**
         * Sets the base delay for exponential backoff between retries.
         *
         * @param retryBaseDelay the base delay (default: 1s)
         * @return this builder
         */
        public Builder retryBaseDelay(Duration retryBaseDelay) {
            this.retryBaseDelay = retryBaseDelay;
            return this;
        }

        /**
         * Sets whether to automatically retry on rate-limit (429) responses.
         *
         * @param autoRetryRateLimit true to auto-retry (default: true)
         * @return this builder
         */
        public Builder autoRetryRateLimit(boolean autoRetryRateLimit) {
            this.autoRetryRateLimit = autoRetryRateLimit;
            return this;
        }

        /**
         * Builds the configuration.
         *
         * @return the built configuration
         * @throws IllegalArgumentException if apiKey is null or blank
         */
        public CryptaScreenConfig build() {
            if (apiKey == null || apiKey.isBlank()) {
                throw new IllegalArgumentException("apiKey must not be null or blank");
            }
            if (baseUrl != null && baseUrl.isBlank()) {
                throw new IllegalArgumentException("baseUrl must not be blank");
            }
            if (baseUrl == null) {
                baseUrl = DEFAULT_BASE_URL;
            }
            return new CryptaScreenConfig(this);
        }
    }
}
