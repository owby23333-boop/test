package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bj implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.j> {
    private static void a(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.llsid = jSONObject.optLong("llsid");
        jVar.creativeId = jSONObject.optLong("creative_id");
        jVar.score = jSONObject.optInt("score");
        jVar.ahU = jSONObject.optInt("is_bidding");
        jVar.source = jSONObject.optString("source");
        if (jVar.source == JSONObject.NULL) {
            jVar.source = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = jVar.llsid;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "llsid", j2);
        }
        long j3 = jVar.creativeId;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creative_id", j3);
        }
        int i2 = jVar.score;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "score", i2);
        }
        int i3 = jVar.ahU;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "is_bidding", i3);
        }
        String str = jVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "source", jVar.source);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.j) bVar, jSONObject);
    }
}
