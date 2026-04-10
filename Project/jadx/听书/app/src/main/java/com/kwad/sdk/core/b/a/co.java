package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class co implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.Pj = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(gVar.Pj)) {
            gVar.Pj = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.acb = jSONObject.optInt("adCacheId");
        gVar.NN = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.NN)) {
            gVar.NN = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.Pj != null && !gVar.Pj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", gVar.Pj);
        }
        if (gVar.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", gVar.actionType);
        }
        if (gVar.acb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", gVar.acb);
        }
        if (gVar.NN != null && !gVar.NN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", gVar.NN);
        }
        return jSONObject;
    }
}
