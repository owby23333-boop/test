package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ij implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXx = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(aVar.aXx)) {
            aVar.aXx = "";
        }
        aVar.aXy = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(aVar.aXy)) {
            aVar.aXy = "";
        }
        aVar.aXz = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(aVar.aXz)) {
            aVar.aXz = "";
        }
        aVar.aXA = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("valueStrList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.aXA.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(aVar.fieldName)) {
            aVar.fieldName = "";
        }
        aVar.className = jSONObject.optString("className");
        if (JSONObject.NULL.toString().equals(aVar.className)) {
            aVar.className = "";
        }
        aVar.aXB = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                b.a aVar2 = new b.a();
                aVar2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                aVar.aXB.add(aVar2);
            }
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aXx != null && !aVar.aXx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeStr", aVar.aXx);
        }
        if (aVar.aXy != null && !aVar.aXy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStr", aVar.aXy);
        }
        if (aVar.aXz != null && !aVar.aXz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listValueType", aVar.aXz);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStrList", aVar.aXA);
        if (aVar.fieldName != null && !aVar.fieldName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fieldName", aVar.fieldName);
        }
        if (aVar.className != null && !aVar.className.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "className", aVar.className);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "childParamList", aVar.aXB);
        return jSONObject;
    }
}
