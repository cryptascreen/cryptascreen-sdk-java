// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletExposureHit (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param hop hop
 * @param counterparty counterparty
 * @param category category
 * @param direction direction
 * @param listings listings
 * @param steps steps
 */
public record WalletExposureHit(
        Long hop,
        String counterparty,
        String category,
        String direction,
        List<WalletListing> listings,
        List<WalletPathStep> steps
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletExposureHit}. */
    public static final class Builder {
        private Long hop;
        private String counterparty;
        private String category;
        private String direction;
        private List<WalletListing> listings;
        private List<WalletPathStep> steps;

        private Builder() {}

        /**
         * Sets hop.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hop(Long v) {
            this.hop = v;
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
         * Sets category.
         *
         * @param v the value
         * @return this builder
         */
        public Builder category(String v) {
            this.category = v;
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
         * Sets listings.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listings(List<WalletListing> v) {
            this.listings = v;
            return this;
        }

        /**
         * Sets steps.
         *
         * @param v the value
         * @return this builder
         */
        public Builder steps(List<WalletPathStep> v) {
            this.steps = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletExposureHit build() {
            return new WalletExposureHit(hop, counterparty, category, direction, listings, steps);
        }
    }
}
