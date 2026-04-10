package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.s> {
    private static void a(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.Vb = jSONObject.optBoolean("needPromopt");
        sVar.Jd = jSONObject.optBoolean("needReport");
        sVar.showTime = jSONObject.optInt("showTime");
        sVar.Vc = jSONObject.optLong("playDuration");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = sVar.Vb;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "needPromopt", z2);
        }
        boolean z3 = sVar.Jd;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "needReport", z3);
        }
        int i2 = sVar.showTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showTime", i2);
        }
        long j2 = sVar.Vc;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playDuration", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.s) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.s) bVar, jSONObject);
    }
}
