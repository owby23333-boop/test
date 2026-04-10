package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ai implements com.kwad.sdk.core.d<AdTemplate> {
    private static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (adTemplate.mOriginJString == JSONObject.NULL) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (adTemplate.impAdExtra == JSONObject.NULL) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (adTemplate.extra == JSONObject.NULL) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (adTemplate.mUniqueId == JSONObject.NULL) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        adTemplate.mAdScene = new SceneImpl();
        adTemplate.mAdScene.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        adTemplate.mVideoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        adTemplate.mPageInfo = new PageInfo();
        adTemplate.mPageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean(ITagManager.STATUS_FALSE).booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.isPlayAgainData = jSONObject.optBoolean("isPlayAgainData");
        adTemplate.inPlayAgain = jSONObject.optBoolean("inPlayAgain");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean(ITagManager.STATUS_FALSE).booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        adTemplate.mAdStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
    }

    private static JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j2 = adTemplate.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posId", j2);
        }
        int i2 = adTemplate.adStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = adTemplate.type;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i3);
        }
        int i4 = adTemplate.contentType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "contentType", i4);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j3 = adTemplate.llsid;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "llsid", j3);
        }
        boolean z2 = adTemplate.mIsFromContent;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mIsFromContent", z2);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j4 = adTemplate.mBidEcpm;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mBidEcpm", j4);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i5 = adTemplate.realShowType;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "realShowType", i5);
        }
        int i6 = adTemplate.mInitVoiceStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mInitVoiceStatus", i6);
        }
        int i7 = adTemplate.mMediaPlayerType;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mMediaPlayerType", i7);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.s.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.s.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i8 = adTemplate.mIsLeftSlipStatus;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mIsLeftSlipStatus", i8);
        }
        int i9 = adTemplate.mPhotoResponseType;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mPhotoResponseType", i9);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.s.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z3 = adTemplate.mIsAudioEnable;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mIsAudioEnable", z3);
        }
        boolean z4 = adTemplate.mRewardVerifyCalled;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mRewardVerifyCalled", z4);
        }
        boolean z5 = adTemplate.isWebViewDownload;
        if (z5) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isWebViewDownload", z5);
        }
        boolean z6 = adTemplate.isPlayAgainData;
        if (z6) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isPlayAgainData", z6);
        }
        boolean z7 = adTemplate.inPlayAgain;
        if (z7) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "inPlayAgain", z7);
        }
        boolean z8 = adTemplate.watched;
        if (z8) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "watched", z8);
        }
        boolean z9 = adTemplate.converted;
        if (z9) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "converted", z9);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j5 = adTemplate.loadDataTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "loadDataTime", j5);
        }
        long j6 = adTemplate.showStartTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showStartTime", j6);
        }
        boolean z10 = adTemplate.notNetworkRequest;
        if (z10) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "notNetworkRequest", z10);
        }
        long j7 = adTemplate.downloadDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadDuration", j7);
        }
        long j8 = adTemplate.adLoadTotalTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adLoadTotalTime", j8);
        }
        long j9 = adTemplate.adShowStartTimeStamp;
        if (j9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adShowStartTimeStamp", j9);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdTemplate) bVar, jSONObject);
    }
}
