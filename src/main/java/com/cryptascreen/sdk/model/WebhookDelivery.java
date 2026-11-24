package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * One delivery record of an endpoint (status PENDING, DELIVERED, FAILED or EXHAUSTED).
 *
 * @param id id
 * @param webhookConfigId webhookConfigId
 * @param eventType eventType
 * @param payload payload
 * @param status status
 * @param attemptCount attemptCount
 * @param lastAttemptAt lastAttemptAt
 * @param nextRetryAt nextRetryAt
 * @param responseCode responseCode
 * @param responseBody responseBody
 * @param createdAt createdAt
 * @param deliveredAt deliveredAt
 * @param eventId eventId
 * @param sourceType sourceType
 * @param sourceId sourceId
 * @param lastError lastError
 */
public record WebhookDelivery(
        String id,
        Long webhookConfigId,
        String eventType,
        Map<String, Object> payload,
        String status,
        Integer attemptCount,
        String lastAttemptAt,
        String nextRetryAt,
        Integer responseCode,
        String responseBody,
        String createdAt,
        String deliveredAt,
        String eventId,
        String sourceType,
        String sourceId,
        String lastError
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WebhookDelivery}. */
    public static final class Builder {
        private String id;
        private Long webhookConfigId;
        private String eventType;
        private Map<String, Object> payload;
        private String status;
        private Integer attemptCount;
        private String lastAttemptAt;
        private String nextRetryAt;
        private Integer responseCode;
        private String responseBody;
        private String createdAt;
        private String deliveredAt;
        private String eventId;
        private String sourceType;
        private String sourceId;
        private String lastError;

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
         * Sets webhookConfigId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder webhookConfigId(Long v) {
            this.webhookConfigId = v;
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
         * Sets payload.
         *
         * @param v the value
         * @return this builder
         */
        public Builder payload(Map<String, Object> v) {
            this.payload = v;
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
         * Sets attemptCount.
         *
         * @param v the value
         * @return this builder
         */
        public Builder attemptCount(Integer v) {
            this.attemptCount = v;
            return this;
        }

        /**
         * Sets lastAttemptAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastAttemptAt(String v) {
            this.lastAttemptAt = v;
            return this;
        }

        /**
         * Sets nextRetryAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder nextRetryAt(String v) {
            this.nextRetryAt = v;
            return this;
        }

        /**
         * Sets responseCode.
         *
         * @param v the value
         * @return this builder
         */
        public Builder responseCode(Integer v) {
            this.responseCode = v;
            return this;
        }

        /**
         * Sets responseBody.
         *
         * @param v the value
         * @return this builder
         */
        public Builder responseBody(String v) {
            this.responseBody = v;
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
         * Sets deliveredAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder deliveredAt(String v) {
            this.deliveredAt = v;
            return this;
        }

        /**
         * Sets eventId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder eventId(String v) {
            this.eventId = v;
            return this;
        }

        /**
         * Sets sourceType.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceType(String v) {
            this.sourceType = v;
            return this;
        }

        /**
         * Sets sourceId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceId(String v) {
            this.sourceId = v;
            return this;
        }

        /**
         * Sets lastError.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastError(String v) {
            this.lastError = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WebhookDelivery build() {
            return new WebhookDelivery(id, webhookConfigId, eventType, payload, status, attemptCount, lastAttemptAt, nextRetryAt, responseCode, responseBody, createdAt, deliveredAt, eventId, sourceType, sourceId, lastError);
        }
    }
}
