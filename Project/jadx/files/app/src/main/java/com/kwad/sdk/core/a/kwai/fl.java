package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.kwai.c> {
    private static void a(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.RX = jSONObject.optString("originalID");
        if (cVar.RX == JSONObject.NULL) {
            cVar.RX = "";
        }
        cVar.RY = jSONObject.optString("path");
        if (cVar.RY == JSONObject.NULL) {
            cVar.RY = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.RX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "originalID", cVar.RX);
        }
        String str2 = cVar.RY;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "path", cVar.RY);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.kwai.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.kwai.c) bVar, jSONObject);
    }
}
