// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * CaseEvidence (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param id id
 * @param caseId caseId
 * @param type type
 * @param label label
 * @param url url
 * @param metadata metadata
 * @param addedAt addedAt
 * @param addedBy addedBy
 */
public record CaseEvidence(
        String id,
        String caseId,
        String type,
        String label,
        String url,
        Map<String, Object> metadata,
        String addedAt,
        String addedBy
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link CaseEvidence}. */
    public static final class Builder {
        private String id;
        private String caseId;
        private String type;
        private String label;
        private String url;
        private Map<String, Object> metadata;
        private String addedAt;
        private String addedBy;

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
         * Sets url.
         *
         * @param v the value
         * @return this builder
         */
        public Builder url(String v) {
            this.url = v;
            return this;
        }

        /**
         * Sets metadata.
         *
         * @param v the value
         * @return this builder
         */
        public Builder metadata(Map<String, Object> v) {
            this.metadata = v;
            return this;
        }

        /**
         * Sets addedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder addedAt(String v) {
            this.addedAt = v;
            return this;
        }

        /**
         * Sets addedBy.
         *
         * @param v the value
         * @return this builder
         */
        public Builder addedBy(String v) {
            this.addedBy = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public CaseEvidence build() {
            return new CaseEvidence(id, caseId, type, label, url, metadata, addedAt, addedBy);
        }
    }
}
