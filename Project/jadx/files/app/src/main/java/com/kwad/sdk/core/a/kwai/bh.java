package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bh implements com.kwad.sdk.core.d<q.a> {
    private static void a(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ajq = jSONObject.optInt("posIdWidth");
        aVar.ajr = jSONObject.optInt("posIdHeight");
    }

    private static JSONObject b(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.ajq;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posIdWidth", i2);
        }
        int i3 = aVar.ajr;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posIdHeight", i3);
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
