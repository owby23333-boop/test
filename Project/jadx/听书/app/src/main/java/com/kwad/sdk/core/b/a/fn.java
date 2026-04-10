package com.kwad.sdk.core.b.a;

import com.google.common.net.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fn implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aNt = jSONObject.optString(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
        if (JSONObject.NULL.toString().equals(aVar.aNt)) {
            aVar.aNt = "";
        }
        aVar.aNu = jSONObject.optString(HttpHeaders.TIMING_ALLOW_ORIGIN);
        if (JSONObject.NULL.toString().equals(aVar.aNu)) {
            aVar.aNu = "";
        }
        aVar.aNv = jSONObject.optString("content-type");
        if (JSONObject.NULL.toString().equals(aVar.aNv)) {
            aVar.aNv = "";
        }
        aVar.aNw = jSONObject.optString(HttpHeaders.DATE);
        if (JSONObject.NULL.toString().equals(aVar.aNw)) {
            aVar.aNw = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aNt != null && !aVar.aNt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, aVar.aNt);
        }
        if (aVar.aNu != null && !aVar.aNu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, HttpHeaders.TIMING_ALLOW_ORIGIN, aVar.aNu);
        }
        if (aVar.aNv != null && !aVar.aNv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content-type", aVar.aNv);
        }
        if (aVar.aNw != null && !aVar.aNw.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, HttpHeaders.DATE, aVar.aNw);
        }
        return jSONObject;
    }
}
