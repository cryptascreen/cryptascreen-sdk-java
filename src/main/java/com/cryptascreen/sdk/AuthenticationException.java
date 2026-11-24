package com.cryptascreen.sdk;

/**
 * Thrown on 401: invalid or missing API key.
 */
public class AuthenticationException extends CryptaScreenException {

    /**
     * Creates the exception.
     *
     * @param message the message
     * @param requestId the requestId
     */
    public AuthenticationException(String message, String requestId) {
        super(message == null ? "Invalid or missing API key" : message, 401, "AUTHENTICATION_ERROR", requestId);
    }
}
