package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gn implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoInteractInfo> {
    private static void a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoInteractInfo.templateId = jSONObject.optString("templateId");
        if (rewardVideoInteractInfo.templateId == JSONObject.NULL) {
            rewardVideoInteractInfo.templateId = "";
        }
        rewardVideoInteractInfo.showTime = jSONObject.optInt("showTime", new Integer(AgooConstants.ACK_PACK_ERROR).intValue());
        rewardVideoInteractInfo.duration = jSONObject.optInt("duration", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
        rewardVideoInteractInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("5").intValue());
        rewardVideoInteractInfo.intervalShow = jSONObject.optInt("intervalShow", new Integer("3").intValue());
        rewardVideoInteractInfo.dayMaxLimit = jSONObject.optInt("dayMaxLimit", new Integer("2").intValue());
        rewardVideoInteractInfo.style = jSONObject.optInt(com.anythink.expressad.foundation.h.i.f10647e);
        rewardVideoInteractInfo.successfulMsg = jSONObject.optString("successfulMsg");
        if (rewardVideoInteractInfo.successfulMsg == JSONObject.NULL) {
            rewardVideoInteractInfo.successfulMsg = "";
        }
        rewardVideoInteractInfo.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
        if (rewardVideoInteractInfo.errorMsg == JSONObject.NULL) {
            rewardVideoInteractInfo.errorMsg = "";
        }
        rewardVideoInteractInfo.styleInfo = new AdMatrixInfo.StyleInfo();
        rewardVideoInteractInfo.styleInfo.parseJson(jSONObject.optJSONObject("styleInfo"));
    }

    private static JSONObject b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoInteractInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateId", rewardVideoInteractInfo.templateId);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "showTime", rewardVideoInteractInfo.showTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "duration", rewardVideoInteractInfo.duration);
        com.kwad.sdk.utils.s.putValue(jSONObject, "rewardTime", rewardVideoInteractInfo.rewardTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "intervalShow", rewardVideoInteractInfo.intervalShow);
        com.kwad.sdk.utils.s.putValue(jSONObject, "dayMaxLimit", rewardVideoInteractInfo.dayMaxLimit);
        int i2 = rewardVideoInteractInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.h.i.f10647e, i2);
        }
        String str2 = rewardVideoInteractInfo.successfulMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "successfulMsg", rewardVideoInteractInfo.successfulMsg);
        }
        String str3 = rewardVideoInteractInfo.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ERROR_MSG, rewardVideoInteractInfo.errorMsg);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "styleInfo", rewardVideoInteractInfo.styleInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RewardVideoInteractInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RewardVideoInteractInfo) bVar, jSONObject);
    }
}
