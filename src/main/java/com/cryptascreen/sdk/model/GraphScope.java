package com.cryptascreen.sdk.model;

/**
 * GraphScope (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param chain chain
 * @param direction direction
 * @param dateFrom dateFrom
 * @param dateTo dateTo
 * @param maxHops maxHops
 * @param timeOrdered timeOrdered
 * @param finalizedBlock finalizedBlock
 * @param provider provider
 */
public record GraphScope(
        String chain,
        String direction,
        String dateFrom,
        String dateTo,
        Long maxHops,
        Boolean timeOrdered,
        Double finalizedBlock,
        String provider
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link GraphScope}. */
    public static final class Builder {
        private String chain;
        private String direction;
        private String dateFrom;
        private String dateTo;
        private Long maxHops;
        private Boolean timeOrdered;
        private Double finalizedBlock;
        private String provider;

        private Builder() {}

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
         * Sets finalizedBlock.
         *
         * @param v the value
         * @return this builder
         */
        public Builder finalizedBlock(Double v) {
            this.finalizedBlock = v;
            return this;
        }

        /**
         * Sets provider.
         *
         * @param v the value
         * @return this builder
         */
        public Builder provider(String v) {
            this.provider = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public GraphScope build() {
            return new GraphScope(chain, direction, dateFrom, dateTo, maxHops, timeOrdered, finalizedBlock, provider);
        }
    }
}
