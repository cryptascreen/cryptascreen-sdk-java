// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * Counts of breach detections.
 *
 * @param unacknowledgedCount unacknowledgedCount
 * @param bySeverity bySeverity
 * @param totalBreaches totalBreaches
 */
public record BreachSummary(
        Long unacknowledgedCount,
        Map<String, Long> bySeverity,
        Long totalBreaches
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link BreachSummary}. */
    public static final class Builder {
        private Long unacknowledgedCount;
        private Map<String, Long> bySeverity;
        private Long totalBreaches;

        private Builder() {}

        /**
         * Sets unacknowledgedCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder unacknowledgedCount(Long v) {
            this.unacknowledgedCount = v;
            return this;
        }

        /**
         * Sets bySeverity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder bySeverity(Map<String, Long> v) {
            this.bySeverity = v;
            return this;
        }

        /**
         * Sets totalBreaches.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalBreaches(Long v) {
            this.totalBreaches = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public BreachSummary build() {
            return new BreachSummary(unacknowledgedCount, bySeverity, totalBreaches);
        }
    }
}
