package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gq implements com.kwad.sdk.core.d<RewardWebViewInfo> {
    private static void a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebViewInfo.event = jSONObject.optString("event");
        if (rewardWebViewInfo.event == JSONObject.NULL) {
            rewardWebViewInfo.event = "";
        }
        rewardWebViewInfo.status = jSONObject.optInt("status");
        rewardWebViewInfo.url = jSONObject.optString("url");
        if (rewardWebViewInfo.url == JSONObject.NULL) {
            rewardWebViewInfo.url = "";
        }
        rewardWebViewInfo.source = jSONObject.optString("source");
        if (rewardWebViewInfo.source == JSONObject.NULL) {
            rewardWebViewInfo.source = "";
        }
        rewardWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (rewardWebViewInfo.sceneId == JSONObject.NULL) {
            rewardWebViewInfo.sceneId = "";
        }
        rewardWebViewInfo.pageType = jSONObject.optString("page_type");
        if (rewardWebViewInfo.pageType == JSONObject.NULL) {
            rewardWebViewInfo.pageType = "";
        }
        rewardWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        rewardWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    private static JSONObject b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "event", rewardWebViewInfo.event);
        }
        int i2 = rewardWebViewInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        String str2 = rewardWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        String str3 = rewardWebViewInfo.source;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "source", rewardWebViewInfo.source);
        }
        String str4 = rewardWebViewInfo.sceneId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "scene_id", rewardWebViewInfo.sceneId);
        }
        String str5 = rewardWebViewInfo.pageType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        long j2 = rewardWebViewInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "duration_ms", j2);
        }
        int i3 = rewardWebViewInfo.timeType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "time_type", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardWebViewInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardWebViewInfo) bVar, jSONObject);
    }
}
