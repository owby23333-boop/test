package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.f.kwai.kwai.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class id implements com.kwad.sdk.core.d<b.a> {
    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.nT = jSONObject.optInt("timerName");
        aVar.nU = jSONObject.optInt("time");
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.nT;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "timerName", i2);
        }
        int i3 = aVar.nU;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "time", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }
}
