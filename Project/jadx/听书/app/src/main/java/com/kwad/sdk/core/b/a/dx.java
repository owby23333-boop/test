package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class dx implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        dVar.materialType = jSONObject.optInt("material_type");
        dVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(dVar.materialUrl)) {
            dVar.materialUrl = "";
        }
        dVar.dy = jSONObject.optLong("resource_load_time_ms");
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, dVar.status);
        }
        if (dVar.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", dVar.materialType);
        }
        if (dVar.materialUrl != null && !dVar.materialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", dVar.materialUrl);
        }
        if (dVar.dy != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_load_time_ms", dVar.dy);
        }
        return jSONObject;
    }
}
