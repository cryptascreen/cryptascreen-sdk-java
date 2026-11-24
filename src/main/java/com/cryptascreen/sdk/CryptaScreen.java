package com.cryptascreen.sdk;

import com.cryptascreen.sdk.http.HttpClient;
import com.cryptascreen.sdk.resource.*;

import java.time.Duration;

/**
 * Main entry point for the CryptaScreen Java SDK.
 *
 * <p>Create an instance using the builder pattern:</p>
 * <pre>{@code
 * var client = CryptaScreen.builder()
 *     .apiKey("csk_...")
 *     .build();
 *
 * var result = client.screening().screenAddress(
 *     ScreenAddressRequest.builder().address("0x...").chain("ethereum").build());
 * }</pre>
 *
 * <p>The client provides one resource per API domain:</p>
 * <ul>
 *   <li>{@link #screening()}</li>
 *   <li>{@link #sanctions()}</li>
 *   <li>{@link #names()}</li>
 *   <li>{@link #graph()}</li>
 *   <li>{@link #cases()}</li>
 *   <li>{@link #alerts()}</li>
 *   <li>{@link #compliance()}</li>
 *   <li>{@link #intelligence()}</li>
 *   <li>{@link #webhooks()}</li>
 *   <li>{@link #auth()}</li>
 *   <li>{@link #capabilities()}</li>
 *   <li>{@link #settings()}</li>
 *   <li>{@link #monitoring()}</li>
 * </ul>
 */
public final class CryptaScreen {

    private final CryptaScreenConfig config;
    private final ScreeningResource screeningResource;
    private final SanctionsResource sanctionsResource;
    private final NamesResource namesResource;
    private final GraphResource graphResource;
    private final CasesResource casesResource;
    private final AlertsResource alertsResource;
    private final ComplianceResource complianceResource;
    private final IntelligenceResource intelligenceResource;
    private final WebhooksResource webhooksResource;
    private final AuthResource authResource;
    private final CapabilitiesResource capabilitiesResource;
    private final SettingsResource settingsResource;
    private final MonitoringResource monitoringResource;

    private CryptaScreen(CryptaScreenConfig config) {
        this.config = config;
        HttpClient httpClient = new HttpClient(config);
        this.screeningResource = new ScreeningResource(httpClient);
        this.sanctionsResource = new SanctionsResource(httpClient);
        this.namesResource = new NamesResource(httpClient);
        this.graphResource = new GraphResource(httpClient);
        this.casesResource = new CasesResource(httpClient);
        this.alertsResource = new AlertsResource(httpClient);
        this.complianceResource = new ComplianceResource(httpClient);
        this.intelligenceResource = new IntelligenceResource(httpClient);
        this.webhooksResource = new WebhooksResource(httpClient);
        this.authResource = new AuthResource(httpClient);
        this.capabilitiesResource = new CapabilitiesResource(httpClient);
        this.settingsResource = new SettingsResource(httpClient);
        this.monitoringResource = new MonitoringResource(httpClient);
    }

    /**
     * Creates a new builder for configuring a CryptaScreen client.
     *
     * @return a new builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates a CryptaScreen client from the given configuration.
     *
     * @param config the client configuration
     * @return a new CryptaScreen client
     */
    public static CryptaScreen create(CryptaScreenConfig config) {
        return new CryptaScreen(config);
    }

    /**
     * Returns the screening resource.
     *
     * @return the screening resource
     */
    public ScreeningResource screening() {
        return screeningResource;
    }

    /**
     * Returns the sanctions resource.
     *
     * @return the sanctions resource
     */
    public SanctionsResource sanctions() {
        return sanctionsResource;
    }

    /**
     * Returns the names resource.
     *
     * @return the names resource
     */
    public NamesResource names() {
        return namesResource;
    }

    /**
     * Returns the graph resource.
     *
     * @return the graph resource
     */
    public GraphResource graph() {
        return graphResource;
    }

    /**
     * Returns the cases resource.
     *
     * @return the cases resource
     */
    public CasesResource cases() {
        return casesResource;
    }

