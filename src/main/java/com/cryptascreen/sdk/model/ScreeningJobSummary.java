// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningJobSummary (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param highRiskAddresses highRiskAddresses
 * @param criticalAddresses criticalAddresses
 * @param sanctionedAddresses sanctionedAddresses
 */
public record ScreeningJobSummary(
        List<String> highRiskAddresses,
        List<String> criticalAddresses,
        List<String> sanctionedAddresses
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningJobSummary}. */
    public static final class Builder {
        private List<String> highRiskAddresses;
        private List<String> criticalAddresses;
        private List<String> sanctionedAddresses;

        private Builder() {}

        /**
         * Sets highRiskAddresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder highRiskAddresses(List<String> v) {
            this.highRiskAddresses = v;
            return this;
        }

        /**
         * Sets criticalAddresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder criticalAddresses(List<String> v) {
            this.criticalAddresses = v;
            return this;
        }

        /**
         * Sets sanctionedAddresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionedAddresses(List<String> v) {
            this.sanctionedAddresses = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningJobSummary build() {
            return new ScreeningJobSummary(highRiskAddresses, criticalAddresses, sanctionedAddresses);
        }
    }
}
