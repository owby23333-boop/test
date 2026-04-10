package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class en implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.b.b> {
    private static void a(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.rR = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.rS = jSONObject.optInt("extraRewardStatus");
    }

    private static JSONObject b(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "extraRewardType", bVar.rR);
        int i2 = bVar.rS;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "extraRewardStatus", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.b.b) bVar, jSONObject);
    }
}
