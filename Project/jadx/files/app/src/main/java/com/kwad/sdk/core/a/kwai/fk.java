package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.l> {
    private static void a(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.url = jSONObject.optString("url");
        if (lVar.url == JSONObject.NULL) {
            lVar.url = "";
        }
        lVar.title = jSONObject.optString("title");
        if (lVar.title == JSONObject.NULL) {
            lVar.title = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", lVar.url);
        }
        String str2 = lVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", lVar.title);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.l) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.l) bVar, jSONObject);
    }
}
