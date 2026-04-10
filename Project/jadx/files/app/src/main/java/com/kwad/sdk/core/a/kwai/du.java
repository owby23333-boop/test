package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class du implements com.kwad.sdk.core.d<r.a> {
    private static void a(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Ti = jSONObject.optInt("playDuration");
    }

    private static JSONObject b(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        int i3 = aVar.Ti;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playDuration", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((r.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((r.a) bVar, jSONObject);
    }
}
