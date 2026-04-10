package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class dq implements com.kwad.sdk.core.d<a.C0353a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0353a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0353a) bVar, jSONObject);
    }

    private static void a(a.C0353a c0353a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0353a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0353a.url)) {
            c0353a.url = "";
        }
        c0353a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0353a.packageName)) {
            c0353a.packageName = "";
        }
    }

    private static JSONObject b(a.C0353a c0353a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0353a.url != null && !c0353a.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0353a.url);
        }
        if (c0353a.packageName != null && !c0353a.packageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", c0353a.packageName);
        }
        return jSONObject;
    }
}
