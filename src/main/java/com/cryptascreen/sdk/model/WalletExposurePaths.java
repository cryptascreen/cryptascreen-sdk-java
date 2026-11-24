package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletExposurePaths (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param chain chain
 * @param address address
 * @param evaluationId evaluationId
 * @param section section
 * @param pathSearch pathSearch
 * @param maxHops maxHops
 * @param shareOfValue shareOfValue
 * @param hitCount hitCount
 * @param hits hits
 * @param categoryExposure categoryExposure
 * @param stolenFundsTrace stolenFundsTrace
 */
public record WalletExposurePaths(
        String chain,
        String address,
        String evaluationId,
        WalletSectionStatus section,
        WalletSectionStatus pathSearch,
        Long maxHops,
        WalletShareOfValue shareOfValue,
        Long hitCount,
        List<WalletExposureHit> hits,
        WalletCategoryExposure categoryExposure,
        WalletStolenFundsTrace stolenFundsTrace
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletExposurePaths}. */
    public static final class Builder {
        private String chain;
        private String address;
        private String evaluationId;
        private WalletSectionStatus section;
        private WalletSectionStatus pathSearch;
        private Long maxHops;
        private WalletShareOfValue shareOfValue;
        private Long hitCount;
        private List<WalletExposureHit> hits;
        private WalletCategoryExposure categoryExposure;
        private WalletStolenFundsTrace stolenFundsTrace;

        private Builder() {}

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
         * Sets evaluationId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evaluationId(String v) {
            this.evaluationId = v;
            return this;
        }

        /**
         * Sets section.
         *
         * @param v the value
         * @return this builder
         */
        public Builder section(WalletSectionStatus v) {
            this.section = v;
            return this;
        }

        /**
         * Sets pathSearch.
         *
         * @param v the value
         * @return this builder
         */
        public Builder pathSearch(WalletSectionStatus v) {
            this.pathSearch = v;
            return this;
        }

        /**
         * Sets maxHops.
         *
         * @param v the value
         * @return this builder
         */
        public Builder maxHops(Long v) {
            this.maxHops = v;
            return this;
        }

        /**
         * Sets shareOfValue.
         *
         * @param v the value
         * @return this builder
         */
        public Builder shareOfValue(WalletShareOfValue v) {
            this.shareOfValue = v;
            return this;
        }

        /**
         * Sets hitCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hitCount(Long v) {
            this.hitCount = v;
            return this;
        }

        /**
         * Sets hits.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hits(List<WalletExposureHit> v) {
            this.hits = v;
            return this;
        }

        /**
         * Sets categoryExposure.
         *
         * @param v the value
         * @return this builder
         */
        public Builder categoryExposure(WalletCategoryExposure v) {
            this.categoryExposure = v;
            return this;
        }

        /**
         * Sets stolenFundsTrace.
         *
         * @param v the value
         * @return this builder
         */
        public Builder stolenFundsTrace(WalletStolenFundsTrace v) {
            this.stolenFundsTrace = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletExposurePaths build() {
            return new WalletExposurePaths(chain, address, evaluationId, section, pathSearch, maxHops, shareOfValue, hitCount, hits, categoryExposure, stolenFundsTrace);
        }
    }
}
