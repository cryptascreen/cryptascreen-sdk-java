// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletTransaction (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param txHash txHash
 * @param time time
 * @param direction direction
 * @param counterparty counterparty
 * @param asset asset
 * @param symbol symbol
 * @param amount amount
 * @param fiatUsd fiatUsd
 * @param priced priced
 * @param category category
 * @param internal internal
 * @param logIndex logIndex
 * @param blockNumber blockNumber
 * @param explorerUrl explorerUrl
 * @param counterpartyListed counterpartyListed
 * @param kind kind
 * @param tokenId tokenId
 * @param protocolIncome protocolIncome
 */
public record WalletTransaction(
        String txHash,
        String time,
        String direction,
        String counterparty,
        String asset,
        String symbol,
        Object amount,
        Object fiatUsd,
        Boolean priced,
        String category,
        Boolean internal,
        Long logIndex,
        Double blockNumber,
        String explorerUrl,
        Boolean counterpartyListed,
        String kind,
        String tokenId,
        Boolean protocolIncome
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletTransaction}. */
    public static final class Builder {
        private String txHash;
        private String time;
        private String direction;
        private String counterparty;
        private String asset;
        private String symbol;
        private Object amount;
        private Object fiatUsd;
        private Boolean priced;
        private String category;
        private Boolean internal;
        private Long logIndex;
        private Double blockNumber;
        private String explorerUrl;
        private Boolean counterpartyListed;
        private String kind;
        private String tokenId;
        private Boolean protocolIncome;

        private Builder() {}

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
         * Sets amount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder amount(Object v) {
            this.amount = v;
            return this;
        }

        /**
         * Sets fiatUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fiatUsd(Object v) {
            this.fiatUsd = v;
            return this;
        }

        /**
         * Sets priced.
         *
         * @param v the value
         * @return this builder
         */
        public Builder priced(Boolean v) {
            this.priced = v;
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
         * Sets internal.
         *
         * @param v the value
         * @return this builder
         */
        public Builder internal(Boolean v) {
            this.internal = v;
            return this;
        }

        /**
         * Sets logIndex.
         *
         * @param v the value
         * @return this builder
         */
        public Builder logIndex(Long v) {
            this.logIndex = v;
            return this;
        }

        /**
         * Sets blockNumber.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blockNumber(Double v) {
            this.blockNumber = v;
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
         * Sets counterpartyListed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder counterpartyListed(Boolean v) {
            this.counterpartyListed = v;
            return this;
        }

        /**
         * Sets kind.
         *
         * @param v the value
         * @return this builder
         */
        public Builder kind(String v) {
            this.kind = v;
            return this;
        }

        /**
         * Sets tokenId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tokenId(String v) {
            this.tokenId = v;
            return this;
        }

        /**
         * Sets protocolIncome.
         *
         * @param v the value
         * @return this builder
         */
        public Builder protocolIncome(Boolean v) {
            this.protocolIncome = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletTransaction build() {
            return new WalletTransaction(txHash, time, direction, counterparty, asset, symbol, amount, fiatUsd, priced, category, internal, logIndex, blockNumber, explorerUrl, counterpartyListed, kind, tokenId, protocolIncome);
        }
    }
}
