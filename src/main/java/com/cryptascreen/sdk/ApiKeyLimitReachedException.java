package com.cryptascreen.sdk;

/** Thrown on 403 {@code API_KEY_LIMIT_REACHED}: the plan's API-key count is reached. */
public class ApiKeyLimitReachedException extends PlanLimitException {

    /**
     * Creates the exception.
     *
     * @param message   the message
     * @param requestId the request id
     * @param used      keys used
     * @param limit     keys allowed
     * @param plan      the plan
     */
    public ApiKeyLimitReachedException(String message, String requestId, Long used, Long limit, String plan) {
        super(message, "API_KEY_LIMIT_REACHED", requestId, used, limit, plan);
    }
}
