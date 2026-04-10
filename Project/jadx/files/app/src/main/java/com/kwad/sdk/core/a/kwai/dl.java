package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dl implements com.kwad.sdk.core.d<a.C0413a> {
    private static void a(a.C0413a c0413a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0413a.showLiveStatus = jSONObject.optInt("showLiveStatus");
        c0413a.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    private static JSONObject b(a.C0413a c0413a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0413a.showLiveStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLiveStatus", i2);
        }
        int i3 = c0413a.showLiveStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLiveStyle", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0413a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0413a) bVar, jSONObject);
    }
}
