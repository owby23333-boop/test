package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ku implements com.kwad.sdk.core.d<u.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((u.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((u.a) bVar, jSONObject);
    }

    private static void a(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString("key");
        if (JSONObject.NULL.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optString("value");
        if (JSONObject.NULL.toString().equals(aVar.value)) {
            aVar.value = "";
        }
    }

    private static JSONObject b(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.key != null && !aVar.key.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "key", aVar.key);
        }
        if (aVar.value != null && !aVar.value.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "value", aVar.value);
        }
        return jSONObject;
    }
}
