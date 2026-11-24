package com.cryptascreen.sdk.model;

/**
 * Tenant thresholds (defaults 40 / 70 until changed).
 *
 * @param reviewAt reviewAt
 * @param blockAt blockAt
 * @param source source
 * @param version version
 * @param defaults defaults
 * @param updatedAt updatedAt
 * @param updatedBy updatedBy
 */
public record ScoreThresholdSettings(
        Integer reviewAt,
        Integer blockAt,
        String source,
        Long version,
        ScoreThresholdValues defaults,
        String updatedAt,
        String updatedBy
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScoreThresholdSettings}. */
    public static final class Builder {
        private Integer reviewAt;
        private Integer blockAt;
        private String source;
        private Long version;
        private ScoreThresholdValues defaults;
        private String updatedAt;
        private String updatedBy;

        private Builder() {}

        /**
         * Sets reviewAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reviewAt(Integer v) {
            this.reviewAt = v;
            return this;
        }

        /**
         * Sets blockAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blockAt(Integer v) {
            this.blockAt = v;
            return this;
        }

        /**
         * Sets source.
         *
         * @param v the value
         * @return this builder
         */
        public Builder source(String v) {
            this.source = v;
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
         * Sets defaults.
         *
         * @param v the value
         * @return this builder
         */
        public Builder defaults(ScoreThresholdValues v) {
            this.defaults = v;
            return this;
        }

        /**
         * Sets updatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedAt(String v) {
            this.updatedAt = v;
            return this;
        }

        /**
         * Sets updatedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedBy(String v) {
            this.updatedBy = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScoreThresholdSettings build() {
            return new ScoreThresholdSettings(reviewAt, blockAt, source, version, defaults, updatedAt, updatedBy);
        }
    }
}
