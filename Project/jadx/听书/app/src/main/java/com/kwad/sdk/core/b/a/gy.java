package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aha = jSONObject.optInt("convertType");
        dVar.Pj = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(dVar.Pj)) {
            dVar.Pj = "";
        }
        dVar.aNT = new com.kwad.sdk.core.webview.d.b.c();
        dVar.aNT.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aha != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", dVar.aha);
        }
        if (dVar.Pj != null && !dVar.Pj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", dVar.Pj);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clickInfo", dVar.aNT);
        return jSONObject;
    }
}
