package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ee implements com.kwad.sdk.core.d<AdMatrixInfo.InterstitialCardInfo> {
    private static void a(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialCardInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        interstitialCardInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
        interstitialCardInfo.cycleAggregateInfo = new AdMatrixInfo.CycleAggregateInfo();
        interstitialCardInfo.cycleAggregateInfo.parseJson(jSONObject.optJSONObject("cycleAggregateInfo"));
    }

    private static JSONObject b(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "interactionInfo", interstitialCardInfo.interactionInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "cycleAggregateInfo", interstitialCardInfo.cycleAggregateInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.InterstitialCardInfo) bVar, jSONObject);
    }
}
