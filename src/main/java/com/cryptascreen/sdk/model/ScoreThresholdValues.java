// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * Review / block thresholds.
 *
 * @param reviewAt reviewAt
 * @param blockAt blockAt
 */
public record ScoreThresholdValues(
        Integer reviewAt,
        Integer blockAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScoreThresholdValues}. */
    public static final class Builder {
        private Integer reviewAt;
        private Integer blockAt;

        private Builder() {}

        /**
         * Sets reviewAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reviewAt(Integer v) {
            this.reviewAt = v;
            return this;
        }

        /**
         * Sets blockAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blockAt(Integer v) {
            this.blockAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScoreThresholdValues build() {
            return new ScoreThresholdValues(reviewAt, blockAt);
        }
    }
}
