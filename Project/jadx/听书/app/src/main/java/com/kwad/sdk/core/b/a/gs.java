package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gs implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcQ = jSONObject.optInt("put_count");
        aVar.bcR = jSONObject.optInt("get_failed_count");
        aVar.bcS = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bcQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "put_count", aVar.bcQ);
        }
        if (aVar.bcR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_failed_count", aVar.bcR);
        }
        if (aVar.bcS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_success_count", aVar.bcS);
        }
        return jSONObject;
    }
}
