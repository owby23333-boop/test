package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adL = jSONObject.optBoolean("clickActionButton");
        aVar.adN = jSONObject.optInt("area");
        aVar.mI = jSONObject.optInt("itemClickType");
        aVar.aNO = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        aVar.adO = new com.kwad.sdk.core.webview.d.b.d();
        aVar.adO.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.Ph = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Pv = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Pv)) {
            aVar.Pv = "";
        }
        aVar.aNP = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aNQ = jSONObject.optBoolean("isCallbackOnly");
        aVar.aNR = jSONObject.optBoolean("disableCallback");
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.adL) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", aVar.adL);
        }
        if (aVar.adN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", aVar.adN);
        }
        if (aVar.mI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.mI);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "convertPageType", aVar.aNO);
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.adO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", aVar.Ph);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", aVar.creativeId);
        if (aVar.Pv != null && !aVar.Pv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveItemId", aVar.Pv);
        }
        if (aVar.aNP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneType", aVar.aNP);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", aVar.adStyle);
        if (aVar.aNQ) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isCallbackOnly", aVar.aNQ);
        }
        if (aVar.aNR) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableCallback", aVar.aNR);
        }
        return jSONObject;
    }
}
