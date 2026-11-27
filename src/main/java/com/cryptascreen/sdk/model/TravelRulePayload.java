// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * TravelRulePayload (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param originatorName originatorName
 * @param originatorAccount originatorAccount
 * @param originatorVasp originatorVasp
 * @param transferAmount transferAmount
 * @param currency currency
 * @param txHash txHash
 * @param chain chain
 * @param timestamp timestamp
 * @param ivms101 ivms101
 */
public record TravelRulePayload(
        String originatorName,
        String originatorAccount,
        String originatorVasp,
        Double transferAmount,
        String currency,
        String txHash,
        String chain,
        String timestamp,
        Map<String, Object> ivms101
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link TravelRulePayload}. */
    public static final class Builder {
        private String originatorName;
        private String originatorAccount;
        private String originatorVasp;
        private Double transferAmount;
        private String currency;
        private String txHash;
        private String chain;
        private String timestamp;
        private Map<String, Object> ivms101;

        private Builder() {}

        /**
         * Sets originatorName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorName(String v) {
            this.originatorName = v;
            return this;
        }

        /**
         * Sets originatorAccount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorAccount(String v) {
            this.originatorAccount = v;
            return this;
        }

        /**
         * Sets originatorVasp.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorVasp(String v) {
            this.originatorVasp = v;
            return this;
        }

        /**
         * Sets transferAmount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transferAmount(Double v) {
            this.transferAmount = v;
            return this;
        }

        /**
         * Sets currency.
         *
         * @param v the value
         * @return this builder
         */
        public Builder currency(String v) {
            this.currency = v;
            return this;
        }

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
         * Sets timestamp.
         *
         * @param v the value
         * @return this builder
         */
        public Builder timestamp(String v) {
            this.timestamp = v;
            return this;
        }

        /**
         * Sets ivms101.
         *
         * @param v the value
         * @return this builder
         */
        public Builder ivms101(Map<String, Object> v) {
            this.ivms101 = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public TravelRulePayload build() {
            return new TravelRulePayload(originatorName, originatorAccount, originatorVasp, transferAmount, currency, txHash, chain, timestamp, ivms101);
        }
    }
}
