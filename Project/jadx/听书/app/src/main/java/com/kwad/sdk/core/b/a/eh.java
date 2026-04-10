package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class eh implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aQf = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.aQf)) {
            bVar.aQf = "";
        }
        bVar.aQg = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.aQg)) {
            bVar.aQg = "";
        }
        bVar.aQh = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.aQh)) {
            bVar.aQh = "";
        }
        bVar.aQi = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aQi)) {
            bVar.aQi = "";
        }
        bVar.aQj = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aQj)) {
            bVar.aQj = "";
        }
        bVar.aQk = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.aQk)) {
            bVar.aQk = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.appId != null && !bVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", bVar.appId);
        }
        if (bVar.aQf != null && !bVar.aQf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pluginListenerName", bVar.aQf);
        }
        if (bVar.aQg != null && !bVar.aQg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportMethodName", bVar.aQg);
        }
        if (bVar.aQh != null && !bVar.aQh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherProxyClassName", bVar.aQh);
        }
        if (bVar.aQi != null && !bVar.aQi.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherFieldName", bVar.aQi);
        }
        if (bVar.aQj != null && !bVar.aQj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherLevelFieldName", bVar.aQj);
        }
        if (bVar.aQk != null && !bVar.aQk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTag", bVar.aQk);
        }
        return jSONObject;
    }
}
