package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gz implements com.kwad.sdk.core.d<q.a> {
    private static void a(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xy = jSONObject.optBoolean("needCloseNeo");
    }

    private static JSONObject b(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = aVar.xy;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "needCloseNeo", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((q.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((q.a) bVar, jSONObject);
    }
}
