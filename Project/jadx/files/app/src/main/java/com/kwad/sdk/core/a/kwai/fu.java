package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.n> {
    private static void a(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.UY = jSONObject.optBoolean("isPlayAgainScene");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = nVar.UY;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isPlayAgainScene", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.n) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.n) bVar, jSONObject);
    }
}
