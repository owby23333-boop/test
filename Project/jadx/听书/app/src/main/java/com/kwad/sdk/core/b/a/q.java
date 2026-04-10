package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.e.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.e.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.awj = jSONObject.optString("imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.awj)) {
            cVar.awj = "";
        }
        cVar.awk = jSONObject.optString("final_imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.awk)) {
            cVar.awk = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.awj != null && !cVar.awj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imp_ad_info", cVar.awj);
        }
        if (cVar.awk != null && !cVar.awk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_imp_ad_info", cVar.awk);
        }
        return jSONObject;
    }
}
