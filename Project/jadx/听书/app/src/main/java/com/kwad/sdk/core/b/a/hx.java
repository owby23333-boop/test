package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.i) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString("host");
        if (JSONObject.NULL.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt("http_code");
        iVar.aEH = jSONObject.optString("req_type");
        if (JSONObject.NULL.toString().equals(iVar.aEH)) {
            iVar.aEH = "";
        }
        iVar.aEI = jSONObject.optInt("use_ip");
    }

    private static JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (iVar.url != null && !iVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", iVar.url);
        }
        if (iVar.host != null && !iVar.host.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host", iVar.host);
        }
        if (iVar.httpCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "http_code", iVar.httpCode);
        }
        if (iVar.aEH != null && !iVar.aEH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "req_type", iVar.aEH);
        }
        if (iVar.aEI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "use_ip", iVar.aEI);
        }
        return jSONObject;
    }
}
