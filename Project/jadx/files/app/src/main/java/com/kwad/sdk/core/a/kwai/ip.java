package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ip implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.x> {
    private static void a(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.nW = jSONObject.optInt("currentTime");
        xVar.Vh = jSONObject.optBoolean("failed");
        xVar.Vd = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = xVar.nW;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentTime", i2);
        }
        boolean z2 = xVar.Vh;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "failed", z2);
        }
        boolean z3 = xVar.Vd;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "finished", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.x) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.x) bVar, jSONObject);
    }
}
