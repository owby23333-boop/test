package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ei implements com.kwad.sdk.core.d<w.a> {
    private static void a(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Tx = jSONObject.optString("adTemplate");
        if (aVar.Tx == JSONObject.NULL) {
            aVar.Tx = "";
        }
    }

    private static JSONObject b(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Tx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adTemplate", aVar.Tx);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((w.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((w.a) bVar, jSONObject);
    }
}
