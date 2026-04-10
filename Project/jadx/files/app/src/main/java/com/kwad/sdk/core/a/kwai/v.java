package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    private static void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt("status");
        adLiveItemShopInfo.title = jSONObject.optString("title");
        if (adLiveItemShopInfo.title == JSONObject.NULL) {
            adLiveItemShopInfo.title = "";
        }
        adLiveItemShopInfo.url = jSONObject.optString("url");
        if (adLiveItemShopInfo.url == JSONObject.NULL) {
            adLiveItemShopInfo.url = "";
        }
        adLiveItemShopInfo.price = jSONObject.optString("price");
        if (adLiveItemShopInfo.price == JSONObject.NULL) {
            adLiveItemShopInfo.price = "";
        }
    }

    private static JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adLiveItemShopInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        String str = adLiveItemShopInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", adLiveItemShopInfo.title);
        }
        String str2 = adLiveItemShopInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", adLiveItemShopInfo.url);
        }
        String str3 = adLiveItemShopInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "price", adLiveItemShopInfo.price);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }
}
