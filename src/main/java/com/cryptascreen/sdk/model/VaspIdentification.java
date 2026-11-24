package com.cryptascreen.sdk.model;

/**
 * VaspIdentification (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param identified identified
 * @param vasp_name vasp_name
 * @param jurisdiction jurisdiction
 * @param mica_registered mica_registered
 * @param travel_rule_protocol travel_rule_protocol
 */
public record VaspIdentification(
        Boolean identified,
        String vasp_name,
        String jurisdiction,
        Boolean mica_registered,
        String travel_rule_protocol
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link VaspIdentification}. */
    public static final class Builder {
        private Boolean identified;
        private String vasp_name;
        private String jurisdiction;
        private Boolean mica_registered;
        private String travel_rule_protocol;

        private Builder() {}

        /**
         * Sets identified.
         *
         * @param v the value
         * @return this builder
         */
        public Builder identified(Boolean v) {
            this.identified = v;
            return this;
        }

        /**
         * Sets vasp_name.
         *
         * @param v the value
         * @return this builder
         */
        public Builder vasp_name(String v) {
            this.vasp_name = v;
            return this;
        }

        /**
         * Sets jurisdiction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder jurisdiction(String v) {
            this.jurisdiction = v;
            return this;
        }

        /**
         * Sets mica_registered.
         *
         * @param v the value
         * @return this builder
         */
        public Builder mica_registered(Boolean v) {
            this.mica_registered = v;
            return this;
        }

        /**
         * Sets travel_rule_protocol.
         *
         * @param v the value
         * @return this builder
         */
        public Builder travel_rule_protocol(String v) {
            this.travel_rule_protocol = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public VaspIdentification build() {
            return new VaspIdentification(identified, vasp_name, jurisdiction, mica_registered, travel_rule_protocol);
        }
    }
}
