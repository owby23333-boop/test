package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.p> {
    private static void a(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.Va = jSONObject.optBoolean("userForce");
        pVar.type = jSONObject.optInt("type");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = pVar.Va;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "userForce", z2);
        }
        int i2 = pVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.p) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.p) bVar, jSONObject);
    }
}
