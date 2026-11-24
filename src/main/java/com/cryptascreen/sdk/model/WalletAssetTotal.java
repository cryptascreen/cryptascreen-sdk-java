package com.cryptascreen.sdk.model;

/**
 * WalletAssetTotal (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param asset asset
 * @param symbol symbol
 * @param received received
 * @param sent sent
 * @param txCount txCount
 */
public record WalletAssetTotal(
        String asset,
        String symbol,
        Object received,
        Object sent,
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

    /** Builder for {@link WalletAssetTotal}. */
    public static final class Builder {
        private String asset;
        private String symbol;
        private Object received;
        private Object sent;
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
         * Sets received.
         *
         * @param v the value
         * @return this builder
         */
        public Builder received(Object v) {
            this.received = v;
            return this;
        }

        /**
         * Sets sent.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sent(Object v) {
            this.sent = v;
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
        public WalletAssetTotal build() {
            return new WalletAssetTotal(asset, symbol, received, sent, txCount);
        }
    }
}
