package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aj;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hx implements com.kwad.sdk.core.d<aj.a> {
    private static void a(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TZ = jSONObject.optInt("taskStatus");
    }

    private static JSONObject b(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.TZ;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "taskStatus", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aj.a) bVar, jSONObject);
    }
}
