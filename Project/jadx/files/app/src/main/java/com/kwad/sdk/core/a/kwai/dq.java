package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dq implements com.kwad.sdk.core.d<v.b> {
    private static void a(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.creativeId = jSONObject.optLong("creativeId", new Long(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).longValue());
    }

    private static JSONObject b(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", bVar.creativeId);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((v.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((v.b) bVar, jSONObject);
    }
}
