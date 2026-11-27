// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk.util;

import com.cryptascreen.sdk.model.GraphResponse;
import com.cryptascreen.sdk.model.NameScreenResponse;
import com.cryptascreen.sdk.model.ScreeningResponse;
import com.cryptascreen.sdk.model.WalletCategoryPart;

import java.util.Locale;

/** Narrowing and display helpers (ports of the helpers exported by {@code @cryptascreen/sdk}). */
public final class Helpers {

    private Helpers() {}

    /**
     * True when the address was assessed (risk level is not UNKNOWN and a score exists).
     *
     * @param r the screening result
     * @return whether it was assessed
     */
    public static boolean isAssessed(ScreeningResponse r) {
        return !"UNKNOWN".equals(r.riskLevel()) && r.riskScore() != null;
    }

    /**
     * True only when the mandatory sanctions layer was COMPLETE; anything else is not an all-clear.
     *
     * @param r the screening result
     * @return whether the sanctions layer is complete
     */
    public static boolean sanctionsLayerComplete(ScreeningResponse r) {
        return r.layers() != null && r.layers().sanctions() != null && "COMPLETE".equals(r.layers().sanctions().state());
    }

    /**
     * True only for a completed screening whose outcome is CLEAR. Anything else needs a person to look.
     *
     * @param r the name screening result
     * @return whether the outcome is CLEAR
     */
    public static boolean isNameClear(NameScreenResponse r) {
        return "CLEAR".equals(r.outcome());
    }

    /**
     * True only when the backend states the graph read was COMPLETE (null status: legacy {@code truncated} flag).
     *
     * @param r the graph response
     * @return whether the graph is complete
     */
    public static boolean isGraphComplete(GraphResponse r) {
        if (r.stats() == null) {
            return false;
        }
        if (r.stats().status() != null) {
            return "COMPLETE".equals(r.stats().status());
        }
        return Boolean.FALSE.equals(r.stats().truncated());
    }

    /**
     * Display helper: {@code n/a} for a part without numbers, a lower bound with a leading {@code ≥}, else {@code x%}. Never
     * renders null as 0%.
     *
     * @param part   the category part
     * @param digits decimal digits
     * @return the label
     */
    public static String categoryShareLabel(WalletCategoryPart part, int digits) {
        if ("NOT_ANALYZED".equals(part.state()) || part.usdShare() == null) {
            return "n/a";
        }
        double share = part.usdShare() instanceof Number n ? n.doubleValue() : Double.parseDouble(part.usdShare().toString());
        String pct = String.format(Locale.ROOT, "%." + digits + "f%%", share * 100);
        return "COMPLETE".equals(part.state()) ? pct : "\u2265 " + pct;
    }

    /**
     * {@link #categoryShareLabel(WalletCategoryPart, int)} with one decimal digit.
     *
     * @param part the category part
     * @return the label
     */
    public static String categoryShareLabel(WalletCategoryPart part) {
        return categoryShareLabel(part, 1);
    }
}
