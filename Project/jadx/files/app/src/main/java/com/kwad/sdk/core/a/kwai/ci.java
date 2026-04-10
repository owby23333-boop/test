package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.kwai.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ci implements com.kwad.sdk.core.d<a.C0420a> {
    private static void a(a.C0420a c0420a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0420a.url = jSONObject.optString("url");
        if (c0420a.url == JSONObject.NULL) {
            c0420a.url = "";
        }
        c0420a.packageName = jSONObject.optString("packageName");
        if (c0420a.packageName == JSONObject.NULL) {
            c0420a.packageName = "";
        }
    }

    private static JSONObject b(a.C0420a c0420a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0420a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", c0420a.url);
        }
        String str2 = c0420a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageName", c0420a.packageName);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0420a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0420a) bVar, jSONObject);
    }
}
