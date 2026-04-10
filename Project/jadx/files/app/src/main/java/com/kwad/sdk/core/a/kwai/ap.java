package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.core.webview.jshandler.ab;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ap implements com.kwad.sdk.core.d<ab.a> {
    private static void a(ab.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TE = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        aVar.status = jSONObject.optInt("status");
    }

    private static JSONObject b(ab.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = aVar.TE;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d2);
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ab.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ab.a) bVar, jSONObject);
    }
}
