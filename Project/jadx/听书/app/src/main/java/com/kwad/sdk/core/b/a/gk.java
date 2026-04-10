package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.ap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gk implements com.kwad.sdk.core.d<ap.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ap.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ap.b) bVar, jSONObject);
    }

    private static void a(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.adT = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.adU = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.adT != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", bVar.adT);
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, bVar.status);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", bVar.totalBytes);
        }
        if (bVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", bVar.soFarBytes);
        }
        if (bVar.adU != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", bVar.adU);
        }
        return jSONObject;
    }
}
