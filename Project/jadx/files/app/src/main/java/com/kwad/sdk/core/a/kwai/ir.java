package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ir implements com.kwad.sdk.core.d<WebCloseStatus> {
    private static void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    private static JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = webCloseStatus.interactSuccess;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "interactSuccess", z2);
        }
        int i2 = webCloseStatus.closeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "closeType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCloseStatus) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCloseStatus) bVar, jSONObject);
    }
}
