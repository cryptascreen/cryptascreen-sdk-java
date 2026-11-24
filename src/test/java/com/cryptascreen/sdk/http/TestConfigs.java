package com.cryptascreen.sdk.http;

import com.cryptascreen.sdk.CryptaScreenConfig;

import java.lang.reflect.Constructor;

/** Test access to the package-private config builder (production visibility is not widened for tests). */
final class TestConfigs {

    private TestConfigs() {}

    static CryptaScreenConfig.Builder builder() {
        try {
            Constructor<CryptaScreenConfig.Builder> c = CryptaScreenConfig.Builder.class.getDeclaredConstructor();
            c.setAccessible(true);
            return c.newInstance().apiKey("test-key");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
}
