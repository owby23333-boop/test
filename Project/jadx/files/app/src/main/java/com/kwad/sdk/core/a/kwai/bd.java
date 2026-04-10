package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bd implements com.kwad.sdk.core.d<AdMatrixInfo.BottomBannerInfo> {
    private static void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bottomBannerInfo.bannerSizeType = jSONObject.optInt("bannerSizeType");
        bottomBannerInfo.bannerAdType = jSONObject.optInt("bannerAdType");
    }

    private static JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bottomBannerInfo.bannerSizeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bannerSizeType", i2);
        }
        int i3 = bottomBannerInfo.bannerAdType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bannerAdType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.BottomBannerInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.BottomBannerInfo) bVar, jSONObject);
    }
}
