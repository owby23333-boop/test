package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.avN = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.avN)) {
            bVar.avN = "";
        }
        bVar.avU = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.avU)) {
            bVar.avU = "";
        }
        bVar.avV = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.avV)) {
            bVar.avV = "";
        }
        bVar.avW = jSONObject.optInt("store_type");
        bVar.avX = jSONObject.optInt("launch_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, bVar.status);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        if (bVar.avN != null && !bVar.avN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.avN);
        }
        if (bVar.avU != null && !bVar.avU.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_path", bVar.avU);
        }
        if (bVar.avV != null && !bVar.avV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "market_pkg_name", bVar.avV);
        }
        if (bVar.avW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "store_type", bVar.avW);
        }
        if (bVar.avX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "launch_type", bVar.avX);
        }
        return jSONObject;
    }
}
