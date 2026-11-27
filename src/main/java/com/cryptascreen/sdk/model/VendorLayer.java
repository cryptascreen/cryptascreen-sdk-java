// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * VendorLayer (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param vendor vendor
 * @param status status
 * @param fetchedAt fetchedAt
 * @param cached cached
 * @param rating rating
 * @param ratingScale ratingScale
 * @param categories categories
 * @param reasons reasons
 * @param attribution attribution
 */
public record VendorLayer(
        String vendor,
        String status,
        String fetchedAt,
        Boolean cached,
        String rating,
        String ratingScale,
        List<String> categories,
        List<String> reasons,
        String attribution
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link VendorLayer}. */
    public static final class Builder {
        private String vendor;
        private String status;
        private String fetchedAt;
        private Boolean cached;
        private String rating;
        private String ratingScale;
        private List<String> categories;
        private List<String> reasons;
        private String attribution;

        private Builder() {}

        /**
         * Sets vendor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder vendor(String v) {
            this.vendor = v;
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
         * Sets fetchedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fetchedAt(String v) {
            this.fetchedAt = v;
            return this;
        }

        /**
         * Sets cached.
         *
         * @param v the value
         * @return this builder
         */
        public Builder cached(Boolean v) {
            this.cached = v;
            return this;
        }

        /**
         * Sets rating.
         *
         * @param v the value
         * @return this builder
         */
        public Builder rating(String v) {
            this.rating = v;
            return this;
        }

        /**
         * Sets ratingScale.
         *
         * @param v the value
         * @return this builder
         */
        public Builder ratingScale(String v) {
            this.ratingScale = v;
            return this;
        }

        /**
         * Sets categories.
         *
         * @param v the value
         * @return this builder
         */
        public Builder categories(List<String> v) {
            this.categories = v;
            return this;
        }

        /**
         * Sets reasons.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasons(List<String> v) {
            this.reasons = v;
            return this;
        }

        /**
         * Sets attribution.
         *
         * @param v the value
         * @return this builder
         */
        public Builder attribution(String v) {
            this.attribution = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public VendorLayer build() {
            return new VendorLayer(vendor, status, fetchedAt, cached, rating, ratingScale, categories, reasons, attribution);
        }
    }
}
