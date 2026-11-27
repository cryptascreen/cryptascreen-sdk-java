// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * Dac8TransactionData (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param txHash txHash
 * @param chain chain
 * @param transactionDate transactionDate
 * @param transactionType transactionType
 * @param cryptoAsset cryptoAsset
 * @param units units
 * @param fmvAtTransaction fmvAtTransaction
 */
public record Dac8TransactionData(
        String txHash,
        String chain,
        String transactionDate,
        String transactionType,
        String cryptoAsset,
        Double units,
        Double fmvAtTransaction
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link Dac8TransactionData}. */
    public static final class Builder {
        private String txHash;
        private String chain;
        private String transactionDate;
        private String transactionType;
        private String cryptoAsset;
        private Double units;
        private Double fmvAtTransaction;

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
         * Sets transactionDate.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transactionDate(String v) {
            this.transactionDate = v;
            return this;
        }

        /**
         * Sets transactionType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transactionType(String v) {
            this.transactionType = v;
            return this;
        }

        /**
         * Sets cryptoAsset.
         *
         * @param v the value
         * @return this builder
         */
        public Builder cryptoAsset(String v) {
            this.cryptoAsset = v;
            return this;
        }

        /**
         * Sets units.
         *
         * @param v the value
         * @return this builder
         */
        public Builder units(Double v) {
            this.units = v;
            return this;
        }

        /**
         * Sets fmvAtTransaction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fmvAtTransaction(Double v) {
            this.fmvAtTransaction = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public Dac8TransactionData build() {
            return new Dac8TransactionData(txHash, chain, transactionDate, transactionType, cryptoAsset, units, fmvAtTransaction);
        }
    }
}
