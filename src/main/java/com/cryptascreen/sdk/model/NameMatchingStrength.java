// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * Name-matching strength (CONSERVATIVE | BALANCED | STRICT).
 *
 * @param strength strength
 * @param source source
 * @param version version
 * @param threshold threshold
 * @param updatedAt updatedAt
 * @param updatedBy updatedBy
 * @param options options
 */
public record NameMatchingStrength(
        String strength,
        String source,
        Long version,
        Double threshold,
        String updatedAt,
        String updatedBy,
        List<String> options
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameMatchingStrength}. */
    public static final class Builder {
        private String strength;
        private String source;
        private Long version;
        private Double threshold;
        private String updatedAt;
        private String updatedBy;
        private List<String> options;

        private Builder() {}

        /**
         * Sets strength.
         *
         * @param v the value
         * @return this builder
         */
        public Builder strength(String v) {
            this.strength = v;
            return this;
        }

        /**
         * Sets source.
         *
         * @param v the value
         * @return this builder
         */
        public Builder source(String v) {
            this.source = v;
            return this;
        }

        /**
         * Sets version.
         *
         * @param v the value
         * @return this builder
         */
        public Builder version(Long v) {
            this.version = v;
            return this;
        }

        /**
         * Sets threshold.
         *
         * @param v the value
         * @return this builder
         */
        public Builder threshold(Double v) {
            this.threshold = v;
            return this;
        }

        /**
         * Sets updatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedAt(String v) {
            this.updatedAt = v;
            return this;
        }

        /**
         * Sets updatedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedBy(String v) {
            this.updatedBy = v;
            return this;
        }

        /**
         * Sets options.
         *
         * @param v the value
         * @return this builder
         */
        public Builder options(List<String> v) {
            this.options = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameMatchingStrength build() {
            return new NameMatchingStrength(strength, source, version, threshold, updatedAt, updatedBy, options);
        }
    }
}
