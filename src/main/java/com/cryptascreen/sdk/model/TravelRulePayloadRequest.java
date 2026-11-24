package com.cryptascreen.sdk.model;

/**
 * TravelRulePayloadRequest (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param txHash txHash
 * @param chain chain
 * @param originatorName originatorName
 * @param originatorFirstName originatorFirstName
 * @param originatorLastName originatorLastName
 * @param originatorWalletAddress originatorWalletAddress
 * @param originatorVaspName originatorVaspName
 * @param transferAmountUsd transferAmountUsd
 */
public record TravelRulePayloadRequest(
        String txHash,
        String chain,
        String originatorName,
        String originatorFirstName,
        String originatorLastName,
        String originatorWalletAddress,
        String originatorVaspName,
        Double transferAmountUsd
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link TravelRulePayloadRequest}. */
    public static final class Builder {
        private String txHash;
        private String chain;
        private String originatorName;
        private String originatorFirstName;
        private String originatorLastName;
        private String originatorWalletAddress;
        private String originatorVaspName;
        private Double transferAmountUsd;

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
         * Sets originatorName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorName(String v) {
            this.originatorName = v;
            return this;
        }

        /**
         * Sets originatorFirstName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorFirstName(String v) {
            this.originatorFirstName = v;
            return this;
        }

        /**
         * Sets originatorLastName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorLastName(String v) {
            this.originatorLastName = v;
            return this;
        }

        /**
         * Sets originatorWalletAddress.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorWalletAddress(String v) {
            this.originatorWalletAddress = v;
            return this;
        }

        /**
         * Sets originatorVaspName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder originatorVaspName(String v) {
            this.originatorVaspName = v;
            return this;
        }

        /**
         * Sets transferAmountUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transferAmountUsd(Double v) {
            this.transferAmountUsd = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public TravelRulePayloadRequest build() {
            return new TravelRulePayloadRequest(txHash, chain, originatorName, originatorFirstName, originatorLastName, originatorWalletAddress, originatorVaspName, transferAmountUsd);
        }
    }
}
