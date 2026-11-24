package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * SanctionsCheckResponse (see types/sanctions.ts in @cryptascreen/sdk).
 *
 * @param address address
 * @param chain chain
 * @param match match
 * @param listName listName
 * @param entityName entityName
 * @param program program
 * @param sanctionType sanctionType
 * @param confidence confidence
 * @param canonicalChain canonicalChain
 * @param blocking blocking
 * @param candidate candidate
 * @param matchState matchState
 * @param disposition disposition
 * @param issuer issuer
 * @param restrictionType restrictionType
 * @param programs programs
 * @param subjectId subjectId
 * @param findings findings
 * @param layer layer
 * @param review review
 * @param policyVersion policyVersion
 */
public record SanctionsCheckResponse(
        String address,
        String chain,
        Boolean match,
        String listName,
        String entityName,
        String program,
        String sanctionType,
        Double confidence,
        String canonicalChain,
        Boolean blocking,
        Boolean candidate,
        String matchState,
        String disposition,
        String issuer,
        String restrictionType,
        List<String> programs,
        String subjectId,
        List<ScreeningFlag> findings,
        ScreeningLayer layer,
        ReviewStatus review,
        String policyVersion
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link SanctionsCheckResponse}. */
    public static final class Builder {
        private String address;
        private String chain;
        private Boolean match;
        private String listName;
        private String entityName;
        private String program;
        private String sanctionType;
        private Double confidence;
        private String canonicalChain;
        private Boolean blocking;
        private Boolean candidate;
        private String matchState;
        private String disposition;
        private String issuer;
        private String restrictionType;
        private List<String> programs;
        private String subjectId;
        private List<ScreeningFlag> findings;
        private ScreeningLayer layer;
        private ReviewStatus review;
        private String policyVersion;

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
         * Sets match.
         *
         * @param v the value
         * @return this builder
         */
        public Builder match(Boolean v) {
            this.match = v;
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
         * Sets entityName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entityName(String v) {
            this.entityName = v;
            return this;
        }

        /**
         * Sets program.
         *
         * @param v the value
         * @return this builder
         */
        public Builder program(String v) {
            this.program = v;
            return this;
        }

        /**
         * Sets sanctionType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionType(String v) {
            this.sanctionType = v;
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
         * Sets canonicalChain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder canonicalChain(String v) {
            this.canonicalChain = v;
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
         * Sets candidate.
         *
         * @param v the value
         * @return this builder
         */
        public Builder candidate(Boolean v) {
            this.candidate = v;
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
         * Sets findings.
         *
         * @param v the value
         * @return this builder
         */
        public Builder findings(List<ScreeningFlag> v) {
            this.findings = v;
            return this;
        }

        /**
         * Sets layer.
         *
         * @param v the value
         * @return this builder
         */
        public Builder layer(ScreeningLayer v) {
            this.layer = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public SanctionsCheckResponse build() {
            return new SanctionsCheckResponse(address, chain, match, listName, entityName, program, sanctionType, confidence, canonicalChain, blocking, candidate, matchState, disposition, issuer, restrictionType, programs, subjectId, findings, layer, review, policyVersion);
        }
    }
}
