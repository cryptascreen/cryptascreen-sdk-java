package com.cryptascreen.sdk.model;

/**
 * GET /auth/me: the calling identity (an API key resolves to its tenant owner).
 *
 * @param id id
 * @param email email
 * @param firstName firstName
 * @param lastName lastName
 * @param companyName companyName
 * @param tier tier
 * @param emailVerified emailVerified
 * @param twoFactorEnabled twoFactorEnabled
 * @param createdAt createdAt
 * @param platformRole platformRole
 * @param tenantId tenantId
 * @param screeningRole screeningRole
 * @param dataRegion dataRegion
 * @param authMethod authMethod
 * @param legalRegion legalRegion
 */
public record AuthMe(
        String id,
        String email,
        String firstName,
        String lastName,
        String companyName,
        String tier,
        Boolean emailVerified,
        Boolean twoFactorEnabled,
        String createdAt,
        String platformRole,
        String tenantId,
        String screeningRole,
        String dataRegion,
        String authMethod,
        String legalRegion
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AuthMe}. */
    public static final class Builder {
        private String id;
        private String email;
        private String firstName;
        private String lastName;
        private String companyName;
        private String tier;
        private Boolean emailVerified;
        private Boolean twoFactorEnabled;
        private String createdAt;
        private String platformRole;
        private String tenantId;
        private String screeningRole;
        private String dataRegion;
        private String authMethod;
        private String legalRegion;

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
         * Sets firstName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstName(String v) {
            this.firstName = v;
            return this;
        }

        /**
         * Sets lastName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastName(String v) {
            this.lastName = v;
            return this;
        }

        /**
         * Sets companyName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder companyName(String v) {
            this.companyName = v;
            return this;
        }

        /**
         * Sets tier.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tier(String v) {
            this.tier = v;
            return this;
        }

        /**
         * Sets emailVerified.
         *
         * @param v the value
         * @return this builder
         */
        public Builder emailVerified(Boolean v) {
            this.emailVerified = v;
            return this;
        }

        /**
         * Sets twoFactorEnabled.
         *
         * @param v the value
         * @return this builder
         */
        public Builder twoFactorEnabled(Boolean v) {
            this.twoFactorEnabled = v;
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
         * Sets platformRole.
         *
         * @param v the value
         * @return this builder
         */
        public Builder platformRole(String v) {
            this.platformRole = v;
            return this;
        }

        /**
         * Sets tenantId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tenantId(String v) {
            this.tenantId = v;
            return this;
        }

        /**
         * Sets screeningRole.
         *
         * @param v the value
         * @return this builder
         */
        public Builder screeningRole(String v) {
            this.screeningRole = v;
            return this;
        }

        /**
         * Sets dataRegion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dataRegion(String v) {
            this.dataRegion = v;
            return this;
        }

        /**
         * Sets authMethod.
         *
         * @param v the value
         * @return this builder
         */
        public Builder authMethod(String v) {
            this.authMethod = v;
            return this;
        }

        /**
         * Sets legalRegion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder legalRegion(String v) {
            this.legalRegion = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AuthMe build() {
            return new AuthMe(id, email, firstName, lastName, companyName, tier, emailVerified, twoFactorEnabled, createdAt, platformRole, tenantId, screeningRole, dataRegion, authMethod, legalRegion);
        }
    }
}
