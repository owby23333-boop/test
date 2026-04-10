package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aXr = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(bVar.aXr)) {
            bVar.aXr = "";
        }
        bVar.aXs = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aXs)) {
            bVar.aXs = "";
        }
        bVar.aXt = jSONObject.optBoolean("childFieldIsStatic");
        bVar.aXu = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(bVar.aXu)) {
            bVar.aXu = "";
        }
        bVar.aXv = new b.C0423b();
        bVar.aXv.parseJson(jSONObject.optJSONObject("childMethod"));
        bVar.aXw = new com.kwad.sdk.n.a.b();
        bVar.aXw.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    private static JSONObject b(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aXr != null && !bVar.aXr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nodeClassName", bVar.aXr);
        }
        if (bVar.aXs != null && !bVar.aXs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldName", bVar.aXs);
        }
        if (bVar.aXt) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldIsStatic", bVar.aXt);
        }
        if (bVar.aXu != null && !bVar.aXu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportKey", bVar.aXu);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "childMethod", bVar.aXv);
        com.kwad.sdk.utils.aa.a(jSONObject, "deepNode", bVar.aXw);
        return jSONObject;
    }
}
