// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * NameCoverage (see types/names.ts in @cryptascreen/sdk).
 *
 * @param source source
 * @param state state
 * @param reason reason
 */
public record NameCoverage(
        String source,
        String state,
        String reason
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameCoverage}. */
    public static final class Builder {
        private String source;
        private String state;
        private String reason;

        private Builder() {}

        /**
         * Sets source.
         *
         * @param v the value
         * @return this builder
         */
        public Builder source(String v) {
            this.source = v;
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
         * Sets reason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reason(String v) {
            this.reason = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameCoverage build() {
            return new NameCoverage(source, state, reason);
        }
    }
}
