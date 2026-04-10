package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class db implements com.kwad.sdk.core.d<FeedWebViewInfo> {
    private static void a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedWebViewInfo.event = jSONObject.optString("event");
        if (feedWebViewInfo.event == JSONObject.NULL) {
            feedWebViewInfo.event = "";
        }
        feedWebViewInfo.url = jSONObject.optString("url");
        if (feedWebViewInfo.url == JSONObject.NULL) {
            feedWebViewInfo.url = "";
        }
        feedWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (feedWebViewInfo.sceneId == JSONObject.NULL) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    private static JSONObject b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "event", feedWebViewInfo.event);
        }
        String str2 = feedWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", feedWebViewInfo.url);
        }
        String str3 = feedWebViewInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "scene_id", feedWebViewInfo.sceneId);
        }
        long j2 = feedWebViewInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "duration_ms", j2);
        }
        int i2 = feedWebViewInfo.timeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "time_type", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedWebViewInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedWebViewInfo) bVar, jSONObject);
    }
}
