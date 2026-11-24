# Changelog

## 0.2.1

- POM metadata: the developer is CryptaCount, Inc. with no e-mail address.
- Signed with the release key 92C998CD6DFEEDBB0B3CA44A8AA7BDAEF292AD0C ("CryptaCount, Inc."), certified by the previous key 342E632911247F1D9137E30D5CA64DBDE5CF228A.
- No code or API change; same behaviour as 0.2.0 (User-Agent reports 0.2.1).

## 0.2.0

- POM metadata: organization and developer are CryptaCount, Inc. (the copyright and licence holder, as in LICENSE).
- Build: Jackson 2.23.0; maven-surefire-plugin 3.6.1, maven-javadoc-plugin 3.12.0, maven-gpg-plugin 3.2.8, central-publishing-maven-plugin 0.12.0; CI actions checkout 7 and setup-java 6.
- **BREAKING:** `chain` is now required on every screening call; the server returns 400 `CHAIN_REQUIRED` when it is missing. `screening().screenAddress` needs `ScreenAddressRequest.chain`, and `screenBulk` / `screenBulkAsync` / `screenBulkAndWait` need `BulkScreeningRequest.chains` (one per address); there is no default network. A null or blank value throws `ValidationException` with `validationCode() == "CHAIN_REQUIRED"` before the request is sent, and the server's 400 is mapped to the same exception.
- New resources for the remaining customer API calls usable with an API key: `auth().me()`, `capabilities().get()`; `settings()` (`getScoreThresholds`, `getScoreThresholdAudit`, `getNameMatching`, `getNameMatchingAudit`, `getNameLists`, `getNameListAudit`, `listVendorKeys`); `monitoring()` (`listWallets`, `addWallet`, `removeWallet`, `listNames`, `addName`, `removeName`, `getOverview`, `listBreaches`, `getBreachSummary`, `acknowledgeBreach`). Each with an `Async` variant.
- Changing settings, the allow and block lists and vendor keys, need a signed-in user in the app and are not wrapped.
- Webhooks: `webhooks().create`, `delete` and `test` are removed (the API answers an API key `403 SESSION_REQUIRED`); `list` and `getDeliveries` stay. The webhook models match the API (`WebhookConfig.isActive`, `WebhookDelivery.status`, ...), `getDeliveries(webhookId)` returns the last 50 deliveries as a list and takes no paging options, `WebhookEventType` lists `HIGH_RISK`, `CRITICAL`, `SANCTIONS_MATCH`, `HEURISTICS_COMPLETE`, `TEST`. `CreateWebhookRequest` and `WebhookTestResult` are gone.
- The OpenAPI parity test has no known gaps: every SDK method is an operation of the customer API contract; the 10 contract operations that are not wrapped are listed with their reason.

## 0.1.0 — unreleased

First version of the CryptaScreen Java SDK. API surface = `@cryptascreen/sdk` 0.2.2 (every endpoint method usable with an API key 1:1, same
request/response fields, error classes and codes, retry policy), plus:

- requests go to `https://api.cryptascreen.com`, which routes them by the API key's data region (no region option),
- webhook signature verification (`WebhookSignature`).

Naming: TS `screenAddress` keeps its name; options objects are records with builders; `CryptaScreenClient` -> `CryptaScreen`.

Notes found by the local contract run:

- `chains[i]` pairs with `addresses[i]`: the lists must have the same length (`400 addresses and chains lists must have the same length`).
- Webhooks: `webhooks().list` and `webhooks().getDeliveries` only. Registering, deleting and test-sending an endpoint require a signed-in user in the CryptaScreen app (an API key gets `403`), so this SDK does not offer them.
