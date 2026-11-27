// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletTransactionPage (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param items items
 */
public record WalletTransactionPage(
        List<WalletTransaction> items
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletTransactionPage}. */
    public static final class Builder {
        private List<WalletTransaction> items;

        private Builder() {}

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<WalletTransaction> v) {
            this.items = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletTransactionPage build() {
            return new WalletTransactionPage(items);
        }
    }
}
