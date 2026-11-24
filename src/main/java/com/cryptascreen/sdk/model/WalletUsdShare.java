package com.cryptascreen.sdk.model;

/**
 * WalletUsdShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param total total
 * @param direct direct
 * @param withinHops withinHops
 * @param directShare directShare
 * @param withinHopsShare withinHopsShare
 * @param pricedTxCount pricedTxCount
 * @param unpricedTxCount unpricedTxCount
 */
public record WalletUsdShare(
        Object total,
        Object direct,
        Object withinHops,
        Object directShare,
        Object withinHopsShare,
        Long pricedTxCount,
        Long unpricedTxCount
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletUsdShare}. */
    public static final class Builder {
        private Object total;
        private Object direct;
        private Object withinHops;
        private Object directShare;
        private Object withinHopsShare;
        private Long pricedTxCount;
        private Long unpricedTxCount;

        private Builder() {}

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
         * Sets pricedTxCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder pricedTxCount(Long v) {
            this.pricedTxCount = v;
            return this;
        }

        /**
         * Sets unpricedTxCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder unpricedTxCount(Long v) {
            this.unpricedTxCount = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletUsdShare build() {
            return new WalletUsdShare(total, direct, withinHops, directShare, withinHopsShare, pricedTxCount, unpricedTxCount);
        }
    }
}
