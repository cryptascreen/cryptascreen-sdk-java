// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * NameScreeningHistoryItem (see types/names.ts in @cryptascreen/sdk).
 *
 * @param screeningId screeningId
 * @param createdAt createdAt
 * @param origin origin
 * @param actor actor
 * @param name name
 * @param outcome outcome
 * @param topScore topScore
 * @param hitCount hitCount
 * @param caseRef caseRef
 */
public record NameScreeningHistoryItem(
        String screeningId,
        String createdAt,
        String origin,
        String actor,
        String name,
        String outcome,
        Double topScore,
        Long hitCount,
        String caseRef
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameScreeningHistoryItem}. */
    public static final class Builder {
        private String screeningId;
        private String createdAt;
        private String origin;
        private String actor;
        private String name;
        private String outcome;
        private Double topScore;
        private Long hitCount;
        private String caseRef;

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
        public Builder actor(String v) {
            this.actor = v;
            return this;
        }

        /**
         * Sets name.
         *
         * @param v the value
         * @return this builder
         */
        public Builder name(String v) {
            this.name = v;
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
         * Sets topScore.
         *
         * @param v the value
         * @return this builder
         */
        public Builder topScore(Double v) {
            this.topScore = v;
            return this;
        }

        /**
         * Sets hitCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hitCount(Long v) {
            this.hitCount = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public NameScreeningHistoryItem build() {
            return new NameScreeningHistoryItem(screeningId, createdAt, origin, actor, name, outcome, topScore, hitCount, caseRef);
        }
    }
}
