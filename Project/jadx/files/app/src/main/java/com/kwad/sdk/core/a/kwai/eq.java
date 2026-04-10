package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.af;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eq implements com.kwad.sdk.core.d<af.a> {
    private static void a(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (aVar.displayWatchingUserCount == JSONObject.NULL) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (aVar.displayLikeUserCount == JSONObject.NULL) {
            aVar.displayLikeUserCount = "";
        }
    }

    private static JSONObject b(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        long j2 = aVar.totalWatchingDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "totalWatchingDuration", j2);
        }
        int i3 = aVar.watchingUserCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "watchingUserCount", i3);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j3 = aVar.liveDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "liveDuration", j3);
        }
        int i4 = aVar.likeUserCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "likeUserCount", i4);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((af.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((af.a) bVar, jSONObject);
    }
}
