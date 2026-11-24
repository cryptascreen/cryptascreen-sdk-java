package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * A registered webhook endpoint as webhooks().list() returns it (the secret is only a hint).
 *
 * @param id id
 * @param url url
 * @param secret secret
 * @param events events
 * @param isActive isActive
 * @param description description
 * @param createdAt createdAt
 */
public record WebhookConfig(
        Long id,
        String url,
        String secret,
        List<String> events,
        Boolean isActive,
        String description,
        String createdAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WebhookConfig}. */
    public static final class Builder {
        private Long id;
        private String url;
        private String secret;
        private List<String> events;
        private Boolean isActive;
        private String description;
        private String createdAt;

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
         * Sets url.
         *
         * @param v the value
         * @return this builder
         */
        public Builder url(String v) {
            this.url = v;
            return this;
        }

        /**
         * Sets secret.
         *
         * @param v the value
         * @return this builder
         */
        public Builder secret(String v) {
            this.secret = v;
            return this;
        }

        /**
         * Sets events.
         *
         * @param v the value
         * @return this builder
         */
        public Builder events(List<String> v) {
            this.events = v;
            return this;
        }

        /**
         * Sets isActive.
         *
         * @param v the value
         * @return this builder
         */
        public Builder isActive(Boolean v) {
            this.isActive = v;
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
         * Builds the record.
         *
         * @return the record
         */
        public WebhookConfig build() {
            return new WebhookConfig(id, url, secret, events, isActive, description, createdAt);
        }
    }
}
