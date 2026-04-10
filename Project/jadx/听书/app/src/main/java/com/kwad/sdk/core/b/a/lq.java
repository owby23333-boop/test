package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lq implements com.kwad.sdk.core.d<com.kwad.components.core.o.c.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.o.c.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.o.c.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.ST = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(dVar.ST)) {
            dVar.ST = "";
        }
        dVar.SU = jSONObject.optLong("load_status");
        dVar.SV = jSONObject.optLong("load_duration_ms");
        dVar.SY = jSONObject.optLong("update_duration_ms");
        dVar.SX = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(dVar.SX)) {
            dVar.SX = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.ST != null && !dVar.ST.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", dVar.ST);
        }
        if (dVar.SU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", dVar.SU);
        }
        if (dVar.SV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", dVar.SV);
        }
        if (dVar.SY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "update_duration_ms", dVar.SY);
        }
        if (dVar.SX != null && !dVar.SX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", dVar.SX);
        }
        return jSONObject;
    }
}
