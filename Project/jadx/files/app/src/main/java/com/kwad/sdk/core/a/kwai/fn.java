package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fn implements com.kwad.sdk.core.d<com.kwad.sdk.e.kwai.b> {
    private static void a(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.asH = jSONObject.optString("packageId");
        if (bVar.asH == JSONObject.NULL) {
            bVar.asH = "";
        }
        bVar.asI = jSONObject.optString("zipFileName");
        if (bVar.asI == JSONObject.NULL) {
            bVar.asI = "";
        }
        bVar.asJ = jSONObject.optString("zipPath");
        if (bVar.asJ == JSONObject.NULL) {
            bVar.asJ = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (bVar.packageUrl == JSONObject.NULL) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (bVar.version == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.asL = jSONObject.optString("checksum");
        if (bVar.asL == JSONObject.NULL) {
            bVar.asL = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.asM = jSONObject.optBoolean("public");
    }

    private static JSONObject b(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.asH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageId", bVar.asH);
        }
        String str2 = bVar.asI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "zipFileName", bVar.asI);
        }
        String str3 = bVar.asJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "zipPath", bVar.asJ);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.asL;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "checksum", bVar.asL);
        }
        int i2 = bVar.loadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "loadType", i2);
        }
        int i3 = bVar.packageType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageType", i3);
        }
        boolean z2 = bVar.asM;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "public", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.e.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.e.kwai.b) bVar, jSONObject);
    }
}
