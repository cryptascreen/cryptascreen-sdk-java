package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * CreateCaseRequest (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param title title
 * @param description description
 * @param priority priority
 * @param assigneeId assigneeId
 * @param addresses addresses
 */
public record CreateCaseRequest(
        String title,
        String description,
        String priority,
        String assigneeId,
        List<Object> addresses
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CreateCaseRequest}. */
    public static final class Builder {
        private String title;
        private String description;
        private String priority;
        private String assigneeId;
        private List<Object> addresses;

        private Builder() {}

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
         * Builds the record.
         *
         * @return the record
         */
        public CreateCaseRequest build() {
            return new CreateCaseRequest(title, description, priority, assigneeId, addresses);
        }
    }
}
