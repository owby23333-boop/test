package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        dVar.awq = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.awq)) {
            dVar.awq = "";
        }
        dVar.awx = jSONObject.optInt("ad_action_type");
        dVar.axH = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, dVar.status);
        }
        if (dVar.awq != null && !dVar.awq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", dVar.awq);
        }
        if (dVar.awx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", dVar.awx);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_type", dVar.axH);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
