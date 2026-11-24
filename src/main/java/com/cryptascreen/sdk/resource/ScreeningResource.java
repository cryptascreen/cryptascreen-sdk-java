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
 * Resource for screening operations (mirrors the screening endpoints of @cryptascreen/sdk).
 */
public final class ScreeningResource {

    private final HttpClient http;

    /**
     * Creates a new ScreeningResource.
     *
     * @param http the HTTP client
     */
    public ScreeningResource(HttpClient http) {
        this.http = http;
    }

    /**
     * POST /screen/address
     *
     * @param request the request
     * @return the result
     */
    public ScreeningResponse screenAddress(ScreenAddressRequest request) {
        requireChain(request);
        return http.request("POST", "/api/v1/screen/address", null, request, null, new TypeReference<ScreeningResponse>() {});
    }

    private static final String CHAIN_REQUIRED = "chain is required: an address does not identify its network";

    private static ValidationException chainRequired(String field) {
        return new ValidationException(CHAIN_REQUIRED, Map.of(field, List.of(CHAIN_REQUIRED)), null, "CHAIN_REQUIRED", null);
    }

    private static boolean blank(String v) {
        return v == null || v.isBlank();
    }

    /** Single screening: {@code chain} is mandatory; there is no default network. */
    private static void requireChain(ScreenAddressRequest request) {
        if (request == null || blank(request.chain())) {
            throw chainRequired("chain");
        }
    }

    /** Bulk screening: every address row needs a non-blank entry in {@code chains}. */
    private static void requireChains(BulkScreeningRequest request) {
        if (request == null) {
            throw chainRequired("chains");
        }
        boolean hasAddresses = request.addresses() != null && !request.addresses().isEmpty();
        if (hasAddresses && (request.chains() == null || request.chains().isEmpty()
                || request.chains().stream().anyMatch(ScreeningResource::blank))) {
            throw chainRequired("chains");
        }
    }

    /**
     * Asynchronous variant of {@link #screenAddress}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningResponse> screenAddressAsync(ScreenAddressRequest request) {
        try {
            requireChain(request);
        } catch (ValidationException e) {
            return CompletableFuture.failedFuture(e);
        }
        return http.requestAsync("POST", "/api/v1/screen/address", null, request, null, new TypeReference<ScreeningResponse>() {});
    }

    /**
     * Screens multiple addresses synchronously (max 1000). {@code async} is forced to false.
     *
     * @param request the request
     * @return the result
     */
    public List<ScreeningResponse> screenBulk(BulkScreeningRequest request) {
        requireChains(request);
        Map<String, Object> body = JsonUtils.toMap(request);
        body.put("async", false);
        return http.request("POST", "/api/v1/screen/bulk", null, body, null, new TypeReference<List<ScreeningResponse>>() {});
    }

    /**
     * Asynchronous variant of {@link #screenBulk}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<ScreeningResponse>> screenBulkFuture(BulkScreeningRequest request) {
        return CompletableFuture.supplyAsync(() -> screenBulk(request));
    }

    /**
     * Submits a bulk screening job (max 10000). {@code async} is forced to true; an Idempotency-Key header is always sent (generated when null).
     *
     * @param request the request
     * @param idempotencyKey the idempotencyKey
     * @return the result
     */
    public ScreeningJob screenBulkAsync(BulkScreeningRequest request, String idempotencyKey) {
        requireChains(request);
        Map<String, Object> body = JsonUtils.toMap(request);
        body.put("async", true);
        String key = idempotencyKey != null && !idempotencyKey.isEmpty() ? idempotencyKey : generateIdempotencyKey();
        return http.request("POST", "/api/v1/screen/bulk", null, body, Map.of("Idempotency-Key", key), new TypeReference<ScreeningJob>() {});
    }

