package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class an implements com.kwad.sdk.core.d<aa.a> {
    private static void a(aa.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    private static JSONObject b(aa.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.id;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "id", i2);
        }
        int i3 = aVar.status;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aa.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aa.a) bVar, jSONObject);
    }
}
