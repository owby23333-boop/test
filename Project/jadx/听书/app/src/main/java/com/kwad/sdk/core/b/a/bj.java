package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.au;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bj implements com.kwad.sdk.core.d<au.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((au.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((au.a) bVar, jSONObject);
    }

    private static void a(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adT = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.totalBytes = jSONObject.optLong("totalBytes");
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.adU = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.adT != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", aVar.adT);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, aVar.status);
        }
        if (aVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", aVar.totalBytes);
        }
        if (aVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", aVar.soFarBytes);
        }
        if (aVar.adU != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", aVar.adU);
        }
        return jSONObject;
    }
}
