// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * GraphResponse (see types/graph.ts in @cryptascreen/sdk).
 *
 * @param seedAddress seedAddress
 * @param chain chain
 * @param nodes nodes
 * @param edges edges
 * @param flaggedNodeIds flaggedNodeIds
 * @param sanctionedNodeIds sanctionedNodeIds
 * @param stats stats
 * @param scope scope
 * @param generatedAt generatedAt
 */
public record GraphResponse(
        String seedAddress,
        String chain,
        List<GraphNode> nodes,
        List<GraphEdge> edges,
        List<String> flaggedNodeIds,
        List<String> sanctionedNodeIds,
        GraphStats stats,
        GraphScope scope,
        String generatedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link GraphResponse}. */
    public static final class Builder {
        private String seedAddress;
        private String chain;
        private List<GraphNode> nodes;
        private List<GraphEdge> edges;
        private List<String> flaggedNodeIds;
        private List<String> sanctionedNodeIds;
        private GraphStats stats;
        private GraphScope scope;
        private String generatedAt;

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
         * Sets nodes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nodes(List<GraphNode> v) {
            this.nodes = v;
            return this;
        }

        /**
         * Sets edges.
         *
         * @param v the value
         * @return this builder
         */
        public Builder edges(List<GraphEdge> v) {
            this.edges = v;
            return this;
        }

        /**
         * Sets flaggedNodeIds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder flaggedNodeIds(List<String> v) {
            this.flaggedNodeIds = v;
            return this;
        }

        /**
         * Sets sanctionedNodeIds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctionedNodeIds(List<String> v) {
            this.sanctionedNodeIds = v;
            return this;
        }

        /**
         * Sets stats.
         *
         * @param v the value
         * @return this builder
         */
        public Builder stats(GraphStats v) {
            this.stats = v;
            return this;
        }

        /**
         * Sets scope.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scope(GraphScope v) {
            this.scope = v;
            return this;
        }

        /**
         * Sets generatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder generatedAt(String v) {
            this.generatedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public GraphResponse build() {
            return new GraphResponse(seedAddress, chain, nodes, edges, flaggedNodeIds, sanctionedNodeIds, stats, scope, generatedAt);
        }
    }
}
