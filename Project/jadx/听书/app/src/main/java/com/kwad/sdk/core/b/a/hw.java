package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aIB = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(dVar.aIB)) {
            dVar.aIB = "";
        }
        dVar.aIC = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(dVar.aIC)) {
            dVar.aIC = "";
        }
        dVar.aID = jSONObject.optInt("connectionType");
        dVar.operatorType = jSONObject.optInt("operatorType");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aIB != null && !dVar.aIB.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", dVar.aIB);
        }
        if (dVar.aIC != null && !dVar.aIC.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kMac", dVar.aIC);
        }
        if (dVar.aID != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connectionType", dVar.aID);
        }
        if (dVar.operatorType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operatorType", dVar.operatorType);
        }
        return jSONObject;
    }
}
