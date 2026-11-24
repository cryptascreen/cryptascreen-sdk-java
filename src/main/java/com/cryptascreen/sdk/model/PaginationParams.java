package com.cryptascreen.sdk.model;

/**
 * PaginationParams (see types/common.ts in @cryptascreen/sdk).
 *
 * @param page page
 * @param pageSize pageSize
 */
public record PaginationParams(
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

    /** Builder for {@link PaginationParams}. */
    public static final class Builder {
        private Long page;
        private Long pageSize;

        private Builder() {}

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
        public PaginationParams build() {
            return new PaginationParams(page, pageSize);
        }
    }
}
