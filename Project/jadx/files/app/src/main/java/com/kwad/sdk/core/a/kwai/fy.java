package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.a.kwai.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fy implements com.kwad.sdk.core.d<h.b> {
    private static void a(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Uy = jSONObject.optInt("playEndType");
    }

    private static JSONObject b(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.Uy;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playEndType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.b) bVar, jSONObject);
    }
}
