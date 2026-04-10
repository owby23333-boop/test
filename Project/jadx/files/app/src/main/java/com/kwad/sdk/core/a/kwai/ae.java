package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ae implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    private static void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (adSplashInfo.skipTips == JSONObject.NULL) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (adSplashInfo.speakerMuteIconUrl == JSONObject.NULL) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (adSplashInfo.speakerIconUrl == JSONObject.NULL) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
    }

    private static JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.s.putValue(jSONObject, "mute", adSplashInfo.mute);
        int i2 = adSplashInfo.skipType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "skipType", i2);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.s.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i3 = adSplashInfo.countdownShow;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "countdownShow", i3);
        }
        int i4 = adSplashInfo.fullScreenClickSwitch;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fullScreenClickSwitch", i4);
        }
        int i5 = adSplashInfo.skipButtonPosition;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "skipButtonPosition", i5);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i6 = adSplashInfo.skipSecond;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "skipSecond", i6);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdSplashInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdSplashInfo) bVar, jSONObject);
    }
}
