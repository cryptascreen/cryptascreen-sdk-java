// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * Dac8OperatorInfo (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param name name
 * @param tin tin
 * @param tinIssuedBy tinIssuedBy
 * @param registrationNumber registrationNumber
 * @param address address
 * @param country country
 */
public record Dac8OperatorInfo(
        String name,
        String tin,
        String tinIssuedBy,
        String registrationNumber,
        String address,
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

    /** Builder for {@link Dac8OperatorInfo}. */
    public static final class Builder {
        private String name;
        private String tin;
        private String tinIssuedBy;
        private String registrationNumber;
        private String address;
        private String country;

        private Builder() {}

        /**
         * Sets name.
         *
         * @param v the value
         * @return this builder
         */
        public Builder name(String v) {
            this.name = v;
            return this;
        }

        /**
         * Sets tin.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tin(String v) {
            this.tin = v;
            return this;
        }

        /**
         * Sets tinIssuedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tinIssuedBy(String v) {
            this.tinIssuedBy = v;
            return this;
        }

        /**
         * Sets registrationNumber.
         *
         * @param v the value
         * @return this builder
         */
        public Builder registrationNumber(String v) {
            this.registrationNumber = v;
            return this;
        }

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
        public Dac8OperatorInfo build() {
            return new Dac8OperatorInfo(name, tin, tinIssuedBy, registrationNumber, address, country);
        }
    }
}
