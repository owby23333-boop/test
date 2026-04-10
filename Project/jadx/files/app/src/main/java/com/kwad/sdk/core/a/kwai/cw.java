package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cw implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.b> {
    private static void a(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u);
        if (bVar.appId == JSONObject.NULL) {
            bVar.appId = "";
        }
        bVar.arI = jSONObject.optString("pluginListenerName");
        if (bVar.arI == JSONObject.NULL) {
            bVar.arI = "";
        }
        bVar.arJ = jSONObject.optString("reportMethodName");
        if (bVar.arJ == JSONObject.NULL) {
            bVar.arJ = "";
        }
        bVar.arK = jSONObject.optString("otherProxyClassName");
        if (bVar.arK == JSONObject.NULL) {
            bVar.arK = "";
        }
        bVar.arL = jSONObject.optString("otherFieldName");
        if (bVar.arL == JSONObject.NULL) {
            bVar.arL = "";
        }
        bVar.arM = jSONObject.optString("otherLevelFieldName");
        if (bVar.arM == JSONObject.NULL) {
            bVar.arM = "";
        }
        bVar.arN = jSONObject.optString("blockTag");
        if (bVar.arN == JSONObject.NULL) {
            bVar.arN = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.videocommon.e.b.f12231u, bVar.appId);
        }
        String str2 = bVar.arI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pluginListenerName", bVar.arI);
        }
        String str3 = bVar.arJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "reportMethodName", bVar.arJ);
        }
        String str4 = bVar.arK;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "otherProxyClassName", bVar.arK);
        }
        String str5 = bVar.arL;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "otherFieldName", bVar.arL);
        }
        String str6 = bVar.arM;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "otherLevelFieldName", bVar.arM);
        }
        String str7 = bVar.arN;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blockTag", bVar.arN);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.kwai.b) bVar, jSONObject);
    }
}
