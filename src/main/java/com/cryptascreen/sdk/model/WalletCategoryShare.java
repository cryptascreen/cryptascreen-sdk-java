package com.cryptascreen.sdk.model;

/**
 * WalletCategoryShare (see types/wallet.ts in @cryptascreen/sdk).
 *
 * @param category category
 * @param direct direct
 * @param indirect indirect
 */
public record WalletCategoryShare(
        String category,
        WalletCategoryPart direct,
        WalletCategoryPart indirect
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link WalletCategoryShare}. */
    public static final class Builder {
        private String category;
        private WalletCategoryPart direct;
        private WalletCategoryPart indirect;

        private Builder() {}

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
         * Sets direct.
         *
         * @param v the value
         * @return this builder
         */
        public Builder direct(WalletCategoryPart v) {
            this.direct = v;
            return this;
        }

        /**
         * Sets indirect.
         *
         * @param v the value
         * @return this builder
         */
        public Builder indirect(WalletCategoryPart v) {
            this.indirect = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public WalletCategoryShare build() {
            return new WalletCategoryShare(category, direct, indirect);
        }
    }
}
