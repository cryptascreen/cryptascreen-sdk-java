// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * ScreeningLayers (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param sanctions sanctions
 * @param threatIntel threatIntel
 * @param entity entity
 * @param onChain onChain
 */
public record ScreeningLayers(
        ScreeningLayer sanctions,
        ScreeningLayer threatIntel,
        ScreeningLayer entity,
        ScreeningLayer onChain
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningLayers}. */
    public static final class Builder {
        private ScreeningLayer sanctions;
        private ScreeningLayer threatIntel;
        private ScreeningLayer entity;
        private ScreeningLayer onChain;

        private Builder() {}

        /**
         * Sets sanctions.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sanctions(ScreeningLayer v) {
            this.sanctions = v;
            return this;
        }

        /**
         * Sets threatIntel.
         *
         * @param v the value
         * @return this builder
         */
        public Builder threatIntel(ScreeningLayer v) {
            this.threatIntel = v;
            return this;
        }

        /**
         * Sets entity.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entity(ScreeningLayer v) {
            this.entity = v;
            return this;
        }

        /**
         * Sets onChain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder onChain(ScreeningLayer v) {
            this.onChain = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningLayers build() {
            return new ScreeningLayers(sanctions, threatIntel, entity, onChain);
        }
    }
}
