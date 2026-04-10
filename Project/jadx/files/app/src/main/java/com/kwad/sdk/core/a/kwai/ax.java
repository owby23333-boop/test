package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ax implements com.kwad.sdk.core.d<l.a> {
    private static void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.name = jSONObject.optString("name");
        if (aVar.name == JSONObject.NULL) {
            aVar.name = "";
        }
    }

    private static JSONObject b(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "name", aVar.name);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((l.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((l.a) bVar, jSONObject);
    }
}
