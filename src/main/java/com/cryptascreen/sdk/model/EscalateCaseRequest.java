// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * EscalateCaseRequest (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param reason reason
 * @param assigneeId assigneeId
 */
public record EscalateCaseRequest(
        String reason,
        String assigneeId
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link EscalateCaseRequest}. */
    public static final class Builder {
        private String reason;
        private String assigneeId;

        private Builder() {}

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
         * Sets assigneeId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assigneeId(String v) {
            this.assigneeId = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public EscalateCaseRequest build() {
            return new EscalateCaseRequest(reason, assigneeId);
        }
    }
}
