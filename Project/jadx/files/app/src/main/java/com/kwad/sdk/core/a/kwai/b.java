package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.d<c.a> {
    private static void a(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.axp = jSONObject.optString("originalActStr");
        if (aVar.axp == JSONObject.NULL) {
            aVar.axp = "";
        }
        aVar.axq = jSONObject.optString("targetField");
        if (aVar.axq == JSONObject.NULL) {
            aVar.axq = "";
        }
    }

    private static JSONObject b(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.axp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "originalActStr", aVar.axp);
        }
        String str2 = aVar.axq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "targetField", aVar.axq);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((c.a) bVar, jSONObject);
    }
}
