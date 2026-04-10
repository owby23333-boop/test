package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.q> {
    private static void a(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.templateId = jSONObject.optString("templateId");
        if (qVar.templateId == JSONObject.NULL) {
            qVar.templateId = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = qVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateId", qVar.templateId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.q) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.q) bVar, jSONObject);
    }
}
