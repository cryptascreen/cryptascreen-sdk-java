package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * GET /settings/score-thresholds/audit.
 *
 * @param items items
 */
public record ScoreThresholdAuditPage(
        List<ScoreThresholdAuditEntry> items
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScoreThresholdAuditPage}. */
    public static final class Builder {
        private List<ScoreThresholdAuditEntry> items;

        private Builder() {}

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<ScoreThresholdAuditEntry> v) {
            this.items = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScoreThresholdAuditPage build() {
            return new ScoreThresholdAuditPage(items);
        }
    }
}
