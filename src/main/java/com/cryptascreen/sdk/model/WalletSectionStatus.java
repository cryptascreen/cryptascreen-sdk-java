// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletSectionStatus (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param state state
 * @param reasonCode reasonCode
 * @param detail detail
 * @param provider provider
 * @param windowFrom windowFrom
 * @param windowTo windowTo
 * @param eventsRead eventsRead
 * @param pagesUsed pagesUsed
 * @param transferCount transferCount
 */
public record WalletSectionStatus(
        String state,
        String reasonCode,
        String detail,
        String provider,
        String windowFrom,
        String windowTo,
        Double eventsRead,
        Double pagesUsed,
        WalletTransferCount transferCount
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletSectionStatus}. */
    public static final class Builder {
        private String state;
        private String reasonCode;
        private String detail;
        private String provider;
        private String windowFrom;
        private String windowTo;
        private Double eventsRead;
        private Double pagesUsed;
        private WalletTransferCount transferCount;

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
         * Sets detail.
         *
         * @param v the value
         * @return this builder
         */
        public Builder detail(String v) {
            this.detail = v;
            return this;
        }

        /**
         * Sets provider.
         *
         * @param v the value
         * @return this builder
         */
        public Builder provider(String v) {
            this.provider = v;
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
         * Sets eventsRead.
         *
         * @param v the value
         * @return this builder
         */
        public Builder eventsRead(Double v) {
            this.eventsRead = v;
            return this;
        }

        /**
         * Sets pagesUsed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder pagesUsed(Double v) {
            this.pagesUsed = v;
            return this;
        }

        /**
         * Sets transferCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transferCount(WalletTransferCount v) {
            this.transferCount = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletSectionStatus build() {
            return new WalletSectionStatus(state, reasonCode, detail, provider, windowFrom, windowTo, eventsRead, pagesUsed, transferCount);
        }
    }
}
