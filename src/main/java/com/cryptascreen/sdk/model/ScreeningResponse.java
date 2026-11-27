// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningResponse (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param address address
 * @param chain chain
 * @param coverage coverage
 * @param riskScore riskScore
 * @param riskLevel riskLevel
 * @param sanctionsMatch sanctionsMatch
 * @param entityLabel entityLabel
 * @param entityCategory entityCategory
 * @param confidence confidence
 * @param flags flags
 * @param screeningProvidersUsed screeningProvidersUsed
 * @param screenedAt screenedAt
 * @param cacheHit cacheHit
 * @param heuristicsStatus heuristicsStatus
 * @param heuristicsJobId heuristicsJobId
 * @param heuristicsDetectors heuristicsDetectors
 * @param policyVersion policyVersion
 * @param scoreVersion scoreVersion
 * @param blockingMatch blockingMatch
 * @param disposition disposition
 * @param assessmentStatus assessmentStatus
 * @param checkedLayers checkedLayers
 * @param layers layers
 * @param review review
 * @param evidenceVersion evidenceVersion
 * @param validity validity
 * @param evaluationId evaluationId
 * @param vendorLayers vendorLayers
 */
public record ScreeningResponse(
        String address,
        String chain,
        String coverage,
        Double riskScore,
        String riskLevel,
        Boolean sanctionsMatch,
        String entityLabel,
        String entityCategory,
        Double confidence,
        List<ScreeningFlag> flags,
        List<String> screeningProvidersUsed,
        String screenedAt,
        Boolean cacheHit,
        String heuristicsStatus,
        String heuristicsJobId,
        List<HeuristicDetectorStatus> heuristicsDetectors,
        String policyVersion,
        String scoreVersion,
        Boolean blockingMatch,
        String disposition,
        String assessmentStatus,
        List<String> checkedLayers,
        ScreeningLayers layers,
        ReviewStatus review,
        String evidenceVersion,
        ResultValidity validity,
        String evaluationId,
        List<VendorLayer> vendorLayers
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningResponse}. */
    public static final class Builder {
        private String address;
        private String chain;
        private String coverage;
        private Double riskScore;
        private String riskLevel;
        private Boolean sanctionsMatch;
        private String entityLabel;
        private String entityCategory;
        private Double confidence;
        private List<ScreeningFlag> flags;
        private List<String> screeningProvidersUsed;
        private String screenedAt;
        private Boolean cacheHit;
        private String heuristicsStatus;
        private String heuristicsJobId;
        private List<HeuristicDetectorStatus> heuristicsDetectors;
        private String policyVersion;
        private String scoreVersion;
        private Boolean blockingMatch;
        private String disposition;
        private String assessmentStatus;
        private List<String> checkedLayers;
        private ScreeningLayers layers;
        private ReviewStatus review;
        private String evidenceVersion;
        private ResultValidity validity;
        private String evaluationId;
        private List<VendorLayer> vendorLayers;

        private Builder() {}

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
         * Sets entityLabel.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entityLabel(String v) {
            this.entityLabel = v;
            return this;
        }

        /**
         * Sets entityCategory.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entityCategory(String v) {
            this.entityCategory = v;
            return this;
        }

        /**
         * Sets confidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder confidence(Double v) {
            this.confidence = v;
            return this;
        }

        /**
         * Sets flags.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flags(List<ScreeningFlag> v) {
            this.flags = v;
            return this;
        }

        /**
         * Sets screeningProvidersUsed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder screeningProvidersUsed(List<String> v) {
            this.screeningProvidersUsed = v;
            return this;
        }

        /**
         * Sets screenedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder screenedAt(String v) {
            this.screenedAt = v;
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
         * Sets heuristicsStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder heuristicsStatus(String v) {
            this.heuristicsStatus = v;
            return this;
        }

        /**
         * Sets heuristicsJobId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder heuristicsJobId(String v) {
            this.heuristicsJobId = v;
            return this;
        }

        /**
         * Sets heuristicsDetectors.
         *
         * @param v the value
         * @return this builder
         */
        public Builder heuristicsDetectors(List<HeuristicDetectorStatus> v) {
            this.heuristicsDetectors = v;
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
         * Sets checkedLayers.
         *
         * @param v the value
         * @return this builder
         */
        public Builder checkedLayers(List<String> v) {
            this.checkedLayers = v;
            return this;
        }

        /**
         * Sets layers.
         *
         * @param v the value
         * @return this builder
         */
        public Builder layers(ScreeningLayers v) {
            this.layers = v;
            return this;
        }

        /**
         * Sets review.
         *
         * @param v the value
         * @return this builder
         */
        public Builder review(ReviewStatus v) {
            this.review = v;
            return this;
        }

        /**
         * Sets evidenceVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evidenceVersion(String v) {
            this.evidenceVersion = v;
            return this;
        }

        /**
         * Sets validity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder validity(ResultValidity v) {
            this.validity = v;
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
         * Sets vendorLayers.
         *
         * @param v the value
         * @return this builder
         */
        public Builder vendorLayers(List<VendorLayer> v) {
            this.vendorLayers = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningResponse build() {
            return new ScreeningResponse(address, chain, coverage, riskScore, riskLevel, sanctionsMatch, entityLabel, entityCategory, confidence, flags, screeningProvidersUsed, screenedAt, cacheHit, heuristicsStatus, heuristicsJobId, heuristicsDetectors, policyVersion, scoreVersion, blockingMatch, disposition, assessmentStatus, checkedLayers, layers, review, evidenceVersion, validity, evaluationId, vendorLayers);
        }
    }
}
