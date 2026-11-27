// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * GET /capabilities.
 *
 * @param chains chains
 * @param layers layers
 */
public record Capabilities(
        List<CapabilityChain> chains,
        List<CapabilityLayer> layers
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link Capabilities}. */
    public static final class Builder {
        private List<CapabilityChain> chains;
        private List<CapabilityLayer> layers;

        private Builder() {}

        /**
         * Sets chains.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chains(List<CapabilityChain> v) {
            this.chains = v;
            return this;
        }

        /**
         * Sets layers.
         *
         * @param v the value
         * @return this builder
         */
        public Builder layers(List<CapabilityLayer> v) {
            this.layers = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public Capabilities build() {
            return new Capabilities(chains, layers);
        }
    }
}
