package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hj implements com.kwad.sdk.core.d<AdMatrixInfo.SplashInfo> {
    private static void a(AdMatrixInfo.SplashInfo splashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        splashInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    private static JSONObject b(AdMatrixInfo.SplashInfo splashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "interactionInfo", splashInfo.interactionInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashInfo) bVar, jSONObject);
    }
}
