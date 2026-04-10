package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.a> {
    private static void a(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Tw = jSONObject.optBoolean("clickActionButton");
        aVar.Ty = jSONObject.optInt("area");
        aVar.jS = jSONObject.optInt("itemClickType");
        aVar.apI = jSONObject.optInt("convertPageType", new Integer(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).intValue());
        aVar.Tz = new com.kwad.sdk.core.webview.c.a.c();
        aVar.Tz.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.Jd = jSONObject.optBoolean("needReport", new Boolean(ITagManager.STATUS_TRUE).booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).longValue());
        aVar.Jl = jSONObject.optString("liveItemId");
        if (aVar.Jl == JSONObject.NULL) {
            aVar.Jl = "";
        }
        aVar.apJ = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE).intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = aVar.Tw;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "clickActionButton", z2);
        }
        int i2 = aVar.Ty;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "area", i2);
        }
        int i3 = aVar.jS;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemClickType", i3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "convertPageType", aVar.apI);
        com.kwad.sdk.utils.s.a(jSONObject, "logParam", aVar.Tz);
        com.kwad.sdk.utils.s.putValue(jSONObject, "needReport", aVar.Jd);
        com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.Jl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "liveItemId", aVar.Jl);
        }
        int i4 = aVar.apJ;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sceneType", i4);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.c.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.c.a.a) bVar, jSONObject);
    }
}
