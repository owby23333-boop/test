package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.be;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class md implements com.kwad.sdk.core.d<be.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((be.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((be.a) bVar, jSONObject);
    }

    private static void a(be.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
    }

    private static JSONObject b(be.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, aVar.status);
        }
        return jSONObject;
    }
}
