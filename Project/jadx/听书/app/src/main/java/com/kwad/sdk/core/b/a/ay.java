package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ay implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.j.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.awx = jSONObject.optInt("ad_action_type");
        bVar.awp = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.awp)) {
            bVar.awp = "";
        }
        bVar.awq = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.awq)) {
            bVar.awq = "";
        }
        bVar.requestType = jSONObject.optInt("request_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, bVar.status);
        }
        if (bVar.awx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", bVar.awx);
        }
        if (bVar.awp != null && !bVar.awp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", bVar.awp);
        }
        if (bVar.awq != null && !bVar.awq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", bVar.awq);
        }
        if (bVar.requestType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_type", bVar.requestType);
        }
        return jSONObject;
    }
}
