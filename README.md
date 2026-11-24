# CryptaScreen Java SDK

Official Java SDK for the [CryptaScreen API](https://github.com/cryptascreen/cryptascreen-sdk-java#readme) — address and name screening, sanctions, wallet exposure, investigations, webhooks.

Same API surface as the [TypeScript SDK](https://github.com/cryptascreen/cryptascreen-sdk-typescript) (`com.cryptascreen.sdk.Operations.ALL` lists each one with its HTTP method and path).

## Requirements

- Supported Java versions: 17, 21, 23, 25 (tested in CI).
- Jackson 2.23 (pulled in transitively)

## Installation

### Maven

```xml
<dependency>
    <groupId>com.cryptascreen</groupId>
    <artifactId>cryptascreen-sdk</artifactId>
    <version>0.2.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.cryptascreen:cryptascreen-sdk:0.2.1'
```

## Quick Start

```java
import com.cryptascreen.sdk.CryptaScreen;
import com.cryptascreen.sdk.model.*;

var client = CryptaScreen.builder()
        .apiKey(System.getenv("CRYPTASCREEN_API_KEY"))
        .build();

ScreeningResponse r = client.screening().screenAddress(
        ScreenAddressRequest.builder().address("0x1111111111111111111111111111111111111111").chain("ethereum").build());
System.out.println(r.riskLevel() + " " + r.riskScore() + " " + r.sanctionsMatch());
// "no match" means no match in the layers listed in r.layers(); check r.assessmentStatus() before treating it as clear
```

Every record has a builder (`Foo.builder()...build()`); responses are records with the API's camelCase names (a few sanctions-status
fields are snake_case on the wire and in the record).

## Configuration

```java
CryptaScreen.builder()
        .apiKey("csk_...")                      // required
        .baseUrl("http://localhost:8081")       // optional: for example a proxy
        .connectTimeout(Duration.ofSeconds(10))
        .requestTimeout(Duration.ofSeconds(30))
        .maxRetries(3)
        .retryBaseDelay(Duration.ofSeconds(1))
        .autoRetryRateLimit(true)
        .build();
```

Every request goes to `https://api.cryptascreen.com`, which routes it to the data region of your API key (`csk_us_...` keys to the US
region, `csk_eu_...` keys to the EU region). There is no region option: use the key of the region your account lives in.

## Chain is required

`chain` is required on every screening call, single and bulk (`chains`, one per address). An address does not identify its
network, so there is no default. A null or blank chain throws `ValidationException` with `validationCode() == "CHAIN_REQUIRED"`.

## API Reference

### Screening

```java
var req = BulkScreeningRequest.builder().addresses(List.of(a1, a2)).chains(List.of("ethereum", "ethereum")).build();   // chains[i] belongs to addresses[i]: equal lengths

List<ScreeningResponse> results = client.screening().screenBulk(req);          // sync, max 1000 ("async" forced to false)
ScreeningJob job = client.screening().screenBulkAsync(req);                    // async job, max 10000, Idempotency-Key always sent
job = client.screening().pollJob(job.jobId());
job = client.screening().screenBulkAndWait(req, Duration.ofSeconds(2), Duration.ofMinutes(5), null);
ScreeningJobResultsPage page = client.screening().getJobResults(job.jobId(), PageOptions.builder().page(0L).size(100L).build());
client.screening().listJobs();
client.screening().cancelJob(job.jobId());

client.screening().getHistory("ethereum", addr);
client.screening().listEvaluations("ethereum", addr, PageOptions.builder().page(0L).size(20L).build());
client.screening().getEvaluation(r.evaluationId());

// wallet sections and exposure (screened wallets only)
client.screening().getCounterparties("ethereum", addr, WalletCounterpartyOptions.builder().listedOnly(true).build());
client.screening().getTransactions("ethereum", addr, null);
client.screening().getExposurePaths("ethereum", addr, WalletSectionOptions.builder().days(90L).build());
```

### Sanctions

```java
client.sanctions().check("ethereum", addr);   // exact match against the self-hosted sanctions lists
client.sanctions().getStatus();
```

### Name screening

```java
NameScreenResponse hit = client.names().screen(NameScreenRequest.builder().name("Test Name").type("PERSON").build(), "my-key");
client.names().get(hit.screeningId());
client.names().history(50);
client.names().decide(NameDecisionRequest.builder().hitId("...").value("FALSE_POSITIVE").reason("different person").build());
client.names().decisionAudit("json");    // or "csv"
```

### Graph, cases, alerts, compliance, intelligence, webhooks

```java
client.graph().buildGraph(GraphRequest.builder().seedAddress(addr).chain("ethereum").maxHops(2L).build());
client.cases().create(CreateCaseRequest.builder().title("Review").addresses(List.of()).build());
client.cases().setAssignee(caseId, 12L);          // null = unassign
client.alerts().acknowledge("7", "reviewed");
client.compliance().identifyVasp("ethereum", addr);
client.intelligence().getEntityLabels("ethereum", addr);   // empty list = no label known, NOT a clean verdict
client.webhooks().list();                         // your endpoints (the secret is only a hint)
client.webhooks().getDeliveries("1");             // the last 50 deliveries of an endpoint, newest first
// registering, deleting and test-sending an endpoint is done by a signed-in user in the app (an API key gets 403)
```

### Account, capabilities, settings (read), monitoring

These calls accept an API key (plans without a feature get 403 `feature_not_in_plan`). Changing settings (thresholds, name
matching, allow and block lists, vendor keys) needs a signed-in tenant administrator in the app and is not wrapped.

```java
client.auth().me();                               // the calling identity (authMethod API_KEY)
client.capabilities().get();                      // chains the API accepts + live layer state
client.settings().getScoreThresholds();           // review / block thresholds (defaults 40 / 70)
client.settings().getScoreThresholdAudit(20);     // also getNameMatching(), getNameMatchingAudit(), getNameLists(), getNameListAudit()
client.settings().listVendorKeys();               // configured state, last four characters, fingerprint; never a key
client.monitoring().getOverview();
client.monitoring().addWallet(AddMonitoredWalletRequest.builder().address(addr).chain("ethereum").label("treasury").build());
client.monitoring().listWallets();   client.monitoring().removeWallet("1");
client.monitoring().addName(NameScreenRequest.builder().name("Jane Doe").build());
client.monitoring().listNames();     client.monitoring().removeName("1");
client.monitoring().listBreaches();  client.monitoring().getBreachSummary();  client.monitoring().acknowledgeBreach("1");
```

### Async (CompletableFuture)

Every resource method has an asynchronous variant with the suffix `Async` (`screenAddressAsync`, ...). The two TypeScript methods
whose own name already ends in `Async` / would clash use `Future`: `screenBulkFuture` (async variant of `screenBulk`) and
`screenBulkAsyncFuture` (async variant of `screenBulkAsync`).

```java
client.screening().screenAddressAsync(request).thenAccept(r -> System.out.println(r.riskLevel()));
```

### Webhook verification

```java
import com.cryptascreen.sdk.webhook.WebhookSignature;

try {
    JsonNode event = WebhookSignature.constructEvent(secret, rawBodyBytes, requestHeaders);   // RAW body, not re-serialised JSON
} catch (WebhookSignature.SignatureException e) {
    // e.code(): WEBHOOK_SIGNATURE_MISSING | _MALFORMED | _MISMATCH | WEBHOOK_TIMESTAMP_OUT_OF_TOLERANCE
}
```

Scheme: `X-CryptaScreen-Signature-V2: t=<unix>,v1=<hex(HMAC-SHA256(secret, "<unix>." + body))>`, timestamp tolerance 300 s,
constant-time comparison. The legacy `X-CryptaScreen-Signature: sha256=<hex>` header carries no timestamp and is accepted only through
`verify(secret, body, headers, tolerance, true, now)`.

## Error Handling

```java
try {
    client.screening().screenAddress(request);
} catch (ValidationException e) {
    e.validationCode(); e.fieldErrors(); e.items();     // INVALID_ADDRESS_FORMAT, UNKNOWN_CHAIN, INVALID_BULK_ITEMS ...
} catch (QuotaExceededException e) {
    e.resetsAt(); e.upgradeUrl();                       // monthly plan quota: not retried
} catch (RateLimitException e) {
    e.retryAfterMs();
} catch (CryptaScreenException e) {
    e.statusCode(); e.errorCode(); e.requestId();
}
```

| Status | Class | `errorCode()` |
|---|---|---|
| 400 | `ValidationException` | `VALIDATION_ERROR` |
| 401 | `AuthenticationException` | `AUTHENTICATION_ERROR` |
| 402 | `ServicePausedException` / `CryptaScreenException` | `SERVICE_PAUSED` / `PAYMENT_REQUIRED` |
| 403 | `PlanLimitException` (`SeatLimitReachedException`, `ApiKeyLimitReachedException`) / `CryptaScreenException` | the limit code / `FORBIDDEN` |
| 404 | `NotFoundException` | `NOT_FOUND` |
| 429 | `RateLimitException` / `QuotaExceededException` | `RATE_LIMIT_EXCEEDED` / `QUOTA_EXCEEDED` |
| other | `CryptaScreenException` | the body's `code` or `UNKNOWN_ERROR` |

## Retry Behavior

429 (except `quota_exceeded`) and every 5xx (501 included, as in the TypeScript SDK) are retried up to `maxRetries` (default 3). The delay is
the `Retry-After` header (integer seconds) when present, otherwise `retryBaseDelay * 2^attempt` (1 s, 2 s, 4 s ...) capped at 30 s. 400,
401, 402, 403, 404 and the monthly quota are never retried; a failure without a response (timeout, connection) is not retried
(`statusCode() == 0`, `UNKNOWN_ERROR`).

## Development

```bash
mvn -B verify
mvn -B package javadoc:jar   # jar + sources jar (attached by the pom) + javadoc jar
```

## License

MIT - see [LICENSE](LICENSE).
