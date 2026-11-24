package com.cryptascreen.sdk.model;

/**
 * CaseAssignee (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param userId userId
 * @param name name
 * @param email email
 * @param assignedAt assignedAt
 * @param assignedBy assignedBy
 */
public record CaseAssignee(
        Long userId,
        String name,
        String email,
        String assignedAt,
        String assignedBy
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CaseAssignee}. */
    public static final class Builder {
        private Long userId;
        private String name;
        private String email;
        private String assignedAt;
        private String assignedBy;

        private Builder() {}

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
         * Sets name.
         *
         * @param v the value
         * @return this builder
         */
        public Builder name(String v) {
            this.name = v;
            return this;
        }

        /**
         * Sets email.
         *
         * @param v the value
         * @return this builder
         */
        public Builder email(String v) {
            this.email = v;
            return this;
        }

        /**
         * Sets assignedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assignedAt(String v) {
            this.assignedAt = v;
            return this;
        }

        /**
         * Sets assignedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assignedBy(String v) {
            this.assignedBy = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CaseAssignee build() {
            return new CaseAssignee(userId, name, email, assignedAt, assignedBy);
        }
    }
}
