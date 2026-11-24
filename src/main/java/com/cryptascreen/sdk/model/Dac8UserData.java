package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * Dac8UserData (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param userId userId
 * @param firstName firstName
 * @param lastName lastName
 * @param entityName entityName
 * @param tin tin
 * @param residenceCountry residenceCountry
 * @param transactions transactions
 */
public record Dac8UserData(
        String userId,
        String firstName,
        String lastName,
        String entityName,
        String tin,
        String residenceCountry,
        List<Dac8TransactionData> transactions
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link Dac8UserData}. */
    public static final class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private String entityName;
        private String tin;
        private String residenceCountry;
        private List<Dac8TransactionData> transactions;

        private Builder() {}

        /**
         * Sets userId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder userId(String v) {
            this.userId = v;
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
         * Sets entityName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder entityName(String v) {
            this.entityName = v;
            return this;
        }

        /**
         * Sets tin.
         *
         * @param v the value
         * @return this builder
         */
        public Builder tin(String v) {
            this.tin = v;
            return this;
        }

        /**
         * Sets residenceCountry.
         *
         * @param v the value
         * @return this builder
         */
        public Builder residenceCountry(String v) {
            this.residenceCountry = v;
            return this;
        }

        /**
         * Sets transactions.
         *
         * @param v the value
         * @return this builder
         */
        public Builder transactions(List<Dac8TransactionData> v) {
            this.transactions = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public Dac8UserData build() {
            return new Dac8UserData(userId, firstName, lastName, entityName, tin, residenceCountry, transactions);
        }
    }
}