    /**
     * Asynchronous variant of {@link #screenBulkAsync}.
     *
     * @param request the request
     * @param idempotencyKey the idempotencyKey
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> screenBulkAsyncFuture(BulkScreeningRequest request, String idempotencyKey) {
        return CompletableFuture.supplyAsync(() -> screenBulkAsync(request, idempotencyKey));
    }

    /**
     * Submits a bulk screening job with a generated Idempotency-Key.
     *
     * @param request the request
     * @return the result
     */
    public ScreeningJob screenBulkAsync(BulkScreeningRequest request) {
        return screenBulkAsync(request, null);
    }

    /**
     * Asynchronous variant of {@link #screenBulkAsync}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> screenBulkAsyncFuture(BulkScreeningRequest request) {
        return CompletableFuture.supplyAsync(() -> screenBulkAsync(request));
    }

    /**
     * GET /screen/jobs/{jobId}
     *
     * @param jobId the jobId
     * @return the result
     */
    public ScreeningJob pollJob(String jobId) {
        return http.request("GET", "/api/v1/screen/jobs/" + PathSegments.encode(jobId), null, null, null, new TypeReference<ScreeningJob>() {});
    }

    /**
     * Asynchronous variant of {@link #pollJob}.
     *
     * @param jobId the jobId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> pollJobAsync(String jobId) {
        return http.requestAsync("GET", "/api/v1/screen/jobs/" + PathSegments.encode(jobId), null, null, null, new TypeReference<ScreeningJob>() {});
    }

    /**
     * GET /screen/jobs
     *
     * @return the result
     */
    public List<ScreeningJob> listJobs() {
        return http.request("GET", "/api/v1/screen/jobs", null, null, null, new TypeReference<List<ScreeningJob>>() {});
    }

    /**
     * Asynchronous variant of {@link #listJobs}.
     *
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<List<ScreeningJob>> listJobsAsync() {
        return http.requestAsync("GET", "/api/v1/screen/jobs", null, null, null, new TypeReference<List<ScreeningJob>>() {});
    }

    /**
     * Returns one page (0-based, size 1..1000) of a job's stored per-address items.
     *
     * @param jobId the jobId
     * @param options the options
     * @return the result
     */
    public ScreeningJobResultsPage getJobResults(String jobId, PageOptions options) {
        long page = options != null && options.page() != null ? options.page() : 0;
        long size = options != null && options.size() != null ? options.size() : 100;
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("page", page);
        q.put("size", size);
        JsonNode d = (JsonNode) http.requestAny("GET", "/api/v1/screen/jobs/" + PathSegments.encode(jobId) + "/results", q, null);
        return normaliseJobResults(d, jobId, page, size);
    }

    /**
     * Asynchronous variant of {@link #getJobResults}.
     *
     * @param jobId the jobId
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJobResultsPage> getJobResultsAsync(String jobId, PageOptions options) {
        return CompletableFuture.supplyAsync(() -> getJobResults(jobId, options));
    }

    /**
     * Returns the first page (size 100) of a job's results.
     *
     * @param jobId the jobId
     * @return the result
     */
    public ScreeningJobResultsPage getJobResults(String jobId) {
        return getJobResults(jobId, null);
    }

    /**
     * Asynchronous variant of {@link #getJobResults}.
     *
     * @param jobId the jobId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJobResultsPage> getJobResultsAsync(String jobId) {
        return CompletableFuture.supplyAsync(() -> getJobResults(jobId));
    }

    /**
     * POST /screen/jobs/{jobId}/cancel
     *
     * @param jobId the jobId
     * @return the result
     */
    public ScreeningJob cancelJob(String jobId) {
        return http.request("POST", "/api/v1/screen/jobs/" + PathSegments.encode(jobId) + "/cancel", null, null, null, new TypeReference<ScreeningJob>() {});
    }

    /**
     * Asynchronous variant of {@link #cancelJob}.
     *
     * @param jobId the jobId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> cancelJobAsync(String jobId) {
        return http.requestAsync("POST", "/api/v1/screen/jobs/" + PathSegments.encode(jobId) + "/cancel", null, null, null, new TypeReference<ScreeningJob>() {});
    }

    /**
     * GET /screen/address/{chain}/{address}/history
     *
     * @param chain the chain
     * @param address the address
     * @return the result
     */
    public ScreeningResponse getHistory(String chain, String address) {
        return http.request("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/history", null, null, null, new TypeReference<ScreeningResponse>() {});
    }

