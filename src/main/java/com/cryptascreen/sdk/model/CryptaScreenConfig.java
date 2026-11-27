// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * CryptaScreenConfig (see types/common.ts in @cryptascreen/sdk).
 *
 * @param baseUrl baseUrl
 * @param apiKey apiKey
 * @param timeout timeout
 * @param retries retries
 */
public record CryptaScreenConfig(
        String baseUrl,
        String apiKey,
        Double timeout,
        Double retries
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CryptaScreenConfig}. */
    public static final class Builder {
        private String baseUrl;
        private String apiKey;
        private Double timeout;
        private Double retries;

        private Builder() {}

        /**
         * Sets baseUrl.
         *
         * @param v the value
         * @return this builder
         */
        public Builder baseUrl(String v) {
            this.baseUrl = v;
            return this;
        }

        /**
         * Sets apiKey.
         *
         * @param v the value
         * @return this builder
         */
        public Builder apiKey(String v) {
            this.apiKey = v;
            return this;
        }

        /**
         * Sets timeout.
         *
         * @param v the value
         * @return this builder
         */
        public Builder timeout(Double v) {
            this.timeout = v;
            return this;
        }

        /**
         * Sets retries.
         *
         * @param v the value
         * @return this builder
         */
        public Builder retries(Double v) {
            this.retries = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CryptaScreenConfig build() {
            return new CryptaScreenConfig(baseUrl, apiKey, timeout, retries);
        }
    }
}
