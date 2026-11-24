package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningJob (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param jobId jobId
 * @param status status
 * @param total total
 * @param processed processed
 * @param succeeded succeeded
 * @param failed failed
 * @param results results
 * @param summary summary
 * @param error error
 * @param createdAt createdAt
 * @param startedAt startedAt
 * @param completedAt completedAt
 * @param errorCode errorCode
 * @param cancelRequested cancelRequested
 * @param resultsUrl resultsUrl
 * @param policyVersion policyVersion
 * @param scoreVersion scoreVersion
 */
public record ScreeningJob(
        String jobId,
        String status,
        Long total,
        Double processed,
        Double succeeded,
        Double failed,
        List<ScreeningResponse> results,
        ScreeningJobSummary summary,
        String error,
        String createdAt,
        String startedAt,
        String completedAt,
        String errorCode,
        Boolean cancelRequested,
        String resultsUrl,
        String policyVersion,
        String scoreVersion
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningJob}. */
    public static final class Builder {
        private String jobId;
        private String status;
        private Long total;
        private Double processed;
        private Double succeeded;
        private Double failed;
        private List<ScreeningResponse> results;
        private ScreeningJobSummary summary;
        private String error;
        private String createdAt;
        private String startedAt;
        private String completedAt;
        private String errorCode;
        private Boolean cancelRequested;
        private String resultsUrl;
        private String policyVersion;
        private String scoreVersion;

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
         * Sets total.
         *
         * @param v the value
         * @return this builder
         */
        public Builder total(Long v) {
            this.total = v;
            return this;
        }

        /**
         * Sets processed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder processed(Double v) {
            this.processed = v;
            return this;
        }

        /**
         * Sets succeeded.
         *
         * @param v the value
         * @return this builder
         */
        public Builder succeeded(Double v) {
            this.succeeded = v;
            return this;
        }

        /**
         * Sets failed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder failed(Double v) {
            this.failed = v;
            return this;
        }

        /**
         * Sets results.
         *
         * @param v the value
         * @return this builder
         */
        public Builder results(List<ScreeningResponse> v) {
            this.results = v;
            return this;
        }

        /**
         * Sets summary.
         *
         * @param v the value
         * @return this builder
         */
        public Builder summary(ScreeningJobSummary v) {
            this.summary = v;
            return this;
        }

        /**
         * Sets error.
         *
         * @param v the value
         * @return this builder
         */
        public Builder error(String v) {
            this.error = v;
            return this;
        }

        /**
         * Sets createdAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder createdAt(String v) {
            this.createdAt = v;
            return this;
        }

        /**
         * Sets startedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder startedAt(String v) {
            this.startedAt = v;
            return this;
        }

        /**
         * Sets completedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder completedAt(String v) {
            this.completedAt = v;
            return this;
        }

        /**
         * Sets errorCode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder errorCode(String v) {
            this.errorCode = v;
            return this;
        }

        /**
         * Sets cancelRequested.
         *
         * @param v the value
         * @return this builder
         */
        public Builder cancelRequested(Boolean v) {
            this.cancelRequested = v;
            return this;
        }

        /**
         * Sets resultsUrl.
         *
         * @param v the value
         * @return this builder
         */
        public Builder resultsUrl(String v) {
            this.resultsUrl = v;
            return this;
        }

        /**
         * Sets policyVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder policyVersion(String v) {
            this.policyVersion = v;
            return this;
        }

        /**
         * Sets scoreVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder scoreVersion(String v) {
            this.scoreVersion = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningJob build() {
            return new ScreeningJob(jobId, status, total, processed, succeeded, failed, results, summary, error, createdAt, startedAt, completedAt, errorCode, cancelRequested, resultsUrl, policyVersion, scoreVersion);
        }
    }
}
