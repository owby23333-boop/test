package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ie implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aRp = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.aRp)) {
            bVar.aRp = "";
        }
        bVar.aRq = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.aRq)) {
            bVar.aRq = "";
        }
        bVar.aRr = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(bVar.aRr)) {
            bVar.aRr = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.ard = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.ard)) {
            bVar.ard = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aRt = jSONObject.optBoolean("public");
    }

    private static JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aRp != null && !bVar.aRp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageId", bVar.aRp);
        }
        if (bVar.aRq != null && !bVar.aRq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipFileName", bVar.aRq);
        }
        if (bVar.aRr != null && !bVar.aRr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipPath", bVar.aRr);
        }
        if (bVar.packageUrl != null && !bVar.packageUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        if (bVar.ard != null && !bVar.ard.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "checksum", bVar.ard);
        }
        if (bVar.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadType", bVar.loadType);
        }
        if (bVar.packageType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageType", bVar.packageType);
        }
        if (bVar.aRt) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "public", bVar.aRt);
        }
        return jSONObject;
    }
}
