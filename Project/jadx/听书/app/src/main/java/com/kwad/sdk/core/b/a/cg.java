package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class cg implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.x = jSONObject.optDouble("x");
        cVar.y = jSONObject.optDouble("y");
        cVar.width = jSONObject.optInt(MediaFormat.KEY_WIDTH);
        cVar.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.x != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "x", cVar.x);
        }
        if (cVar.y != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "y", cVar.y);
        }
        if (cVar.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, cVar.width);
        }
        if (cVar.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, cVar.height);
        }
        return jSONObject;
    }
}
