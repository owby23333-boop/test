package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class es implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.c> {
    private static void a(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.apK = jSONObject.optInt("convertType");
        cVar.To = jSONObject.optString("payload");
        if (cVar.To == JSONObject.NULL) {
            cVar.To = "";
        }
        cVar.apL = new com.kwad.sdk.core.webview.c.a.b();
        cVar.apL.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = cVar.apK;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "convertType", i2);
        }
        String str = cVar.To;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "payload", cVar.To);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "clickInfo", cVar.apL);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.c.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.c.a.c) bVar, jSONObject);
    }
}
