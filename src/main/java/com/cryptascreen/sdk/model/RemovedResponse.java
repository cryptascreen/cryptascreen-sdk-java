package com.cryptascreen.sdk.model;

/**
 * {removed: true}.
 *
 * @param removed removed
 */
public record RemovedResponse(
        Boolean removed
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link RemovedResponse}. */
    public static final class Builder {
        private Boolean removed;

        private Builder() {}

        /**
         * Sets removed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder removed(Boolean v) {
            this.removed = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public RemovedResponse build() {
            return new RemovedResponse(removed);
        }
    }
}
