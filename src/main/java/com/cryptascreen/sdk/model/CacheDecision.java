package com.cryptascreen.sdk.model;

/** Known values of CacheDecision. */
public final class CacheDecision {

    private CacheDecision() {}

    /** The value {@code HIT}. */
    public static final String HIT = "HIT";

    /** The value {@code MISS}. */
    public static final String MISS = "MISS";

    /** The value {@code FORCE_REFRESH}. */
    public static final String FORCE_REFRESH = "FORCE_REFRESH";

    /** The value {@code FINDINGS_PRESENT}. */
    public static final String FINDINGS_PRESENT = "FINDINGS_PRESENT";

    /** The value {@code STALE_VERSION}. */
    public static final String STALE_VERSION = "STALE_VERSION";

    /** The value {@code SCOPE_MISMATCH}. */
    public static final String SCOPE_MISMATCH = "SCOPE_MISMATCH";

    /** The value {@code SAFETY_TTL_EXPIRED}. */
    public static final String SAFETY_TTL_EXPIRED = "SAFETY_TTL_EXPIRED";

    /** The value {@code NOT_REUSABLE}. */
    public static final String NOT_REUSABLE = "NOT_REUSABLE";

    /** The value {@code VERSION_UNKNOWN}. */
    public static final String VERSION_UNKNOWN = "VERSION_UNKNOWN";
}
