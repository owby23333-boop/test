package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fy implements com.kwad.sdk.core.d<m.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((m.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((m.b) bVar, jSONObject);
    }

    private static void a(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.progress = jSONObject.optInt("progress");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.acv = jSONObject.optInt("realProgress");
    }

    private static JSONObject b(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, bVar.status);
        }
        if (bVar.progress != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", bVar.progress);
        }
        if (bVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", bVar.soFarBytes);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", bVar.totalBytes);
        }
        if (bVar.acv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", bVar.acv);
        }
        return jSONObject;
    }
}
