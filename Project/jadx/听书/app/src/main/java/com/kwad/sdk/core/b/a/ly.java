package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ly implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.ahn = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
        if (JSONObject.NULL.toString().equals(yVar.ahn)) {
            yVar.ahn = "";
        }
        yVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        yVar.errorReason = jSONObject.optString("errorReason");
        if (JSONObject.NULL.toString().equals(yVar.errorReason)) {
            yVar.errorReason = "";
        }
        yVar.qz = jSONObject.optInt("currentTime");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (yVar.ahn != null && !yVar.ahn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, yVar.ahn);
        }
        if (yVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, yVar.errorCode);
        }
        if (yVar.errorReason != null && !yVar.errorReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorReason", yVar.errorReason);
        }
        if (yVar.qz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", yVar.qz);
        }
        return jSONObject;
    }
}
