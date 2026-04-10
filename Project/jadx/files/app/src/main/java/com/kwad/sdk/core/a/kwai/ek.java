package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.am;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ek implements com.kwad.sdk.core.d<am.a> {
    private static void a(am.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jS = jSONObject.optInt("itemClickType");
    }

    private static JSONObject b(am.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.jS;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemClickType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((am.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((am.a) bVar, jSONObject);
    }
}
