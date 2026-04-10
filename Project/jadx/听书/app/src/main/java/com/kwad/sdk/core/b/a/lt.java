package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lt implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aIL = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(gVar.aIL)) {
            gVar.aIL = "";
        }
        gVar.aIM = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(gVar.aIM)) {
            gVar.aIM = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.aIL != null && !gVar.aIL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserId", gVar.aIL);
        }
        if (gVar.aIM != null && !gVar.aIM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserName", gVar.aIM);
        }
        if (gVar.thirdAge != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", gVar.thirdAge);
        }
        if (gVar.thirdGender != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", gVar.thirdGender);
        }
        if (gVar.thirdInterest != null && !gVar.thirdInterest.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        return jSONObject;
    }
}
