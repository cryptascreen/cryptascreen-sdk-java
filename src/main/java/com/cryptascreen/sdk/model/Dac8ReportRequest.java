package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * Dac8ReportRequest (see types/compliance.ts in @cryptascreen/sdk).
 *
 * @param taxYear taxYear
 * @param jurisdiction jurisdiction
 * @param operator operator
 * @param users users
 */
public record Dac8ReportRequest(
        Long taxYear,
        String jurisdiction,
        Dac8OperatorInfo operator,
        List<Dac8UserData> users
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link Dac8ReportRequest}. */
    public static final class Builder {
        private Long taxYear;
        private String jurisdiction;
        private Dac8OperatorInfo operator;
        private List<Dac8UserData> users;

        private Builder() {}

        /**
         * Sets taxYear.
         *
         * @param v the value
         * @return this builder
         */
        public Builder taxYear(Long v) {
            this.taxYear = v;
            return this;
        }

        /**
         * Sets jurisdiction.
         *
         * @param v the value
         * @return this builder
         */
        public Builder jurisdiction(String v) {
            this.jurisdiction = v;
            return this;
        }

        /**
         * Sets operator.
         *
         * @param v the value
         * @return this builder
         */
        public Builder operator(Dac8OperatorInfo v) {
            this.operator = v;
            return this;
        }

        /**
         * Sets users.
         *
         * @param v the value
         * @return this builder
         */
        public Builder users(List<Dac8UserData> v) {
            this.users = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public Dac8ReportRequest build() {
            return new Dac8ReportRequest(taxYear, jurisdiction, operator, users);
        }
    }
}
