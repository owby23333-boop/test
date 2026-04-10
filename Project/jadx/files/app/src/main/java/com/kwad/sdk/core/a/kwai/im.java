package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class im implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.w> {
    private static void a(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        wVar.Vg = jSONObject.optString("status");
        if (wVar.Vg == JSONObject.NULL) {
            wVar.Vg = "";
        }
        wVar.errorCode = jSONObject.optInt("errorCode");
        wVar.errorReason = jSONObject.optString("errorReason");
        if (wVar.errorReason == JSONObject.NULL) {
            wVar.errorReason = "";
        }
        wVar.nW = jSONObject.optInt("currentTime");
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = wVar.Vg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", wVar.Vg);
        }
        int i2 = wVar.errorCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "errorCode", i2);
        }
        String str2 = wVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "errorReason", wVar.errorReason);
        }
        int i3 = wVar.nW;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentTime", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.w) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.w) bVar, jSONObject);
    }
}
