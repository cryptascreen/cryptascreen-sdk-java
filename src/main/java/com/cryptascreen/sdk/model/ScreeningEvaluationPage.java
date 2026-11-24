package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningEvaluationPage (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param items items
 * @param page page
 * @param size size
 * @param totalElements totalElements
 * @param totalPages totalPages
 * @param latestEvaluationId latestEvaluationId
 */
public record ScreeningEvaluationPage(
        List<ScreeningEvaluation> items,
        Long page,
        Long size,
        Long totalElements,
        Long totalPages,
        String latestEvaluationId
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningEvaluationPage}. */
    public static final class Builder {
        private List<ScreeningEvaluation> items;
        private Long page;
        private Long size;
        private Long totalElements;
        private Long totalPages;
        private String latestEvaluationId;

        private Builder() {}

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<ScreeningEvaluation> v) {
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
         * Sets totalElements.
         *
         * @param v the value
         * @return this builder
         */
        public Builder totalElements(Long v) {
            this.totalElements = v;
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
         * Sets latestEvaluationId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder latestEvaluationId(String v) {
            this.latestEvaluationId = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningEvaluationPage build() {
            return new ScreeningEvaluationPage(items, page, size, totalElements, totalPages, latestEvaluationId);
        }
    }
}
