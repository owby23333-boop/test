package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.o> {
    private static void a(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        oVar.UZ = jSONObject.optBoolean("isEnd");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = oVar.UZ;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isEnd", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.o) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.o) bVar, jSONObject);
    }
}
