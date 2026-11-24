package com.cryptascreen.sdk.model;

/**
 * GraphEdge (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param source source
 * @param target target
 * @param txHash txHash
 * @param chain chain
 * @param valueUsd valueUsd
 * @param valueNative valueNative
 * @param assetSymbol assetSymbol
 * @param timestamp timestamp
 * @param txCount txCount
 * @param isAggregated isAggregated
 * @param hop hop
 * @param firstBlock firstBlock
 * @param lastBlock lastBlock
 * @param scopeStatus scopeStatus
 */
public record GraphEdge(
        String id,
        String source,
        String target,
        String txHash,
        String chain,
        Double valueUsd,
        Double valueNative,
        String assetSymbol,
        String timestamp,
        Long txCount,
        Boolean isAggregated,
        Long hop,
        Double firstBlock,
        Double lastBlock,
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

    /** Builder for {@link GraphEdge}. */
    public static final class Builder {
        private String id;
        private String source;
        private String target;
        private String txHash;
        private String chain;
        private Double valueUsd;
        private Double valueNative;
        private String assetSymbol;
        private String timestamp;
        private Long txCount;
        private Boolean isAggregated;
        private Long hop;
        private Double firstBlock;
        private Double lastBlock;
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
         * Sets target.
         *
         * @param v the value
         * @return this builder
         */
        public Builder target(String v) {
            this.target = v;
            return this;
        }

        /**
         * Sets txHash.
         *
         * @param v the value
         * @return this builder
         */
        public Builder txHash(String v) {
            this.txHash = v;
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
         * Sets valueUsd.
         *
         * @param v the value
         * @return this builder
         */
        public Builder valueUsd(Double v) {
            this.valueUsd = v;
            return this;
        }

        /**
         * Sets valueNative.
         *
         * @param v the value
         * @return this builder
         */
        public Builder valueNative(Double v) {
            this.valueNative = v;
            return this;
        }

        /**
         * Sets assetSymbol.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assetSymbol(String v) {
            this.assetSymbol = v;
            return this;
        }

        /**
         * Sets timestamp.
         *
         * @param v the value
         * @return this builder
         */
        public Builder timestamp(String v) {
            this.timestamp = v;
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
         * Sets isAggregated.
         *
         * @param v the value
         * @return this builder
         */
        public Builder isAggregated(Boolean v) {
            this.isAggregated = v;
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
         * Sets firstBlock.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstBlock(Double v) {
            this.firstBlock = v;
            return this;
        }

        /**
         * Sets lastBlock.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastBlock(Double v) {
            this.lastBlock = v;
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
        public GraphEdge build() {
            return new GraphEdge(id, source, target, txHash, chain, valueUsd, valueNative, assetSymbol, timestamp, txCount, isAggregated, hop, firstBlock, lastBlock, scopeStatus);
        }
    }
}
