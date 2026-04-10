package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.adlog.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ec implements com.kwad.sdk.core.d<c.a> {
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
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
    }

    private static JSONObject b(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.code != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "code", aVar.code);
        }
        if (aVar.msg != null && !aVar.msg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_MESSAGE, aVar.msg);
        }
        return jSONObject;
    }
}
