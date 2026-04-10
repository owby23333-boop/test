package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    private static void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (adBaseInfo.liveStreamId == JSONObject.NULL) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (adBaseInfo.sdkExtraData == JSONObject.NULL) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (adBaseInfo.adDescription == JSONObject.NULL) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (adBaseInfo.installAppLabel == JSONObject.NULL) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (adBaseInfo.openAppLabel == JSONObject.NULL) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (adBaseInfo.adMarkIcon == JSONObject.NULL) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (adBaseInfo.adGrayMarkIcon == JSONObject.NULL) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (adBaseInfo.adSourceDescription == JSONObject.NULL) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (adBaseInfo.adActionDescription == JSONObject.NULL) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (adBaseInfo.adActionBarColor == JSONObject.NULL) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (adBaseInfo.appName == JSONObject.NULL) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (adBaseInfo.appIconUrl == JSONObject.NULL) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (adBaseInfo.appPackageName == JSONObject.NULL) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (adBaseInfo.appDownloadCountDesc == JSONObject.NULL) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (adBaseInfo.appCategory == JSONObject.NULL) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (adBaseInfo.appVersion == JSONObject.NULL) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (adBaseInfo.corporationName == JSONObject.NULL) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                adBaseInfo.appImageUrl.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        adBaseInfo.appImageSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (adBaseInfo.appDescription == JSONObject.NULL) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (adBaseInfo.videoPlayedNS == JSONObject.NULL) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (adBaseInfo.productName == JSONObject.NULL) {
            adBaseInfo.productName = "";
        }
        adBaseInfo.mABParams = new ABParams();
        try {
            adBaseInfo.mABParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (adBaseInfo.showUrl == JSONObject.NULL) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (adBaseInfo.clickUrl == JSONObject.NULL) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (adBaseInfo.convUrl == JSONObject.NULL) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        adBaseInfo.apiExpParam = new AdInfo.H5Config();
        adBaseInfo.apiExpParam.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    private static JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adBaseInfo.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", j2);
        }
        int i2 = adBaseInfo.adSourceType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adSourceType", i2);
        }
        String str = adBaseInfo.liveStreamId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        int i3 = adBaseInfo.universeLiveType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "universeLiveType", i3);
        }
        long j3 = adBaseInfo.viewCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "viewCount", j3);
        }
        String str2 = adBaseInfo.sdkExtraData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str3 = adBaseInfo.adDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str4 = adBaseInfo.installAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str5 = adBaseInfo.openAppLabel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str6 = adBaseInfo.adMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str7 = adBaseInfo.adGrayMarkIcon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str8 = adBaseInfo.adSourceDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i4 = adBaseInfo.adOperationType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adOperationType", i4);
        }
        String str9 = adBaseInfo.adActionDescription;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str10 = adBaseInfo.adActionBarColor;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i5 = adBaseInfo.adShowDuration;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adShowDuration", i5);
        }
        String str11 = adBaseInfo.appName;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, adBaseInfo.appName);
        }
        String str12 = adBaseInfo.appIconUrl;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str13 = adBaseInfo.appPackageName;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i6 = adBaseInfo.appScore;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appScore", i6);
        }
        String str14 = adBaseInfo.appDownloadCountDesc;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str15 = adBaseInfo.appCategory;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str16 = adBaseInfo.appVersion;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str17 = adBaseInfo.corporationName;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j4 = adBaseInfo.packageSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageSize", j4);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.s.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str18 = adBaseInfo.appDescription;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i7 = adBaseInfo.enableSkipAd;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enableSkipAd", i7);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.s.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.s.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.s.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i8 = adBaseInfo.skipSecond;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "skipSecond", i8);
        }
        int i9 = adBaseInfo.ecpm;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ecpm", i9);
        }
        String str19 = adBaseInfo.videoPlayedNS;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str20 = adBaseInfo.productName;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str21 = adBaseInfo.showUrl;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str22 = adBaseInfo.clickUrl;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        String str23 = adBaseInfo.convUrl;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i10 = adBaseInfo.adAttributeType;
        if (i10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adAttributeType", i10);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i11 = adBaseInfo.taskType;
        if (i11 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "taskType", i11);
        }
        int i12 = adBaseInfo.campaignType;
        if (i12 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "campaignType", i12);
        }
        int i13 = adBaseInfo.itemType;
        if (i13 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemType", i13);
        }
        int i14 = adBaseInfo.industryFirstLevelId;
        if (i14 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "industryFirstLevelId", i14);
        }
        boolean z2 = adBaseInfo.extraClickReward;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "extraClickReward", z2);
        }
        boolean z3 = adBaseInfo.enableClientProofreadTime;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enableClientProofreadTime", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBaseInfo) bVar, jSONObject);
    }
}
