package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * CaseEvent (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param caseId caseId
 * @param eventType eventType
 * @param description description
 * @param actorId actorId
 * @param metadata metadata
 * @param occurredAt occurredAt
 */
public record CaseEvent(
        String id,
        String caseId,
        String eventType,
        String description,
        String actorId,
        Map<String, Object> metadata,
        String occurredAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CaseEvent}. */
    public static final class Builder {
        private String id;
        private String caseId;
        private String eventType;
        private String description;
        private String actorId;
        private Map<String, Object> metadata;
        private String occurredAt;

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
         * Sets caseId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder caseId(String v) {
            this.caseId = v;
            return this;
        }

        /**
         * Sets eventType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder eventType(String v) {
            this.eventType = v;
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
         * Sets actorId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder actorId(String v) {
            this.actorId = v;
            return this;
        }

        /**
         * Sets metadata.
         *
         * @param v the value
         * @return this builder
         */
        public Builder metadata(Map<String, Object> v) {
            this.metadata = v;
            return this;
        }

        /**
         * Sets occurredAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder occurredAt(String v) {
            this.occurredAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CaseEvent build() {
            return new CaseEvent(id, caseId, eventType, description, actorId, metadata, occurredAt);
        }
    }
}
