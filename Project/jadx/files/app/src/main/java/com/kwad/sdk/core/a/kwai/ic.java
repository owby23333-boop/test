package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ic implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.e> {
    private static void a(com.kwad.sdk.core.threads.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.ama = jSONObject.optInt("rate_reciprocal");
        eVar.amg = jSONObject.optInt("threshold");
        eVar.interval = jSONObject.optLong(com.umeng.analytics.pro.am.aU);
    }

    private static JSONObject b(com.kwad.sdk.core.threads.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = eVar.ama;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rate_reciprocal", i2);
        }
        int i3 = eVar.amg;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "threshold", i3);
        }
        long j2 = eVar.interval;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.umeng.analytics.pro.am.aU, j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.e) bVar, jSONObject);
    }
}
