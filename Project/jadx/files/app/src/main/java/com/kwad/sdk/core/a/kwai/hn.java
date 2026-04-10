package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.t> {
    private static void a(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.nW = jSONObject.optInt("currentTime");
        tVar.Vd = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = tVar.nW;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentTime", i2);
        }
        boolean z2 = tVar.Vd;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.t) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.t) bVar, jSONObject);
    }
}
