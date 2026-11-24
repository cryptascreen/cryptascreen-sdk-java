package com.cryptascreen.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * A list wrapped as {items: [...]}; entries are open objects.
 *
 * @param items items
 */
public record ItemsResponse(
        List<Map<String, Object>> items
) {

    /**
     * Creates a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /** Builder for {@link ItemsResponse}. */
    public static final class Builder {
        private List<Map<String, Object>> items;

        private Builder() {}

        /**
         * Sets items.
         *
         * @param v the value
         * @return this builder
         */
        public Builder items(List<Map<String, Object>> v) {
            this.items = v;
            return this;
        }

        /**
         * Builds the record.
         *
         * @return the record
         */
        public ItemsResponse build() {
            return new ItemsResponse(items);
        }
    }
}
