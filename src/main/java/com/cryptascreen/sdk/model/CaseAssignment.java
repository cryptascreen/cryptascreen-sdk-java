package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * CaseAssignment (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param caseRef caseRef
 * @param assignee assignee
 * @param evaluationIds evaluationIds
 * @param changed changed
 */
public record CaseAssignment(
        String caseRef,
        CaseAssignee assignee,
        List<String> evaluationIds,
        Boolean changed
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CaseAssignment}. */
    public static final class Builder {
        private String caseRef;
        private CaseAssignee assignee;
        private List<String> evaluationIds;
        private Boolean changed;

        private Builder() {}

        /**
         * Sets caseRef.
         *
         * @param v the value
         * @return this builder
         */
        public Builder caseRef(String v) {
            this.caseRef = v;
            return this;
        }

        /**
         * Sets assignee.
         *
         * @param v the value
         * @return this builder
         */
        public Builder assignee(CaseAssignee v) {
            this.assignee = v;
            return this;
        }

        /**
         * Sets evaluationIds.
         *
         * @param v the value
         * @return this builder
         */
        public Builder evaluationIds(List<String> v) {
            this.evaluationIds = v;
            return this;
        }

        /**
         * Sets changed.
         *
         * @param v the value
         * @return this builder
         */
        public Builder changed(Boolean v) {
            this.changed = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CaseAssignment build() {
            return new CaseAssignment(caseRef, assignee, evaluationIds, changed);
        }
    }
}
