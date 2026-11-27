// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletCategoryAssetShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param asset asset
 * @param symbol symbol
 * @param units units
 * @param assetTotal assetTotal
 * @param share share
 */
public record WalletCategoryAssetShare(
        String asset,
        String symbol,
        Object units,
        Object assetTotal,
        Object share
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryAssetShare}. */
    public static final class Builder {
        private String asset;
        private String symbol;
        private Object units;
        private Object assetTotal;
        private Object share;

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
         * Sets units.
         *
         * @param v the value
         * @return this builder
         */
        public Builder units(Object v) {
            this.units = v;
            return this;
        }

        /**
         * Sets assetTotal.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assetTotal(Object v) {
            this.assetTotal = v;
            return this;
        }

        /**
         * Sets share.
         *
         * @param v the value
         * @return this builder
         */
        public Builder share(Object v) {
            this.share = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryAssetShare build() {
            return new WalletCategoryAssetShare(asset, symbol, units, assetTotal, share);
        }
    }
}
