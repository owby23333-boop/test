package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ib implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.o> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.o) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.o) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        oVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(oVar.url)) {
            oVar.url = "";
        }
        oVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(oVar.title)) {
            oVar.title = "";
        }
        oVar.ahh = jSONObject.optBoolean("showConfirmDialog");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (oVar.url != null && !oVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", oVar.url);
        }
        if (oVar.title != null && !oVar.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", oVar.title);
        }
        if (oVar.ahh) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showConfirmDialog", oVar.ahh);
        }
        return jSONObject;
    }
}
