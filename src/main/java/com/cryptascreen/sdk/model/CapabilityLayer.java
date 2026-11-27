// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * Live state of a screening layer.
 *
 * @param layer layer
 * @param state state
 * @param status status
 * @param sources sources
 */
public record CapabilityLayer(
        String layer,
        String state,
        String status,
        List<String> sources
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CapabilityLayer}. */
    public static final class Builder {
        private String layer;
        private String state;
        private String status;
        private List<String> sources;

        private Builder() {}

        /**
         * Sets layer.
         *
         * @param v the value
         * @return this builder
         */
        public Builder layer(String v) {
            this.layer = v;
            return this;
        }

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
         * Sets status.
         *
         * @param v the value
         * @return this builder
         */
        public Builder status(String v) {
            this.status = v;
            return this;
        }

        /**
         * Sets sources.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sources(List<String> v) {
            this.sources = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CapabilityLayer build() {
            return new CapabilityLayer(layer, state, status, sources);
        }
    }
}
