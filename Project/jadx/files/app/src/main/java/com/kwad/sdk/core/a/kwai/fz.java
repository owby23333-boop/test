package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fz implements com.kwad.sdk.core.d<n.a> {
    private static void a(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.playableExtraData = jSONObject.optString("playableExtraData");
        if (aVar.playableExtraData == JSONObject.NULL) {
            aVar.playableExtraData = "";
        }
    }

    private static JSONObject b(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableExtraData", aVar.playableExtraData);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((n.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((n.a) bVar, jSONObject);
    }
}
