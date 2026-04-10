package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bq implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.lY = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.lZ = jSONObject.optInt("cardShowCount");
    }

    private static JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.lY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowCardTimeStamp", bVar.lY);
        }
        if (bVar.lZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowCount", bVar.lZ);
        }
        return jSONObject;
    }
}
