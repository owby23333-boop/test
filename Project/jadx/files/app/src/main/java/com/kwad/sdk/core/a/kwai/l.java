package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    private static void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (adConversionInfo.h5Url == JSONObject.NULL) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (adConversionInfo.deeplinkUrl == JSONObject.NULL) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (adConversionInfo.deeplinkExtra == JSONObject.NULL) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (adConversionInfo.appDownloadUrl == JSONObject.NULL) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (adConversionInfo.marketUrl == JSONObject.NULL) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (adConversionInfo.playableUrl == JSONObject.NULL) {
            adConversionInfo.playableUrl = "";
        }
        adConversionInfo.playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (adConversionInfo.callbackUrl == JSONObject.NULL) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (adConversionInfo.callbackUrlInfo == JSONObject.NULL) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
    }

    private static JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        int i2 = adConversionInfo.h5Type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "h5Type", i2);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        String str4 = adConversionInfo.appDownloadUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str5 = adConversionInfo.marketUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        int i3 = adConversionInfo.supportThirdDownload;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "supportThirdDownload", i3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str6 = adConversionInfo.playableUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i4 = adConversionInfo.webUriSourceType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "webUriSourceType", i4);
        }
        String str7 = adConversionInfo.callbackUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str8 = adConversionInfo.callbackUrlInfo;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z2 = adConversionInfo.blockCallbackIfSpam;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blockCallbackIfSpam", z2);
        }
        boolean z3 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "needDeeplinkReplaceAdapta", z3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.s.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdConversionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdConversionInfo) bVar, jSONObject);
    }
}
