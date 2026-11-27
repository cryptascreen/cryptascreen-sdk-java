// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * UpdateCaseStatusRequest (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param status status
 * @param reason reason
 */
public record UpdateCaseStatusRequest(
        String status,
        String reason
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link UpdateCaseStatusRequest}. */
    public static final class Builder {
        private String status;
        private String reason;

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
         * Sets reason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reason(String v) {
            this.reason = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public UpdateCaseStatusRequest build() {
            return new UpdateCaseStatusRequest(status, reason);
        }
    }
}
