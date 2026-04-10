package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.h> {
    private static void a(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.US = jSONObject.optInt("hasDeepReward");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = hVar.US;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "hasDeepReward", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.h) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.h) bVar, jSONObject);
    }
}
