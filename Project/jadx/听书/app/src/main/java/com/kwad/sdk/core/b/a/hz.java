package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hz implements com.kwad.sdk.core.d<com.kwad.components.core.o.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.o.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.o.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ST = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(bVar.ST)) {
            bVar.ST = "";
        }
        bVar.SU = jSONObject.optLong("load_status");
        bVar.SV = jSONObject.optLong("load_duration_ms");
        bVar.SW = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.SX = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(bVar.SX)) {
            bVar.SX = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.ST != null && !bVar.ST.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", bVar.ST);
        }
        if (bVar.SU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", bVar.SU);
        }
        if (bVar.SV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", bVar.SV);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thread_core_size", bVar.SW);
        if (bVar.SX != null && !bVar.SX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", bVar.SX);
        }
        return jSONObject;
    }
}
