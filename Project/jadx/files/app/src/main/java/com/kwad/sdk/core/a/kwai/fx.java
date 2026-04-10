package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fx implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    private static void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        playEndInfo.adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        playEndInfo.endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
    }

    private static JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = playEndInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        int i3 = playEndInfo.showLandingPage3;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLandingPage3", i3);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo) bVar, jSONObject);
    }
}
