package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class is implements com.kwad.sdk.core.d<WebViewCommercialMsg> {
    private static void a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewCommercialMsg.category = jSONObject.optString("category");
        if (webViewCommercialMsg.category == JSONObject.NULL) {
            webViewCommercialMsg.category = "";
        }
        webViewCommercialMsg.tag = jSONObject.optString("tag");
        if (webViewCommercialMsg.tag == JSONObject.NULL) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        webViewCommercialMsg.eventId = jSONObject.optString("event_id");
        if (webViewCommercialMsg.eventId == JSONObject.NULL) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
        webViewCommercialMsg.suffixRatio = jSONObject.optString("suffixRatio");
        if (webViewCommercialMsg.suffixRatio == JSONObject.NULL) {
            webViewCommercialMsg.suffixRatio = "";
        }
    }

    private static JSONObject b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewCommercialMsg.category;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "category", webViewCommercialMsg.category);
        }
        String str2 = webViewCommercialMsg.tag;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "tag", webViewCommercialMsg.tag);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        com.kwad.sdk.utils.s.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        String str3 = webViewCommercialMsg.eventId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "event_id", webViewCommercialMsg.eventId);
        }
        double d2 = webViewCommercialMsg.rate;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "rate", d2);
        }
        String str4 = webViewCommercialMsg.suffixRatio;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "suffixRatio", webViewCommercialMsg.suffixRatio);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewCommercialMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewCommercialMsg) bVar, jSONObject);
    }
}
