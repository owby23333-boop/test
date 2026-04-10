package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hr implements com.kwad.sdk.core.d<SplashWebMonitorInfo> {
    private static void a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashWebMonitorInfo.event = jSONObject.optString("event");
        if (splashWebMonitorInfo.event == JSONObject.NULL) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        splashWebMonitorInfo.url = jSONObject.optString("url");
        if (splashWebMonitorInfo.url == JSONObject.NULL) {
            splashWebMonitorInfo.url = "";
        }
        splashWebMonitorInfo.sceneId = jSONObject.optString("scene_id");
        if (splashWebMonitorInfo.sceneId == JSONObject.NULL) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
        splashWebMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (splashWebMonitorInfo.errorMsg == JSONObject.NULL) {
            splashWebMonitorInfo.errorMsg = "";
        }
    }

    private static JSONObject b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashWebMonitorInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "event", splashWebMonitorInfo.event);
        }
        int i2 = splashWebMonitorInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        String str2 = splashWebMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", splashWebMonitorInfo.url);
        }
        String str3 = splashWebMonitorInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "scene_id", splashWebMonitorInfo.sceneId);
        }
        long j2 = splashWebMonitorInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "duration_ms", j2);
        }
        int i3 = splashWebMonitorInfo.timeType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "time_type", i3);
        }
        String str4 = splashWebMonitorInfo.errorMsg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_msg", splashWebMonitorInfo.errorMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashWebMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashWebMonitorInfo) bVar, jSONObject);
    }
}
