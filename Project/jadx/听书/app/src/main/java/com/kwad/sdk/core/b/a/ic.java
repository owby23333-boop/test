package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ic implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.abZ = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(cVar.abZ)) {
            cVar.abZ = "";
        }
        cVar.aca = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(cVar.aca)) {
            cVar.aca = "";
        }
        cVar.acb = jSONObject.optInt("adCacheId");
        cVar.NN = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(cVar.NN)) {
            cVar.NN = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.abZ != null && !cVar.abZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originalID", cVar.abZ);
        }
        if (cVar.aca != null && !cVar.aca.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "path", cVar.aca);
        }
        if (cVar.acb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", cVar.acb);
        }
        if (cVar.NN != null && !cVar.NN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", cVar.NN);
        }
        return jSONObject;
    }
}
