package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.b.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class iq implements com.kwad.sdk.core.d<h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.b) bVar, jSONObject);
    }

    private static void a(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.agy = jSONObject.optInt("playEndType");
    }

    private static JSONObject b(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.agy != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playEndType", bVar.agy);
        }
        return jSONObject;
    }
}
