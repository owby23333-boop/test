package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class cb implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.block.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aPO = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(dVar.aPO)) {
            dVar.aPO = "";
        }
        dVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.aPP = jSONObject.optBoolean("isDisable");
        dVar.aPQ = jSONObject.optBoolean("hasMatrix");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aPO != null && !dVar.aPO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "printerName", dVar.aPO);
        }
        if (dVar.errorMsg != null && !dVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, dVar.errorMsg);
        }
        if (dVar.aPP) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDisable", dVar.aPP);
        }
        if (dVar.aPQ) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasMatrix", dVar.aPQ);
        }
        return jSONObject;
    }
}
