// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

import java.util.Map;

/**
 * AlertReason (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param code code
 * @param params params
 */
public record AlertReason(
        String code,
        Map<String, Object> params
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link AlertReason}. */
    public static final class Builder {
        private String code;
        private Map<String, Object> params;

        private Builder() {}

        /**
         * Sets code.
         *
         * @param v the value
         * @return this builder
         */
        public Builder code(String v) {
            this.code = v;
            return this;
        }

        /**
         * Sets params.
         *
         * @param v the value
         * @return this builder
         */
        public Builder params(Map<String, Object> v) {
            this.params = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public AlertReason build() {
            return new AlertReason(code, params);
        }
    }
}
