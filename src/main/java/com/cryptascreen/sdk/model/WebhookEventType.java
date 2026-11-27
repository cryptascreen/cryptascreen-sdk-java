// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.model;

/** Known values of WebhookEventType. */
public final class WebhookEventType {

    private WebhookEventType() {}

    /** The value {@code HIGH_RISK}. */
    public static final String HIGH_RISK = "HIGH_RISK";

    /** The value {@code CRITICAL}. */
    public static final String CRITICAL = "CRITICAL";

    /** The value {@code SANCTIONS_MATCH}. */
    public static final String SANCTIONS_MATCH = "SANCTIONS_MATCH";

    /** The value {@code HEURISTICS_COMPLETE}. */
    public static final String HEURISTICS_COMPLETE = "HEURISTICS_COMPLETE";

    /** The value {@code TEST}. */
    public static final String TEST = "TEST";
}
