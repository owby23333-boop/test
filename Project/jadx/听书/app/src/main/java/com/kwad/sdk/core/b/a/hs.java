package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hs implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.c) bVar, jSONObject);
    }

    private static void a(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        cVar.ach = jSONObject.optInt("extra");
        cVar.aci = jSONObject.optLong("playDuration");
        cVar.acj = jSONObject.optBoolean("clickRewardDialog");
    }

    private static JSONObject b(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, cVar.errorCode);
        }
        if (cVar.ach != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", cVar.ach);
        }
        if (cVar.aci != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", cVar.aci);
        }
        if (cVar.acj) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickRewardDialog", cVar.acj);
        }
        return jSONObject;
    }
}
