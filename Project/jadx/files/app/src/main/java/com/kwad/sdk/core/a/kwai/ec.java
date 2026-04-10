package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ec implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.a.a> {
    private static void a(com.kwad.components.ad.interstitial.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gp = jSONObject.optLong("lastShowTimestamp");
        aVar.jf = jSONObject.optInt("aggregateAdShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.interstitial.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.gp;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        int i2 = aVar.jf;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "aggregateAdShowCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.a.a) bVar, jSONObject);
    }
}
