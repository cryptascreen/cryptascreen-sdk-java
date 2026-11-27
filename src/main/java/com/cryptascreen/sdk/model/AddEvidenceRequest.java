// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * AddEvidenceRequest (see types/cases.ts in @cryptascreen/sdk).
 *
 * @param type type
 * @param label label
 * @param url url
 * @param metadata metadata
 */
public record AddEvidenceRequest(
        String type,
        String label,
        String url,
        Map<String, Object> metadata
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AddEvidenceRequest}. */
    public static final class Builder {
        private String type;
        private String label;
        private String url;
        private Map<String, Object> metadata;

        private Builder() {}

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
         * Builds the record.
         *
         * @return the record
         */
        public AddEvidenceRequest build() {
            return new AddEvidenceRequest(type, label, url, metadata);
        }
    }
}
