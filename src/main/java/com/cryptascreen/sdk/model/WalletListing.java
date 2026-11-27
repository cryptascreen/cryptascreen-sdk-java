// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletListing (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param category category
 * @param sourceId sourceId
 * @param listType listType
 * @param entityName entityName
 * @param program program
 */
public record WalletListing(
        String category,
        String sourceId,
        String listType,
        String entityName,
        String program
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletListing}. */
    public static final class Builder {
        private String category;
        private String sourceId;
        private String listType;
        private String entityName;
        private String program;

        private Builder() {}

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
         * Sets listType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listType(String v) {
            this.listType = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public WalletListing build() {
            return new WalletListing(category, sourceId, listType, entityName, program);
        }
    }
}
