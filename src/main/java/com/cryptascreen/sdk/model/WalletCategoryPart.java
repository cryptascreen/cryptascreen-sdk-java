package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletCategoryPart (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param state state
 * @param reasonCode reasonCode
 * @param usd usd
 * @param usdShare usdShare
 * @param txCount txCount
 * @param byAsset byAsset
 */
public record WalletCategoryPart(
        String state,
        String reasonCode,
        Object usd,
        Object usdShare,
        Long txCount,
        List<WalletCategoryAssetShare> byAsset
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryPart}. */
    public static final class Builder {
        private String state;
        private String reasonCode;
        private Object usd;
        private Object usdShare;
        private Long txCount;
        private List<WalletCategoryAssetShare> byAsset;

        private Builder() {}

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
         * Sets reasonCode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasonCode(String v) {
            this.reasonCode = v;
            return this;
        }

        /**
         * Sets usd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder usd(Object v) {
            this.usd = v;
            return this;
        }

        /**
         * Sets usdShare.
         *
         * @param v the value
         * @return this builder
         */
        public Builder usdShare(Object v) {
            this.usdShare = v;
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
         * Sets byAsset.
         *
         * @param v the value
         * @return this builder
         */
        public Builder byAsset(List<WalletCategoryAssetShare> v) {
            this.byAsset = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryPart build() {
            return new WalletCategoryPart(state, reasonCode, usd, usdShare, txCount, byAsset);
        }
    }
}
