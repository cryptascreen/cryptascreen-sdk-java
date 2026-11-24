package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * GraphStats (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param totalNodes totalNodes
 * @param totalEdges totalEdges
 * @param flaggedNodes flaggedNodes
 * @param sanctionedNodes sanctionedNodes
 * @param totalValueTracedUsd totalValueTracedUsd
 * @param maxHopsReached maxHopsReached
 * @param truncated truncated
 * @param status status
 * @param statusReasons statusReasons
 * @param nodeCap nodeCap
 */
public record GraphStats(
        Double totalNodes,
        Double totalEdges,
        Double flaggedNodes,
        Double sanctionedNodes,
        Double totalValueTracedUsd,
        Long maxHopsReached,
        Boolean truncated,
        String status,
        List<String> statusReasons,
        Double nodeCap
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link GraphStats}. */
    public static final class Builder {
        private Double totalNodes;
        private Double totalEdges;
        private Double flaggedNodes;
        private Double sanctionedNodes;
        private Double totalValueTracedUsd;
        private Long maxHopsReached;
        private Boolean truncated;
        private String status;
        private List<String> statusReasons;
        private Double nodeCap;

        private Builder() {}

        /**
         * Sets totalNodes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalNodes(Double v) {
            this.totalNodes = v;
            return this;
        }

        /**
         * Sets totalEdges.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalEdges(Double v) {
            this.totalEdges = v;
            return this;
        }

        /**
         * Sets flaggedNodes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flaggedNodes(Double v) {
            this.flaggedNodes = v;
            return this;
        }

        /**
         * Sets sanctionedNodes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionedNodes(Double v) {
            this.sanctionedNodes = v;
            return this;
        }

        /**
         * Sets totalValueTracedUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalValueTracedUsd(Double v) {
            this.totalValueTracedUsd = v;
            return this;
        }

        /**
         * Sets maxHopsReached.
         *
         * @param v the value
         * @return this builder
         */
        public Builder maxHopsReached(Long v) {
            this.maxHopsReached = v;
            return this;
        }

        /**
         * Sets truncated.
         *
         * @param v the value
         * @return this builder
         */
        public Builder truncated(Boolean v) {
            this.truncated = v;
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
         * Sets statusReasons.
         *
         * @param v the value
         * @return this builder
         */
        public Builder statusReasons(List<String> v) {
            this.statusReasons = v;
            return this;
        }

        /**
         * Sets nodeCap.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nodeCap(Double v) {
            this.nodeCap = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public GraphStats build() {
            return new GraphStats(totalNodes, totalEdges, flaggedNodes, sanctionedNodes, totalValueTracedUsd, maxHopsReached, truncated, status, statusReasons, nodeCap);
        }
    }
}
