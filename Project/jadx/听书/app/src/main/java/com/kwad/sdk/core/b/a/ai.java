package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.axz = jSONObject.optBoolean("retrySwitch");
        cVar.axA = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.axB = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.axC = jSONObject.optInt("retryQueueSize", new Integer("10").intValue());
        cVar.axD = jSONObject.optBoolean("retryCountFeeOnly");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.axz) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retrySwitch", cVar.axz);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountConfig", cVar.axA);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheExpireTime", cVar.axB);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryQueueSize", cVar.axC);
        if (cVar.axD) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountFeeOnly", cVar.axD);
        }
        return jSONObject;
    }
}
