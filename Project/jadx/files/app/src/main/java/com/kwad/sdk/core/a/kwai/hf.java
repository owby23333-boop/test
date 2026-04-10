package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hf implements com.kwad.sdk.core.d<AdMatrixInfo.SplashActionBarInfo> {
    private static void a(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashActionBarInfo.title = jSONObject.optString("title");
        if (splashActionBarInfo.title == JSONObject.NULL) {
            splashActionBarInfo.title = "";
        }
        splashActionBarInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashActionBarInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    private static JSONObject b(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashActionBarInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", splashActionBarInfo.title);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "downloadTexts", splashActionBarInfo.downloadTexts);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashActionBarInfo) bVar, jSONObject);
    }
}
