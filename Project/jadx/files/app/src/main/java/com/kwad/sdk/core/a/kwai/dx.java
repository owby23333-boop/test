package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dx implements com.kwad.sdk.core.d<h.a> {
    private static void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adB = jSONObject.optString("imei");
        if (aVar.adB == JSONObject.NULL) {
            aVar.adB = "";
        }
        aVar.adC = jSONObject.optString("oaid");
        if (aVar.adC == JSONObject.NULL) {
            aVar.adC = "";
        }
    }

    private static JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.adB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imei", aVar.adB);
        }
        String str2 = aVar.adC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "oaid", aVar.adC);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.a) bVar, jSONObject);
    }
}
