package com.cryptascreen.sdk.model;

/**
 * PageOptions (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param page page
 * @param size size
 */
public record PageOptions(
        Long page,
        Long size
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link PageOptions}. */
    public static final class Builder {
        private Long page;
        private Long size;

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
         * Builds the record.
         *
         * @return the record
         */
        public PageOptions build() {
            return new PageOptions(page, size);
        }
    }
}
