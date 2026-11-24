package com.cryptascreen.sdk.model;

/**
 * NameMatchReason (see types/names.ts in @cryptascreen/sdk).
 *
 * @param field field
 * @param outcome outcome
 * @param points points
 * @param detail detail
 */
public record NameMatchReason(
        String field,
        String outcome,
        Long points,
        String detail
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameMatchReason}. */
    public static final class Builder {
        private String field;
        private String outcome;
        private Long points;
        private String detail;

        private Builder() {}

        /**
         * Sets field.
         *
         * @param v the value
         * @return this builder
         */
        public Builder field(String v) {
            this.field = v;
            return this;
        }

        /**
         * Sets outcome.
         *
         * @param v the value
         * @return this builder
         */
        public Builder outcome(String v) {
            this.outcome = v;
            return this;
        }

        /**
         * Sets points.
         *
         * @param v the value
         * @return this builder
         */
        public Builder points(Long v) {
            this.points = v;
            return this;
        }

        /**
         * Sets detail.
         *
         * @param v the value
         * @return this builder
         */
        public Builder detail(String v) {
            this.detail = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameMatchReason build() {
            return new NameMatchReason(field, outcome, points, detail);
        }
    }
}
