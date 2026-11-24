package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * HeuristicDetectorStatus (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param detector detector
 * @param outcome outcome
 * @param reason reason
 * @param missingCapabilities missingCapabilities
 * @param flagCount flagCount
 */
public record HeuristicDetectorStatus(
        String detector,
        String outcome,
        String reason,
        List<String> missingCapabilities,
        Long flagCount
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link HeuristicDetectorStatus}. */
    public static final class Builder {
        private String detector;
        private String outcome;
        private String reason;
        private List<String> missingCapabilities;
        private Long flagCount;

        private Builder() {}

        /**
         * Sets detector.
         *
         * @param v the value
         * @return this builder
         */
        public Builder detector(String v) {
            this.detector = v;
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
         * Sets missingCapabilities.
         *
         * @param v the value
         * @return this builder
         */
        public Builder missingCapabilities(List<String> v) {
            this.missingCapabilities = v;
            return this;
        }

        /**
         * Sets flagCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flagCount(Long v) {
            this.flagCount = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public HeuristicDetectorStatus build() {
            return new HeuristicDetectorStatus(detector, outcome, reason, missingCapabilities, flagCount);
        }
    }
}
