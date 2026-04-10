package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements com.kwad.sdk.core.d<AdBid> {
    private static void a(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        if (adBid.winNoticeUrl == JSONObject.NULL) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (adBid.materialId == JSONObject.NULL) {
            adBid.materialId = "";
        }
    }

    private static JSONObject b(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adBid.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", j2);
        }
        long j3 = adBid.ecpm;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ecpm", j3);
        }
        int i2 = adBid.bidEcpm;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bidEcpm", i2);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdBid) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdBid) bVar, jSONObject);
    }
}
