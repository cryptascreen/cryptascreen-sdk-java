// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * A wallet on the monitored list.
 *
 * @param id id
 * @param address address
 * @param chain chain
 * @param label label
 * @param addedAt addedAt
 * @param lastCheckedAt lastCheckedAt
 */
public record MonitoredWallet(
        Long id,
        String address,
        String chain,
        String label,
        String addedAt,
        String lastCheckedAt
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link MonitoredWallet}. */
    public static final class Builder {
        private Long id;
        private String address;
        private String chain;
        private String label;
        private String addedAt;
        private String lastCheckedAt;

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
         * Sets lastCheckedAt.
         *
         * @param v the value
         * @return this builder
         */
        public Builder lastCheckedAt(String v) {
            this.lastCheckedAt = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public MonitoredWallet build() {
            return new MonitoredWallet(id, address, chain, label, addedAt, lastCheckedAt);
        }
    }
}
