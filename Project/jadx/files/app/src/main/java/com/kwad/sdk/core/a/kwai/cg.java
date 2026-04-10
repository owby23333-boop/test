package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cg implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt(com.anythink.expressad.foundation.h.i.f10647e);
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (detailWebCardInfo.cardUrl == JSONObject.NULL) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (detailWebCardInfo.cardData == JSONObject.NULL) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = detailWebCardInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.h.i.f10647e, i2);
        }
        long j2 = detailWebCardInfo.maxTimeOut;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxTimeOut", j2);
        }
        long j3 = detailWebCardInfo.typeLandscape;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "typeLandscape", j3);
        }
        long j4 = detailWebCardInfo.typePortrait;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "typePortrait", j4);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j5 = detailWebCardInfo.cardShowTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardShowTime", j5);
        }
        int i3 = detailWebCardInfo.cardType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }
}
