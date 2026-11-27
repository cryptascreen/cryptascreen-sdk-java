// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * ScreeningLayer (see types/screening.ts in @cryptascreen/sdk).
 *
 * @param state state
 * @param reason reason
 * @param checked checked
 * @param findings findings
 * @param sources sources
 * @param provider provider
 * @param missingCapabilities missingCapabilities
 * @param truncated truncated
 * @param truncationReasons truncationReasons
 */
public record ScreeningLayer(
        String state,
        String reason,
        Boolean checked,
        Double findings,
        List<SourceFreshness> sources,
        String provider,
        List<String> missingCapabilities,
        Boolean truncated,
        List<String> truncationReasons
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ScreeningLayer}. */
    public static final class Builder {
        private String state;
        private String reason;
        private Boolean checked;
        private Double findings;
        private List<SourceFreshness> sources;
        private String provider;
        private List<String> missingCapabilities;
        private Boolean truncated;
        private List<String> truncationReasons;

        private Builder() {}

        /**
         * Sets state.
         *
         * @param v the value
         * @return this builder
         */
        public Builder state(String v) {
            this.state = v;
            return this;
        }

        /**
         * Sets reason.
         *
         * @param v the value
         * @return this builder
         */
        public Builder reason(String v) {
            this.reason = v;
            return this;
        }

        /**
         * Sets checked.
         *
         * @param v the value
         * @return this builder
         */
        public Builder checked(Boolean v) {
            this.checked = v;
            return this;
        }

        /**
         * Sets findings.
         *
         * @param v the value
         * @return this builder
         */
        public Builder findings(Double v) {
            this.findings = v;
            return this;
        }

        /**
         * Sets sources.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sources(List<SourceFreshness> v) {
            this.sources = v;
            return this;
        }

        /**
         * Sets provider.
         *
         * @param v the value
         * @return this builder
         */
        public Builder provider(String v) {
            this.provider = v;
            return this;
        }

        /**
         * Sets missingCapabilities.
         *
         * @param v the value
         * @return this builder
         */
        public Builder missingCapabilities(List<String> v) {
            this.missingCapabilities = v;
            return this;
        }

        /**
         * Sets truncated.
         *
         * @param v the value
         * @return this builder
         */
        public Builder truncated(Boolean v) {
            this.truncated = v;
            return this;
        }

        /**
         * Sets truncationReasons.
         *
         * @param v the value
         * @return this builder
         */
        public Builder truncationReasons(List<String> v) {
            this.truncationReasons = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ScreeningLayer build() {
            return new ScreeningLayer(state, reason, checked, findings, sources, provider, missingCapabilities, truncated, truncationReasons);
        }
    }
}
