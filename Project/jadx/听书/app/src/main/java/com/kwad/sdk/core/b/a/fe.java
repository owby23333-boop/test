package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fe implements com.kwad.sdk.core.d<j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((j.b) bVar, jSONObject);
    }

    private static void a(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.acq = jSONObject.optInt("playableSrc");
        bVar.acr = jSONObject.optInt("isMiddleEnd");
        bVar.Re = jSONObject.optInt("adType");
        bVar.acs = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.acs)) {
            bVar.acs = "";
        }
    }

    private static JSONObject b(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.acq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableSrc", bVar.acq);
        }
        if (bVar.acr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isMiddleEnd", bVar.acr);
        }
        if (bVar.Re != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adType", bVar.Re);
        }
        if (bVar.acs != null && !bVar.acs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", bVar.acs);
        }
        return jSONObject;
    }
}
