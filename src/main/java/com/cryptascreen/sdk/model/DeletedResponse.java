// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * {deleted: true}.
 *
 * @param deleted deleted
 */
public record DeletedResponse(
        Boolean deleted
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link DeletedResponse}. */
    public static final class Builder {
        private Boolean deleted;

        private Builder() {}

        /**
         * Sets deleted.
         *
         * @param v the value
         * @return this builder
         */
        public Builder deleted(Boolean v) {
            this.deleted = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public DeletedResponse build() {
            return new DeletedResponse(deleted);
        }
    }
}
