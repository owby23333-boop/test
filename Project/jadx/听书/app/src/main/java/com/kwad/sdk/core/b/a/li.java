package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class li implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aJK = jSONObject.optInt("rate_reciprocal");
        dVar.aJQ = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.an.aU);
    }

    private static JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aJK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate_reciprocal", dVar.aJK);
        }
        if (dVar.aJQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "threshold", dVar.aJQ);
        }
        if (dVar.interval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.an.aU, dVar.interval);
        }
        return jSONObject;
    }
}
