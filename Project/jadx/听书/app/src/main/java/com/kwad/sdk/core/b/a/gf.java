package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gf implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.jC = jSONObject.optLong("lastShowTimestamp");
        bVar.lW = jSONObject.optInt("currentDailyAdShowCount");
        bVar.lX = jSONObject.optInt("currentDailyRetainShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.jC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowTimestamp", bVar.jC);
        }
        if (bVar.lW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentDailyAdShowCount", bVar.lW);
        }
        if (bVar.lX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentDailyRetainShowCount", bVar.lX);
        }
        return jSONObject;
    }
}
