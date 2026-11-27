// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

/**
 * Thrown on 403 with a plan-limit code: an addition beyond the plan's entitlement was refused. Not retried.
 */
public class PlanLimitException extends CryptaScreenException {
    private final String limitCode;
    private final Long used;
    private final Long limit;
    private final String plan;

    /**
     * Creates the exception.
     *
     * @param message the message
     * @param limitCode the limitCode
     * @param requestId the requestId
     * @param used the used
     * @param limit the limit
     * @param plan the plan
     */
    public PlanLimitException(String message, String limitCode, String requestId, Long used, Long limit, String plan) {
        super(message, 403, limitCode, requestId);
        this.limitCode = limitCode;
        this.used = used;
        this.limit = limit;
        this.plan = plan;
    }

    /** Returns limitCode. */
    public String limitCode() {
        return limitCode;
    }

    /** Returns used. */
    public Long used() {
        return used;
    }

    /** Returns limit. */
    public Long limit() {
        return limit;
    }

    /** Returns plan. */
    public String plan() {
        return plan;
    }
}
