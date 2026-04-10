package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.webview.c.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gj implements com.kwad.sdk.core.d<b.a> {
    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.url = jSONObject.optString("url");
        if (aVar.url == JSONObject.NULL) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString("method");
        if (aVar.method == JSONObject.NULL) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString("params");
        if (aVar.params == JSONObject.NULL) {
            aVar.params = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", aVar.url);
        }
        String str2 = aVar.method;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "method", aVar.method);
        }
        String str3 = aVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "params", aVar.params);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }
}
