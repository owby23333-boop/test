package com.kwad.sdk.core.a.kwai;

import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fm implements com.kwad.sdk.core.d<com.kwad.sdk.e.kwai.a> {
    private static void a(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.sceneId = jSONObject.optString("sceneId");
        if (aVar.sceneId == JSONObject.NULL) {
            aVar.sceneId = "";
        }
        aVar.asG = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Constants.KEY_PACKAGES);
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                com.kwad.sdk.e.kwai.b bVar = new com.kwad.sdk.e.kwai.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                aVar.asG.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_PACKAGES, aVar.asG);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.e.kwai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.e.kwai.a) bVar, jSONObject);
    }
}
