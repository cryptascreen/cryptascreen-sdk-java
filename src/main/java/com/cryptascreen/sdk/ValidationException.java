// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Thrown on 400: request validation failed (also thrown client-side for a DAC8 request of the 0.1.x shape).
 *
 * <p>{@link #fieldErrors()} maps field to messages; bulk items appear as {@code field[index]}.
 * {@link #validationCode()} is e.g. UNKNOWN_CHAIN, INVALID_ADDRESS_FORMAT, INVALID_CHECKSUM, INVALID_BULK_ITEMS.</p>
 */
public class ValidationException extends CryptaScreenException {

    private final Map<String, List<String>> fieldErrors;
    private final String validationCode;
    private final JsonNode items;

    /**
     * Creates the exception.
     *
     * @param message        the message
     * @param fieldErrors    field to messages (copied; null = none)
     * @param requestId      the request id
     * @param validationCode the machine validation code (may be null)
     * @param items          bulk: every invalid item as sent by the API (may be null)
     */
    public ValidationException(String message, Map<String, List<String>> fieldErrors, String requestId,
                               String validationCode, JsonNode items) {
        super(message, 400, "VALIDATION_ERROR", requestId);
        Map<String, List<String>> copy = new LinkedHashMap<>();
        if (fieldErrors != null) {
            fieldErrors.forEach((k, v) -> copy.put(k, new ArrayList<>(v)));
        }
        this.fieldErrors = copy;
        this.validationCode = validationCode;
        this.items = items;
    }

    /** Returns the field errors. */
    public Map<String, List<String>> fieldErrors() {
        return fieldErrors;
    }

    /** Returns the machine validation code, or null. */
    public String validationCode() {
        return validationCode;
    }

    /** Returns the invalid bulk items as JSON (array of {index, field, code, message}), or null. */
    public JsonNode items() {
        return items;
    }
}
