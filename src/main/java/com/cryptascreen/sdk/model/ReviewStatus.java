// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * ReviewStatus (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param status status
 * @param decisionId decisionId
 * @param decisionType decisionType
 * @param effect effect
 * @param reason reason
 * @param actor actor
 * @param createdAt createdAt
 * @param expiresAt expiresAt
 * @param revokedAt revokedAt
 * @param alertRoutingSuppressed alertRoutingSuppressed
 * @param blockingFindingPreserved blockingFindingPreserved
 */
public record ReviewStatus(
        String status,
        Long decisionId,
        String decisionType,
        String effect,
        String reason,
        String actor,
        String createdAt,
        String expiresAt,
        String revokedAt,
        Boolean alertRoutingSuppressed,
        Boolean blockingFindingPreserved
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ReviewStatus}. */
    public static final class Builder {
        private String status;
        private Long decisionId;
        private String decisionType;
        private String effect;
        private String reason;
        private String actor;
        private String createdAt;
        private String expiresAt;
        private String revokedAt;
        private Boolean alertRoutingSuppressed;
        private Boolean blockingFindingPreserved;

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
         * Sets decisionId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decisionId(Long v) {
            this.decisionId = v;
            return this;
        }

        /**
         * Sets decisionType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder decisionType(String v) {
            this.decisionType = v;
            return this;
        }

        /**
         * Sets effect.
         *
         * @param v the value
         * @return this builder
         */
        public Builder effect(String v) {
            this.effect = v;
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
         * Sets actor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder actor(String v) {
            this.actor = v;
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
         * Sets expiresAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder expiresAt(String v) {
            this.expiresAt = v;
            return this;
        }

        /**
         * Sets revokedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder revokedAt(String v) {
            this.revokedAt = v;
            return this;
        }

        /**
         * Sets alertRoutingSuppressed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder alertRoutingSuppressed(Boolean v) {
            this.alertRoutingSuppressed = v;
            return this;
        }

        /**
         * Sets blockingFindingPreserved.
         *
         * @param v the value
         * @return this builder
         */
        public Builder blockingFindingPreserved(Boolean v) {
            this.blockingFindingPreserved = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ReviewStatus build() {
            return new ReviewStatus(status, decisionId, decisionType, effect, reason, actor, createdAt, expiresAt, revokedAt, alertRoutingSuppressed, blockingFindingPreserved);
        }
    }
}
