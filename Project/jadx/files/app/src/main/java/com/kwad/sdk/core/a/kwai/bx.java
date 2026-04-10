package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bx implements com.kwad.sdk.core.d<SdkConfigData.CouponActiveConfig> {
    private static void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        couponActiveConfig.title = jSONObject.optString("title");
        if (couponActiveConfig.title == JSONObject.NULL) {
            couponActiveConfig.title = "";
        }
        couponActiveConfig.secondTitle = jSONObject.optString("secondTitle");
        if (couponActiveConfig.secondTitle == JSONObject.NULL) {
            couponActiveConfig.secondTitle = "";
        }
        couponActiveConfig.bottomTitle = jSONObject.optString("bottomTitle");
        if (couponActiveConfig.bottomTitle == JSONObject.NULL) {
            couponActiveConfig.bottomTitle = "";
        }
        couponActiveConfig.videoThreshold = jSONObject.optInt("videoThreshold");
        couponActiveConfig.videoSeconds = jSONObject.optInt("videoSeconds");
        couponActiveConfig.couponOpenConfig = new TemplateConfig();
        couponActiveConfig.couponOpenConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        couponActiveConfig.couponInfoConfig = new TemplateConfig();
        couponActiveConfig.couponInfoConfig.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        couponActiveConfig.activityInfo = new ActivityInfo();
        couponActiveConfig.activityInfo.parseJson(jSONObject.optJSONObject("activityInfo"));
    }

    private static JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = couponActiveConfig.popUpShowTimeSeconds;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "popUpShowTimeSeconds", i2);
        }
        String str = couponActiveConfig.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", couponActiveConfig.title);
        }
        String str2 = couponActiveConfig.secondTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        }
        String str3 = couponActiveConfig.bottomTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        int i3 = couponActiveConfig.videoThreshold;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoThreshold", i3);
        }
        int i4 = couponActiveConfig.videoSeconds;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoSeconds", i4);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.s.a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.s.a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SdkConfigData.CouponActiveConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SdkConfigData.CouponActiveConfig) bVar, jSONObject);
    }
}
