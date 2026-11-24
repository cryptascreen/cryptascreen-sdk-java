package com.cryptascreen.sdk.model;

/**
 * AddNoteRequest (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param content content
 */
public record AddNoteRequest(
        String content
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AddNoteRequest}. */
    public static final class Builder {
        private String content;

        private Builder() {}

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
         * Builds the record.
         *
         * @return the record
         */
        public AddNoteRequest build() {
            return new AddNoteRequest(content);
        }
    }
}
