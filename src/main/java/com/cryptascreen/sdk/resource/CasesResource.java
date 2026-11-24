package com.cryptascreen.sdk.resource;

import com.cryptascreen.sdk.CryptaScreenException;
import com.cryptascreen.sdk.ValidationException;
import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.model.*;
import com.cryptascreen.sdk.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for cases operations (mirrors the cases endpoints of @cryptascreen/sdk).
 */
public final class CasesResource {

    private final HttpClient http;

    /**
     * Creates a new CasesResource.
     *
     * @param http the HTTP client
     */
    public CasesResource(HttpClient http) {
        this.http = http;
    }

    /**
     * POST /cases
     *
     * @param request the request
     * @return the result
     */
    public InvestigationCase create(CreateCaseRequest request) {
        return http.request("POST", "/api/v1/cases", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * Asynchronous variant of {@link #create}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<InvestigationCase> createAsync(CreateCaseRequest request) {
        return http.requestAsync("POST", "/api/v1/cases", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * GET /cases
     *
     * @param options the options
     * @return the result
     */
    public PaginatedResponse<InvestigationCase> list(ListCasesParams options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.request("GET", "/api/v1/cases", q, null, null, new TypeReference<PaginatedResponse<InvestigationCase>>() {});
    }

    /**
     * Asynchronous variant of {@link #list}.
     *
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<PaginatedResponse<InvestigationCase>> listAsync(ListCasesParams options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.requestAsync("GET", "/api/v1/cases", q, null, null, new TypeReference<PaginatedResponse<InvestigationCase>>() {});
    }

    /**
     * GET /cases/{caseId}
     *
     * @param caseId the caseId
     * @return the result
     */
    public InvestigationCase get(String caseId) {
        return http.request("GET", "/api/v1/cases/" + PathSegments.encode(caseId), null, null, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * Asynchronous variant of {@link #get}.
     *
     * @param caseId the caseId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<InvestigationCase> getAsync(String caseId) {
        return http.requestAsync("GET", "/api/v1/cases/" + PathSegments.encode(caseId), null, null, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * PUT /cases/{caseId}/status
     *
     * @param caseId the caseId
     * @param request the request
     * @return the result
     */
    public InvestigationCase updateStatus(String caseId, UpdateCaseStatusRequest request) {
        return http.request("PUT", "/api/v1/cases/" + PathSegments.encode(caseId) + "/status", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * Asynchronous variant of {@link #updateStatus}.
     *
     * @param caseId the caseId
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<InvestigationCase> updateStatusAsync(String caseId, UpdateCaseStatusRequest request) {
        return http.requestAsync("PUT", "/api/v1/cases/" + PathSegments.encode(caseId) + "/status", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * POST /cases/{caseId}/notes
     *
     * @param caseId the caseId
     * @param request the request
     * @return the result
     */
    public CaseNote addNote(String caseId, AddNoteRequest request) {
        return http.request("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/notes", null, request, null, new TypeReference<CaseNote>() {});
    }

    /**
     * Asynchronous variant of {@link #addNote}.
     *
     * @param caseId the caseId
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<CaseNote> addNoteAsync(String caseId, AddNoteRequest request) {
        return http.requestAsync("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/notes", null, request, null, new TypeReference<CaseNote>() {});
    }

    /**
     * POST /cases/{caseId}/evidence
     *
     * @param caseId the caseId
     * @param request the request
     * @return the result
     */
    public CaseEvidence addEvidence(String caseId, AddEvidenceRequest request) {
        return http.request("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/evidence", null, request, null, new TypeReference<CaseEvidence>() {});
    }

    /**
     * Asynchronous variant of {@link #addEvidence}.
     *
     * @param caseId the caseId
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<CaseEvidence> addEvidenceAsync(String caseId, AddEvidenceRequest request) {
        return http.requestAsync("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/evidence", null, request, null, new TypeReference<CaseEvidence>() {});
    }

    /**
     * POST /cases/{caseId}/escalate
     *
     * @param caseId the caseId
     * @param request the request
     * @return the result
     */
    public InvestigationCase escalate(String caseId, EscalateCaseRequest request) {
        return http.request("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/escalate", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * Asynchronous variant of {@link #escalate}.
     *
     * @param caseId the caseId
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<InvestigationCase> escalateAsync(String caseId, EscalateCaseRequest request) {
        return http.requestAsync("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/escalate", null, request, null, new TypeReference<InvestigationCase>() {});
    }

    /**
     * GET /cases/{caseId}/assignment
     *
     * @param caseId the caseId
     * @return the result
     */
    public CaseAssignment getAssignment(String caseId) {
        return http.request("GET", "/api/v1/cases/" + PathSegments.encode(caseId) + "/assignment", null, null, null, new TypeReference<CaseAssignment>() {});
    }

    /**
     * Asynchronous variant of {@link #getAssignment}.
     *
     * @param caseId the caseId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<CaseAssignment> getAssignmentAsync(String caseId) {
        return http.requestAsync("GET", "/api/v1/cases/" + PathSegments.encode(caseId) + "/assignment", null, null, null, new TypeReference<CaseAssignment>() {});
    }

    /**
     * Assigns the case to a user of your organization, or unassigns with null.
     *
     * @param caseId the caseId
     * @param userId the userId
     * @return the result
     */
    public CaseAssignment setAssignee(String caseId, Long userId) {
        ObjectNode body = JsonUtils.mapper().createObjectNode();
        if (userId == null) {
            body.putNull("userId");
        } else {
            body.put("userId", userId);
        }
        return http.request("PUT", "/api/v1/cases/" + PathSegments.encode(caseId) + "/assignee", null, body, null, new TypeReference<CaseAssignment>() {});
    }

    /**
     * Asynchronous variant of {@link #setAssignee}.
     *
     * @param caseId the caseId
     * @param userId the userId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<CaseAssignment> setAssigneeAsync(String caseId, Long userId) {
        return CompletableFuture.supplyAsync(() -> setAssignee(caseId, userId));
    }

    /**
     * Links a screening evaluation of your organization to the case (idempotent).
     *
     * @param caseId the caseId
     * @param evaluationId the evaluationId
     * @return the result
     */
    public CaseAssignment linkEvaluation(String caseId, String evaluationId) {
        return http.request("POST", "/api/v1/cases/" + PathSegments.encode(caseId) + "/evaluations", null, Map.of("evaluationId", evaluationId), null, new TypeReference<CaseAssignment>() {});
    }

    /**
     * Asynchronous variant of {@link #linkEvaluation}.
     *
     * @param caseId the caseId
     * @param evaluationId the evaluationId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<CaseAssignment> linkEvaluationAsync(String caseId, String evaluationId) {
        return CompletableFuture.supplyAsync(() -> linkEvaluation(caseId, evaluationId));
    }

    private static Map<String, Object> optionsToQuery(Object options) {
        Map<String, Object> q = new LinkedHashMap<>();
        if (options != null) {
            JsonUtils.toMap(options).forEach((k, v) -> {
                if (v != null) {
                    q.put(k, v);
                }
            });
        }
        return q;
    }
}
