package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lv implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (JSONObject.NULL.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (JSONObject.NULL.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (JSONObject.NULL.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt(MediaFormat.KEY_WIDTH);
        videoInfo.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    private static JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (videoInfo.videoUrl != null && !videoInfo.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        if (videoInfo.manifest != null && !videoInfo.manifest.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        if (videoInfo.firstFrame != null && !videoInfo.firstFrame.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        if (videoInfo.duration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", videoInfo.duration);
        }
        if (videoInfo.size != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "size", videoInfo.size);
        }
        if (videoInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, videoInfo.width);
        }
        if (videoInfo.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, videoInfo.height);
        }
        if (videoInfo.leftRatio != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftRatio", videoInfo.leftRatio);
        }
        if (videoInfo.topRatio != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topRatio", videoInfo.topRatio);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
