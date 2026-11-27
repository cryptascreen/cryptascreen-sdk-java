// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletCounterpartyPage (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param unpricedAssets unpricedAssets
 * @param items items
 */
public record WalletCounterpartyPage(
        List<String> unpricedAssets,
        List<WalletCounterparty> items
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCounterpartyPage}. */
    public static final class Builder {
        private List<String> unpricedAssets;
        private List<WalletCounterparty> items;

        private Builder() {}

        /**
         * Sets unpricedAssets.
         *
         * @param v the value
         * @return this builder
         */
        public Builder unpricedAssets(List<String> v) {
            this.unpricedAssets = v;
            return this;
        }

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<WalletCounterparty> v) {
            this.items = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCounterpartyPage build() {
            return new WalletCounterpartyPage(unpricedAssets, items);
        }
    }
}
