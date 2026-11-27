// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * NameScreenRequest (see types/names.ts in @cryptascreen/sdk).
 *
 * @param name name
 * @param type type
 * @param aliases aliases
 * @param dateOfBirth dateOfBirth
 * @param nationalities nationalities
 * @param country country
 * @param identifiers identifiers
 * @param monitor monitor
 */
public record NameScreenRequest(
        String name,
        String type,
        List<String> aliases,
        String dateOfBirth,
        List<String> nationalities,
        String country,
        List<NameIdentifier> identifiers,
        Boolean monitor
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameScreenRequest}. */
    public static final class Builder {
        private String name;
        private String type;
        private List<String> aliases;
        private String dateOfBirth;
        private List<String> nationalities;
        private String country;
        private List<NameIdentifier> identifiers;
        private Boolean monitor;

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
         * Sets aliases.
         *
         * @param v the value
         * @return this builder
         */
        public Builder aliases(List<String> v) {
            this.aliases = v;
            return this;
        }

        /**
         * Sets dateOfBirth.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dateOfBirth(String v) {
            this.dateOfBirth = v;
            return this;
        }

        /**
         * Sets nationalities.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nationalities(List<String> v) {
            this.nationalities = v;
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
         * Sets identifiers.
         *
         * @param v the value
         * @return this builder
         */
        public Builder identifiers(List<NameIdentifier> v) {
            this.identifiers = v;
            return this;
        }

        /**
         * Sets monitor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder monitor(Boolean v) {
            this.monitor = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameScreenRequest build() {
            return new NameScreenRequest(name, type, aliases, dateOfBirth, nationalities, country, identifiers, monitor);
        }
    }
}
