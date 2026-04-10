package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gr implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.um = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.un = jSONObject.optInt("extraRewardStatus");
    }

    private static JSONObject b(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extraRewardType", bVar.um);
        if (bVar.un != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extraRewardStatus", bVar.un);
        }
        return jSONObject;
    }
}
