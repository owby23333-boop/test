package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hp implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    private static void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (splashSlideInfo.title == JSONObject.NULL) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString("subtitle");
        if (splashSlideInfo.subtitle == JSONObject.NULL) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt(com.anythink.expressad.foundation.h.i.f10647e);
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        splashSlideInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    private static JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashSlideInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        String str2 = splashSlideInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "subtitle", splashSlideInfo.subtitle);
        }
        int i2 = splashSlideInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.h.i.f10647e, i2);
        }
        int i3 = splashSlideInfo.convertDistance;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "convertDistance", i3);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashSlideInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashSlideInfo) bVar, jSONObject);
    }
}
