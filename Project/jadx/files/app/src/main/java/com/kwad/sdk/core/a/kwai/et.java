package com.kwad.sdk.core.a.kwai;

import com.arialyy.aria.core.inf.IOptionConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class et implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.b> {
    private static void a(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (bVar.contentEncoding == JSONObject.NULL) {
            bVar.contentEncoding = "";
        }
        bVar.apr = jSONObject.optString("Cache-Control");
        if (bVar.apr == JSONObject.NULL) {
            bVar.apr = "";
        }
        bVar.app = jSONObject.optString("Content-Type");
        if (bVar.app == JSONObject.NULL) {
            bVar.app = "";
        }
        bVar.aps = new com.kwad.sdk.core.webview.a.kwai.a();
        bVar.aps.parseJson(jSONObject.optJSONObject(IOptionConstant.headers));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Status", i2);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.apr;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Cache-Control", bVar.apr);
        }
        String str3 = bVar.app;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "Content-Type", bVar.app);
        }
        com.kwad.sdk.utils.s.a(jSONObject, IOptionConstant.headers, bVar.aps);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.a.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.a.kwai.b) bVar, jSONObject);
    }
}
