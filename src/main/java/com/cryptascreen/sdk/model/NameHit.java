// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * NameHit (see types/names.ts in @cryptascreen/sdk).
 *
 * @param hitId hitId
 * @param listedEntity listedEntity
 * @param score score
 * @param nameScore nameScore
 * @param matchedName matchedName
 * @param matchedAliasQuality matchedAliasQuality
 * @param matchedFields matchedFields
 * @param conflictFields conflictFields
 * @param reasons reasons
 * @param explanation explanation
 * @param engineDecision engineDecision
 * @param listVersion listVersion
 * @param decision decision
 */
public record NameHit(
        String hitId,
        NameListedEntity listedEntity,
        Double score,
        Double nameScore,
        String matchedName,
        String matchedAliasQuality,
        List<String> matchedFields,
        List<String> conflictFields,
        List<NameMatchReason> reasons,
        String explanation,
        String engineDecision,
        String listVersion,
        NameMatchDecision decision
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameHit}. */
    public static final class Builder {
        private String hitId;
        private NameListedEntity listedEntity;
        private Double score;
        private Double nameScore;
        private String matchedName;
        private String matchedAliasQuality;
        private List<String> matchedFields;
        private List<String> conflictFields;
        private List<NameMatchReason> reasons;
        private String explanation;
        private String engineDecision;
        private String listVersion;
        private NameMatchDecision decision;

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
         * Sets listedEntity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listedEntity(NameListedEntity v) {
            this.listedEntity = v;
            return this;
        }

        /**
         * Sets score.
         *
         * @param v the value
         * @return this builder
         */
        public Builder score(Double v) {
            this.score = v;
            return this;
        }

        /**
         * Sets nameScore.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nameScore(Double v) {
            this.nameScore = v;
            return this;
        }

        /**
         * Sets matchedName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder matchedName(String v) {
            this.matchedName = v;
            return this;
        }

        /**
         * Sets matchedAliasQuality.
         *
         * @param v the value
         * @return this builder
         */
        public Builder matchedAliasQuality(String v) {
            this.matchedAliasQuality = v;
            return this;
        }

        /**
         * Sets matchedFields.
         *
         * @param v the value
         * @return this builder
         */
        public Builder matchedFields(List<String> v) {
            this.matchedFields = v;
            return this;
        }

        /**
         * Sets conflictFields.
         *
         * @param v the value
         * @return this builder
         */
        public Builder conflictFields(List<String> v) {
            this.conflictFields = v;
            return this;
        }

        /**
         * Sets reasons.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasons(List<NameMatchReason> v) {
            this.reasons = v;
            return this;
        }

        /**
         * Sets explanation.
         *
         * @param v the value
         * @return this builder
         */
        public Builder explanation(String v) {
            this.explanation = v;
            return this;
        }

        /**
         * Sets engineDecision.
         *
         * @param v the value
         * @return this builder
         */
        public Builder engineDecision(String v) {
            this.engineDecision = v;
            return this;
        }

        /**
         * Sets listVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listVersion(String v) {
            this.listVersion = v;
            return this;
        }

        /**
         * Sets decision.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decision(NameMatchDecision v) {
            this.decision = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameHit build() {
            return new NameHit(hitId, listedEntity, score, nameScore, matchedName, matchedAliasQuality, matchedFields, conflictFields, reasons, explanation, engineDecision, listVersion, decision);
        }
    }
}
