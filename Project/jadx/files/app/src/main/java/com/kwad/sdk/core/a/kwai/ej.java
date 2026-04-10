package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.core.webview.jshandler.w;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ej implements com.kwad.sdk.core.d<w.b> {
    private static void a(w.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.TE = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
    }

    private static JSONObject b(w.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = bVar.TE;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d2);
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        long j2 = bVar.totalBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((w.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((w.b) bVar, jSONObject);
    }
}