    /**
     * Returns the alerts resource.
     *
     * @return the alerts resource
     */
    public AlertsResource alerts() {
        return alertsResource;
    }

    /**
     * Returns the compliance resource.
     *
     * @return the compliance resource
     */
    public ComplianceResource compliance() {
        return complianceResource;
    }

    /**
     * Returns the intelligence resource.
     *
     * @return the intelligence resource
     */
    public IntelligenceResource intelligence() {
        return intelligenceResource;
    }

    /**
     * Returns the webhooks resource.
     *
     * @return the webhooks resource
     */
    public WebhooksResource webhooks() {
        return webhooksResource;
    }

    /**
     * Returns the auth resource.
     *
     * @return the auth resource
     */
    public AuthResource auth() {
        return authResource;
    }

    /**
     * Returns the capabilities resource.
     *
     * @return the capabilities resource
     */
    public CapabilitiesResource capabilities() {
        return capabilitiesResource;
    }

    /**
     * Returns the settings resource.
     *
     * @return the settings resource
     */
    public SettingsResource settings() {
        return settingsResource;
    }

    /**
     * Returns the monitoring resource.
     *
     * @return the monitoring resource
     */
    public MonitoringResource monitoring() {
        return monitoringResource;
    }

    /**
     * Returns the configuration used by this client.
     *
     * @return the configuration
     */
    public CryptaScreenConfig config() {
        return config;
    }

    /**
     * Builder for creating a {@link CryptaScreen} client.
     */
    public static final class Builder {

        private final CryptaScreenConfig.Builder configBuilder = new CryptaScreenConfig.Builder();

        private Builder() {}

        /**
         * Sets the API key for authentication.
         *
         * @param apiKey the API key
         * @return this builder
         */
        public Builder apiKey(String apiKey) {
            configBuilder.apiKey(apiKey);
            return this;
        }

        /**
         * Sets the base URL for the CryptaScreen API.
         *
         * @param baseUrl the base URL (default: https://api.cryptascreen.com)
         * @return this builder
         */
        public Builder baseUrl(String baseUrl) {
            configBuilder.baseUrl(baseUrl);
            return this;
        }

        /**
         * Sets the connection timeout.
         *
         * @param connectTimeout the connection timeout (default: 10s)
         * @return this builder
         */
        public Builder connectTimeout(Duration connectTimeout) {
            configBuilder.connectTimeout(connectTimeout);
            return this;
        }

        /**
         * Sets the request timeout.
         *
         * @param requestTimeout the request timeout (default: 30s)
         * @return this builder
         */
        public Builder requestTimeout(Duration requestTimeout) {
            configBuilder.requestTimeout(requestTimeout);
            return this;
        }

        /**
         * Sets the maximum number of retries on 429 (not quota) and 5xx.
         *
         * @param maxRetries the maximum retries (default: 3)
         * @return this builder
         */
        public Builder maxRetries(int maxRetries) {
            configBuilder.maxRetries(maxRetries);
            return this;
        }

        /**
         * Sets the base delay for exponential backoff between retries.
         *
         * @param retryBaseDelay the base delay (default: 1s)
         * @return this builder
         */
        public Builder retryBaseDelay(Duration retryBaseDelay) {
            configBuilder.retryBaseDelay(retryBaseDelay);
            return this;
        }

        /**
         * Sets whether to automatically retry on rate-limit (429) responses.
         *
         * @param autoRetryRateLimit true to auto-retry (default: true)
         * @return this builder
         */
        public Builder autoRetryRateLimit(boolean autoRetryRateLimit) {
            configBuilder.autoRetryRateLimit(autoRetryRateLimit);
            return this;
        }

        /**
         * Builds and returns a new CryptaScreen client.
         *
         * @return a configured CryptaScreen client
         * @throws IllegalArgumentException if required configuration is missing or inconsistent
         */
        public CryptaScreen build() {
            return new CryptaScreen(configBuilder.build());
        }
    }
}
