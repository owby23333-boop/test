package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gl implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.b> {
    private static void a(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gp = jSONObject.optLong("lastShowTimestamp");
        bVar.rW = jSONObject.optInt("showInteractCount");
    }

    private static JSONObject b(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = bVar.gp;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        int i2 = bVar.rW;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showInteractCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }
}
