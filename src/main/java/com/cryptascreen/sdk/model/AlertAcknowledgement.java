// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * AlertAcknowledgement (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param at at
 * @param by by
 * @param userId userId
 * @param note note
 */
public record AlertAcknowledgement(
        String at,
        String by,
        Long userId,
        String note
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AlertAcknowledgement}. */
    public static final class Builder {
        private String at;
        private String by;
        private Long userId;
        private String note;

        private Builder() {}

        /**
         * Sets at.
         *
         * @param v the value
         * @return this builder
         */
        public Builder at(String v) {
            this.at = v;
            return this;
        }

        /**
         * Sets by.
         *
         * @param v the value
         * @return this builder
         */
        public Builder by(String v) {
            this.by = v;
            return this;
        }

        /**
         * Sets userId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder userId(Long v) {
            this.userId = v;
            return this;
        }

        /**
         * Sets note.
         *
         * @param v the value
         * @return this builder
         */
        public Builder note(String v) {
            this.note = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AlertAcknowledgement build() {
            return new AlertAcknowledgement(at, by, userId, note);
        }
    }
}
