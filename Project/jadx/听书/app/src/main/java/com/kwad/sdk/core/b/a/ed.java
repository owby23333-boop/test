package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ed implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aPm = jSONObject.optInt("funcSwitch");
        bVar.aPn = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.aPn)) {
            bVar.aPn = "";
        }
        bVar.aPo = jSONObject.optString("maxSdkVersionExclude");
        if (JSONObject.NULL.toString().equals(bVar.aPo)) {
            bVar.aPo = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aPp = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.aPp)) {
            bVar.aPp = "";
        }
        bVar.aPq = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.aPq)) {
            bVar.aPq = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aPr = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.aPr)) {
            bVar.aPr = "";
        }
        bVar.aPs = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.aPs)) {
            bVar.aPs = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aPm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", bVar.aPm);
        }
        if (bVar.aPn != null && !bVar.aPn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minSdkVersion", bVar.aPn);
        }
        if (bVar.aPo != null && !bVar.aPo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxSdkVersionExclude", bVar.aPo);
        }
        if (bVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", bVar.sdkType);
        }
        if (bVar.aPp != null && !bVar.aPp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V7", bVar.aPp);
        }
        if (bVar.aPq != null && !bVar.aPq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V8", bVar.aPq);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        if (bVar.aPr != null && !bVar.aPr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v7Url", bVar.aPr);
        }
        if (bVar.aPs != null && !bVar.aPs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v8Url", bVar.aPs);
        }
        return jSONObject;
    }
}
