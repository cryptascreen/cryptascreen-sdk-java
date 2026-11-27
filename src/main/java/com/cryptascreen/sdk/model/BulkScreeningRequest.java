// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * BulkScreeningRequest (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param addresses addresses
 * @param chains chains
 * @param async async
 * @param names names
 */
public record BulkScreeningRequest(
        List<String> addresses,
        List<String> chains,
        Boolean async,
        List<Object> names
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link BulkScreeningRequest}. */
    public static final class Builder {
        private List<String> addresses;
        private List<String> chains;
        private Boolean async;
        private List<Object> names;

        private Builder() {}

        /**
         * Sets addresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder addresses(List<String> v) {
            this.addresses = v;
            return this;
        }

        /**
         * Sets chains.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chains(List<String> v) {
            this.chains = v;
            return this;
        }

        /**
         * Sets async.
         *
         * @param v the value
         * @return this builder
         */
        public Builder async(Boolean v) {
            this.async = v;
            return this;
        }

        /**
         * Sets names.
         *
         * @param v the value
         * @return this builder
         */
        public Builder names(List<Object> v) {
            this.names = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public BulkScreeningRequest build() {
            return new BulkScreeningRequest(addresses, chains, async, names);
        }
    }
}
