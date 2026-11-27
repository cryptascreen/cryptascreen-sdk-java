// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletDerivedStep (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param index index
 * @param from from
 * @param to to
 * @param txHash txHash
 * @param block block
 * @param time time
 * @param asset asset
 * @param symbol symbol
 * @param decimals decimals
 * @param amountRaw amountRaw
 * @param stolenRaw stolenRaw
 * @param shareAtReceiver shareAtReceiver
 * @param explorerUrl explorerUrl
 */
public record WalletDerivedStep(
        Long index,
        String from,
        String to,
        String txHash,
        Double block,
        String time,
        String asset,
        String symbol,
        Long decimals,
        String amountRaw,
        String stolenRaw,
        Double shareAtReceiver,
        String explorerUrl
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletDerivedStep}. */
    public static final class Builder {
        private Long index;
        private String from;
        private String to;
        private String txHash;
        private Double block;
        private String time;
        private String asset;
        private String symbol;
        private Long decimals;
        private String amountRaw;
        private String stolenRaw;
        private Double shareAtReceiver;
        private String explorerUrl;

        private Builder() {}

        /**
         * Sets index.
         *
         * @param v the value
         * @return this builder
         */
        public Builder index(Long v) {
            this.index = v;
            return this;
        }

        /**
         * Sets from.
         *
         * @param v the value
         * @return this builder
         */
        public Builder from(String v) {
            this.from = v;
            return this;
        }

        /**
         * Sets to.
         *
         * @param v the value
         * @return this builder
         */
        public Builder to(String v) {
            this.to = v;
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
         * Sets block.
         *
         * @param v the value
         * @return this builder
         */
        public Builder block(Double v) {
            this.block = v;
            return this;
        }

        /**
         * Sets time.
         *
         * @param v the value
         * @return this builder
         */
        public Builder time(String v) {
            this.time = v;
            return this;
        }

        /**
         * Sets asset.
         *
         * @param v the value
         * @return this builder
         */
        public Builder asset(String v) {
            this.asset = v;
            return this;
        }

        /**
         * Sets symbol.
         *
         * @param v the value
         * @return this builder
         */
        public Builder symbol(String v) {
            this.symbol = v;
            return this;
        }

        /**
         * Sets decimals.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decimals(Long v) {
            this.decimals = v;
            return this;
        }

        /**
         * Sets amountRaw.
         *
         * @param v the value
         * @return this builder
         */
        public Builder amountRaw(String v) {
            this.amountRaw = v;
            return this;
        }

        /**
         * Sets stolenRaw.
         *
         * @param v the value
         * @return this builder
         */
        public Builder stolenRaw(String v) {
            this.stolenRaw = v;
            return this;
        }

        /**
         * Sets shareAtReceiver.
         *
         * @param v the value
         * @return this builder
         */
        public Builder shareAtReceiver(Double v) {
            this.shareAtReceiver = v;
            return this;
        }

        /**
         * Sets explorerUrl.
         *
         * @param v the value
         * @return this builder
         */
        public Builder explorerUrl(String v) {
            this.explorerUrl = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletDerivedStep build() {
            return new WalletDerivedStep(index, from, to, txHash, block, time, asset, symbol, decimals, amountRaw, stolenRaw, shareAtReceiver, explorerUrl);
        }
    }
}
