package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cq implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.EndTopToolBarInfo> {
    private static void a(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (endTopToolBarInfo.callButtonDescription == JSONObject.NULL) {
            endTopToolBarInfo.callButtonDescription = "";
        }
        endTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (endTopToolBarInfo.rewardIconUrl == JSONObject.NULL) {
            endTopToolBarInfo.rewardIconUrl = "";
        }
    }

    private static JSONObject b(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = endTopToolBarInfo.callButtonDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "callButtonDescription", endTopToolBarInfo.callButtonDescription);
        }
        String str2 = endTopToolBarInfo.rewardIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rewardIconUrl", endTopToolBarInfo.rewardIconUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo.EndTopToolBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo.EndTopToolBarInfo) bVar, jSONObject);
    }
}
