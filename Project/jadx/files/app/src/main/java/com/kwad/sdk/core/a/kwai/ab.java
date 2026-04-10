package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ab implements com.kwad.sdk.core.d<AdProductInfo> {
    private static void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString("icon");
        if (adProductInfo.icon == JSONObject.NULL) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (adProductInfo.name == JSONObject.NULL) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString("price");
        if (adProductInfo.price == JSONObject.NULL) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (adProductInfo.originPrice == JSONObject.NULL) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("couponList");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (adProductInfo.volume == JSONObject.NULL) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString(com.anythink.expressad.foundation.d.c.Y);
        if (adProductInfo.rating == JSONObject.NULL) {
            adProductInfo.rating = "";
        }
        adProductInfo.seckillInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    private static JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adProductInfo.icon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "icon", adProductInfo.icon);
        }
        String str2 = adProductInfo.name;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "name", adProductInfo.name);
        }
        String str3 = adProductInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "price", adProductInfo.price);
        }
        String str4 = adProductInfo.originPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "couponList", adProductInfo.couponList);
        String str5 = adProductInfo.volume;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        String str6 = adProductInfo.rating;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.d.c.Y, adProductInfo.rating);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo) bVar, jSONObject);
    }
}
