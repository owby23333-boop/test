package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fl implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aRf = jSONObject.optInt("apiLevel");
        aVar.aRg = jSONObject.optInt("colorModeSupport");
        aVar.aRh = jSONObject.optInt("screenHdrAvailable");
        aVar.aRi = jSONObject.optInt("hdrSupport");
    }

    private static JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aRf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiLevel", aVar.aRf);
        }
        if (aVar.aRg != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "colorModeSupport", aVar.aRg);
        }
        if (aVar.aRh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHdrAvailable", aVar.aRh);
        }
        if (aVar.aRi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hdrSupport", aVar.aRi);
        }
        return jSONObject;
    }
}
