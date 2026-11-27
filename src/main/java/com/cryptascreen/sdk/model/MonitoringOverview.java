// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * GET /monitoring/overview.
 *
 * @param names names
 * @param wallets wallets
 * @param nameHits nameHits
 */
public record MonitoringOverview(
        List<Map<String, Object>> names,
        List<Map<String, Object>> wallets,
        List<Map<String, Object>> nameHits
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link MonitoringOverview}. */
    public static final class Builder {
        private List<Map<String, Object>> names;
        private List<Map<String, Object>> wallets;
        private List<Map<String, Object>> nameHits;

        private Builder() {}

        /**
         * Sets names.
         *
         * @param v the value
         * @return this builder
         */
        public Builder names(List<Map<String, Object>> v) {
            this.names = v;
            return this;
        }

        /**
         * Sets wallets.
         *
         * @param v the value
         * @return this builder
         */
        public Builder wallets(List<Map<String, Object>> v) {
            this.wallets = v;
            return this;
        }

        /**
         * Sets nameHits.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nameHits(List<Map<String, Object>> v) {
            this.nameHits = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public MonitoringOverview build() {
            return new MonitoringOverview(names, wallets, nameHits);
        }
    }
}
