package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ez implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.c> {
    private static void a(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.arO = new com.kwad.sdk.crash.online.monitor.kwai.a();
        cVar.arO.parseJson(jSONObject.optJSONObject("blockConfig"));
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "blockConfig", cVar.arO);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.kwai.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.kwai.c) bVar, jSONObject);
    }
}
