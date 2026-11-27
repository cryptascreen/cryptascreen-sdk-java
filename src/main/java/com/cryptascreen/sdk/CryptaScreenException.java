// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import java.time.Duration;

/**
 * Base exception for all CryptaScreen SDK errors (same classes and codes as {@code @cryptascreen/sdk}).
 *
 * <p>Contains the HTTP status code (0 when no response was received), the machine code, and the request ID.</p>
 */
public class CryptaScreenException extends RuntimeException {

    private final int statusCode;
    private final String errorCode;
    private final String requestId;
    private final Duration retryAfter;

    /**
     * Creates a new CryptaScreenException.
     *
     * @param message    the error message
     * @param statusCode the HTTP status code
     * @param errorCode  the machine code, e.g. {@code AUTHENTICATION_ERROR} (may be null)
     * @param requestId  the request ID for debugging (may be null)
     */
    public CryptaScreenException(String message, int statusCode, String errorCode, String requestId) {
        this(message, statusCode, errorCode, requestId, null);
    }

    /**
     * Creates a new CryptaScreenException that carries the response's {@code Retry-After}.
     *
     * @param message    the error message
     * @param statusCode the HTTP status code
     * @param errorCode  the machine code (may be null)
     * @param requestId  the request ID (may be null)
     * @param retryAfter the parsed {@code Retry-After} header, or null
     */
    public CryptaScreenException(String message, int statusCode, String errorCode, String requestId,
                                 Duration retryAfter) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.requestId = requestId;
        this.retryAfter = retryAfter;
    }

    /**
     * Creates a new CryptaScreenException wrapping a cause (no HTTP response: timeout, connection error).
     *
     * @param message the error message
     * @param cause   the underlying cause
     */
    public CryptaScreenException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = 0;
        this.errorCode = "UNKNOWN_ERROR";
        this.requestId = null;
        this.retryAfter = null;
    }

    /** Returns the HTTP status code, or 0 if no response was received. */
    public int statusCode() {
        return statusCode;
    }

    /** Returns the machine code (e.g. VALIDATION_ERROR), or null if not available. */
    public String errorCode() {
        return errorCode;
    }

    /** Returns the request ID for debugging, or null if not available. */
    public String requestId() {
        return requestId;
    }

    /** Returns the response's {@code Retry-After} (integer seconds), or null. Drives the retry delay. */
    public Duration retryAfter() {
        return retryAfter;
    }
}
