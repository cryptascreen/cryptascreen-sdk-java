// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * TravelRuleCheckResult (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param txHash txHash
 * @param chain chain
 * @param required required
 * @param thresholdExceeded thresholdExceeded
 * @param thresholdUsd thresholdUsd
 * @param originatorVaspIdentified originatorVaspIdentified
 * @param originatorVaspName originatorVaspName
 * @param beneficiaryVaspIdentified beneficiaryVaspIdentified
 * @param beneficiaryVaspName beneficiaryVaspName
 * @param travelRuleProtocol travelRuleProtocol
 */
public record TravelRuleCheckResult(
        String txHash,
        String chain,
        Boolean required,
        Boolean thresholdExceeded,
        Double thresholdUsd,
        Boolean originatorVaspIdentified,
        String originatorVaspName,
        Boolean beneficiaryVaspIdentified,
        String beneficiaryVaspName,
        String travelRuleProtocol
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link TravelRuleCheckResult}. */
    public static final class Builder {
        private String txHash;
        private String chain;
        private Boolean required;
        private Boolean thresholdExceeded;
        private Double thresholdUsd;
        private Boolean originatorVaspIdentified;
        private String originatorVaspName;
        private Boolean beneficiaryVaspIdentified;
        private String beneficiaryVaspName;
        private String travelRuleProtocol;

        private Builder() {}

        /**
         * Sets txHash.
         *
         * @param v the value
         * @return this builder
         */
        public Builder txHash(String v) {
            this.txHash = v;
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
         * Sets required.
         *
         * @param v the value
         * @return this builder
         */
        public Builder required(Boolean v) {
            this.required = v;
            return this;
        }

        /**
         * Sets thresholdExceeded.
         *
         * @param v the value
         * @return this builder
         */
        public Builder thresholdExceeded(Boolean v) {
            this.thresholdExceeded = v;
            return this;
        }

        /**
         * Sets thresholdUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder thresholdUsd(Double v) {
            this.thresholdUsd = v;
            return this;
        }

        /**
         * Sets originatorVaspIdentified.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorVaspIdentified(Boolean v) {
            this.originatorVaspIdentified = v;
            return this;
        }

        /**
         * Sets originatorVaspName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorVaspName(String v) {
            this.originatorVaspName = v;
            return this;
        }

        /**
         * Sets beneficiaryVaspIdentified.
         *
         * @param v the value
         * @return this builder
         */
        public Builder beneficiaryVaspIdentified(Boolean v) {
            this.beneficiaryVaspIdentified = v;
            return this;
        }

        /**
         * Sets beneficiaryVaspName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder beneficiaryVaspName(String v) {
            this.beneficiaryVaspName = v;
            return this;
        }

        /**
         * Sets travelRuleProtocol.
         *
         * @param v the value
         * @return this builder
         */
        public Builder travelRuleProtocol(String v) {
            this.travelRuleProtocol = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public TravelRuleCheckResult build() {
            return new TravelRuleCheckResult(txHash, chain, required, thresholdExceeded, thresholdUsd, originatorVaspIdentified, originatorVaspName, beneficiaryVaspIdentified, beneficiaryVaspName, travelRuleProtocol);
        }
    }
}
