// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningJobResultsPage (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param jobId jobId
 * @param status status
 * @param items items
 * @param page page
 * @param size size
 * @param totalItems totalItems
 * @param totalPages totalPages
 */
public record ScreeningJobResultsPage(
        String jobId,
        String status,
        List<ScreeningJobItem> items,
        Long page,
        Long size,
        Long totalItems,
        Long totalPages
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningJobResultsPage}. */
    public static final class Builder {
        private String jobId;
        private String status;
        private List<ScreeningJobItem> items;
        private Long page;
        private Long size;
        private Long totalItems;
        private Long totalPages;

        private Builder() {}

        /**
         * Sets jobId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder jobId(String v) {
            this.jobId = v;
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
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<ScreeningJobItem> v) {
            this.items = v;
            return this;
        }

        /**
         * Sets page.
         *
         * @param v the value
         * @return this builder
         */
        public Builder page(Long v) {
            this.page = v;
            return this;
        }

        /**
         * Sets size.
         *
         * @param v the value
         * @return this builder
         */
        public Builder size(Long v) {
            this.size = v;
            return this;
        }

        /**
         * Sets totalItems.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalItems(Long v) {
            this.totalItems = v;
            return this;
        }

        /**
         * Sets totalPages.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalPages(Long v) {
            this.totalPages = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningJobResultsPage build() {
            return new ScreeningJobResultsPage(jobId, status, items, page, size, totalItems, totalPages);
        }
    }
}
