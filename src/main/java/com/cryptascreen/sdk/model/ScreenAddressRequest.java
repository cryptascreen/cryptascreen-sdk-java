// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * ScreenAddressRequest (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param address address
 * @param chain chain
 * @param includeHeuristics includeHeuristics
 * @param forceRefresh forceRefresh
 * @param mode mode
 */
public record ScreenAddressRequest(
        String address,
        String chain,
        Boolean includeHeuristics,
        Boolean forceRefresh,
        String mode
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreenAddressRequest}. */
    public static final class Builder {
        private String address;
        private String chain;
        private Boolean includeHeuristics;
        private Boolean forceRefresh;
        private String mode;

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
         * Sets includeHeuristics.
         *
         * @param v the value
         * @return this builder
         */
        public Builder includeHeuristics(Boolean v) {
            this.includeHeuristics = v;
            return this;
        }

        /**
         * Sets forceRefresh.
         *
         * @param v the value
         * @return this builder
         */
        public Builder forceRefresh(Boolean v) {
            this.forceRefresh = v;
            return this;
        }

        /**
         * Sets mode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder mode(String v) {
            this.mode = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreenAddressRequest build() {
            return new ScreenAddressRequest(address, chain, includeHeuristics, forceRefresh, mode);
        }
    }
}
