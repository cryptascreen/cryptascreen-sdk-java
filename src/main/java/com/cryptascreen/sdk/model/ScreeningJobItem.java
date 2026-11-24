package com.cryptascreen.sdk.model;

/**
 * ScreeningJobItem (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param index index
 * @param address address
 * @param chain chain
 * @param status status
 * @param evaluationId evaluationId
 * @param riskLevel riskLevel
 * @param riskScore riskScore
 * @param sanctionsMatch sanctionsMatch
 * @param result result
 * @param errorCode errorCode
 * @param createdAt createdAt
 */
public record ScreeningJobItem(
        Long index,
        String address,
        String chain,
        String status,
        String evaluationId,
        String riskLevel,
        Double riskScore,
        Boolean sanctionsMatch,
        ScreeningResponse result,
        String errorCode,
        String createdAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningJobItem}. */
    public static final class Builder {
        private Long index;
        private String address;
        private String chain;
        private String status;
        private String evaluationId;
        private String riskLevel;
        private Double riskScore;
        private Boolean sanctionsMatch;
        private ScreeningResponse result;
        private String errorCode;
        private String createdAt;

        private Builder() {}

        /**
         * Sets index.
         *
         * @param v the value
         * @return this builder
         */
        public Builder index(Long v) {
            this.index = v;
            return this;
        }

        /**
         * Sets address.
         *
         * @param v the value
         * @return this builder
         */
        public Builder address(String v) {
            this.address = v;
            return this;
        }

        /**
         * Sets chain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chain(String v) {
            this.chain = v;
            return this;
        }

        /**
         * Sets status.
         *
         * @param v the value
         * @return this builder
         */
        public Builder status(String v) {
            this.status = v;
            return this;
        }

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
         * Sets errorCode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder errorCode(String v) {
            this.errorCode = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningJobItem build() {
            return new ScreeningJobItem(index, address, chain, status, evaluationId, riskLevel, riskScore, sanctionsMatch, result, errorCode, createdAt);
        }
    }
}
