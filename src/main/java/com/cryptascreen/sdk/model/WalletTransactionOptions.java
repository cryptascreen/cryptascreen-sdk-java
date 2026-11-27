// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletTransactionOptions (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param page page
 * @param size size
 * @param sort sort
 * @param order order
 * @param days days
 * @param direction direction
 * @param counterparty counterparty
 */
public record WalletTransactionOptions(
        Long page,
        Long size,
        String sort,
        String order,
        Long days,
        String direction,
        String counterparty
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletTransactionOptions}. */
    public static final class Builder {
        private Long page;
        private Long size;
        private String sort;
        private String order;
        private Long days;
        private String direction;
        private String counterparty;

        private Builder() {}

        /**
         * Sets page.
         *
         * @param v the value
         * @return this builder
         */
        public Builder page(Long v) {
            this.page = v;
            return this;
        }

        /**
         * Sets size.
         *
         * @param v the value
         * @return this builder
         */
        public Builder size(Long v) {
            this.size = v;
            return this;
        }

        /**
         * Sets sort.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sort(String v) {
            this.sort = v;
            return this;
        }

        /**
         * Sets order.
         *
         * @param v the value
         * @return this builder
         */
        public Builder order(String v) {
            this.order = v;
            return this;
        }

        /**
         * Sets days.
         *
         * @param v the value
         * @return this builder
         */
        public Builder days(Long v) {
            this.days = v;
            return this;
        }

        /**
         * Sets direction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder direction(String v) {
            this.direction = v;
            return this;
        }

        /**
         * Sets counterparty.
         *
         * @param v the value
         * @return this builder
         */
        public Builder counterparty(String v) {
            this.counterparty = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletTransactionOptions build() {
            return new WalletTransactionOptions(page, size, sort, order, days, direction, counterparty);
        }
    }
}
