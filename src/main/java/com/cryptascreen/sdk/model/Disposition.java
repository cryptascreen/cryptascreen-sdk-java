// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/** Known values of Disposition. */
public final class Disposition {

    private Disposition() {}

    /** The value {@code BLOCKING_MATCH}. */
    public static final String BLOCKING_MATCH = "BLOCKING_MATCH";

    /** The value {@code RESTRICTION_MATCH}. */
    public static final String RESTRICTION_MATCH = "RESTRICTION_MATCH";

    /** The value {@code CANDIDATE_REVIEW}. */
    public static final String CANDIDATE_REVIEW = "CANDIDATE_REVIEW";

    /** The value {@code RISK_INDICATORS}. */
    public static final String RISK_INDICATORS = "RISK_INDICATORS";

    /** The value {@code CONTEXT_ONLY}. */
    public static final String CONTEXT_ONLY = "CONTEXT_ONLY";

    /** The value {@code NO_MATCH_IN_CHECKED_LAYERS}. */
    public static final String NO_MATCH_IN_CHECKED_LAYERS = "NO_MATCH_IN_CHECKED_LAYERS";
}
