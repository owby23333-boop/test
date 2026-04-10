package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bd implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXl = jSONObject.optInt("aggregationType");
        aVar.aXm = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdkCheckList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.aXm.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.aXn = new com.kwad.sdk.n.a.b();
        aVar.aXn.parseJson(jSONObject.optJSONObject("anchorNode"));
        aVar.aXo = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("stackCheckList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                aVar.aXo.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        aVar.aXp = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("callStackList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                aVar.aXp.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aXl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationType", aVar.aXl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkCheckList", aVar.aXm);
        com.kwad.sdk.utils.aa.a(jSONObject, "anchorNode", aVar.aXn);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "stackCheckList", aVar.aXo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "callStackList", aVar.aXp);
        return jSONObject;
    }
}
