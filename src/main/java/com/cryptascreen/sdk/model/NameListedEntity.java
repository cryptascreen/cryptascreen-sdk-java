package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * NameListedEntity (see types/names.ts in @cryptascreen/sdk).
 *
 * @param source source
 * @param subjectId subjectId
 * @param name name
 * @param type type
 * @param programs programs
 * @param listedDate listedDate
 */
public record NameListedEntity(
        String source,
        String subjectId,
        String name,
        String type,
        List<String> programs,
        String listedDate
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link NameListedEntity}. */
    public static final class Builder {
        private String source;
        private String subjectId;
        private String name;
        private String type;
        private List<String> programs;
        private String listedDate;

        private Builder() {}

        /**
         * Sets source.
         *
         * @param v the value
         * @return this builder
         */
        public Builder source(String v) {
            this.source = v;
            return this;
        }

        /**
         * Sets subjectId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder subjectId(String v) {
            this.subjectId = v;
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
         * Sets type.
         *
         * @param v the value
         * @return this builder
         */
        public Builder type(String v) {
            this.type = v;
            return this;
        }

        /**
         * Sets programs.
         *
         * @param v the value
         * @return this builder
         */
        public Builder programs(List<String> v) {
            this.programs = v;
            return this;
        }

        /**
         * Sets listedDate.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listedDate(String v) {
            this.listedDate = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public NameListedEntity build() {
            return new NameListedEntity(source, subjectId, name, type, programs, listedDate);
        }
    }
}
