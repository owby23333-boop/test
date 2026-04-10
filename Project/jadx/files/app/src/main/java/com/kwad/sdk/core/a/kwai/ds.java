package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ak;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ds implements com.kwad.sdk.core.d<ak.a> {
    private static void a(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt("visibility");
    }

    private static JSONObject b(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.visibility;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "visibility", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ak.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ak.a) bVar, jSONObject);
    }
}
