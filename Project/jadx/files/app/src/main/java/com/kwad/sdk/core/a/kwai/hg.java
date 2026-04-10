package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hg implements com.kwad.sdk.core.d<StatusInfo.SplashAdInfo> {
    private static void a(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashAdInfo.dailyShowCount = jSONObject.optInt("dailyShowCount");
        splashAdInfo.splashStyleControl = new StatusInfo.SplashStyleControl();
        splashAdInfo.splashStyleControl.parseJson(jSONObject.optJSONObject("splashStyleControl"));
    }

    private static JSONObject b(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = splashAdInfo.dailyShowCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "dailyShowCount", i2);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "splashStyleControl", splashAdInfo.splashStyleControl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }
}
