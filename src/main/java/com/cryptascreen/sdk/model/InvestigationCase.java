// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * InvestigationCase (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param title title
 * @param description description
 * @param status status
 * @param priority priority
 * @param assigneeId assigneeId
 * @param addresses addresses
 * @param notes notes
 * @param evidence evidence
 * @param events events
 * @param createdAt createdAt
 * @param updatedAt updatedAt
 * @param resolvedAt resolvedAt
 */
public record InvestigationCase(
        String id,
        String title,
        String description,
        String status,
        String priority,
        String assigneeId,
        List<Object> addresses,
        List<CaseNote> notes,
        List<CaseEvidence> evidence,
        List<CaseEvent> events,
        String createdAt,
        String updatedAt,
        String resolvedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link InvestigationCase}. */
    public static final class Builder {
        private String id;
        private String title;
        private String description;
        private String status;
        private String priority;
        private String assigneeId;
        private List<Object> addresses;
        private List<CaseNote> notes;
        private List<CaseEvidence> evidence;
        private List<CaseEvent> events;
        private String createdAt;
        private String updatedAt;
        private String resolvedAt;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(String v) {
            this.id = v;
            return this;
        }

        /**
         * Sets title.
         *
         * @param v the value
         * @return this builder
         */
        public Builder title(String v) {
            this.title = v;
            return this;
        }

        /**
         * Sets description.
         *
         * @param v the value
         * @return this builder
         */
        public Builder description(String v) {
            this.description = v;
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
         * Sets priority.
         *
         * @param v the value
         * @return this builder
         */
        public Builder priority(String v) {
            this.priority = v;
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
         * Sets addresses.
         *
         * @param v the value
         * @return this builder
         */
        public Builder addresses(List<Object> v) {
            this.addresses = v;
            return this;
        }

        /**
         * Sets notes.
         *
         * @param v the value
         * @return this builder
         */
        public Builder notes(List<CaseNote> v) {
            this.notes = v;
            return this;
        }

        /**
         * Sets evidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evidence(List<CaseEvidence> v) {
            this.evidence = v;
            return this;
        }

        /**
         * Sets events.
         *
         * @param v the value
         * @return this builder
         */
        public Builder events(List<CaseEvent> v) {
            this.events = v;
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
         * Sets updatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedAt(String v) {
            this.updatedAt = v;
            return this;
        }

        /**
         * Sets resolvedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder resolvedAt(String v) {
            this.resolvedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public InvestigationCase build() {
            return new InvestigationCase(id, title, description, status, priority, assigneeId, addresses, notes, evidence, events, createdAt, updatedAt, resolvedAt);
        }
    }
}
