package com.cryptascreen.sdk.model;

/**
 * WalletStolenAssetShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param symbol symbol
 * @param decimals decimals
 * @param stolenRaw stolenRaw
 * @param receivedRaw receivedRaw
 * @param sharePct sharePct
 * @param priced priced
 */
public record WalletStolenAssetShare(
        String symbol,
        Long decimals,
        String stolenRaw,
        String receivedRaw,
        Double sharePct,
        Boolean priced
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletStolenAssetShare}. */
    public static final class Builder {
        private String symbol;
        private Long decimals;
        private String stolenRaw;
        private String receivedRaw;
        private Double sharePct;
        private Boolean priced;

        private Builder() {}

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
         * Sets decimals.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decimals(Long v) {
            this.decimals = v;
            return this;
        }

        /**
         * Sets stolenRaw.
         *
         * @param v the value
         * @return this builder
         */
        public Builder stolenRaw(String v) {
            this.stolenRaw = v;
            return this;
        }

        /**
         * Sets receivedRaw.
         *
         * @param v the value
         * @return this builder
         */
        public Builder receivedRaw(String v) {
            this.receivedRaw = v;
            return this;
        }

        /**
         * Sets sharePct.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sharePct(Double v) {
            this.sharePct = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public WalletStolenAssetShare build() {
            return new WalletStolenAssetShare(symbol, decimals, stolenRaw, receivedRaw, sharePct, priced);
        }
    }
}
