// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * NameIdentifier (see types/names.ts in @cryptascreen/sdk).
 *
 * @param type type
 * @param value value
 * @param country country
 */
public record NameIdentifier(
        String type,
        String value,
        String country
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameIdentifier}. */
    public static final class Builder {
        private String type;
        private String value;
        private String country;

        private Builder() {}

        /**
         * Sets type.
         *
         * @param v the value
         * @return this builder
         */
        public Builder type(String v) {
            this.type = v;
            return this;
        }

        /**
         * Sets value.
         *
         * @param v the value
         * @return this builder
         */
        public Builder value(String v) {
            this.value = v;
            return this;
        }

        /**
         * Sets country.
         *
         * @param v the value
         * @return this builder
         */
        public Builder country(String v) {
            this.country = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameIdentifier build() {
            return new NameIdentifier(type, value, country);
        }
    }
}
