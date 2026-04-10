package com.kwad.sdk.core.a.kwai;

import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dw implements com.kwad.sdk.core.d<HybridLoadMsg> {
    private static void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString("scene_id");
        if (hybridLoadMsg.sceneId == JSONObject.NULL) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (hybridLoadMsg.h5Version == JSONObject.NULL) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt(CallMraidJS.b);
        hybridLoadMsg.interval = jSONObject.optString(com.umeng.analytics.pro.am.aU);
        if (hybridLoadMsg.interval == JSONObject.NULL) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (hybridLoadMsg.failReason == JSONObject.NULL) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (hybridLoadMsg.url == JSONObject.NULL) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (hybridLoadMsg.packageUrl == JSONObject.NULL) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    private static JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = hybridLoadMsg.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "scene_id", hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i2 = hybridLoadMsg.loadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "load_type", i2);
        }
        int i3 = hybridLoadMsg.state;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, CallMraidJS.b, i3);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.umeng.analytics.pro.am.aU, hybridLoadMsg.interval);
        }
        int i4 = hybridLoadMsg.failState;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fail_state", i4);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HybridLoadMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HybridLoadMsg) bVar, jSONObject);
    }
}
