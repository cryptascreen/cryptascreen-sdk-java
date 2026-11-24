package com.cryptascreen.sdk.model;

/**
 * ApiResponse (see types/common.ts in @cryptascreen/sdk).
 *
 * @param data data
 * @param requestId requestId
 */
public record ApiResponse(
        Object data,
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

    /** Builder for {@link ApiResponse}. */
    public static final class Builder {
        private Object data;
        private String requestId;

        private Builder() {}

        /**
         * Sets data.
         *
         * @param v the value
         * @return this builder
         */
        public Builder data(Object v) {
            this.data = v;
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
        public ApiResponse build() {
            return new ApiResponse(data, requestId);
        }
    }
}
