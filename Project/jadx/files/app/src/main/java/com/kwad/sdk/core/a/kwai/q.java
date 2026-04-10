package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.kwad.components.core.webview.jshandler.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements com.kwad.sdk.core.d<f.a> {
    private static void a(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creativeId", new Long(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).intValue());
    }

    private static JSONObject b(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((f.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((f.a) bVar, jSONObject);
    }
}
