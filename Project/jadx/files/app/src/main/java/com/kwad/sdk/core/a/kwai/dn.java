package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dn implements com.kwad.sdk.core.d<b.C0414b> {
    private static void a(b.C0414b c0414b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0414b.Sc = jSONObject.optInt("playableSrc");
        c0414b.Sd = jSONObject.optInt("isPlayAgainScene");
        c0414b.Se = jSONObject.optInt("isMiddleEnd");
        c0414b.JR = jSONObject.optInt("adType");
    }

    private static JSONObject b(b.C0414b c0414b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0414b.Sc;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableSrc", i2);
        }
        int i3 = c0414b.Sd;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isPlayAgainScene", i3);
        }
        int i4 = c0414b.Se;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isMiddleEnd", i4);
        }
        int i5 = c0414b.JR;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adType", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.C0414b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.C0414b) bVar, jSONObject);
    }
}
