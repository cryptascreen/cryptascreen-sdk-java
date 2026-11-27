// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletCounterparty (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param address address
 * @param direction direction
 * @param txCount txCount
 * @param inCount inCount
 * @param outCount outCount
 * @param assets assets
 * @param fiat fiat
 * @param firstSeen firstSeen
 * @param lastSeen lastSeen
 * @param listed listed
 * @param listings listings
 */
public record WalletCounterparty(
        String address,
        String direction,
        Long txCount,
        Long inCount,
        Long outCount,
        List<WalletAssetTotal> assets,
        WalletFiat fiat,
        String firstSeen,
        String lastSeen,
        Boolean listed,
        List<WalletListing> listings
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCounterparty}. */
    public static final class Builder {
        private String address;
        private String direction;
        private Long txCount;
        private Long inCount;
        private Long outCount;
        private List<WalletAssetTotal> assets;
        private WalletFiat fiat;
        private String firstSeen;
        private String lastSeen;
        private Boolean listed;
        private List<WalletListing> listings;

        private Builder() {}

        /**
         * Sets address.
         *
         * @param v the value
         * @return this builder
         */
        public Builder address(String v) {
            this.address = v;
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
         * Sets inCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder inCount(Long v) {
            this.inCount = v;
            return this;
        }

        /**
         * Sets outCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder outCount(Long v) {
            this.outCount = v;
            return this;
        }

        /**
         * Sets assets.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assets(List<WalletAssetTotal> v) {
            this.assets = v;
            return this;
        }

        /**
         * Sets fiat.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fiat(WalletFiat v) {
            this.fiat = v;
            return this;
        }

        /**
         * Sets firstSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstSeen(String v) {
            this.firstSeen = v;
            return this;
        }

        /**
         * Sets lastSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastSeen(String v) {
            this.lastSeen = v;
            return this;
        }

        /**
         * Sets listed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listed(Boolean v) {
            this.listed = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public WalletCounterparty build() {
            return new WalletCounterparty(address, direction, txCount, inCount, outCount, assets, fiat, firstSeen, lastSeen, listed, listings);
        }
    }
}
