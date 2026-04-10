package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.draw.view.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lz implements com.kwad.sdk.core.d<c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((c.a) bVar, jSONObject);
    }

    private static void a(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.gb = jSONObject.optBoolean("controlPlayerStatus");
    }

    private static JSONObject b(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, aVar.status);
        }
        if (aVar.gb) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "controlPlayerStatus", aVar.gb);
        }
        return jSONObject;
    }
}
