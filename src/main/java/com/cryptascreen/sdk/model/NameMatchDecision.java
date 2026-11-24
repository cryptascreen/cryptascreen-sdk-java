package com.cryptascreen.sdk.model;

/**
 * NameMatchDecision (see types/names.ts in @cryptascreen/sdk).
 *
 * @param value value
 * @param reason reason
 * @param decidedBy decidedBy
 * @param decidedAt decidedAt
 * @param autoApplied autoApplied
 */
public record NameMatchDecision(
        String value,
        String reason,
        String decidedBy,
        String decidedAt,
        Boolean autoApplied
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameMatchDecision}. */
    public static final class Builder {
        private String value;
        private String reason;
        private String decidedBy;
        private String decidedAt;
        private Boolean autoApplied;

        private Builder() {}

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
         * Sets reason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reason(String v) {
            this.reason = v;
            return this;
        }

        /**
         * Sets decidedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decidedBy(String v) {
            this.decidedBy = v;
            return this;
        }

        /**
         * Sets decidedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decidedAt(String v) {
            this.decidedAt = v;
            return this;
        }

        /**
         * Sets autoApplied.
         *
         * @param v the value
         * @return this builder
         */
        public Builder autoApplied(Boolean v) {
            this.autoApplied = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameMatchDecision build() {
            return new NameMatchDecision(value, reason, decidedBy, decidedAt, autoApplied);
        }
    }
}
