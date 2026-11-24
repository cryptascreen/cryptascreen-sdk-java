package com.cryptascreen.sdk.model;

/**
 * WalletPathStep (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param index index
 * @param from from
 * @param to to
 * @param txHash txHash
 * @param time time
 * @param asset asset
 * @param symbol symbol
 * @param amount amount
 * @param fiatUsd fiatUsd
 * @param edgeTxCount edgeTxCount
 * @param explorerUrl explorerUrl
 */
public record WalletPathStep(
        Long index,
        String from,
        String to,
        String txHash,
        String time,
        String asset,
        String symbol,
        Object amount,
        Object fiatUsd,
        Long edgeTxCount,
        String explorerUrl
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletPathStep}. */
    public static final class Builder {
        private Long index;
        private String from;
        private String to;
        private String txHash;
        private String time;
        private String asset;
        private String symbol;
        private Object amount;
        private Object fiatUsd;
        private Long edgeTxCount;
        private String explorerUrl;

        private Builder() {}

        /**
         * Sets index.
         *
         * @param v the value
         * @return this builder
         */
        public Builder index(Long v) {
            this.index = v;
            return this;
        }

        /**
         * Sets from.
         *
         * @param v the value
         * @return this builder
         */
        public Builder from(String v) {
            this.from = v;
            return this;
        }

        /**
         * Sets to.
         *
         * @param v the value
         * @return this builder
         */
        public Builder to(String v) {
            this.to = v;
            return this;
        }

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
         * Sets edgeTxCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder edgeTxCount(Long v) {
            this.edgeTxCount = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public WalletPathStep build() {
            return new WalletPathStep(index, from, to, txHash, time, asset, symbol, amount, fiatUsd, edgeTxCount, explorerUrl);
        }
    }
}
