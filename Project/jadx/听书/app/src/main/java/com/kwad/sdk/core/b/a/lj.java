package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.h.a.a.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lj implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.qw = jSONObject.optInt("timerName");
        aVar.qx = jSONObject.optInt("time");
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.qw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "timerName", aVar.qw);
        }
        if (aVar.qx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "time", aVar.qx);
        }
        return jSONObject;
    }
}
