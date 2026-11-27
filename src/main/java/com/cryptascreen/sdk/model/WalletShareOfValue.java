// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/**
 * WalletShareOfValue (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param method method
 * @param maxHops maxHops
 * @param windowFrom windowFrom
 * @param windowTo windowTo
 * @param received received
 * @param sent sent
 */
public record WalletShareOfValue(
        String method,
        Long maxHops,
        String windowFrom,
        String windowTo,
        WalletDirectionShare received,
        WalletDirectionShare sent
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletShareOfValue}. */
    public static final class Builder {
        private String method;
        private Long maxHops;
        private String windowFrom;
        private String windowTo;
        private WalletDirectionShare received;
        private WalletDirectionShare sent;

        private Builder() {}

        /**
         * Sets method.
         *
         * @param v the value
         * @return this builder
         */
        public Builder method(String v) {
            this.method = v;
            return this;
        }

        /**
         * Sets maxHops.
         *
         * @param v the value
         * @return this builder
         */
        public Builder maxHops(Long v) {
            this.maxHops = v;
            return this;
        }

        /**
         * Sets windowFrom.
         *
         * @param v the value
         * @return this builder
         */
        public Builder windowFrom(String v) {
            this.windowFrom = v;
            return this;
        }

        /**
         * Sets windowTo.
         *
         * @param v the value
         * @return this builder
         */
        public Builder windowTo(String v) {
            this.windowTo = v;
            return this;
        }

        /**
         * Sets received.
         *
         * @param v the value
         * @return this builder
         */
        public Builder received(WalletDirectionShare v) {
            this.received = v;
            return this;
        }

        /**
         * Sets sent.
         *
         * @param v the value
         * @return this builder
         */
        public Builder sent(WalletDirectionShare v) {
            this.sent = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletShareOfValue build() {
            return new WalletShareOfValue(method, maxHops, windowFrom, windowTo, received, sent);
        }
    }
}
