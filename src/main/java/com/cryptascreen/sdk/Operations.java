package com.cryptascreen.sdk;

import java.util.List;

/**
 * Operation table: SDK method to HTTP method + path (relative to {@code /api/v1}). Checked against
 * the customer API operations by the test-suite (generated).
 */
public final class Operations {

    private Operations() {}

    /**
     * One SDK method and the API operation it calls.
     *
     * @param resource   the resource accessor, e.g. {@code screening}
     * @param method     the Java method name (equals the TypeScript method name)
     * @param httpMethod the HTTP method, or null when the method makes no request of its own
     * @param path       the path relative to /api/v1, or null
     */
    public record Operation(String resource, String method, String httpMethod, String path) {}

    /** All operations (one per TypeScript SDK method). */
    public static final List<Operation> ALL = List.of(
        new Operation("screening", "screenAddress", "POST", "/screen/address"),
        new Operation("screening", "screenBulk", "POST", "/screen/bulk"),
        new Operation("screening", "screenBulkAsync", "POST", "/screen/bulk"),
        new Operation("screening", "pollJob", "GET", "/screen/jobs/{jobId}"),
        new Operation("screening", "listJobs", "GET", "/screen/jobs"),
        new Operation("screening", "getJobResults", "GET", "/screen/jobs/{jobId}/results"),
        new Operation("screening", "cancelJob", "POST", "/screen/jobs/{jobId}/cancel"),
        new Operation("screening", "getHistory", "GET", "/screen/address/{chain}/{address}/history"),
        new Operation("screening", "listEvaluations", "GET", "/screen/address/{chain}/{address}/evaluations"),
        new Operation("screening", "getCounterparties", "GET", "/screen/address/{chain}/{address}/counterparties"),
        new Operation("screening", "getTransactions", "GET", "/screen/address/{chain}/{address}/transactions"),
        new Operation("screening", "getExposurePaths", "GET", "/screen/address/{chain}/{address}/exposure-paths"),
        new Operation("screening", "getEvaluation", "GET", "/screen/evaluations/{evaluationId}"),
        new Operation("screening", "screenBulkAndWait", null, null),
        new Operation("sanctions", "check", "GET", "/sanctions/check/{chain}/{address}"),
        new Operation("sanctions", "getStatus", "GET", "/sanctions/status"),
        new Operation("names", "screen", "POST", "/screen/name"),
        new Operation("names", "get", "GET", "/screen/name/{screeningId}"),
        new Operation("names", "history", "GET", "/screen/name/history"),
        new Operation("names", "decide", "POST", "/screen/name/decisions"),
        new Operation("names", "decisionAudit", "GET", "/screen/name/decisions/audit"),
        new Operation("graph", "buildGraph", "POST", "/investigate/graph"),
        new Operation("graph", "exportGraph", "POST", "/investigate/graph/export"),
        new Operation("graph", "trace", "POST", "/investigate/trace"),
        new Operation("cases", "create", "POST", "/cases"),
        new Operation("cases", "list", "GET", "/cases"),
        new Operation("cases", "get", "GET", "/cases/{caseId}"),
        new Operation("cases", "updateStatus", "PUT", "/cases/{caseId}/status"),
        new Operation("cases", "addNote", "POST", "/cases/{caseId}/notes"),
        new Operation("cases", "addEvidence", "POST", "/cases/{caseId}/evidence"),
        new Operation("cases", "escalate", "POST", "/cases/{caseId}/escalate"),
        new Operation("cases", "getAssignment", "GET", "/cases/{caseId}/assignment"),
        new Operation("cases", "setAssignee", "PUT", "/cases/{caseId}/assignee"),
        new Operation("cases", "linkEvaluation", "POST", "/cases/{caseId}/evaluations"),
        new Operation("alerts", "get", "GET", "/alerts/{id}"),
        new Operation("alerts", "acknowledge", "POST", "/alerts/{id}/acknowledge"),
        new Operation("compliance", "checkTravelRule", "POST", "/compliance/travel-rule/check"),
        new Operation("compliance", "buildTravelRulePayload", "POST", "/compliance/travel-rule/payload"),
        new Operation("compliance", "identifyVasp", "GET", "/compliance/travel-rule/vasp/identify/{chain}/{address}"),
        new Operation("compliance", "generateDac8Report", "POST", "/compliance/dac8/report"),
        new Operation("intelligence", "getEntityLabels", "GET", "/intelligence/entity/{chain}/{address}"),
        new Operation("intelligence", "getEntityLabel", null, null),
        new Operation("intelligence", "getVaspInfo", null, null),
        new Operation("webhooks", "list", "GET", "/webhooks"),
        new Operation("webhooks", "getDeliveries", "GET", "/webhooks/{webhookId}/deliveries"),
        new Operation("auth", "me", "GET", "/auth/me"),
        new Operation("capabilities", "get", "GET", "/capabilities"),
        new Operation("settings", "getScoreThresholds", "GET", "/settings/score-thresholds"),
        new Operation("settings", "getScoreThresholdAudit", "GET", "/settings/score-thresholds/audit"),
        new Operation("settings", "getNameMatching", "GET", "/settings/name-matching"),
        new Operation("settings", "getNameMatchingAudit", "GET", "/settings/name-matching/audit"),
        new Operation("settings", "getNameLists", "GET", "/settings/name-lists"),
        new Operation("settings", "getNameListAudit", "GET", "/settings/name-lists/audit"),
        new Operation("settings", "listVendorKeys", "GET", "/settings/vendor-keys"),
        new Operation("monitoring", "listWallets", "GET", "/monitoring/wallets"),
        new Operation("monitoring", "addWallet", "POST", "/monitoring/wallets"),
        new Operation("monitoring", "removeWallet", "DELETE", "/monitoring/wallets/{id}"),
        new Operation("monitoring", "listNames", "GET", "/monitoring/names"),
        new Operation("monitoring", "addName", "POST", "/monitoring/names"),
        new Operation("monitoring", "removeName", "DELETE", "/monitoring/names/{id}"),
        new Operation("monitoring", "getOverview", "GET", "/monitoring/overview"),
        new Operation("monitoring", "listBreaches", "GET", "/monitoring/breaches"),
        new Operation("monitoring", "getBreachSummary", "GET", "/monitoring/breaches/summary"),
        new Operation("monitoring", "acknowledgeBreach", "POST", "/monitoring/breaches/{id}/acknowledge"));
}
