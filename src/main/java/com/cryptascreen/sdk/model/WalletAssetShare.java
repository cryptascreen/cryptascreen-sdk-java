package com.cryptascreen.sdk.model;

/**
 * WalletAssetShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param asset asset
 * @param symbol symbol
 * @param total total
 * @param direct direct
 * @param withinHops withinHops
 * @param directShare directShare
 * @param withinHopsShare withinHopsShare
 * @param txCount txCount
 */
public record WalletAssetShare(
        String asset,
        String symbol,
        Object total,
        Object direct,
        Object withinHops,
        Object directShare,
        Object withinHopsShare,
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

    /** Builder for {@link WalletAssetShare}. */
    public static final class Builder {
        private String asset;
        private String symbol;
        private Object total;
        private Object direct;
        private Object withinHops;
        private Object directShare;
        private Object withinHopsShare;
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
         * Sets direct.
         *
         * @param v the value
         * @return this builder
         */
        public Builder direct(Object v) {
            this.direct = v;
            return this;
        }

        /**
         * Sets withinHops.
         *
         * @param v the value
         * @return this builder
         */
        public Builder withinHops(Object v) {
            this.withinHops = v;
            return this;
        }

        /**
         * Sets directShare.
         *
         * @param v the value
         * @return this builder
         */
        public Builder directShare(Object v) {
            this.directShare = v;
            return this;
        }

        /**
         * Sets withinHopsShare.
         *
         * @param v the value
         * @return this builder
         */
        public Builder withinHopsShare(Object v) {
            this.withinHopsShare = v;
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
        public WalletAssetShare build() {
            return new WalletAssetShare(asset, symbol, total, direct, withinHops, directShare, withinHopsShare, txCount);
        }
    }
}
