package com.kwad.sdk.core.a.kwai;

import cn.bmob.v3.datatype.up.Params;
import com.umeng.message.utils.HttpRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dt implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.a> {
    private static void a(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.apn = jSONObject.optString("Access-Control-Allow-Origin");
        if (aVar.apn == JSONObject.NULL) {
            aVar.apn = "";
        }
        aVar.apo = jSONObject.optString("Timing-Allow-Origin");
        if (aVar.apo == JSONObject.NULL) {
            aVar.apo = "";
        }
        aVar.app = jSONObject.optString(Params.CONTENT_TYPE);
        if (aVar.app == JSONObject.NULL) {
            aVar.app = "";
        }
        aVar.apq = jSONObject.optString(HttpRequest.HEADER_DATE);
        if (aVar.apq == JSONObject.NULL) {
            aVar.apq = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.apn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.apn);
        }
        String str2 = aVar.apo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Timing-Allow-Origin", aVar.apo);
        }
        String str3 = aVar.app;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Params.CONTENT_TYPE, aVar.app);
        }
        String str4 = aVar.apq;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, HttpRequest.HEADER_DATE, aVar.apq);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.a.kwai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.a.kwai.a) bVar, jSONObject);
    }
}
