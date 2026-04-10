package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bm implements com.kwad.sdk.core.d<e.a> {
    private static void a(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xq = jSONObject.optBoolean("forceClose");
    }

    private static JSONObject b(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = aVar.xq;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "forceClose", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((e.a) bVar, jSONObject);
    }
}
