package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fo implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.m> {
    private static void a(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.UX = jSONObject.optInt("scene");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = mVar.UX;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "scene", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.m) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.m) bVar, jSONObject);
    }
}
