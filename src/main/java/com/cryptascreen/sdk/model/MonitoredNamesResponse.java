// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * GET /monitoring/names.
 *
 * @param items items
 * @param used used
 */
public record MonitoredNamesResponse(
        List<Map<String, Object>> items,
        Long used
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link MonitoredNamesResponse}. */
    public static final class Builder {
        private List<Map<String, Object>> items;
        private Long used;

        private Builder() {}

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<Map<String, Object>> v) {
            this.items = v;
            return this;
        }

        /**
         * Sets used.
         *
         * @param v the value
         * @return this builder
         */
        public Builder used(Long v) {
            this.used = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public MonitoredNamesResponse build() {
            return new MonitoredNamesResponse(items, used);
        }
    }
}
