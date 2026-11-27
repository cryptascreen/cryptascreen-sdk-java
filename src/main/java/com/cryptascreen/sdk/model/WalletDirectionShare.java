// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletDirectionShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param flow flow
 * @param usd usd
 * @param byAsset byAsset
 */
public record WalletDirectionShare(
        String flow,
        WalletUsdShare usd,
        List<WalletAssetShare> byAsset
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletDirectionShare}. */
    public static final class Builder {
        private String flow;
        private WalletUsdShare usd;
        private List<WalletAssetShare> byAsset;

        private Builder() {}

        /**
         * Sets flow.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flow(String v) {
            this.flow = v;
            return this;
        }

        /**
         * Sets usd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder usd(WalletUsdShare v) {
            this.usd = v;
            return this;
        }

        /**
         * Sets byAsset.
         *
         * @param v the value
         * @return this builder
         */
        public Builder byAsset(List<WalletAssetShare> v) {
            this.byAsset = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletDirectionShare build() {
            return new WalletDirectionShare(flow, usd, byAsset);
        }
    }
}
