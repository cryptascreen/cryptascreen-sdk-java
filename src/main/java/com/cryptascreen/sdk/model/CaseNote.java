package com.cryptascreen.sdk.model;

/**
 * CaseNote (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param caseId caseId
 * @param authorId authorId
 * @param content content
 * @param createdAt createdAt
 */
public record CaseNote(
        String id,
        String caseId,
        String authorId,
        String content,
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

    /** Builder for {@link CaseNote}. */
    public static final class Builder {
        private String id;
        private String caseId;
        private String authorId;
        private String content;
        private String createdAt;

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
         * Sets authorId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder authorId(String v) {
            this.authorId = v;
            return this;
        }

        /**
         * Sets content.
         *
         * @param v the value
         * @return this builder
         */
        public Builder content(String v) {
            this.content = v;
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
        public CaseNote build() {
            return new CaseNote(id, caseId, authorId, content, createdAt);
        }
    }
}
