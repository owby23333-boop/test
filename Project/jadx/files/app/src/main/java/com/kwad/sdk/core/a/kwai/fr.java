package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fr implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (patchAdInfo.weakStyleIcon == JSONObject.NULL) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (patchAdInfo.weakStyleTitle == JSONObject.NULL) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (patchAdInfo.weakStyleDownloadingTitle == JSONObject.NULL) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (patchAdInfo.weakStyleAdMark == JSONObject.NULL) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean(ITagManager.STATUS_TRUE).booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (patchAdInfo.strongStyleCardUrl == JSONObject.NULL) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (patchAdInfo.strongStyleTitle == JSONObject.NULL) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (patchAdInfo.strongStyleSubTitle == JSONObject.NULL) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (patchAdInfo.strongStyleAdMark == JSONObject.NULL) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean(ITagManager.STATUS_TRUE).booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchAdInfo.weakStyleIcon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        String str2 = patchAdInfo.weakStyleTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        String str3 = patchAdInfo.weakStyleDownloadingTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        String str4 = patchAdInfo.weakStyleAdMark;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        long j2 = patchAdInfo.weakStyleAppearTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleAppearTime", j2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        int i2 = patchAdInfo.typePortrait;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "typePortrait", i2);
        }
        String str5 = patchAdInfo.strongStyleCardUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        long j3 = patchAdInfo.strongStyleAppearTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleAppearTime", j3);
        }
        String str6 = patchAdInfo.strongStyleTitle;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        String str7 = patchAdInfo.strongStyleSubTitle;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        String str8 = patchAdInfo.strongStyleAdMark;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        long j4 = patchAdInfo.weakStyleShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weakStyleShowTime", j4);
        }
        long j5 = patchAdInfo.strongStyleShowTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "strongStyleShowTime", j5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.PatchAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.PatchAdInfo) bVar, jSONObject);
    }
}
