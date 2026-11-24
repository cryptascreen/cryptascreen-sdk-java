package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * ApiError (see types/common.ts in @cryptascreen/sdk).
 *
 * @param status status
 * @param code code
 * @param message message
 * @param details details
 * @param requestId requestId
 */
public record ApiError(
        Double status,
        String code,
        String message,
        Map<String, Object> details,
        String requestId
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ApiError}. */
    public static final class Builder {
        private Double status;
        private String code;
        private String message;
        private Map<String, Object> details;
        private String requestId;

        private Builder() {}

        /**
         * Sets status.
         *
         * @param v the value
         * @return this builder
         */
        public Builder status(Double v) {
            this.status = v;
            return this;
        }

        /**
         * Sets code.
         *
         * @param v the value
         * @return this builder
         */
        public Builder code(String v) {
            this.code = v;
            return this;
        }

        /**
         * Sets message.
         *
         * @param v the value
         * @return this builder
         */
        public Builder message(String v) {
            this.message = v;
            return this;
        }

        /**
         * Sets details.
         *
         * @param v the value
         * @return this builder
         */
        public Builder details(Map<String, Object> v) {
            this.details = v;
            return this;
        }

        /**
         * Sets requestId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder requestId(String v) {
            this.requestId = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ApiError build() {
            return new ApiError(status, code, message, details, requestId);
        }
    }
}
