package com.cryptascreen.sdk;

import com.cryptascreen.sdk.model.*;
import com.cryptascreen.sdk.util.Helpers;
import com.cryptascreen.sdk.util.JsonUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    private static <T> T parse(String json, Class<T> c) throws Exception {
        return JsonUtils.mapper().readValue(json, c);
    }

    @Test
    void assessedAndSanctionsLayer() throws Exception {
        assertTrue(Helpers.isAssessed(parse("{\"riskLevel\":\"LOW\",\"riskScore\":3}", ScreeningResponse.class)));
        ScreeningResponse unknown = parse("{\"riskLevel\":\"UNKNOWN\"}", ScreeningResponse.class);
        assertFalse(Helpers.isAssessed(unknown));
        assertFalse(Helpers.sanctionsLayerComplete(unknown));
        assertTrue(Helpers.sanctionsLayerComplete(parse("{\"layers\":{\"sanctions\":{\"state\":\"COMPLETE\"}}}", ScreeningResponse.class)));
        assertFalse(Helpers.sanctionsLayerComplete(parse("{\"layers\":{\"sanctions\":{\"state\":\"SOMETHING_NEW\"}}}", ScreeningResponse.class)));
    }

    @Test
    void nameAndGraph() throws Exception {
        assertTrue(Helpers.isNameClear(parse("{\"outcome\":\"CLEAR\"}", NameScreenResponse.class)));
        assertFalse(Helpers.isNameClear(parse("{\"outcome\":\"SOMETHING_NEW\"}", NameScreenResponse.class)));
        assertFalse(Helpers.isGraphComplete(parse("{}", GraphResponse.class)));
        assertTrue(Helpers.isGraphComplete(parse("{\"stats\":{\"status\":\"COMPLETE\"}}", GraphResponse.class)));
        assertTrue(Helpers.isGraphComplete(parse("{\"stats\":{\"truncated\":false}}", GraphResponse.class)));
        assertFalse(Helpers.isGraphComplete(parse("{\"stats\":{\"truncated\":true}}", GraphResponse.class)));
    }

    @Test
    void categoryShareLabel() throws Exception {
        assertEquals("n/a", Helpers.categoryShareLabel(parse("{\"state\":\"NOT_ANALYZED\"}", WalletCategoryPart.class)));
        assertEquals("n/a", Helpers.categoryShareLabel(parse("{\"state\":\"COMPLETE\"}", WalletCategoryPart.class)));
        assertEquals("12.3%", Helpers.categoryShareLabel(parse("{\"state\":\"COMPLETE\",\"usdShare\":\"0.1234\"}", WalletCategoryPart.class)));
        assertEquals("\u2265 50%", Helpers.categoryShareLabel(parse("{\"state\":\"PARTIAL\",\"usdShare\":0.5}", WalletCategoryPart.class), 0));
    }
}
