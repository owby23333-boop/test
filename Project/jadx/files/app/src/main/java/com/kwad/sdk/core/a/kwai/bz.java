package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bz implements com.kwad.sdk.core.d<u.a> {
    private static void a(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Tw = jSONObject.optBoolean("clickActionButton");
        aVar.Tx = jSONObject.optString("adTemplate");
        if (aVar.Tx == JSONObject.NULL) {
            aVar.Tx = "";
        }
        aVar.Ty = jSONObject.optInt("area");
        aVar.Tz = new com.kwad.sdk.core.webview.c.a.c();
        aVar.Tz.parseJson(jSONObject.optJSONObject("logParam"));
    }

    private static JSONObject b(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = aVar.Tw;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "clickActionButton", z2);
        }
        String str = aVar.Tx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adTemplate", aVar.Tx);
        }
        int i2 = aVar.Ty;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "area", i2);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "logParam", aVar.Tz);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((u.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((u.a) bVar, jSONObject);
    }
}
