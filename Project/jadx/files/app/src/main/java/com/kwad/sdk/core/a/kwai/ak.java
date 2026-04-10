package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ak implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    private static void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (adWebCardInfo.cardUrl == JSONObject.NULL) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (adWebCardInfo.cardData == JSONObject.NULL) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    private static JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = adWebCardInfo.typeLandscape;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "typeLandscape", j2);
        }
        long j3 = adWebCardInfo.typePortrait;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "typePortrait", j3);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i2 = adWebCardInfo.cardShowPlayCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardShowPlayCount", i2);
        }
        long j4 = adWebCardInfo.cardShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardShowTime", j4);
        }
        long j5 = adWebCardInfo.cardDelayTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardDelayTime", j5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }
}
