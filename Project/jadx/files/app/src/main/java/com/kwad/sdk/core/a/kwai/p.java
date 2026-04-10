package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.kwad.sdk.core.d<com.kwad.components.core.i.a> {
    private static void a(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Ke = jSONObject.optInt("currentActiveCount");
        aVar.Kf = jSONObject.optLong("lastForceActiveTimestamp");
    }

    private static JSONObject b(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.Ke;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentActiveCount", i2);
        }
        long j2 = aVar.Kf;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "lastForceActiveTimestamp", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.i.a) bVar, jSONObject);
    }
}
