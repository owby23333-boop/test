package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cm implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    private static void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadTexts.adActionDescription = jSONObject.optString("adActionDescription");
        if (downloadTexts.adActionDescription == JSONObject.NULL) {
            downloadTexts.adActionDescription = "";
        }
        downloadTexts.installAppLabel = jSONObject.optString("installAppLabel");
        if (downloadTexts.installAppLabel == JSONObject.NULL) {
            downloadTexts.installAppLabel = "";
        }
        downloadTexts.openAppLabel = jSONObject.optString("openAppLabel");
        if (downloadTexts.openAppLabel == JSONObject.NULL) {
            downloadTexts.openAppLabel = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadTexts.adActionDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adActionDescription", downloadTexts.adActionDescription);
        }
        String str2 = downloadTexts.installAppLabel;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "installAppLabel", downloadTexts.installAppLabel);
        }
        String str3 = downloadTexts.openAppLabel;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "openAppLabel", downloadTexts.openAppLabel);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.DownloadTexts) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.DownloadTexts) bVar, jSONObject);
    }
}
