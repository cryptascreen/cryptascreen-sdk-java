package com.cryptascreen.sdk.model;

/**
 * SourceFreshness (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param sourceId sourceId
 * @param issuer issuer
 * @param listName listName
 * @param required required
 * @param fetchEnabled fetchEnabled
 * @param freshnessState freshnessState
 * @param staleReason staleReason
 * @param snapshotVersion snapshotVersion
 * @param snapshotHash snapshotHash
 * @param publishedAt publishedAt
 * @param lastSuccessAt lastSuccessAt
 * @param errorState errorState
 */
public record SourceFreshness(
        String sourceId,
        String issuer,
        String listName,
        Boolean required,
        Boolean fetchEnabled,
        String freshnessState,
        String staleReason,
        Long snapshotVersion,
        String snapshotHash,
        String publishedAt,
        String lastSuccessAt,
        String errorState
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link SourceFreshness}. */
    public static final class Builder {
        private String sourceId;
        private String issuer;
        private String listName;
        private Boolean required;
        private Boolean fetchEnabled;
        private String freshnessState;
        private String staleReason;
        private Long snapshotVersion;
        private String snapshotHash;
        private String publishedAt;
        private String lastSuccessAt;
        private String errorState;

        private Builder() {}

        /**
         * Sets sourceId.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sourceId(String v) {
            this.sourceId = v;
            return this;
        }

        /**
         * Sets issuer.
         *
         * @param v the value
         * @return this builder
         */
        public Builder issuer(String v) {
            this.issuer = v;
            return this;
        }

        /**
         * Sets listName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder listName(String v) {
            this.listName = v;
            return this;
        }

        /**
         * Sets required.
         *
         * @param v the value
         * @return this builder
         */
        public Builder required(Boolean v) {
            this.required = v;
            return this;
        }

        /**
         * Sets fetchEnabled.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fetchEnabled(Boolean v) {
            this.fetchEnabled = v;
            return this;
        }

        /**
         * Sets freshnessState.
         *
         * @param v the value
         * @return this builder
         */
        public Builder freshnessState(String v) {
            this.freshnessState = v;
            return this;
        }

        /**
         * Sets staleReason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder staleReason(String v) {
            this.staleReason = v;
            return this;
        }

        /**
         * Sets snapshotVersion.
         *
         * @param v the value
         * @return this builder
         */
        public Builder snapshotVersion(Long v) {
            this.snapshotVersion = v;
            return this;
        }

        /**
         * Sets snapshotHash.
         *
         * @param v the value
         * @return this builder
         */
        public Builder snapshotHash(String v) {
            this.snapshotHash = v;
            return this;
        }

        /**
         * Sets publishedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder publishedAt(String v) {
            this.publishedAt = v;
            return this;
        }

        /**
         * Sets lastSuccessAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastSuccessAt(String v) {
            this.lastSuccessAt = v;
            return this;
        }

        /**
         * Sets errorState.
         *
         * @param v the value
         * @return this builder
         */
        public Builder errorState(String v) {
            this.errorState = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public SourceFreshness build() {
            return new SourceFreshness(sourceId, issuer, listName, required, fetchEnabled, freshnessState, staleReason, snapshotVersion, snapshotHash, publishedAt, lastSuccessAt, errorState);
        }
    }
}
