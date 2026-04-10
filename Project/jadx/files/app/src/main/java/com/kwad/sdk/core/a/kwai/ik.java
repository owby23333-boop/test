package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ik implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.v> {
    private static void a(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.Vf = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "videoCloseTime", vVar.Vf);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.v) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.v) bVar, jSONObject);
    }
}
