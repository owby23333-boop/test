package com.kwad.sdk.core.a.kwai;

import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class av implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.d> {
    private static void a(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.UQ = jSONObject.optBoolean(NativeAdvancedJsUtils.f8241k);
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = dVar.UQ;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NativeAdvancedJsUtils.f8241k, z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.d) bVar, jSONObject);
    }
}
