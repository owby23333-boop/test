package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gh implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.kwai.kwai.b> {
    private static void a(com.kwad.sdk.ranger.kwai.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.alY = jSONObject.optInt("func_ratio_count");
        bVar.axE = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("func_values");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                com.kwad.sdk.ranger.kwai.kwai.a aVar = new com.kwad.sdk.ranger.kwai.kwai.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                bVar.axE.add(aVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.ranger.kwai.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.alY;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "func_ratio_count", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "func_values", bVar.axE);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.ranger.kwai.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.ranger.kwai.kwai.b) bVar, jSONObject);
    }
}
