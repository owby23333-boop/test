package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fc implements com.kwad.sdk.core.d<AdInfo.NativeAdInfo> {
    private static void a(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdInfo.shakeInfo = new AdInfo.NativeAdShakeInfo();
        nativeAdInfo.shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
    }

    private static JSONObject b(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "shakeInfo", nativeAdInfo.shakeInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.NativeAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.NativeAdInfo) bVar, jSONObject);
    }
}
