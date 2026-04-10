package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class go implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoTaskInfo> {
    private static void a(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoTaskInfo.templateId = jSONObject.optString("templateId");
        if (rewardVideoTaskInfo.templateId == JSONObject.NULL) {
            rewardVideoTaskInfo.templateId = "";
        }
        rewardVideoTaskInfo.showTime = jSONObject.optInt("showTime", new Integer(AgooConstants.ACK_PACK_ERROR).intValue());
        rewardVideoTaskInfo.duration = jSONObject.optInt("duration", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
        rewardVideoTaskInfo.taskType = jSONObject.optInt("taskType", new Integer("0").intValue());
        rewardVideoTaskInfo.thresholdTime = jSONObject.optInt("thresholdTime", new Integer(AgooConstants.ACK_REMOVE_PACKAGE).intValue());
    }

    private static JSONObject b(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoTaskInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateId", rewardVideoTaskInfo.templateId);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "showTime", rewardVideoTaskInfo.showTime);
        com.kwad.sdk.utils.s.putValue(jSONObject, "duration", rewardVideoTaskInfo.duration);
        com.kwad.sdk.utils.s.putValue(jSONObject, "taskType", rewardVideoTaskInfo.taskType);
        com.kwad.sdk.utils.s.putValue(jSONObject, "thresholdTime", rewardVideoTaskInfo.thresholdTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RewardVideoTaskInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RewardVideoTaskInfo) bVar, jSONObject);
    }
}
