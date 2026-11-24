package com.cryptascreen.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * NameScreenResponse (see types/names.ts in @cryptascreen/sdk).
 *
 * @param screeningId screeningId
 * @param subjectRef subjectRef
 * @param outcome outcome
 * @param listMatch listMatch
 * @param policyVersion policyVersion
 * @param strength strength
 * @param threshold threshold
 * @param listsVersion listsVersion
 * @param coverage coverage
 * @param hits hits
 * @param caseRef caseRef
 * @param createdAt createdAt
 * @param replayed replayed
 */
public record NameScreenResponse(
        String screeningId,
        String subjectRef,
        String outcome,
        String listMatch,
        String policyVersion,
        String strength,
        Double threshold,
        Map<String, String> listsVersion,
        List<NameCoverage> coverage,
        List<NameHit> hits,
        String caseRef,
        String createdAt,
        Boolean replayed
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameScreenResponse}. */
    public static final class Builder {
        private String screeningId;
        private String subjectRef;
        private String outcome;
        private String listMatch;
        private String policyVersion;
        private String strength;
        private Double threshold;
        private Map<String, String> listsVersion;
        private List<NameCoverage> coverage;
        private List<NameHit> hits;
        private String caseRef;
        private String createdAt;
        private Boolean replayed;

        private Builder() {}

        /**
         * Sets screeningId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder screeningId(String v) {
            this.screeningId = v;
            return this;
        }

        /**
         * Sets subjectRef.
         *
         * @param v the value
         * @return this builder
         */
        public Builder subjectRef(String v) {
            this.subjectRef = v;
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
         * Sets listMatch.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listMatch(String v) {
            this.listMatch = v;
            return this;
        }

        /**
         * Sets policyVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder policyVersion(String v) {
            this.policyVersion = v;
            return this;
        }

        /**
         * Sets strength.
         *
         * @param v the value
         * @return this builder
         */
        public Builder strength(String v) {
            this.strength = v;
            return this;
        }

        /**
         * Sets threshold.
         *
         * @param v the value
         * @return this builder
         */
        public Builder threshold(Double v) {
            this.threshold = v;
            return this;
        }

        /**
         * Sets listsVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listsVersion(Map<String, String> v) {
            this.listsVersion = v;
            return this;
        }

        /**
         * Sets coverage.
         *
         * @param v the value
         * @return this builder
         */
        public Builder coverage(List<NameCoverage> v) {
            this.coverage = v;
            return this;
        }

        /**
         * Sets hits.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hits(List<NameHit> v) {
            this.hits = v;
            return this;
        }

        /**
         * Sets caseRef.
         *
         * @param v the value
         * @return this builder
         */
        public Builder caseRef(String v) {
            this.caseRef = v;
            return this;
        }

        /**
         * Sets createdAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder createdAt(String v) {
            this.createdAt = v;
            return this;
        }

        /**
         * Sets replayed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder replayed(Boolean v) {
            this.replayed = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameScreenResponse build() {
            return new NameScreenResponse(screeningId, subjectRef, outcome, listMatch, policyVersion, strength, threshold, listsVersion, coverage, hits, caseRef, createdAt, replayed);
        }
    }
}
