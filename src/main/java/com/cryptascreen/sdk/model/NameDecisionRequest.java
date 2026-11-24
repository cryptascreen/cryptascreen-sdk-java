package com.cryptascreen.sdk.model;

/**
 * NameDecisionRequest (see types/names.ts in @cryptascreen/sdk).
 *
 * @param hitId hitId
 * @param value value
 * @param reason reason
 */
public record NameDecisionRequest(
        String hitId,
        String value,
        String reason
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameDecisionRequest}. */
    public static final class Builder {
        private String hitId;
        private String value;
        private String reason;

        private Builder() {}

        /**
         * Sets hitId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hitId(String v) {
            this.hitId = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public NameDecisionRequest build() {
            return new NameDecisionRequest(hitId, value, reason);
        }
    }
}
