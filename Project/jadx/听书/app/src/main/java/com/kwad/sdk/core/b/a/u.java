package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements com.kwad.sdk.core.d<com.kwad.components.core.l.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.l.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.l.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Rr = jSONObject.optInt("currentActiveCount");
        aVar.Rs = jSONObject.optLong("lastForceActiveTimestamp");
    }

    private static JSONObject b(com.kwad.components.core.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.Rr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentActiveCount", aVar.Rr);
        }
        if (aVar.Rs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastForceActiveTimestamp", aVar.Rs);
        }
        return jSONObject;
    }
}
