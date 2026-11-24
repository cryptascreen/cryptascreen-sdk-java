package com.cryptascreen.sdk.model;

/**
 * AsyncSubmitOptions (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param idempotencyKey idempotencyKey
 */
public record AsyncSubmitOptions(
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

    /** Builder for {@link AsyncSubmitOptions}. */
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
        public AsyncSubmitOptions build() {
            return new AsyncSubmitOptions(idempotencyKey);
        }
    }
}
