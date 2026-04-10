package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ey implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    private static void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (merchantLiveReservationInfo.title == JSONObject.NULL) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (merchantLiveReservationInfo.userHeadUrl == JSONObject.NULL) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (merchantLiveReservationInfo.liveStartTime == JSONObject.NULL) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        merchantLiveReservationInfo.playEndCard = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    private static JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i2 = merchantLiveReservationInfo.bookUserCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bookUserCount", i2);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z2 = merchantLiveReservationInfo.displayWeakCard;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "displayWeakCard", z2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z3 = merchantLiveReservationInfo.displayBookCount;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "displayBookCount", z3);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }
}
