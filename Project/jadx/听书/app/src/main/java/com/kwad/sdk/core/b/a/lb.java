package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lb implements com.kwad.sdk.core.d<b.C0423b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.C0423b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.C0423b) bVar, jSONObject);
    }

    private static void a(b.C0423b c0423b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0423b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c0423b.name)) {
            c0423b.name = "";
        }
        c0423b.aXE = jSONObject.optBoolean("isStatic");
        c0423b.aXF = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                b.a aVar = new b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c0423b.aXF.add(aVar);
            }
        }
    }

    private static JSONObject b(b.C0423b c0423b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0423b.name != null && !c0423b.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", c0423b.name);
        }
        if (c0423b.aXE) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", c0423b.aXE);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0423b.aXF);
        return jSONObject;
    }
}
