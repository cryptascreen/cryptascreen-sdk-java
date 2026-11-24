package com.cryptascreen.sdk.model;

/**
 * EntityLabel (see types/intelligence.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param address address
 * @param chain chain
 * @param label label
 * @param category category
 * @param subcategory subcategory
 * @param confidence confidence
 * @param source source
 * @param verified verified
 * @param firstSeen firstSeen
 * @param lastSeen lastSeen
 * @param metadata metadata
 * @param ingestedAt ingestedAt
 * @param validTo validTo
 * @param reviewStatus reviewStatus
 */
public record EntityLabel(
        Long id,
        String address,
        String chain,
        String label,
        String category,
        String subcategory,
        Double confidence,
        String source,
        Boolean verified,
        String firstSeen,
        String lastSeen,
        String metadata,
        String ingestedAt,
        String validTo,
        String reviewStatus
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link EntityLabel}. */
    public static final class Builder {
        private Long id;
        private String address;
        private String chain;
        private String label;
        private String category;
        private String subcategory;
        private Double confidence;
        private String source;
        private Boolean verified;
        private String firstSeen;
        private String lastSeen;
        private String metadata;
        private String ingestedAt;
        private String validTo;
        private String reviewStatus;

        private Builder() {}

        /**
         * Sets id.
         *
         * @param v the value
         * @return this builder
         */
        public Builder id(Long v) {
            this.id = v;
            return this;
        }

        /**
         * Sets address.
         *
         * @param v the value
         * @return this builder
         */
        public Builder address(String v) {
            this.address = v;
            return this;
        }

        /**
         * Sets chain.
         *
         * @param v the value
         * @return this builder
         */
        public Builder chain(String v) {
            this.chain = v;
            return this;
        }

        /**
         * Sets label.
         *
         * @param v the value
         * @return this builder
         */
        public Builder label(String v) {
            this.label = v;
            return this;
        }

        /**
         * Sets category.
         *
         * @param v the value
         * @return this builder
         */
        public Builder category(String v) {
            this.category = v;
            return this;
        }

        /**
         * Sets subcategory.
         *
         * @param v the value
         * @return this builder
         */
        public Builder subcategory(String v) {
            this.subcategory = v;
            return this;
        }

        /**
         * Sets confidence.
         *
         * @param v the value
         * @return this builder
         */
        public Builder confidence(Double v) {
            this.confidence = v;
            return this;
        }

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
         * Sets verified.
         *
         * @param v the value
         * @return this builder
         */
        public Builder verified(Boolean v) {
            this.verified = v;
            return this;
        }

        /**
         * Sets firstSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder firstSeen(String v) {
            this.firstSeen = v;
            return this;
        }

        /**
         * Sets lastSeen.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastSeen(String v) {
            this.lastSeen = v;
            return this;
        }

        /**
         * Sets metadata.
         *
         * @param v the value
         * @return this builder
         */
        public Builder metadata(String v) {
            this.metadata = v;
            return this;
        }

        /**
         * Sets ingestedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder ingestedAt(String v) {
            this.ingestedAt = v;
            return this;
        }

        /**
         * Sets validTo.
         *
         * @param v the value
         * @return this builder
         */
        public Builder validTo(String v) {
            this.validTo = v;
            return this;
        }

        /**
         * Sets reviewStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reviewStatus(String v) {
            this.reviewStatus = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public EntityLabel build() {
            return new EntityLabel(id, address, chain, label, category, subcategory, confidence, source, verified, firstSeen, lastSeen, metadata, ingestedAt, validTo, reviewStatus);
        }
    }
}
