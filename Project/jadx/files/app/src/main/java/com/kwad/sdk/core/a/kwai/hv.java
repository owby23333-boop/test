package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hv implements com.kwad.sdk.core.d<TKAdLiveShopItemInfo> {
    private static void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKAdLiveShopItemInfo.itemId = jSONObject.optString("itemId");
        if (tKAdLiveShopItemInfo.itemId == JSONObject.NULL) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        tKAdLiveShopItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (tKAdLiveShopItemInfo.imageUrl == JSONObject.NULL) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        tKAdLiveShopItemInfo.title = jSONObject.optString("title");
        if (tKAdLiveShopItemInfo.title == JSONObject.NULL) {
            tKAdLiveShopItemInfo.title = "";
        }
        tKAdLiveShopItemInfo.price = jSONObject.optString("price");
        if (tKAdLiveShopItemInfo.price == JSONObject.NULL) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    private static JSONObject b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tKAdLiveShopItemInfo.itemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        String str2 = tKAdLiveShopItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        String str3 = tKAdLiveShopItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", tKAdLiveShopItemInfo.title);
        }
        String str4 = tKAdLiveShopItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "price", tKAdLiveShopItemInfo.price);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TKAdLiveShopItemInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TKAdLiveShopItemInfo) bVar, jSONObject);
    }
}
