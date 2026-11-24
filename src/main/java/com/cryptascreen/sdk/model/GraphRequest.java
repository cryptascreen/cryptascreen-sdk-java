package com.cryptascreen.sdk.model;

/**
 * GraphRequest (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param seedAddress seedAddress
 * @param chain chain
 * @param direction direction
 * @param maxHops maxHops
 * @param maxNodes maxNodes
 * @param minValueUsd minValueUsd
 * @param dateFrom dateFrom
 * @param dateTo dateTo
 * @param aggregateEdges aggregateEdges
 * @param forceRefresh forceRefresh
 * @param timeOrdered timeOrdered
 */
public record GraphRequest(
        String seedAddress,
        String chain,
        String direction,
        Long maxHops,
        Double maxNodes,
        Double minValueUsd,
        String dateFrom,
        String dateTo,
        Boolean aggregateEdges,
        Boolean forceRefresh,
        Boolean timeOrdered
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link GraphRequest}. */
    public static final class Builder {
        private String seedAddress;
        private String chain;
        private String direction;
        private Long maxHops;
        private Double maxNodes;
        private Double minValueUsd;
        private String dateFrom;
        private String dateTo;
        private Boolean aggregateEdges;
        private Boolean forceRefresh;
        private Boolean timeOrdered;

        private Builder() {}

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
         * Sets direction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder direction(String v) {
            this.direction = v;
            return this;
        }

        /**
         * Sets maxHops.
         *
         * @param v the value
         * @return this builder
         */
        public Builder maxHops(Long v) {
            this.maxHops = v;
            return this;
        }

        /**
         * Sets maxNodes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder maxNodes(Double v) {
            this.maxNodes = v;
            return this;
        }

        /**
         * Sets minValueUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder minValueUsd(Double v) {
            this.minValueUsd = v;
            return this;
        }

        /**
         * Sets dateFrom.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dateFrom(String v) {
            this.dateFrom = v;
            return this;
        }

        /**
         * Sets dateTo.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dateTo(String v) {
            this.dateTo = v;
            return this;
        }

        /**
         * Sets aggregateEdges.
         *
         * @param v the value
         * @return this builder
         */
        public Builder aggregateEdges(Boolean v) {
            this.aggregateEdges = v;
            return this;
        }

        /**
         * Sets forceRefresh.
         *
         * @param v the value
         * @return this builder
         */
        public Builder forceRefresh(Boolean v) {
            this.forceRefresh = v;
            return this;
        }

        /**
         * Sets timeOrdered.
         *
         * @param v the value
         * @return this builder
         */
        public Builder timeOrdered(Boolean v) {
            this.timeOrdered = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public GraphRequest build() {
            return new GraphRequest(seedAddress, chain, direction, maxHops, maxNodes, minValueUsd, dateFrom, dateTo, aggregateEdges, forceRefresh, timeOrdered);
        }
    }
}
