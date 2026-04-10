package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    private static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aln = jSONObject.optInt("adPhotoCountForMedia");
        aVar.alo = jSONObject.optBoolean("enablePreload");
        aVar.alp = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.alq = jSONObject.optInt("adLoadStrategy");
        aVar.alr = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posId", j2);
        }
        int i2 = aVar.aln;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adPhotoCountForMedia", i2);
        }
        boolean z2 = aVar.alo;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enablePreload", z2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "increaseAdLoadTime", aVar.alp);
        int i3 = aVar.alq;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adLoadStrategy", i3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.alr);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }
}
