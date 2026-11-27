// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.resource;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Encodes one URL path segment (the equivalent of {@code encodeURIComponent}), so a hostile id or address can never
 * add a segment, a query or a fragment to the request path.
 */
public final class PathSegments {

    private PathSegments() {}

    /**
     * Percent-encodes a path segment.
     *
     * @param segment the raw value
     * @return the encoded segment
     * @throws IllegalArgumentException if the segment is null
     */
    public static String encode(String segment) {
        if (segment == null) {
            throw new IllegalArgumentException("path segment must not be null");
        }
        return URLEncoder.encode(segment, StandardCharsets.UTF_8).replace("+", "%20").replace("*", "%2A")
                .replace("%7E", "~").replace("%21", "!").replace("%27", "'").replace("%28", "(").replace("%29", ")");
    }
}
