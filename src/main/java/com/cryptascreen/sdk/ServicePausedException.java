// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

/**
 * Thrown on 402 {@code SERVICE_PAUSED}: a payment is overdue. Not retried.
 */
public class ServicePausedException extends CryptaScreenException {
    private final String subscriptionStatus;
    private final String billingUrl;
    private final String reason;

    /**
     * Creates the exception.
     *
     * @param message the message
     * @param requestId the requestId
     * @param subscriptionStatus the subscriptionStatus
     * @param billingUrl the billingUrl
     * @param reason the reason
     */
    public ServicePausedException(String message, String requestId, String subscriptionStatus, String billingUrl, String reason) {
        super(message, 402, "SERVICE_PAUSED", requestId);
        this.subscriptionStatus = subscriptionStatus;
        this.billingUrl = billingUrl;
        this.reason = reason;
    }

    /** Returns subscriptionStatus. */
    public String subscriptionStatus() {
        return subscriptionStatus;
    }

    /** Returns billingUrl. */
    public String billingUrl() {
        return billingUrl;
    }

    /** Returns reason. */
    public String reason() {
        return reason;
    }
}
