package com.cryptascreen.sdk.model;

/**
 * Dac8ReportResult (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param reportId reportId
 * @param transactionCount transactionCount
 * @param generatedAt generatedAt
 * @param status status
 * @param xmlPreview xmlPreview
 */
public record Dac8ReportResult(
        String reportId,
        Long transactionCount,
        String generatedAt,
        String status,
        String xmlPreview
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link Dac8ReportResult}. */
    public static final class Builder {
        private String reportId;
        private Long transactionCount;
        private String generatedAt;
        private String status;
        private String xmlPreview;

        private Builder() {}

        /**
         * Sets reportId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reportId(String v) {
            this.reportId = v;
            return this;
        }

        /**
         * Sets transactionCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transactionCount(Long v) {
            this.transactionCount = v;
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
         * Sets xmlPreview.
         *
         * @param v the value
         * @return this builder
         */
        public Builder xmlPreview(String v) {
            this.xmlPreview = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public Dac8ReportResult build() {
            return new Dac8ReportResult(reportId, transactionCount, generatedAt, status, xmlPreview);
        }
    }
}
