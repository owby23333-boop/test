package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fs implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.a) bVar, jSONObject);
    }

    private static void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCk = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(aVar.aCk)) {
            aVar.aCk = "";
        }
        aVar.aCl = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(aVar.aCl)) {
            aVar.aCl = "";
        }
    }

    private static JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aCk != null && !aVar.aCk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", aVar.aCk);
        }
        if (aVar.aCl != null && !aVar.aCl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", aVar.aCl);
        }
        return jSONObject;
    }
}
