package com.cryptascreen.sdk.model;

/**
 * Body of monitoring().addWallet.
 *
 * @param address address
 * @param chain chain
 * @param label label
 */
public record AddMonitoredWalletRequest(
        String address,
        String chain,
        String label
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AddMonitoredWalletRequest}. */
    public static final class Builder {
        private String address;
        private String chain;
        private String label;

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
         * Sets chain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chain(String v) {
            this.chain = v;
            return this;
        }

        /**
         * Sets label.
         *
         * @param v the value
         * @return this builder
         */
        public Builder label(String v) {
            this.label = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AddMonitoredWalletRequest build() {
            return new AddMonitoredWalletRequest(address, chain, label);
        }
    }
}
