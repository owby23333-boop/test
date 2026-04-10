package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.b.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cu implements com.kwad.sdk.core.d<e.a> {
    private static void a(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.rT = jSONObject.optString("dialogEvent");
        if (aVar.rT == JSONObject.NULL) {
            aVar.rT = "";
        }
    }

    private static JSONObject b(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.rT;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "dialogEvent", aVar.rT);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((e.a) bVar, jSONObject);
    }
}
