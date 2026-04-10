package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fx implements com.kwad.sdk.core.d<m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((m.a) bVar, jSONObject);
    }

    private static void a(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.acu = jSONObject.optString("apkUrl");
        if (JSONObject.NULL.toString().equals(aVar.acu)) {
            aVar.acu = "";
        }
        aVar.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(aVar.packageName)) {
            aVar.packageName = "";
        }
    }

    private static JSONObject b(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.acu != null && !aVar.acu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apkUrl", aVar.acu);
        }
        if (aVar.packageName != null && !aVar.packageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", aVar.packageName);
        }
        return jSONObject;
    }
}
