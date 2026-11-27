// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class providing a pre-configured Jackson {@link ObjectMapper}.
 *
 * <p>The mapper is configured with:</p>
 * <ul>
 *   <li>camelCase property names (the CryptaScreen API convention; no naming strategy)</li>
 *   <li>Java 8 date/time support via {@link JavaTimeModule}</li>
 *   <li>Ignoring unknown properties for forward compatibility</li>
 *   <li>Non-null inclusion for serialization</li>
 * </ul>
 */
public final class JsonUtils {

    private static final ObjectMapper MAPPER = createMapper();

    private JsonUtils() {}

    /**
     * Returns the shared, pre-configured ObjectMapper instance.
     *
     * @return the ObjectMapper
     */
    public static ObjectMapper mapper() {
        return MAPPER;
    }

    /**
     * Converts a request object to a mutable map (nulls dropped).
     *
     * @param value the request record or map
     * @return a mutable map
     */
    public static Map<String, Object> toMap(Object value) {
        if (value == null) {
            return new LinkedHashMap<>();
        }
        return MAPPER.convertValue(value, new TypeReference<LinkedHashMap<String, Object>>() {});
    }

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }
}
