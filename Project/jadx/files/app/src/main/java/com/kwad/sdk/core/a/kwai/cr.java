package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cr implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.l> {
    private static void a(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.ahV = jSONObject.optString("log");
        if (lVar.ahV == JSONObject.NULL) {
            lVar.ahV = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.ahV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "log", lVar.ahV);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.l) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.l) bVar, jSONObject);
    }
}
