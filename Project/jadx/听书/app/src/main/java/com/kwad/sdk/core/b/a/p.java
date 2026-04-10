package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.e.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.e.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.awh = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(bVar.awh)) {
            bVar.awh = "";
        }
        bVar.awi = jSONObject.optString("error_data");
        if (JSONObject.NULL.toString().equals(bVar.awi)) {
            bVar.awi = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.awh != null && !bVar.awh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_name", bVar.awh);
        }
        if (bVar.awi != null && !bVar.awi.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_data", bVar.awi);
        }
        return jSONObject;
    }
}
