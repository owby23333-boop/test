package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.g> {
    private static void a(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.To = jSONObject.optString("payload");
        if (gVar.To == JSONObject.NULL) {
            gVar.To = "";
        }
        gVar.Tn = jSONObject.optInt("actionType");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.To;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "payload", gVar.To);
        }
        int i2 = gVar.Tn;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "actionType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.g) bVar, jSONObject);
    }
}
