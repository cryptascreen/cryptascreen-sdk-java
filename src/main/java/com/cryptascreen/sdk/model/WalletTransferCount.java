// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletTransferCount (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param value value
 * @param basis basis
 */
public record WalletTransferCount(
        Double value,
        String basis
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletTransferCount}. */
    public static final class Builder {
        private Double value;
        private String basis;

        private Builder() {}

        /**
         * Sets value.
         *
         * @param v the value
         * @return this builder
         */
        public Builder value(Double v) {
            this.value = v;
            return this;
        }

        /**
         * Sets basis.
         *
         * @param v the value
         * @return this builder
         */
        public Builder basis(String v) {
            this.basis = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletTransferCount build() {
            return new WalletTransferCount(value, basis);
        }
    }
}
