// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * SanctionsStatusResponse (see types/sanctions.ts in @cryptascreen/sdk).
 *
 * @param total_active total_active
 * @param by_source by_source
 * @param last_checked last_checked
 */
public record SanctionsStatusResponse(
        Double total_active,
        Map<String, Double> by_source,
        String last_checked
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link SanctionsStatusResponse}. */
    public static final class Builder {
        private Double total_active;
        private Map<String, Double> by_source;
        private String last_checked;

        private Builder() {}

        /**
         * Sets total_active.
         *
         * @param v the value
         * @return this builder
         */
        public Builder total_active(Double v) {
            this.total_active = v;
            return this;
        }

        /**
         * Sets by_source.
         *
         * @param v the value
         * @return this builder
         */
        public Builder by_source(Map<String, Double> v) {
            this.by_source = v;
            return this;
        }

        /**
         * Sets last_checked.
         *
         * @param v the value
         * @return this builder
         */
        public Builder last_checked(String v) {
            this.last_checked = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public SanctionsStatusResponse build() {
            return new SanctionsStatusResponse(total_active, by_source, last_checked);
        }
    }
}
