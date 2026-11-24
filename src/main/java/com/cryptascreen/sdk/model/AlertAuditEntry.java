package com.cryptascreen.sdk.model;

/**
 * AlertAuditEntry (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param event event
 * @param actor actor
 * @param at at
 * @param note note
 */
public record AlertAuditEntry(
        String event,
        String actor,
        String at,
        String note
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AlertAuditEntry}. */
    public static final class Builder {
        private String event;
        private String actor;
        private String at;
        private String note;

        private Builder() {}

        /**
         * Sets event.
         *
         * @param v the value
         * @return this builder
         */
        public Builder event(String v) {
            this.event = v;
            return this;
        }

        /**
         * Sets actor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder actor(String v) {
            this.actor = v;
            return this;
        }

        /**
         * Sets at.
         *
         * @param v the value
         * @return this builder
         */
        public Builder at(String v) {
            this.at = v;
            return this;
        }

        /**
         * Sets note.
         *
         * @param v the value
         * @return this builder
         */
        public Builder note(String v) {
            this.note = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AlertAuditEntry build() {
            return new AlertAuditEntry(event, actor, at, note);
        }
    }
}
