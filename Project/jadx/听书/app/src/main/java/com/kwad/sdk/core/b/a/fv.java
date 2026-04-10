package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fv implements com.kwad.sdk.core.d<j.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((j.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((j.a) bVar, jSONObject);
    }

    private static void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCm = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.aCn = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    private static JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "horizontalShowDuration", aVar.aCm);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "verticalShowDuration", aVar.aCn);
        return jSONObject;
    }
}
