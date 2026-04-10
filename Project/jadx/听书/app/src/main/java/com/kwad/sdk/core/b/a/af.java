package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class af implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.awx = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.axt = jSONObject.optInt("retry_error_code");
        bVar.axu = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.axu)) {
            bVar.axu = "";
        }
        bVar.axE = jSONObject.optInt("cache_total_num");
        bVar.axF = jSONObject.optInt("cache_num");
        bVar.axG = jSONObject.optLong("cacheTimeMs");
        bVar.axD = jSONObject.optBoolean("retry_only");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, bVar.status);
        }
        if (bVar.awx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", bVar.awx);
        }
        if (bVar.retryCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", bVar.retryCount);
        }
        if (bVar.axt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_code", bVar.axt);
        }
        if (bVar.axu != null && !bVar.axu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_msg", bVar.axu);
        }
        if (bVar.axE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_total_num", bVar.axE);
        }
        if (bVar.axF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_num", bVar.axF);
        }
        if (bVar.axG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTimeMs", bVar.axG);
        }
        if (bVar.axD) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_only", bVar.axD);
        }
        return jSONObject;
    }
}