    /**
     * Asynchronous variant of {@link #getHistory}.
     *
     * @param chain the chain
     * @param address the address
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningResponse> getHistoryAsync(String chain, String address) {
        return http.requestAsync("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/history", null, null, null, new TypeReference<ScreeningResponse>() {});
    }

    /**
     * GET /screen/address/{chain}/{address}/evaluations
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return the result
     */
    public ScreeningEvaluationPage listEvaluations(String chain, String address, PageOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        q.putIfAbsent("page", 0);
        q.putIfAbsent("size", 20);
        return http.request("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/evaluations", q, null, null, new TypeReference<ScreeningEvaluationPage>() {});
    }

    /**
     * Asynchronous variant of {@link #listEvaluations}.
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningEvaluationPage> listEvaluationsAsync(String chain, String address, PageOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        q.putIfAbsent("page", 0);
        q.putIfAbsent("size", 20);
        return http.requestAsync("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/evaluations", q, null, null, new TypeReference<ScreeningEvaluationPage>() {});
    }

    /**
     * GET /screen/address/{chain}/{address}/counterparties
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return the result
     */
    public WalletCounterpartyPage getCounterparties(String chain, String address, WalletCounterpartyOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.request("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/counterparties", q, null, null, new TypeReference<WalletCounterpartyPage>() {});
    }

    /**
     * Asynchronous variant of {@link #getCounterparties}.
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<WalletCounterpartyPage> getCounterpartiesAsync(String chain, String address, WalletCounterpartyOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.requestAsync("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/counterparties", q, null, null, new TypeReference<WalletCounterpartyPage>() {});
    }

    /**
     * GET /screen/address/{chain}/{address}/transactions
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return the result
     */
    public WalletTransactionPage getTransactions(String chain, String address, WalletTransactionOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.request("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/transactions", q, null, null, new TypeReference<WalletTransactionPage>() {});
    }

    /**
     * Asynchronous variant of {@link #getTransactions}.
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<WalletTransactionPage> getTransactionsAsync(String chain, String address, WalletTransactionOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.requestAsync("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/transactions", q, null, null, new TypeReference<WalletTransactionPage>() {});
    }

    /**
     * GET /screen/address/{chain}/{address}/exposure-paths
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return the result
     */
    public WalletExposurePaths getExposurePaths(String chain, String address, WalletSectionOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.request("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/exposure-paths", q, null, null, new TypeReference<WalletExposurePaths>() {});
    }

    /**
     * Asynchronous variant of {@link #getExposurePaths}.
     *
     * @param chain the chain
     * @param address the address
     * @param options the options
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<WalletExposurePaths> getExposurePathsAsync(String chain, String address, WalletSectionOptions options) {
        Map<String, Object> q = optionsToQuery(options);
        return http.requestAsync("GET", "/api/v1/screen/address/" + PathSegments.encode(chain) + "/" + PathSegments.encode(address) + "/exposure-paths", q, null, null, new TypeReference<WalletExposurePaths>() {});
    }

    /**
     * GET /screen/evaluations/{evaluationId}
     *
     * @param evaluationId the evaluationId
     * @return the result
     */
    public ScreeningEvaluation getEvaluation(String evaluationId) {
        return http.request("GET", "/api/v1/screen/evaluations/" + PathSegments.encode(evaluationId), null, null, null, new TypeReference<ScreeningEvaluation>() {});
    }

