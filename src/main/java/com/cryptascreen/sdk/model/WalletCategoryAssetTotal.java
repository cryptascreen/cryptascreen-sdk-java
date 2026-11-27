// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletCategoryAssetTotal (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param asset asset
 * @param symbol symbol
 * @param total total
 * @param txCount txCount
 */
public record WalletCategoryAssetTotal(
        String asset,
        String symbol,
        Object total,
        Long txCount
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryAssetTotal}. */
    public static final class Builder {
        private String asset;
        private String symbol;
        private Object total;
        private Long txCount;

        private Builder() {}

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
         * Sets total.
         *
         * @param v the value
         * @return this builder
         */
        public Builder total(Object v) {
            this.total = v;
            return this;
        }

        /**
         * Sets txCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder txCount(Long v) {
            this.txCount = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryAssetTotal build() {
            return new WalletCategoryAssetTotal(asset, symbol, total, txCount);
        }
    }
}
