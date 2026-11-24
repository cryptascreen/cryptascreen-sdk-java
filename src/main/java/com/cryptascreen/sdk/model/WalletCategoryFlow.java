package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletCategoryFlow (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param flow flow
 * @param usdTotal usdTotal
 * @param pricedTxCount pricedTxCount
 * @param unpricedTxCount unpricedTxCount
 * @param assetTotals assetTotals
 * @param categories categories
 * @param anyDirect anyDirect
 * @param anyIndirect anyIndirect
 * @param protocolIncome protocolIncome
 */
public record WalletCategoryFlow(
        String flow,
        Object usdTotal,
        Long pricedTxCount,
        Long unpricedTxCount,
        List<WalletCategoryAssetTotal> assetTotals,
        List<WalletCategoryShare> categories,
        WalletCategoryPart anyDirect,
        WalletCategoryPart anyIndirect,
        WalletCategoryPart protocolIncome
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryFlow}. */
    public static final class Builder {
        private String flow;
        private Object usdTotal;
        private Long pricedTxCount;
        private Long unpricedTxCount;
        private List<WalletCategoryAssetTotal> assetTotals;
        private List<WalletCategoryShare> categories;
        private WalletCategoryPart anyDirect;
        private WalletCategoryPart anyIndirect;
        private WalletCategoryPart protocolIncome;

        private Builder() {}

        /**
         * Sets flow.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flow(String v) {
            this.flow = v;
            return this;
        }

        /**
         * Sets usdTotal.
         *
         * @param v the value
         * @return this builder
         */
        public Builder usdTotal(Object v) {
            this.usdTotal = v;
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
         * Sets assetTotals.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assetTotals(List<WalletCategoryAssetTotal> v) {
            this.assetTotals = v;
            return this;
        }

        /**
         * Sets categories.
         *
         * @param v the value
         * @return this builder
         */
        public Builder categories(List<WalletCategoryShare> v) {
            this.categories = v;
            return this;
        }

        /**
         * Sets anyDirect.
         *
         * @param v the value
         * @return this builder
         */
        public Builder anyDirect(WalletCategoryPart v) {
            this.anyDirect = v;
            return this;
        }

        /**
         * Sets anyIndirect.
         *
         * @param v the value
         * @return this builder
         */
        public Builder anyIndirect(WalletCategoryPart v) {
            this.anyIndirect = v;
            return this;
        }

        /**
         * Sets protocolIncome.
         *
         * @param v the value
         * @return this builder
         */
        public Builder protocolIncome(WalletCategoryPart v) {
            this.protocolIncome = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryFlow build() {
            return new WalletCategoryFlow(flow, usdTotal, pricedTxCount, unpricedTxCount, assetTotals, categories, anyDirect, anyIndirect, protocolIncome);
        }
    }
}
