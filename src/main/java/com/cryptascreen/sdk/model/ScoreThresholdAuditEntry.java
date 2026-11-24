package com.cryptascreen.sdk.model;

/**
 * One change of the thresholds (action SET | RESET).
 *
 * @param changedAt changedAt
 * @param actor actor
 * @param action action
 * @param previous previous
 * @param current current
 * @param version version
 */
public record ScoreThresholdAuditEntry(
        String changedAt,
        String actor,
        String action,
        ScoreThresholdValues previous,
        ScoreThresholdValues current,
        Long version
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScoreThresholdAuditEntry}. */
    public static final class Builder {
        private String changedAt;
        private String actor;
        private String action;
        private ScoreThresholdValues previous;
        private ScoreThresholdValues current;
        private Long version;

        private Builder() {}

        /**
         * Sets changedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder changedAt(String v) {
            this.changedAt = v;
            return this;
        }

        /**
         * Sets actor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder actor(String v) {
            this.actor = v;
            return this;
        }

        /**
         * Sets action.
         *
         * @param v the value
         * @return this builder
         */
        public Builder action(String v) {
            this.action = v;
            return this;
        }

        /**
         * Sets previous.
         *
         * @param v the value
         * @return this builder
         */
        public Builder previous(ScoreThresholdValues v) {
            this.previous = v;
            return this;
        }

        /**
         * Sets current.
         *
         * @param v the value
         * @return this builder
         */
        public Builder current(ScoreThresholdValues v) {
            this.current = v;
            return this;
        }

        /**
         * Sets version.
         *
         * @param v the value
         * @return this builder
         */
        public Builder version(Long v) {
            this.version = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScoreThresholdAuditEntry build() {
            return new ScoreThresholdAuditEntry(changedAt, actor, action, previous, current, version);
        }
    }
}
