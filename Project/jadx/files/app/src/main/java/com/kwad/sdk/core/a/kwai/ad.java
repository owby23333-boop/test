package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ad implements com.kwad.sdk.core.d<AdInfo.AdShowVideoH5Info> {
    private static void a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adShowVideoH5Info.showPageType = jSONObject.optInt("showPageType");
        adShowVideoH5Info.videoAutoLoopAtH5 = jSONObject.optBoolean("videoAutoLoopAtH5");
        adShowVideoH5Info.videoMutedAtH5 = jSONObject.optBoolean("videoMutedAtH5");
        adShowVideoH5Info.videoClickAtH5 = jSONObject.optBoolean("videoClickAtH5");
    }

    private static JSONObject b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adShowVideoH5Info.showPageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showPageType", i2);
        }
        boolean z2 = adShowVideoH5Info.videoAutoLoopAtH5;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoAutoLoopAtH5", z2);
        }
        boolean z3 = adShowVideoH5Info.videoMutedAtH5;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoMutedAtH5", z3);
        }
        boolean z4 = adShowVideoH5Info.videoClickAtH5;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoClickAtH5", z4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdShowVideoH5Info) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdShowVideoH5Info) bVar, jSONObject);
    }
}
