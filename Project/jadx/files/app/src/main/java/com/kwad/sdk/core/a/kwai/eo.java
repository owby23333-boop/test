package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eo implements com.kwad.sdk.core.d<com.kwad.sdk.utils.a.a> {
    private static void a(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aBC = jSONObject.optInt("put_count");
        aVar.aBD = jSONObject.optInt("get_failed_count");
        aVar.aBE = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.aBC;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "put_count", i2);
        }
        int i3 = aVar.aBD;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "get_failed_count", i3);
        }
        int i4 = aVar.aBE;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "get_success_count", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.a.a) bVar, jSONObject);
    }
}
