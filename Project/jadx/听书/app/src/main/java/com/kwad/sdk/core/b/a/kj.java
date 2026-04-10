package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class kj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.v> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.v) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.v) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.qz = jSONObject.optInt("currentTime");
        vVar.Wy = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (vVar.qz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", vVar.qz);
        }
        if (vVar.Wy) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finished", vVar.Wy);
        }
        return jSONObject;
    }
}
