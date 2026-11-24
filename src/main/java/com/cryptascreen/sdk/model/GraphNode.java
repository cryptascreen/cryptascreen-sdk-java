package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * GraphNode (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param address address
 * @param chain chain
 * @param label label
 * @param category category
 * @param riskScore riskScore
 * @param riskLevel riskLevel
 * @param sanctionsMatch sanctionsMatch
 * @param flagTypes flagTypes
 * @param isSeed isSeed
 * @param isFlagged isFlagged
 * @param totalInboundUsd totalInboundUsd
 * @param totalOutboundUsd totalOutboundUsd
 * @param txCount txCount
 * @param firstSeen firstSeen
 * @param lastSeen lastSeen
 * @param hop hop
 * @param scopeStatus scopeStatus
 */
public record GraphNode(
        String id,
        String address,
        String chain,
        String label,
        String category,
        Double riskScore,
        String riskLevel,
        Boolean sanctionsMatch,
        List<String> flagTypes,
        Boolean isSeed,
        Boolean isFlagged,
        Double totalInboundUsd,
        Double totalOutboundUsd,
        Long txCount,
        String firstSeen,
        String lastSeen,
        Long hop,
        String scopeStatus
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link GraphNode}. */
    public static final class Builder {
        private String id;
        private String address;
        private String chain;
        private String label;
        private String category;
        private Double riskScore;
        private String riskLevel;
        private Boolean sanctionsMatch;
        private List<String> flagTypes;
        private Boolean isSeed;
        private Boolean isFlagged;
        private Double totalInboundUsd;
        private Double totalOutboundUsd;
        private Long txCount;
        private String firstSeen;
        private String lastSeen;
        private Long hop;
        private String scopeStatus;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(String v) {
            this.id = v;
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
         * Sets label.
         *
         * @param v the value
         * @return this builder
         */
        public Builder label(String v) {
            this.label = v;
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
         * Sets flagTypes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flagTypes(List<String> v) {
            this.flagTypes = v;
            return this;
        }

        /**
         * Sets isSeed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder isSeed(Boolean v) {
            this.isSeed = v;
            return this;
        }

        /**
         * Sets isFlagged.
         *
         * @param v the value
         * @return this builder
         */
        public Builder isFlagged(Boolean v) {
            this.isFlagged = v;
            return this;
        }

        /**
         * Sets totalInboundUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalInboundUsd(Double v) {
            this.totalInboundUsd = v;
            return this;
        }

        /**
         * Sets totalOutboundUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalOutboundUsd(Double v) {
            this.totalOutboundUsd = v;
            return this;
        }

        /**
         * Sets txCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder txCount(Long v) {
            this.txCount = v;
            return this;
        }

        /**
         * Sets firstSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstSeen(String v) {
            this.firstSeen = v;
            return this;
        }

        /**
         * Sets lastSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastSeen(String v) {
            this.lastSeen = v;
            return this;
        }

        /**
         * Sets hop.
         *
         * @param v the value
         * @return this builder
         */
        public Builder hop(Long v) {
            this.hop = v;
            return this;
        }

        /**
         * Sets scopeStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scopeStatus(String v) {
            this.scopeStatus = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public GraphNode build() {
            return new GraphNode(id, address, chain, label, category, riskScore, riskLevel, sanctionsMatch, flagTypes, isSeed, isFlagged, totalInboundUsd, totalOutboundUsd, txCount, firstSeen, lastSeen, hop, scopeStatus);
        }
    }
}
