package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.kwai.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cl implements com.kwad.sdk.core.d<a.b> {
    private static void a(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
    }

    private static JSONObject b(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        int i3 = bVar.progress;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.b) bVar, jSONObject);
    }
}
