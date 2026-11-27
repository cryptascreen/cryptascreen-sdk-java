// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * TravelRuleCheckRequest (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param txHash txHash
 * @param chain chain
 * @param fromAddress fromAddress
 * @param toAddress toAddress
 * @param transferAmountUsd transferAmountUsd
 */
public record TravelRuleCheckRequest(
        String txHash,
        String chain,
        String fromAddress,
        String toAddress,
        Double transferAmountUsd
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link TravelRuleCheckRequest}. */
    public static final class Builder {
        private String txHash;
        private String chain;
        private String fromAddress;
        private String toAddress;
        private Double transferAmountUsd;

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
         * Sets fromAddress.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fromAddress(String v) {
            this.fromAddress = v;
            return this;
        }

        /**
         * Sets toAddress.
         *
         * @param v the value
         * @return this builder
         */
        public Builder toAddress(String v) {
            this.toAddress = v;
            return this;
        }

        /**
         * Sets transferAmountUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transferAmountUsd(Double v) {
            this.transferAmountUsd = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public TravelRuleCheckRequest build() {
            return new TravelRuleCheckRequest(txHash, chain, fromAddress, toAddress, transferAmountUsd);
        }
    }
}
