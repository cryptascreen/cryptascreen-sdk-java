// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * AlertDetail (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param address address
 * @param chain chain
 * @param riskLevel riskLevel
 * @param alertType alertType
 * @param createdAt createdAt
 * @param reasonState reasonState
 * @param reasons reasons
 * @param evaluationId evaluationId
 * @param caseRefs caseRefs
 * @param acknowledged acknowledged
 * @param acknowledgement acknowledgement
 * @param auditTrail auditTrail
 * @param alreadyAcknowledged alreadyAcknowledged
 */
public record AlertDetail(
        Long id,
        String address,
        String chain,
        String riskLevel,
        String alertType,
        String createdAt,
        String reasonState,
        List<AlertReason> reasons,
        String evaluationId,
        List<String> caseRefs,
        Boolean acknowledged,
        AlertAcknowledgement acknowledgement,
        List<AlertAuditEntry> auditTrail,
        Boolean alreadyAcknowledged
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AlertDetail}. */
    public static final class Builder {
        private Long id;
        private String address;
        private String chain;
        private String riskLevel;
        private String alertType;
        private String createdAt;
        private String reasonState;
        private List<AlertReason> reasons;
        private String evaluationId;
        private List<String> caseRefs;
        private Boolean acknowledged;
        private AlertAcknowledgement acknowledgement;
        private List<AlertAuditEntry> auditTrail;
        private Boolean alreadyAcknowledged;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(Long v) {
            this.id = v;
            return this;
        }

        /**
         * Sets address.
         *
         * @param v the value
         * @return this builder
         */
        public Builder address(String v) {
            this.address = v;
            return this;
        }

        /**
         * Sets chain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chain(String v) {
            this.chain = v;
            return this;
        }

        /**
         * Sets riskLevel.
         *
         * @param v the value
         * @return this builder
         */
        public Builder riskLevel(String v) {
            this.riskLevel = v;
            return this;
        }

        /**
         * Sets alertType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder alertType(String v) {
            this.alertType = v;
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
         * Sets reasonState.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasonState(String v) {
            this.reasonState = v;
            return this;
        }

        /**
         * Sets reasons.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reasons(List<AlertReason> v) {
            this.reasons = v;
            return this;
        }

        /**
         * Sets evaluationId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evaluationId(String v) {
            this.evaluationId = v;
            return this;
        }

        /**
         * Sets caseRefs.
         *
         * @param v the value
         * @return this builder
         */
        public Builder caseRefs(List<String> v) {
            this.caseRefs = v;
            return this;
        }

        /**
         * Sets acknowledged.
         *
         * @param v the value
         * @return this builder
         */
        public Builder acknowledged(Boolean v) {
            this.acknowledged = v;
            return this;
        }

        /**
         * Sets acknowledgement.
         *
         * @param v the value
         * @return this builder
         */
        public Builder acknowledgement(AlertAcknowledgement v) {
            this.acknowledgement = v;
            return this;
        }

        /**
         * Sets auditTrail.
         *
         * @param v the value
         * @return this builder
         */
        public Builder auditTrail(List<AlertAuditEntry> v) {
            this.auditTrail = v;
            return this;
        }

        /**
         * Sets alreadyAcknowledged.
         *
         * @param v the value
         * @return this builder
         */
        public Builder alreadyAcknowledged(Boolean v) {
            this.alreadyAcknowledged = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AlertDetail build() {
            return new AlertDetail(id, address, chain, riskLevel, alertType, createdAt, reasonState, reasons, evaluationId, caseRefs, acknowledged, acknowledgement, auditTrail, alreadyAcknowledged);
        }
    }
}
