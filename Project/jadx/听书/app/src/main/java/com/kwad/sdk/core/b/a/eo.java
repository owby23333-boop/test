package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class eo implements com.kwad.sdk.core.d<FeedWebViewInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedWebViewInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedWebViewInfo) bVar, jSONObject);
    }

    private static void a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedWebViewInfo.event = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.event)) {
            feedWebViewInfo.event = "";
        }
        feedWebViewInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.url)) {
            feedWebViewInfo.url = "";
        }
        feedWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.sceneId)) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    private static JSONObject b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedWebViewInfo.event != null && !feedWebViewInfo.event.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_EVENT, feedWebViewInfo.event);
        }
        if (feedWebViewInfo.url != null && !feedWebViewInfo.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", feedWebViewInfo.url);
        }
        if (feedWebViewInfo.sceneId != null && !feedWebViewInfo.sceneId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "scene_id", feedWebViewInfo.sceneId);
        }
        if (feedWebViewInfo.durationMs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration_ms", feedWebViewInfo.durationMs);
        }
        if (feedWebViewInfo.timeType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "time_type", feedWebViewInfo.timeType);
        }
        return jSONObject;
    }
}
