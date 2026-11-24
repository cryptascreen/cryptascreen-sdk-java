package com.cryptascreen.sdk.model;

/**
 * NameScreenOptions (see types/names.ts in @cryptascreen/sdk).
 *
 * @param idempotencyKey idempotencyKey
 */
public record NameScreenOptions(
        String idempotencyKey
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameScreenOptions}. */
    public static final class Builder {
        private String idempotencyKey;

        private Builder() {}

        /**
         * Sets idempotencyKey.
         *
         * @param v the value
         * @return this builder
         */
        public Builder idempotencyKey(String v) {
            this.idempotencyKey = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameScreenOptions build() {
            return new NameScreenOptions(idempotencyKey);
        }
    }
}
