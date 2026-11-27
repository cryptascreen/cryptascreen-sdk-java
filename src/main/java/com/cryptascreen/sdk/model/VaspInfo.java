// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * VaspInfo (see types/intelligence.ts in @cryptascreen/sdk).
 *
 * @param vaspId vaspId
 * @param name name
 * @param website website
 * @param jurisdiction jurisdiction
 * @param regulatoryStatus regulatoryStatus
 * @param supportedChains supportedChains
 * @param knownAddresses knownAddresses
 * @param riskScore riskScore
 * @param updatedAt updatedAt
 */
public record VaspInfo(
        String vaspId,
        String name,
        String website,
        String jurisdiction,
        String regulatoryStatus,
        List<String> supportedChains,
        List<Object> knownAddresses,
        Double riskScore,
        String updatedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link VaspInfo}. */
    public static final class Builder {
        private String vaspId;
        private String name;
        private String website;
        private String jurisdiction;
        private String regulatoryStatus;
        private List<String> supportedChains;
        private List<Object> knownAddresses;
        private Double riskScore;
        private String updatedAt;

        private Builder() {}

        /**
         * Sets vaspId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder vaspId(String v) {
            this.vaspId = v;
            return this;
        }

        /**
         * Sets name.
         *
         * @param v the value
         * @return this builder
         */
        public Builder name(String v) {
            this.name = v;
            return this;
        }

        /**
         * Sets website.
         *
         * @param v the value
         * @return this builder
         */
        public Builder website(String v) {
            this.website = v;
            return this;
        }

        /**
         * Sets jurisdiction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder jurisdiction(String v) {
            this.jurisdiction = v;
            return this;
        }

        /**
         * Sets regulatoryStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder regulatoryStatus(String v) {
            this.regulatoryStatus = v;
            return this;
        }

        /**
         * Sets supportedChains.
         *
         * @param v the value
         * @return this builder
         */
        public Builder supportedChains(List<String> v) {
            this.supportedChains = v;
            return this;
        }

        /**
         * Sets knownAddresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder knownAddresses(List<Object> v) {
            this.knownAddresses = v;
            return this;
        }

        /**
         * Sets riskScore.
         *
         * @param v the value
         * @return this builder
         */
        public Builder riskScore(Double v) {
            this.riskScore = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public VaspInfo build() {
            return new VaspInfo(vaspId, name, website, jurisdiction, regulatoryStatus, supportedChains, knownAddresses, riskScore, updatedAt);
        }
    }
}
