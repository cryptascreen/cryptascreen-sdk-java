package com.cryptascreen.sdk.webhook;

import com.cryptascreen.sdk.CryptaScreenException;
import com.cryptascreen.sdk.util.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Webhook signature verification.
 *
 * <p>CryptaScreen signs every webhook delivery twice:
 * {@code X-CryptaScreen-Signature-V2: t=<unix>,v1=hex(HMAC_SHA256(secret, "<unix>." + body))} (replay-resistant) and
 * {@code X-CryptaScreen-Signature: sha256=hex(HMAC_SHA256(secret, body))} (legacy, no timestamp).
 * {@link #verify} checks V2 (constant-time compare, timestamp within the tolerance, default 300 s). The legacy header
 * is accepted only with {@code allowLegacy}. The same algorithm and test vectors
 * ({@code src/test/resources/webhook_vectors.json}) are used by the other CryptaScreen SDKs.</p>
 */
public final class WebhookSignature {

    /** Legacy signature header. */
    public static final String SIGNATURE_HEADER = "X-CryptaScreen-Signature";
    /** Replay-resistant signature header. */
    public static final String SIGNATURE_V2_HEADER = "X-CryptaScreen-Signature-V2";
    /** Default tolerance in seconds. */
    public static final long DEFAULT_TOLERANCE_SECONDS = 300;

    private WebhookSignature() {}

    /** Why a delivery could not be authenticated. */
    public static class SignatureException extends CryptaScreenException {
        private final String code;

        /**
         * Creates the exception.
         *
         * @param message the message
         * @param code    WEBHOOK_SIGNATURE_MISSING | _MALFORMED | _MISMATCH | WEBHOOK_TIMESTAMP_OUT_OF_TOLERANCE
         */
        public SignatureException(String message, String code) {
            super(message, 0, code, null);
            this.code = code;
        }

        /** Returns the machine code. */
        public String code() {
            return code;
        }
    }

    /**
     * Hex HMAC-SHA256 of the body (legacy) or of {@code "<timestamp>." + body}.
     *
     * @param secret    the webhook secret
     * @param body      the raw body
     * @param timestamp the unix timestamp, or null for the legacy signature
     * @return lowercase hex
     */
    public static String compute(String secret, byte[] body, Long timestamp) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            if (timestamp != null) {
                mac.update((timestamp + ".").getBytes(StandardCharsets.UTF_8));
            }
            return HexFormat.of().formatHex(mac.doFinal(body));
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("HMAC-SHA256 unavailable", e);
        }
    }

    /**
     * Same as {@link #compute(String, byte[], Long)} for a UTF-8 string body.
     *
     * @param secret    the webhook secret
     * @param body      the raw body
     * @param timestamp the unix timestamp, or null for the legacy signature
     * @return lowercase hex
     */
    public static String compute(String secret, String body, Long timestamp) {
        return compute(secret, body.getBytes(StandardCharsets.UTF_8), timestamp);
    }

    /**
     * Verifies a delivery with the default tolerance, V2 only.
     *
     * @param secret  the webhook secret ({@code WebhookConfig.secret})
     * @param body    the RAW request body exactly as received
     * @param headers the request headers (case-insensitive lookup; first value wins)
     * @return true when authentic
     * @throws SignatureException when it is not
     */
    public static boolean verify(String secret, byte[] body, Map<String, String> headers) {
        return verify(secret, body, headers, DEFAULT_TOLERANCE_SECONDS, false, System.currentTimeMillis() / 1000.0);
    }

    /**
     * Verifies a delivery.
     *
     * @param secret       the webhook secret
     * @param body         the RAW request body exactly as received
     * @param headers      the request headers (case-insensitive lookup)
     * @param tolerance    maximum seconds between the signed timestamp and {@code now} (both directions)
     * @param allowLegacy  accept the legacy header when no V2 header is present
     * @param now          the current unix time in seconds
     * @return true when authentic
     * @throws SignatureException when it is not
     */
    public static boolean verify(String secret, byte[] body, Map<String, String> headers, long tolerance,
                                 boolean allowLegacy, double now) {
        Map<String, String> h = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        h.putAll(headers);
        String v2 = h.get(SIGNATURE_V2_HEADER);
        if (v2 != null && !v2.isEmpty()) {
            String tRaw = null;
            List<String> sigs = new ArrayList<>();
            for (String part : v2.split(",")) {
                String p = part.trim();
                if (p.startsWith("t=")) {
                    if (tRaw == null) {
                        tRaw = p.substring(2);
                    }
                } else if (p.startsWith("v1=")) {
                    sigs.add(p.substring(3));
                }
            }
            if (tRaw == null || !tRaw.matches("[0-9]+") || tRaw.length() > 15 || sigs.isEmpty()) {
                throw new SignatureException("Malformed X-CryptaScreen-Signature-V2 header", "WEBHOOK_SIGNATURE_MALFORMED");
            }
            long t = Long.parseLong(tRaw);
            byte[] expected = compute(secret, body, t).getBytes(StandardCharsets.UTF_8);
            boolean match = false;
            for (String s : sigs) {
                match |= MessageDigest.isEqual(expected, s.toLowerCase().getBytes(StandardCharsets.UTF_8));
            }
            if (!match) {
                throw new SignatureException("Webhook signature does not match", "WEBHOOK_SIGNATURE_MISMATCH");
            }
            if (Math.abs(now - t) > tolerance) {
                throw new SignatureException("Webhook timestamp outside the tolerance of " + tolerance + "s",
                        "WEBHOOK_TIMESTAMP_OUT_OF_TOLERANCE");
            }
            return true;
        }
        String legacy = h.get(SIGNATURE_HEADER);
        if (legacy != null && !legacy.isEmpty() && allowLegacy) {
            if (!legacy.startsWith("sha256=")) {
                throw new SignatureException("Malformed X-CryptaScreen-Signature header", "WEBHOOK_SIGNATURE_MALFORMED");
            }
            byte[] expected = compute(secret, body, null).getBytes(StandardCharsets.UTF_8);
            if (!MessageDigest.isEqual(expected, legacy.substring(7).toLowerCase().getBytes(StandardCharsets.UTF_8))) {
                throw new SignatureException("Webhook signature does not match", "WEBHOOK_SIGNATURE_MISMATCH");
            }
            return true;
        }
        throw new SignatureException("No usable signature header (X-CryptaScreen-Signature-V2)", "WEBHOOK_SIGNATURE_MISSING");
    }

    /**
     * Verifies (default tolerance, V2 only) and parses the event {@code {id, type, createdAt, source, data}}.
     *
     * @param secret  the webhook secret
     * @param body    the RAW request body
     * @param headers the request headers
     * @return the parsed event
     * @throws SignatureException when the delivery is not authentic
     */
    public static JsonNode constructEvent(String secret, byte[] body, Map<String, String> headers) {
        verify(secret, body, headers);
        try {
            return JsonUtils.mapper().readTree(body);
        } catch (IOException e) {
            throw new CryptaScreenException("Webhook body is not JSON: " + e.getMessage(), e);
        }
    }
}
