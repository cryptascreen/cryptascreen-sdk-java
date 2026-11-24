package com.cryptascreen.sdk.model;

/**
 * ScreeningEvaluation (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param evaluationId evaluationId
 * @param jobId jobId
 * @param origin origin
 * @param actor actor
 * @param input input
 * @param evaluatedAt evaluatedAt
 * @param riskScore riskScore
 * @param riskLevel riskLevel
 * @param assessmentStatus assessmentStatus
 * @param disposition disposition
 * @param coverage coverage
 * @param sanctionsMatch sanctionsMatch
 * @param blockingMatch blockingMatch
 * @param cacheHit cacheHit
 * @param policyVersion policyVersion
 * @param scoreVersion scoreVersion
 * @param scope scope
 * @param evidence evidence
 * @param result result
 * @param supersession supersession
 * @param latest latest
 * @param integrity integrity
 * @param retention retention
 */
public record ScreeningEvaluation(
        String evaluationId,
        String jobId,
        String origin,
        Object actor,
        Object input,
        String evaluatedAt,
        Double riskScore,
        String riskLevel,
        String assessmentStatus,
        String disposition,
        String coverage,
        Boolean sanctionsMatch,
        Boolean blockingMatch,
        Boolean cacheHit,
        String policyVersion,
        String scoreVersion,
        Object scope,
        Object evidence,
        ScreeningResponse result,
        Object supersession,
        Boolean latest,
        Object integrity,
        Object retention
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningEvaluation}. */
    public static final class Builder {
        private String evaluationId;
        private String jobId;
        private String origin;
        private Object actor;
        private Object input;
        private String evaluatedAt;
        private Double riskScore;
        private String riskLevel;
        private String assessmentStatus;
        private String disposition;
        private String coverage;
        private Boolean sanctionsMatch;
        private Boolean blockingMatch;
        private Boolean cacheHit;
        private String policyVersion;
        private String scoreVersion;
        private Object scope;
        private Object evidence;
        private ScreeningResponse result;
        private Object supersession;
        private Boolean latest;
        private Object integrity;
        private Object retention;

        private Builder() {}

        /**
         * Sets evaluationId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evaluationId(String v) {
            this.evaluationId = v;
            return this;
        }

        /**
         * Sets jobId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder jobId(String v) {
            this.jobId = v;
            return this;
        }

        /**
         * Sets origin.
         *
         * @param v the value
         * @return this builder
         */
        public Builder origin(String v) {
            this.origin = v;
            return this;
        }

        /**
         * Sets actor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder actor(Object v) {
            this.actor = v;
            return this;
        }

        /**
         * Sets input.
         *
         * @param v the value
         * @return this builder
         */
        public Builder input(Object v) {
            this.input = v;
            return this;
        }

        /**
         * Sets evaluatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evaluatedAt(String v) {
            this.evaluatedAt = v;
            return this;
        }

        /**
         * Sets riskScore.
         *
         * @param v the value
         * @return this builder
         */
        public Builder riskScore(Double v) {
            this.riskScore = v;
            return this;
        }

        /**
         * Sets riskLevel.
         *
         * @param v the value
         * @return this builder
         */
        public Builder riskLevel(String v) {
            this.riskLevel = v;
            return this;
        }

        /**
         * Sets assessmentStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assessmentStatus(String v) {
            this.assessmentStatus = v;
            return this;
        }

        /**
         * Sets disposition.
         *
         * @param v the value
         * @return this builder
         */
        public Builder disposition(String v) {
            this.disposition = v;
            return this;
        }

        /**
         * Sets coverage.
         *
         * @param v the value
         * @return this builder
         */
        public Builder coverage(String v) {
            this.coverage = v;
            return this;
        }

        /**
         * Sets sanctionsMatch.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionsMatch(Boolean v) {
            this.sanctionsMatch = v;
            return this;
        }

        /**
         * Sets blockingMatch.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blockingMatch(Boolean v) {
            this.blockingMatch = v;
            return this;
        }

        /**
         * Sets cacheHit.
         *
         * @param v the value
         * @return this builder
         */
        public Builder cacheHit(Boolean v) {
            this.cacheHit = v;
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
         * Sets scoreVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scoreVersion(String v) {
            this.scoreVersion = v;
            return this;
        }

        /**
         * Sets scope.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scope(Object v) {
            this.scope = v;
            return this;
        }

        /**
         * Sets evidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evidence(Object v) {
            this.evidence = v;
            return this;
        }

        /**
         * Sets result.
         *
         * @param v the value
         * @return this builder
         */
        public Builder result(ScreeningResponse v) {
            this.result = v;
            return this;
        }

        /**
         * Sets supersession.
         *
         * @param v the value
         * @return this builder
         */
        public Builder supersession(Object v) {
            this.supersession = v;
            return this;
        }

        /**
         * Sets latest.
         *
         * @param v the value
         * @return this builder
         */
        public Builder latest(Boolean v) {
            this.latest = v;
            return this;
        }

        /**
         * Sets integrity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder integrity(Object v) {
            this.integrity = v;
            return this;
        }

        /**
         * Sets retention.
         *
         * @param v the value
         * @return this builder
         */
        public Builder retention(Object v) {
            this.retention = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningEvaluation build() {
            return new ScreeningEvaluation(evaluationId, jobId, origin, actor, input, evaluatedAt, riskScore, riskLevel, assessmentStatus, disposition, coverage, sanctionsMatch, blockingMatch, cacheHit, policyVersion, scoreVersion, scope, evidence, result, supersession, latest, integrity, retention);
        }
    }
}