    /**
     * Asynchronous variant of {@link #getEvaluation}.
     *
     * @param evaluationId the evaluationId
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningEvaluation> getEvaluationAsync(String evaluationId) {
        return http.requestAsync("GET", "/api/v1/screen/evaluations/" + PathSegments.encode(evaluationId), null, null, null, new TypeReference<ScreeningEvaluation>() {});
    }

    /**
     * Submits a bulk job and polls until a terminal status (COMPLETED, PARTIAL, FAILED, CANCELLED) or the timeout.
     *
     * @param request the request
     * @param pollInterval the pollInterval
     * @param timeout the timeout
     * @param idempotencyKey the idempotencyKey
     * @return the result
     */
    public ScreeningJob screenBulkAndWait(BulkScreeningRequest request, Duration pollInterval, Duration timeout, String idempotencyKey) {
        ScreeningJob job = screenBulkAsync(request, idempotencyKey);
        long deadline = System.nanoTime() + timeout.toNanos();
        while (System.nanoTime() < deadline) {
            ScreeningJob status = pollJob(job.jobId());
            if (isTerminalJobStatus(status.status())) {
                return status;
            }
            try {
                Thread.sleep(pollInterval.toMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CryptaScreenException("Interrupted while waiting for the job", e);
            }
        }
        throw new CryptaScreenException("Screening job " + job.jobId() + " did not complete within " + timeout.toMillis() + "ms", 0, "JOB_TIMEOUT", null);
    }

    /**
     * Asynchronous variant of {@link #screenBulkAndWait}.
     *
     * @param request the request
     * @param pollInterval the pollInterval
     * @param timeout the timeout
     * @param idempotencyKey the idempotencyKey
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> screenBulkAndWaitAsync(BulkScreeningRequest request, Duration pollInterval, Duration timeout, String idempotencyKey) {
        return CompletableFuture.supplyAsync(() -> screenBulkAndWait(request, pollInterval, timeout, idempotencyKey));
    }

    /**
     * Same with a 2 s poll interval and a 5 min timeout.
     *
     * @param request the request
     * @return the result
     */
    public ScreeningJob screenBulkAndWait(BulkScreeningRequest request) {
        return screenBulkAndWait(request, Duration.ofSeconds(2), Duration.ofMinutes(5), null);
    }

    /**
     * Asynchronous variant of {@link #screenBulkAndWait}.
     *
     * @param request the request
     * @return a CompletableFuture with the result
     */
    public CompletableFuture<ScreeningJob> screenBulkAndWaitAsync(BulkScreeningRequest request) {
        return CompletableFuture.supplyAsync(() -> screenBulkAndWait(request));
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

    /**
     * Random idempotency key (RFC 4122 v4).
     *
     * @return a UUID string
     */
    public static String generateIdempotencyKey() {
        return UUID.randomUUID().toString();
    }

    /**
     * Terminal job statuses (polling stops). Unknown future values are NOT terminal.
     *
     * @param status the job status
     * @return true for COMPLETED, PARTIAL, FAILED, CANCELLED
     */
    public static boolean isTerminalJobStatus(String status) {
        return status != null && List.of("COMPLETED", "PARTIAL", "FAILED", "CANCELLED").contains(status);
    }

    private static ScreeningJobResultsPage normaliseJobResults(JsonNode d, String jobId, long page, long size) {
        ObjectNode out = JsonUtils.mapper().createObjectNode();
        JsonNode src = d == null || !d.isObject() ? JsonUtils.mapper().createObjectNode() : d;
        JsonNode items = src.has("items") && src.get("items").isArray() ? src.get("items")
                : src.has("content") && src.get("content").isArray() ? src.get("content") : JsonUtils.mapper().createArrayNode();
        out.put("jobId", src.has("jobId") && src.get("jobId").isTextual() ? src.get("jobId").asText() : jobId);
        if (src.has("status") && src.get("status").isTextual()) {
            out.put("status", src.get("status").asText());
        }
        out.set("items", items);
        out.put("page", num(src, page, "page", "number"));
        out.put("size", num(src, size, "size"));
        out.put("totalItems", num(src, items.size(), "totalItems", "totalElements"));
        out.put("totalPages", num(src, 1, "totalPages"));
        return JsonUtils.mapper().convertValue(out, ScreeningJobResultsPage.class);
    }

    private static long num(JsonNode n, long fallback, String... names) {
        for (String name : names) {
            if (n.has(name) && n.get(name).isNumber()) {
                return n.get(name).asLong();
            }
        }
        return fallback;
    }
}
