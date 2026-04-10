package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ac implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    private static void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
    }

    private static JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i2 = adRewardInfo.showLandingPage;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLandingPage", i2);
        }
        boolean z2 = adRewardInfo.rewardVideoEndCardSwitch;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardVideoEndCardSwitch", z2);
        }
        boolean z3 = adRewardInfo.recommendAggregateSwitch;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "recommendAggregateSwitch", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdRewardInfo) bVar, jSONObject);
    }
}
