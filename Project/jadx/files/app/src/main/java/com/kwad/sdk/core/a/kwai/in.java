package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class in implements com.kwad.sdk.core.d<VideoPlayerStatus> {
    private static void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    private static JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = videoPlayerStatus.mVideoPlayerType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mVideoPlayerType", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((VideoPlayerStatus) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((VideoPlayerStatus) bVar, jSONObject);
    }
}
