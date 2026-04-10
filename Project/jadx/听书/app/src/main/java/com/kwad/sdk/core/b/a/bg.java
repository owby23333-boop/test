package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.at;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bg implements com.kwad.sdk.core.d<at.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((at.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((at.a) bVar, jSONObject);
    }

    private static void a(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
    }

    private static JSONObject b(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "id", aVar.id);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, aVar.status);
        }
        return jSONObject;
    }
}
