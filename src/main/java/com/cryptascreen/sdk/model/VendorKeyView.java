// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * A customer-supplied vendor key as shown to the caller (last4 and fingerprint only, never the key).
 *
 * @param vendor vendor
 * @param displayName displayName
 * @param configured configured
 * @param enabled enabled
 * @param needsSecret needsSecret
 * @param last4 last4
 * @param fingerprint fingerprint
 * @param dailyCap dailyCap
 * @param usedToday usedToday
 * @param lastTestAt lastTestAt
 * @param lastTestStatus lastTestStatus
 * @param updatedAt updatedAt
 */
public record VendorKeyView(
        String vendor,
        String displayName,
        Boolean configured,
        Boolean enabled,
        Boolean needsSecret,
        String last4,
        String fingerprint,
        Integer dailyCap,
        Integer usedToday,
        String lastTestAt,
        String lastTestStatus,
        String updatedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link VendorKeyView}. */
    public static final class Builder {
        private String vendor;
        private String displayName;
        private Boolean configured;
        private Boolean enabled;
        private Boolean needsSecret;
        private String last4;
        private String fingerprint;
        private Integer dailyCap;
        private Integer usedToday;
        private String lastTestAt;
        private String lastTestStatus;
        private String updatedAt;

        private Builder() {}

        /**
         * Sets vendor.
         *
         * @param v the value
         * @return this builder
         */
        public Builder vendor(String v) {
            this.vendor = v;
            return this;
        }

        /**
         * Sets displayName.
         *
         * @param v the value
         * @return this builder
         */
        public Builder displayName(String v) {
            this.displayName = v;
            return this;
        }

        /**
         * Sets configured.
         *
         * @param v the value
         * @return this builder
         */
        public Builder configured(Boolean v) {
            this.configured = v;
            return this;
        }

        /**
         * Sets enabled.
         *
         * @param v the value
         * @return this builder
         */
        public Builder enabled(Boolean v) {
            this.enabled = v;
            return this;
        }

        /**
         * Sets needsSecret.
         *
         * @param v the value
         * @return this builder
         */
        public Builder needsSecret(Boolean v) {
            this.needsSecret = v;
            return this;
        }

        /**
         * Sets last4.
         *
         * @param v the value
         * @return this builder
         */
        public Builder last4(String v) {
            this.last4 = v;
            return this;
        }

        /**
         * Sets fingerprint.
         *
         * @param v the value
         * @return this builder
         */
        public Builder fingerprint(String v) {
            this.fingerprint = v;
            return this;
        }

        /**
         * Sets dailyCap.
         *
         * @param v the value
         * @return this builder
         */
        public Builder dailyCap(Integer v) {
            this.dailyCap = v;
            return this;
        }

        /**
         * Sets usedToday.
         *
         * @param v the value
         * @return this builder
         */
        public Builder usedToday(Integer v) {
            this.usedToday = v;
            return this;
        }

        /**
         * Sets lastTestAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastTestAt(String v) {
            this.lastTestAt = v;
            return this;
        }

        /**
         * Sets lastTestStatus.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastTestStatus(String v) {
            this.lastTestStatus = v;
            return this;
        }

        /**
         * Sets updatedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder updatedAt(String v) {
            this.updatedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public VendorKeyView build() {
            return new VendorKeyView(vendor, displayName, configured, enabled, needsSecret, last4, fingerprint, dailyCap, usedToday, lastTestAt, lastTestStatus, updatedAt);
        }
    }
}
