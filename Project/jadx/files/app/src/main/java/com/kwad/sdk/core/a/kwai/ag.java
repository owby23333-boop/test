package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ag implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    private static void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardReflowSwitch = jSONObject.optBoolean("rewardReflowSwitch", new Boolean(ITagManager.STATUS_TRUE).booleanValue());
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        adStyleConfInfo.adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        adStyleConfInfo.nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
    }

    private static JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j2 = adStyleConfInfo.closeDelaySeconds;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "closeDelaySeconds", j2);
        }
        long j3 = adStyleConfInfo.playableCloseSeconds;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableCloseSeconds", j3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "rewardReflowSwitch", adStyleConfInfo.rewardReflowSwitch);
        boolean z2 = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardVideoInteractSwitch", z2);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z3 = adStyleConfInfo.adPushSwitch;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adPushSwitch", z3);
        }
        int i2 = adStyleConfInfo.adPushShowAfterTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adPushShowAfterTime", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.s.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z4 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "useNativeForOuterLiveAd", z4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdStyleConfInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdStyleConfInfo) bVar, jSONObject);
    }
}
