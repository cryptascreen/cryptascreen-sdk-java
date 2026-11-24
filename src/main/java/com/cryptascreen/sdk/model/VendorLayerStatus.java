package com.cryptascreen.sdk.model;

/** Known values of VendorLayerStatus. */
public final class VendorLayerStatus {

    private VendorLayerStatus() {}

    /** The value {@code OK}. */
    public static final String OK = "OK";

    /** The value {@code TIMEOUT}. */
    public static final String TIMEOUT = "TIMEOUT";

    /** The value {@code SKIPPED_CAP}. */
    public static final String SKIPPED_CAP = "SKIPPED_CAP";

    /** The value {@code SKIPPED_BREAKER}. */
    public static final String SKIPPED_BREAKER = "SKIPPED_BREAKER";

    /** The value {@code AUTH_FAILED}. */
    public static final String AUTH_FAILED = "AUTH_FAILED";

    /** The value {@code RATE_LIMITED}. */
    public static final String RATE_LIMITED = "RATE_LIMITED";

    /** The value {@code UNAVAILABLE}. */
    public static final String UNAVAILABLE = "UNAVAILABLE";

    /** The value {@code NOT_FOUND}. */
    public static final String NOT_FOUND = "NOT_FOUND";

    /** The value {@code UNSUPPORTED_CHAIN}. */
    public static final String UNSUPPORTED_CHAIN = "UNSUPPORTED_CHAIN";

    /** The value {@code UNEXPECTED_RESPONSE}. */
    public static final String UNEXPECTED_RESPONSE = "UNEXPECTED_RESPONSE";
}
