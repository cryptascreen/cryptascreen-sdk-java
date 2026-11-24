package com.cryptascreen.sdk.model;

/** Known values of ScreeningJobStatus. */
public final class ScreeningJobStatus {

    private ScreeningJobStatus() {}

    /** The value {@code PENDING}. */
    public static final String PENDING = "PENDING";

    /** The value {@code PROCESSING}. */
    public static final String PROCESSING = "PROCESSING";

    /** The value {@code COMPLETED}. */
    public static final String COMPLETED = "COMPLETED";

    /** The value {@code PARTIAL}. */
    public static final String PARTIAL = "PARTIAL";

    /** The value {@code FAILED}. */
    public static final String FAILED = "FAILED";

    /** The value {@code CANCELLED}. */
    public static final String CANCELLED = "CANCELLED";
}
