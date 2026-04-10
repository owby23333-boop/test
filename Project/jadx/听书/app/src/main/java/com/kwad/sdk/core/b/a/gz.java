package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.awp = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(aVar.awp)) {
            aVar.awp = "";
        }
        aVar.awq = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(aVar.awq)) {
            aVar.awq = "";
        }
        aVar.awh = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(aVar.awh)) {
            aVar.awh = "";
        }
        aVar.awr = jSONObject.optString("macro_type");
        if (JSONObject.NULL.toString().equals(aVar.awr)) {
            aVar.awr = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.awp != null && !aVar.awp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", aVar.awp);
        }
        if (aVar.awq != null && !aVar.awq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", aVar.awq);
        }
        if (aVar.awh != null && !aVar.awh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_name", aVar.awh);
        }
        if (aVar.awr != null && !aVar.awr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "macro_type", aVar.awr);
        }
        return jSONObject;
    }
}
