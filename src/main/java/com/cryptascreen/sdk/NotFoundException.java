package com.cryptascreen.sdk;

/**
 * Thrown on 404.
 */
public class NotFoundException extends CryptaScreenException {

    /**
     * Creates the exception.
     *
     * @param resource the resource
     * @param id the id
     * @param requestId the requestId
     */
    public NotFoundException(String resource, String id, String requestId) {
        super(resource + " not found: " + id, 404, "NOT_FOUND", requestId);
    }
}
