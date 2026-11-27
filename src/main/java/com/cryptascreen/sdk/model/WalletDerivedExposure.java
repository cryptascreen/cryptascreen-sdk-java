// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * WalletDerivedExposure (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param hops hops
 * @param sharePct sharePct
 * @param category category
 * @param seedSourceId seedSourceId
 * @param incidentId incidentId
 * @param incidentDate incidentDate
 * @param incidentDateBasis incidentDateBasis
 * @param sourceUrl sourceUrl
 * @param sourcePublished sourcePublished
 * @param seedAddress seedAddress
 * @param completeness completeness
 * @param completenessReason completenessReason
 * @param partialEvidence partialEvidence
 * @param chainConfidence chainConfidence
 * @param chainNote chainNote
 * @param valueByAsset valueByAsset
 * @param valueUsd valueUsd
 * @param firstReceivedAt firstReceivedAt
 * @param steps steps
 * @param points points
 * @param why why
 * @param traceVersion traceVersion
 * @param computedAt computedAt
 */
public record WalletDerivedExposure(
        Long hops,
        Double sharePct,
        String category,
        String seedSourceId,
        String incidentId,
        String incidentDate,
        String incidentDateBasis,
        String sourceUrl,
        String sourcePublished,
        String seedAddress,
        String completeness,
        String completenessReason,
        Boolean partialEvidence,
        Double chainConfidence,
        String chainNote,
        Map<String, WalletStolenAssetShare> valueByAsset,
        Object valueUsd,
        String firstReceivedAt,
        List<WalletDerivedStep> steps,
        Long points,
        String why,
        String traceVersion,
        String computedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletDerivedExposure}. */
    public static final class Builder {
        private Long hops;
        private Double sharePct;
        private String category;
        private String seedSourceId;
        private String incidentId;
        private String incidentDate;
        private String incidentDateBasis;
        private String sourceUrl;
        private String sourcePublished;
        private String seedAddress;
        private String completeness;
        private String completenessReason;
        private Boolean partialEvidence;
        private Double chainConfidence;
        private String chainNote;
        private Map<String, WalletStolenAssetShare> valueByAsset;
        private Object valueUsd;
        private String firstReceivedAt;
        private List<WalletDerivedStep> steps;
        private Long points;
        private String why;
        private String traceVersion;
        private String computedAt;

        private Builder() {}

        /**
         * Sets hops.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hops(Long v) {
            this.hops = v;
            return this;
        }

        /**
         * Sets sharePct.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sharePct(Double v) {
            this.sharePct = v;
            return this;
        }

        /**
         * Sets category.
         *
         * @param v the value
         * @return this builder
         */
        public Builder category(String v) {
            this.category = v;
            return this;
        }

        /**
         * Sets seedSourceId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder seedSourceId(String v) {
            this.seedSourceId = v;
            return this;
        }

        /**
         * Sets incidentId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder incidentId(String v) {
            this.incidentId = v;
            return this;
        }

        /**
         * Sets incidentDate.
         *
         * @param v the value
         * @return this builder
         */
        public Builder incidentDate(String v) {
            this.incidentDate = v;
            return this;
        }

        /**
         * Sets incidentDateBasis.
         *
         * @param v the value
         * @return this builder
         */
        public Builder incidentDateBasis(String v) {
            this.incidentDateBasis = v;
            return this;
        }

        /**
         * Sets sourceUrl.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceUrl(String v) {
            this.sourceUrl = v;
            return this;
        }

        /**
         * Sets sourcePublished.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourcePublished(String v) {
            this.sourcePublished = v;
            return this;
        }

        /**
         * Sets seedAddress.
         *
         * @param v the value
         * @return this builder
         */
        public Builder seedAddress(String v) {
            this.seedAddress = v;
            return this;
        }

        /**
         * Sets completeness.
         *
         * @param v the value
         * @return this builder
         */
        public Builder completeness(String v) {
            this.completeness = v;
            return this;
        }

        /**
         * Sets completenessReason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder completenessReason(String v) {
            this.completenessReason = v;
            return this;
        }

        /**
         * Sets partialEvidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder partialEvidence(Boolean v) {
            this.partialEvidence = v;
            return this;
        }

        /**
         * Sets chainConfidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chainConfidence(Double v) {
            this.chainConfidence = v;
            return this;
        }

        /**
         * Sets chainNote.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chainNote(String v) {
            this.chainNote = v;
            return this;
        }

        /**
         * Sets valueByAsset.
         *
         * @param v the value
         * @return this builder
         */
        public Builder valueByAsset(Map<String, WalletStolenAssetShare> v) {
            this.valueByAsset = v;
            return this;
        }

        /**
         * Sets valueUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder valueUsd(Object v) {
            this.valueUsd = v;
            return this;
        }

        /**
         * Sets firstReceivedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstReceivedAt(String v) {
            this.firstReceivedAt = v;
            return this;
        }

        /**
         * Sets steps.
         *
         * @param v the value
         * @return this builder
         */
        public Builder steps(List<WalletDerivedStep> v) {
            this.steps = v;
            return this;
        }

        /**
         * Sets points.
         *
         * @param v the value
         * @return this builder
         */
        public Builder points(Long v) {
            this.points = v;
            return this;
        }

        /**
         * Sets why.
         *
         * @param v the value
         * @return this builder
         */
        public Builder why(String v) {
            this.why = v;
            return this;
        }

        /**
         * Sets traceVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder traceVersion(String v) {
            this.traceVersion = v;
            return this;
        }

        /**
         * Sets computedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder computedAt(String v) {
            this.computedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletDerivedExposure build() {
            return new WalletDerivedExposure(hops, sharePct, category, seedSourceId, incidentId, incidentDate, incidentDateBasis, sourceUrl, sourcePublished, seedAddress, completeness, completenessReason, partialEvidence, chainConfidence, chainNote, valueByAsset, valueUsd, firstReceivedAt, steps, points, why, traceVersion, computedAt);
        }
    }
}
