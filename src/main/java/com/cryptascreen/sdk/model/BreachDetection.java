// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * A breach detection.
 *
 * @param id id
 * @param address address
 * @param chain chain
 * @param breachSource breachSource
 * @param breachDate breachDate
 * @param severity severity
 * @param description description
 * @param detectedAt detectedAt
 * @param acknowledgedAt acknowledgedAt
 */
public record BreachDetection(
        Long id,
        String address,
        String chain,
        String breachSource,
        String breachDate,
        String severity,
        String description,
        String detectedAt,
        String acknowledgedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link BreachDetection}. */
    public static final class Builder {
        private Long id;
        private String address;
        private String chain;
        private String breachSource;
        private String breachDate;
        private String severity;
        private String description;
        private String detectedAt;
        private String acknowledgedAt;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(Long v) {
            this.id = v;
            return this;
        }

        /**
         * Sets address.
         *
         * @param v the value
         * @return this builder
         */
        public Builder address(String v) {
            this.address = v;
            return this;
        }

        /**
         * Sets chain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chain(String v) {
            this.chain = v;
            return this;
        }

        /**
         * Sets breachSource.
         *
         * @param v the value
         * @return this builder
         */
        public Builder breachSource(String v) {
            this.breachSource = v;
            return this;
        }

        /**
         * Sets breachDate.
         *
         * @param v the value
         * @return this builder
         */
        public Builder breachDate(String v) {
            this.breachDate = v;
            return this;
        }

        /**
         * Sets severity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder severity(String v) {
            this.severity = v;
            return this;
        }

        /**
         * Sets description.
         *
         * @param v the value
         * @return this builder
         */
        public Builder description(String v) {
            this.description = v;
            return this;
        }

        /**
         * Sets detectedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder detectedAt(String v) {
            this.detectedAt = v;
            return this;
        }

        /**
         * Sets acknowledgedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder acknowledgedAt(String v) {
            this.acknowledgedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public BreachDetection build() {
            return new BreachDetection(id, address, chain, breachSource, breachDate, severity, description, detectedAt, acknowledgedAt);
        }
    }
}
