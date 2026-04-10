package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.agU = jSONObject.optInt("hasInstalled");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.agU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasInstalled", bVar.agU);
        }
        return jSONObject;
    }
}
