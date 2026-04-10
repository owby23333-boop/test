package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eu implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    private static void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (materialFeature.materialUrl == JSONObject.NULL) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (materialFeature.coverUrl == JSONObject.NULL) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt("videoDuration");
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (materialFeature.firstFrame == JSONObject.NULL) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (materialFeature.blurBackgroundUrl == JSONObject.NULL) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (materialFeature.webpCoverUrl == JSONObject.NULL) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (materialFeature.ruleId == JSONObject.NULL) {
            materialFeature.ruleId = "";
        }
    }

    private static JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = materialFeature.featureType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "featureType", i2);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j2 = materialFeature.photoId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoId", j2);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i3 = materialFeature.videoDuration;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoDuration", i3);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i4 = materialFeature.videoWidth;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoWidth", i4);
        }
        int i5 = materialFeature.videoHeight;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoHeight", i5);
        }
        long j3 = materialFeature.likeCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "likeCount", j3);
        }
        long j4 = materialFeature.commentCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "commentCount", j4);
        }
        int i6 = materialFeature.source;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "source", i6);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdMaterialInfo.MaterialFeature) bVar, jSONObject);
    }
}
