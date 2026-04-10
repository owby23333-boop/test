package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class aw implements com.kwad.sdk.core.d<ac.a> {
    private static void a(ac.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
    }

    private static JSONObject b(ac.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ac.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ac.a) bVar, jSONObject);
    }
}
