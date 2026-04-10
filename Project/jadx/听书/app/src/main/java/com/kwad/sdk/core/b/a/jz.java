package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jz implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.smallApp.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.smallApp.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.smallApp.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
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
        bVar.aws = jSONObject.optString("small_origin_id");
        if (JSONObject.NULL.toString().equals(bVar.aws)) {
            bVar.aws = "";
        }
        bVar.awt = jSONObject.optString("small_app_id");
        if (JSONObject.NULL.toString().equals(bVar.awt)) {
            bVar.awt = "";
        }
        bVar.awu = jSONObject.optString("jump_from");
        if (JSONObject.NULL.toString().equals(bVar.awu)) {
            bVar.awu = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
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
        if (bVar.aws != null && !bVar.aws.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "small_origin_id", bVar.aws);
        }
        if (bVar.awt != null && !bVar.awt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "small_app_id", bVar.awt);
        }
        if (bVar.awu != null && !bVar.awu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jump_from", bVar.awu);
        }
        return jSONObject;
    }
}
