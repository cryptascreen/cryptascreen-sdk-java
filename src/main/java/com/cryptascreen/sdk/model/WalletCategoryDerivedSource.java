package com.cryptascreen.sdk.model;

/**
 * WalletCategoryDerivedSource (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param state state
 * @param reasonCode reasonCode
 * @param entries entries
 */
public record WalletCategoryDerivedSource(
        String id,
        String state,
        String reasonCode,
        Double entries
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryDerivedSource}. */
    public static final class Builder {
        private String id;
        private String state;
        private String reasonCode;
        private Double entries;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(String v) {
            this.id = v;
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
         * Sets reasonCode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasonCode(String v) {
            this.reasonCode = v;
            return this;
        }

        /**
         * Sets entries.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entries(Double v) {
            this.entries = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryDerivedSource build() {
            return new WalletCategoryDerivedSource(id, state, reasonCode, entries);
        }
    }
}
