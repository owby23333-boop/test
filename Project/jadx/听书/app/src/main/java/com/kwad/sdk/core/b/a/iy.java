package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class iy implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aJI = jSONObject.optInt("func_ratio_count");
        cVar.aXN = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("func_values");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.n.b.a.b bVar = new com.kwad.sdk.n.b.a.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                cVar.aXN.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.aJI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", cVar.aJI);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "func_values", cVar.aXN);
        return jSONObject;
    }
}
