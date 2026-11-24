package com.cryptascreen.sdk.model;

/**
 * WalletFiat (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param currency currency
 * @param state state
 * @param received received
 * @param sent sent
 * @param total total
 * @param pricedTxCount pricedTxCount
 * @param unpricedTxCount unpricedTxCount
 */
public record WalletFiat(
        String currency,
        String state,
        Object received,
        Object sent,
        Object total,
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

    /** Builder for {@link WalletFiat}. */
    public static final class Builder {
        private String currency;
        private String state;
        private Object received;
        private Object sent;
        private Object total;
        private Long pricedTxCount;
        private Long unpricedTxCount;

        private Builder() {}

        /**
         * Sets currency.
         *
         * @param v the value
         * @return this builder
         */
        public Builder currency(String v) {
            this.currency = v;
            return this;
        }

        /**
         * Sets state.
         *
         * @param v the value
         * @return this builder
         */
        public Builder state(String v) {
            this.state = v;
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
        public WalletFiat build() {
            return new WalletFiat(currency, state, received, sent, total, pricedTxCount, unpricedTxCount);
        }
    }
}
