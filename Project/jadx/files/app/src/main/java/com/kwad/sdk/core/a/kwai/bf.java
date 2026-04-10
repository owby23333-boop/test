package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.b> {
    private static void a(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f16964x = jSONObject.optDouble("x");
        bVar.f16965y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    private static JSONObject b(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = bVar.f16964x;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "x", d2);
        }
        double d3 = bVar.f16965y;
        if (d3 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "y", d3);
        }
        int i2 = bVar.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", i2);
        }
        int i3 = bVar.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.c.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.c.a.b) bVar, jSONObject);
    }
}
