package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class el implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.i) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.agZ = jSONObject.optInt("motionType");
        iVar.aha = jSONObject.optInt("convertType");
        iVar.ahb = jSONObject.optString("convertSensitivity");
        if (JSONObject.NULL.toString().equals(iVar.ahb)) {
            iVar.ahb = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (iVar.agZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "motionType", iVar.agZ);
        }
        if (iVar.aha != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", iVar.aha);
        }
        if (iVar.ahb != null && !iVar.ahb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertSensitivity", iVar.ahb);
        }
        return jSONObject;
    }
}
