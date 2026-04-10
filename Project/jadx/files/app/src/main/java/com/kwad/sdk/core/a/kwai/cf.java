package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cf implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (detailTopToolBarInfo.callButtonDescription == JSONObject.NULL) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (detailTopToolBarInfo.rewardIconUrl == JSONObject.NULL) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (detailTopToolBarInfo.rewardCallDescription == JSONObject.NULL) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt(com.anythink.expressad.foundation.h.i.f10647e);
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = detailTopToolBarInfo.callButtonShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "callButtonShowTime", j2);
        }
        String str = detailTopToolBarInfo.callButtonDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        String str2 = detailTopToolBarInfo.rewardIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        String str3 = detailTopToolBarInfo.rewardCallDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        int i2 = detailTopToolBarInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.h.i.f10647e, i2);
        }
        long j3 = detailTopToolBarInfo.maxTimeOut;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxTimeOut", j3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo) bVar, jSONObject);
    }
}
