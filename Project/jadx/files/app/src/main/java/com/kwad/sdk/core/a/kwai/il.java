package com.kwad.sdk.core.a.kwai;

import com.anythink.core.api.ATAdConst;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class il implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    private static void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (videoInfo.videoUrl == JSONObject.NULL) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (videoInfo.manifest == JSONObject.NULL) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (videoInfo.firstFrame == JSONObject.NULL) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    private static JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j2 = videoInfo.duration;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "duration", j2);
        }
        int i2 = videoInfo.size;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i2);
        }
        int i3 = videoInfo.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", i3);
        }
        int i4 = videoInfo.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", i4);
        }
        double d2 = videoInfo.leftRatio;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "leftRatio", d2);
        }
        double d3 = videoInfo.topRatio;
        if (d3 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "topRatio", d3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.s.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.VideoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.VideoInfo) bVar, jSONObject);
    }
}
