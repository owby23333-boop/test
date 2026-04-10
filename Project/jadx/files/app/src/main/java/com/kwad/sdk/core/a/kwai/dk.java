package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dk implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.kwai.kwai.a> {
    private static void a(com.kwad.sdk.ranger.kwai.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString("key");
        if (aVar.key == JSONObject.NULL) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optInt("value");
    }

    private static JSONObject b(com.kwad.sdk.ranger.kwai.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "key", aVar.key);
        }
        int i2 = aVar.value;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "value", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.ranger.kwai.kwai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.ranger.kwai.kwai.a) bVar, jSONObject);
    }
}
