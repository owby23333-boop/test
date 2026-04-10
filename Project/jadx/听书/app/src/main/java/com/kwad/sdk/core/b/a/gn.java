package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gn implements com.kwad.sdk.core.d<bi.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((bi.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((bi.a) bVar, jSONObject);
    }

    private static void a(bi.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.mI = jSONObject.optInt("itemClickType");
    }

    private static JSONObject b(bi.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.mI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.mI);
        }
        return jSONObject;
    }
}
