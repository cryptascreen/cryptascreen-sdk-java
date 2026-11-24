package com.cryptascreen.sdk;

/**
 * Thrown on 429 {@code quota_exceeded}: the plan's monthly screenings are used up. Not a rate limit; never retried.
 */
public class QuotaExceededException extends CryptaScreenException {
    private final String resetsAt;
    private final String upgradeUrl;

    /**
     * Creates the exception.
     *
     * @param message the message
     * @param requestId the requestId
     * @param resetsAt the resetsAt
     * @param upgradeUrl the upgradeUrl
     */
    public QuotaExceededException(String message, String requestId, String resetsAt, String upgradeUrl) {
        super(message, 429, "QUOTA_EXCEEDED", requestId);
        this.resetsAt = resetsAt;
        this.upgradeUrl = upgradeUrl;
    }

    /** Returns resetsAt. */
    public String resetsAt() {
        return resetsAt;
    }

    /** Returns upgradeUrl. */
    public String upgradeUrl() {
        return upgradeUrl;
    }
}
