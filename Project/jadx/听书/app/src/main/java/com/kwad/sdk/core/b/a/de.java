package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class de implements com.kwad.sdk.core.d<an.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((an.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((an.a) bVar, jSONObject);
    }

    private static void a(an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adL = jSONObject.optBoolean("clickActionButton");
        aVar.adM = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.adM)) {
            aVar.adM = "";
        }
        aVar.adN = jSONObject.optInt("area");
        aVar.adO = new com.kwad.sdk.core.webview.d.b.d();
        aVar.adO.parseJson(jSONObject.optJSONObject("logParam"));
    }

    private static JSONObject b(an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.adL) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", aVar.adL);
        }
        if (aVar.adM != null && !aVar.adM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adTemplate", aVar.adM);
        }
        if (aVar.adN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", aVar.adN);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.adO);
        return jSONObject;
    }
}
