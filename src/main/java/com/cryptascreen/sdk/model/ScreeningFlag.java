// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningFlag (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param flagType flagType
 * @param description description
 * @param hopDistance hopDistance
 * @param confidence confidence
 * @param source source
 * @param sourceAddress sourceAddress
 * @param sourceSanctionType sourceSanctionType
 * @param sourceEntity sourceEntity
 * @param category category
 * @param matchState matchState
 * @param blocking blocking
 * @param contextOnly contextOnly
 * @param scoreContribution scoreContribution
 * @param dedupKey dedupKey
 * @param counted counted
 * @param policyReason policyReason
 * @param policyVersion policyVersion
 * @param sourceId sourceId
 * @param issuer issuer
 * @param listName listName
 * @param programs programs
 * @param restrictionType restrictionType
 * @param subjectId subjectId
 * @param aliasIds aliasIds
 * @param currencyTag currencyTag
 * @param chainBasis chainBasis
 * @param matchQuality matchQuality
 * @param validFrom validFrom
 * @param validTo validTo
 * @param snapshotId snapshotId
 * @param snapshotVersion snapshotVersion
 */
public record ScreeningFlag(
        String flagType,
        String description,
        Long hopDistance,
        Double confidence,
        String source,
        String sourceAddress,
        String sourceSanctionType,
        String sourceEntity,
        String category,
        String matchState,
        Boolean blocking,
        Boolean contextOnly,
        Double scoreContribution,
        String dedupKey,
        Boolean counted,
        String policyReason,
        String policyVersion,
        String sourceId,
        String issuer,
        String listName,
        List<String> programs,
        String restrictionType,
        String subjectId,
        String aliasIds,
        String currencyTag,
        String chainBasis,
        String matchQuality,
        String validFrom,
        String validTo,
        Long snapshotId,
        Long snapshotVersion
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningFlag}. */
    public static final class Builder {
        private String flagType;
        private String description;
        private Long hopDistance;
        private Double confidence;
        private String source;
        private String sourceAddress;
        private String sourceSanctionType;
        private String sourceEntity;
        private String category;
        private String matchState;
        private Boolean blocking;
        private Boolean contextOnly;
        private Double scoreContribution;
        private String dedupKey;
        private Boolean counted;
        private String policyReason;
        private String policyVersion;
        private String sourceId;
        private String issuer;
        private String listName;
        private List<String> programs;
        private String restrictionType;
        private String subjectId;
        private String aliasIds;
        private String currencyTag;
        private String chainBasis;
        private String matchQuality;
        private String validFrom;
        private String validTo;
        private Long snapshotId;
        private Long snapshotVersion;

        private Builder() {}

        /**
         * Sets flagType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flagType(String v) {
            this.flagType = v;
            return this;
        }

        /**
         * Sets description.
         *
         * @param v the value
         * @return this builder
         */
        public Builder description(String v) {
            this.description = v;
            return this;
        }

        /**
         * Sets hopDistance.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hopDistance(Long v) {
            this.hopDistance = v;
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
         * Sets sourceAddress.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceAddress(String v) {
            this.sourceAddress = v;
            return this;
        }

        /**
         * Sets sourceSanctionType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceSanctionType(String v) {
            this.sourceSanctionType = v;
            return this;
        }

        /**
         * Sets sourceEntity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceEntity(String v) {
            this.sourceEntity = v;
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
         * Sets matchState.
         *
         * @param v the value
         * @return this builder
         */
        public Builder matchState(String v) {
            this.matchState = v;
            return this;
        }

        /**
         * Sets blocking.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blocking(Boolean v) {
            this.blocking = v;
            return this;
        }

        /**
         * Sets contextOnly.
         *
         * @param v the value
         * @return this builder
         */
        public Builder contextOnly(Boolean v) {
            this.contextOnly = v;
            return this;
        }

        /**
         * Sets scoreContribution.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scoreContribution(Double v) {
            this.scoreContribution = v;
            return this;
        }

        /**
         * Sets dedupKey.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dedupKey(String v) {
            this.dedupKey = v;
            return this;
        }

        /**
         * Sets counted.
         *
         * @param v the value
         * @return this builder
         */
        public Builder counted(Boolean v) {
            this.counted = v;
            return this;
        }

        /**
         * Sets policyReason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder policyReason(String v) {
            this.policyReason = v;
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
         * Sets sourceId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceId(String v) {
            this.sourceId = v;
            return this;
        }

        /**
         * Sets issuer.
         *
         * @param v the value
         * @return this builder
         */
        public Builder issuer(String v) {
            this.issuer = v;
            return this;
        }

        /**
         * Sets listName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listName(String v) {
            this.listName = v;
            return this;
        }

        /**
         * Sets programs.
         *
         * @param v the value
         * @return this builder
         */
        public Builder programs(List<String> v) {
            this.programs = v;
            return this;
        }

        /**
         * Sets restrictionType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder restrictionType(String v) {
            this.restrictionType = v;
            return this;
        }

        /**
         * Sets subjectId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder subjectId(String v) {
            this.subjectId = v;
            return this;
        }

        /**
         * Sets aliasIds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder aliasIds(String v) {
            this.aliasIds = v;
            return this;
        }

        /**
         * Sets currencyTag.
         *
         * @param v the value
         * @return this builder
         */
        public Builder currencyTag(String v) {
            this.currencyTag = v;
            return this;
        }

        /**
         * Sets chainBasis.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chainBasis(String v) {
            this.chainBasis = v;
            return this;
        }

        /**
         * Sets matchQuality.
         *
         * @param v the value
         * @return this builder
         */
        public Builder matchQuality(String v) {
            this.matchQuality = v;
            return this;
        }

        /**
         * Sets validFrom.
         *
         * @param v the value
         * @return this builder
         */
        public Builder validFrom(String v) {
            this.validFrom = v;
            return this;
        }

        /**
         * Sets validTo.
         *
         * @param v the value
         * @return this builder
         */
        public Builder validTo(String v) {
            this.validTo = v;
            return this;
        }

        /**
         * Sets snapshotId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder snapshotId(Long v) {
            this.snapshotId = v;
            return this;
        }

        /**
         * Sets snapshotVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder snapshotVersion(Long v) {
            this.snapshotVersion = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningFlag build() {
            return new ScreeningFlag(flagType, description, hopDistance, confidence, source, sourceAddress, sourceSanctionType, sourceEntity, category, matchState, blocking, contextOnly, scoreContribution, dedupKey, counted, policyReason, policyVersion, sourceId, issuer, listName, programs, restrictionType, subjectId, aliasIds, currencyTag, chainBasis, matchQuality, validFrom, validTo, snapshotId, snapshotVersion);
        }
    }
}
