package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ay implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    private static void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (baseInfo.sdkExtraData == JSONObject.NULL) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (baseInfo.title == JSONObject.NULL) {
            baseInfo.title = "";
        }
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (baseInfo.shareUrl == JSONObject.NULL) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (baseInfo.recoExt == JSONObject.NULL) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (baseInfo.videoDesc == JSONObject.NULL) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    private static JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = baseInfo.photoId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoId", j2);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", baseInfo.title);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j3 = baseInfo.likeCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "likeCount", j3);
        }
        long j4 = baseInfo.commentCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "commentCount", j4);
        }
        long j5 = baseInfo.viewCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "viewCount", j5);
        }
        long j6 = baseInfo.createTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "createTime", j6);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j7 = baseInfo.playTimes;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playTimes", j7);
        }
        long j8 = baseInfo.videoUrlCacheTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoUrlCacheTime", j8);
        }
        int i2 = baseInfo.contentSourceType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "contentSourceType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.BaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.BaseInfo) bVar, jSONObject);
    }
}
