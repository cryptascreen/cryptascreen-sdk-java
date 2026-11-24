package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * ResultValidity (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param evidenceVersion evidenceVersion
 * @param cacheDecision cacheDecision
 * @param mode mode
 * @param includeHeuristics includeHeuristics
 * @param addressEvidenceVersion addressEvidenceVersion
 * @param entityLabelVersion entityLabelVersion
 * @param sourceSnapshotVersions sourceSnapshotVersions
 * @param tenantPolicyVersion tenantPolicyVersion
 * @param policyVersion policyVersion
 * @param scoreVersion scoreVersion
 * @param chainProvider chainProvider
 * @param entitlements entitlements
 * @param computedAt computedAt
 * @param resultAgeSeconds resultAgeSeconds
 * @param sourceAgeSeconds sourceAgeSeconds
 * @param oldestRequiredSourceAgeSeconds oldestRequiredSourceAgeSeconds
 * @param tier0Lookup tier0Lookup
 */
public record ResultValidity(
        String evidenceVersion,
        String cacheDecision,
        String mode,
        Boolean includeHeuristics,
        Long addressEvidenceVersion,
        Long entityLabelVersion,
        Map<String, Double> sourceSnapshotVersions,
        Long tenantPolicyVersion,
        String policyVersion,
        String scoreVersion,
        String chainProvider,
        String entitlements,
        String computedAt,
        Double resultAgeSeconds,
        Map<String, Double> sourceAgeSeconds,
        Double oldestRequiredSourceAgeSeconds,
        String tier0Lookup
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ResultValidity}. */
    public static final class Builder {
        private String evidenceVersion;
        private String cacheDecision;
        private String mode;
        private Boolean includeHeuristics;
        private Long addressEvidenceVersion;
        private Long entityLabelVersion;
        private Map<String, Double> sourceSnapshotVersions;
        private Long tenantPolicyVersion;
        private String policyVersion;
        private String scoreVersion;
        private String chainProvider;
        private String entitlements;
        private String computedAt;
        private Double resultAgeSeconds;
        private Map<String, Double> sourceAgeSeconds;
        private Double oldestRequiredSourceAgeSeconds;
        private String tier0Lookup;

        private Builder() {}

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
         * Sets cacheDecision.
         *
         * @param v the value
         * @return this builder
         */
        public Builder cacheDecision(String v) {
            this.cacheDecision = v;
            return this;
        }

        /**
         * Sets mode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder mode(String v) {
            this.mode = v;
            return this;
        }

        /**
         * Sets includeHeuristics.
         *
         * @param v the value
         * @return this builder
         */
        public Builder includeHeuristics(Boolean v) {
            this.includeHeuristics = v;
            return this;
        }

        /**
         * Sets addressEvidenceVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder addressEvidenceVersion(Long v) {
            this.addressEvidenceVersion = v;
            return this;
        }

        /**
         * Sets entityLabelVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entityLabelVersion(Long v) {
            this.entityLabelVersion = v;
            return this;
        }

        /**
         * Sets sourceSnapshotVersions.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceSnapshotVersions(Map<String, Double> v) {
            this.sourceSnapshotVersions = v;
            return this;
        }

        /**
         * Sets tenantPolicyVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tenantPolicyVersion(Long v) {
            this.tenantPolicyVersion = v;
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
         * Sets chainProvider.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chainProvider(String v) {
            this.chainProvider = v;
            return this;
        }

        /**
         * Sets entitlements.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entitlements(String v) {
            this.entitlements = v;
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
         * Sets resultAgeSeconds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder resultAgeSeconds(Double v) {
            this.resultAgeSeconds = v;
            return this;
        }

        /**
         * Sets sourceAgeSeconds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceAgeSeconds(Map<String, Double> v) {
            this.sourceAgeSeconds = v;
            return this;
        }

        /**
         * Sets oldestRequiredSourceAgeSeconds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder oldestRequiredSourceAgeSeconds(Double v) {
            this.oldestRequiredSourceAgeSeconds = v;
            return this;
        }

        /**
         * Sets tier0Lookup.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tier0Lookup(String v) {
            this.tier0Lookup = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ResultValidity build() {
            return new ResultValidity(evidenceVersion, cacheDecision, mode, includeHeuristics, addressEvidenceVersion, entityLabelVersion, sourceSnapshotVersions, tenantPolicyVersion, policyVersion, scoreVersion, chainProvider, entitlements, computedAt, resultAgeSeconds, sourceAgeSeconds, oldestRequiredSourceAgeSeconds, tier0Lookup);
        }
    }
}
