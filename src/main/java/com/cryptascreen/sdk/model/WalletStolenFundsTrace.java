// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * WalletStolenFundsTrace (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param derivedFrom derivedFrom
 * @param policyVersion policyVersion
 * @param points points
 * @param blocks blocks
 * @param entries entries
 */
public record WalletStolenFundsTrace(
        String derivedFrom,
        String policyVersion,
        Long points,
        Object blocks,
        List<WalletDerivedExposure> entries
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletStolenFundsTrace}. */
    public static final class Builder {
        private String derivedFrom;
        private String policyVersion;
        private Long points;
        private Object blocks;
        private List<WalletDerivedExposure> entries;

        private Builder() {}

        /**
         * Sets derivedFrom.
         *
         * @param v the value
         * @return this builder
         */
        public Builder derivedFrom(String v) {
            this.derivedFrom = v;
            return this;
        }

        /**
         * Sets policyVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder policyVersion(String v) {
            this.policyVersion = v;
            return this;
        }

        /**
         * Sets points.
         *
         * @param v the value
         * @return this builder
         */
        public Builder points(Long v) {
            this.points = v;
            return this;
        }

        /**
         * Sets blocks.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blocks(Object v) {
            this.blocks = v;
            return this;
        }

        /**
         * Sets entries.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entries(List<WalletDerivedExposure> v) {
            this.entries = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletStolenFundsTrace build() {
            return new WalletStolenFundsTrace(derivedFrom, policyVersion, points, blocks, entries);
        }
    }
}
