package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ah implements com.kwad.sdk.core.d<AdStyleInfo> {
    private static void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleInfo.playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        adStyleInfo.playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        adStyleInfo.feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        adStyleInfo.adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        adStyleInfo.extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        adStyleInfo.playableExtraData = jSONObject.optString("playableExtraData");
        if (adStyleInfo.playableExtraData == JSONObject.NULL) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    private static JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        String str = adStyleInfo.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableExtraData", adStyleInfo.playableExtraData);
        }
        boolean z2 = adStyleInfo.slideClick;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "slideClick", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo) bVar, jSONObject);
    }
}
