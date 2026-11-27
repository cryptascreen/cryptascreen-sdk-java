// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

/** Thrown on 403 {@code SEAT_LIMIT_REACHED}: all user seats of the plan are taken. */
public class SeatLimitReachedException extends PlanLimitException {

    /**
     * Creates the exception.
     *
     * @param message   the message
     * @param requestId the request id
     * @param used      seats used
     * @param limit     seats allowed
     * @param plan      the plan
     */
    public SeatLimitReachedException(String message, String requestId, Long used, Long limit, String plan) {
        super(message, "SEAT_LIMIT_REACHED", requestId, used, limit, plan);
    }
}
