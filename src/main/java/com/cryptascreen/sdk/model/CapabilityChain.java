// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * A chain the screening API accepts.
 *
 * @param chain chain
 * @param displayName displayName
 * @param onChain onChain
 * @param sanctionsScreenable sanctionsScreenable
 */
public record CapabilityChain(
        String chain,
        String displayName,
        String onChain,
        Boolean sanctionsScreenable
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CapabilityChain}. */
    public static final class Builder {
        private String chain;
        private String displayName;
        private String onChain;
        private Boolean sanctionsScreenable;

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
         * Sets displayName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder displayName(String v) {
            this.displayName = v;
            return this;
        }

        /**
         * Sets onChain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder onChain(String v) {
            this.onChain = v;
            return this;
        }

        /**
         * Sets sanctionsScreenable.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionsScreenable(Boolean v) {
            this.sanctionsScreenable = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CapabilityChain build() {
            return new CapabilityChain(chain, displayName, onChain, sanctionsScreenable);
        }
    }
}
