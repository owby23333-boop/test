package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gs implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    private static void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateInfo.title = jSONObject.optString("title");
        if (rotateInfo.title == JSONObject.NULL) {
            rotateInfo.title = "";
        }
        rotateInfo.subTitle = jSONObject.optString("subTitle");
        if (rotateInfo.subTitle == JSONObject.NULL) {
            rotateInfo.subTitle = "";
        }
        rotateInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        rotateInfo.f16961x = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f16961x.parseJson(jSONObject.optJSONObject("x"));
        rotateInfo.f16962y = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f16962y.parseJson(jSONObject.optJSONObject("y"));
        rotateInfo.f16963z = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f16963z.parseJson(jSONObject.optJSONObject(com.umeng.analytics.pro.am.aD));
    }

    private static JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rotateInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", rotateInfo.title);
        }
        String str2 = rotateInfo.subTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "subTitle", rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.s.a(jSONObject, "x", rotateInfo.f16961x);
        com.kwad.sdk.utils.s.a(jSONObject, "y", rotateInfo.f16962y);
        com.kwad.sdk.utils.s.a(jSONObject, com.umeng.analytics.pro.am.aD, rotateInfo.f16963z);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RotateInfo) bVar, jSONObject);
    }
}
