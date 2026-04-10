package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class cf implements com.kwad.sdk.core.d<a.C0355a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0355a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0355a) bVar, jSONObject);
    }

    private static void a(a.C0355a c0355a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0355a.aeH = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0355a.aeH)) {
            c0355a.aeH = "";
        }
    }

    private static JSONObject b(a.C0355a c0355a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0355a.aeH != null && !c0355a.aeH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "android", c0355a.aeH);
        }
        return jSONObject;
    }
}
