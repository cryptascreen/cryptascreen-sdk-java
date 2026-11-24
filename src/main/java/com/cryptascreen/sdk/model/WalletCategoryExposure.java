package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletCategoryExposure (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param method method
 * @param maxHops maxHops
 * @param windowFrom windowFrom
 * @param windowTo windowTo
 * @param section section
 * @param pathSearch pathSearch
 * @param derivedSources derivedSources
 * @param received received
 * @param sent sent
 */
public record WalletCategoryExposure(
        String method,
        Long maxHops,
        String windowFrom,
        String windowTo,
        WalletSectionStatus section,
        WalletSectionStatus pathSearch,
        List<WalletCategoryDerivedSource> derivedSources,
        WalletCategoryFlow received,
        WalletCategoryFlow sent
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryExposure}. */
    public static final class Builder {
        private String method;
        private Long maxHops;
        private String windowFrom;
        private String windowTo;
        private WalletSectionStatus section;
        private WalletSectionStatus pathSearch;
        private List<WalletCategoryDerivedSource> derivedSources;
        private WalletCategoryFlow received;
        private WalletCategoryFlow sent;

        private Builder() {}

        /**
         * Sets method.
         *
         * @param v the value
         * @return this builder
         */
        public Builder method(String v) {
            this.method = v;
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
         * Sets windowFrom.
         *
         * @param v the value
         * @return this builder
         */
        public Builder windowFrom(String v) {
            this.windowFrom = v;
            return this;
        }

        /**
         * Sets windowTo.
         *
         * @param v the value
         * @return this builder
         */
        public Builder windowTo(String v) {
            this.windowTo = v;
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
         * Sets derivedSources.
         *
         * @param v the value
         * @return this builder
         */
        public Builder derivedSources(List<WalletCategoryDerivedSource> v) {
            this.derivedSources = v;
            return this;
        }

        /**
         * Sets received.
         *
         * @param v the value
         * @return this builder
         */
        public Builder received(WalletCategoryFlow v) {
            this.received = v;
            return this;
        }

        /**
         * Sets sent.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sent(WalletCategoryFlow v) {
            this.sent = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryExposure build() {
            return new WalletCategoryExposure(method, maxHops, windowFrom, windowTo, section, pathSearch, derivedSources, received, sent);
        }
    }
}
