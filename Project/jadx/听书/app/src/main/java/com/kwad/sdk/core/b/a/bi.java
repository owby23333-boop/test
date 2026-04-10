package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bi implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        bVar.downloadId = jSONObject.optString("download_id");
        if (JSONObject.NULL.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.avO = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(bVar.avO)) {
            bVar.avO = "";
        }
        bVar.avP = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(bVar.avP)) {
            bVar.avP = "";
        }
        bVar.avQ = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.avR = jSONObject.optLong("apk_cur_size");
        bVar.avS = jSONObject.optInt("apk_install_type");
        bVar.avT = jSONObject.optInt("apk_install_source");
    }

    private static JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        if (bVar.downloadId != null && !bVar.downloadId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        if (bVar.avO != null && !bVar.avO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_package", bVar.avO);
        }
        if (bVar.avP != null && !bVar.avP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_name", bVar.avP);
        }
        if (bVar.avQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_size", bVar.avQ);
        }
        if (bVar.downloadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_time", bVar.downloadTime);
        }
        if (bVar.avR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_cur_size", bVar.avR);
        }
        if (bVar.avS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_type", bVar.avS);
        }
        if (bVar.avT != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_source", bVar.avT);
        }
        return jSONObject;
    }
}
