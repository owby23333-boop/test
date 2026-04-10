package com.kwad.sdk.core.a.kwai;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fh implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    private static void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.url = jSONObject.optString("url");
        if (jVar.url == JSONObject.NULL) {
            jVar.url = "";
        }
        jVar.host = jSONObject.optString(Constants.KEY_HOST);
        if (jVar.host == JSONObject.NULL) {
            jVar.host = "";
        }
        jVar.httpCode = jSONObject.optInt("http_code");
        jVar.errorMsg = jSONObject.optString("error_msg");
        if (jVar.errorMsg == JSONObject.NULL) {
            jVar.errorMsg = "";
        }
        jVar.age = jSONObject.optString("req_type");
        if (jVar.age == JSONObject.NULL) {
            jVar.age = "";
        }
        jVar.agf = jSONObject.optInt("use_ip");
        jVar.agg = jSONObject.optString("ok_http_version");
        if (jVar.agg == JSONObject.NULL) {
            jVar.agg = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", jVar.url);
        }
        String str2 = jVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_HOST, jVar.host);
        }
        int i2 = jVar.httpCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "http_code", i2);
        }
        String str3 = jVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_msg", jVar.errorMsg);
        }
        String str4 = jVar.age;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "req_type", jVar.age);
        }
        int i3 = jVar.agf;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "use_ip", i3);
        }
        String str5 = jVar.agg;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ok_http_version", jVar.agg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }
}
