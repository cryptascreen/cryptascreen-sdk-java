// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * ListCasesParams (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param status status
 * @param priority priority
 * @param page page
 * @param pageSize pageSize
 */
public record ListCasesParams(
        String status,
        String priority,
        Long page,
        Long pageSize
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ListCasesParams}. */
    public static final class Builder {
        private String status;
        private String priority;
        private Long page;
        private Long pageSize;

        private Builder() {}

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
         * Sets priority.
         *
         * @param v the value
         * @return this builder
         */
        public Builder priority(String v) {
            this.priority = v;
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
         * Sets pageSize.
         *
         * @param v the value
         * @return this builder
         */
        public Builder pageSize(Long v) {
            this.pageSize = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ListCasesParams build() {
            return new ListCasesParams(status, priority, page, pageSize);
        }
    }
}
