# Changelog

## 0.2.1 - 2026-11-24

Maintenance release. No API changes.

## 0.2.0 - 2026-11-24

First release on Maven Central. Requires Java 17 or later.

- Client for the CryptaScreen customer API: address and bulk screening, async jobs, evaluations and history, sanctions, name screening, wallet sections and exposure, graph, cases and alerts, compliance and intelligence. Every call also has an `Async` variant (`CompletableFuture`).
- `chain` is required on every screening call; `screenBulk`, `screenBulkAsync` and `screenBulkAndWait` take `chains`, one per address. A missing value throws `ValidationException` with `validationCode() == "CHAIN_REQUIRED"`.
- `auth().me()`, `capabilities().get()`, `settings()` (read-only with an API key) and `monitoring()` (monitored wallets and names, overview, breaches).
- Webhooks: `webhooks().list` and `webhooks().getDeliveries` (last 50 deliveries), plus signature verification with `WebhookSignature`. Registering, deleting and testing endpoints is done in the CryptaScreen app.
- Requests go to `https://api.cryptascreen.com`, which routes them by the API key's data region.
