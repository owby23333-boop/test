package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class mf implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.abE = jSONObject.optString("vse_msg");
        if (JSONObject.NULL.toString().equals(eVar.abE)) {
            eVar.abE = "";
        }
        eVar.abF = jSONObject.optString("vse_simple_msg");
        if (JSONObject.NULL.toString().equals(eVar.abF)) {
            eVar.abF = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.abE != null && !eVar.abE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_msg", eVar.abE);
        }
        if (eVar.abF != null && !eVar.abF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_simple_msg", eVar.abF);
        }
        return jSONObject;
    }
}
