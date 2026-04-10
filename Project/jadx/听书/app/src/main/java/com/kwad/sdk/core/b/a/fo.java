package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ak;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fo implements com.kwad.sdk.core.d<ak.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ak.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ak.a) bVar, jSONObject);
    }

    private static void a(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.ady = jSONObject.optInt("playDuration");
    }

    private static JSONObject b(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", aVar.type);
        }
        if (aVar.ady != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", aVar.ady);
        }
        return jSONObject;
    }
}
