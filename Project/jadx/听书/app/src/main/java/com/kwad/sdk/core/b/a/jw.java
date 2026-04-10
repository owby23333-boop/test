package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.ahk = jSONObject.optBoolean("needPromopt");
        uVar.Ph = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.aci = jSONObject.optLong("playDuration");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (uVar.ahk) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needPromopt", uVar.ahk);
        }
        if (uVar.Ph) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", uVar.Ph);
        }
        if (uVar.showTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", uVar.showTime);
        }
        if (uVar.aci != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", uVar.aci);
        }
        return jSONObject;
    }
}
