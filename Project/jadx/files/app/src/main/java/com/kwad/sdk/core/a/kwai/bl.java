package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bl implements com.kwad.sdk.core.d<k.c> {
    private static void a(k.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt(com.anythink.expressad.foundation.h.i.f10647e);
        cVar.title = jSONObject.optString("title");
        if (cVar.title == JSONObject.NULL) {
            cVar.title = "";
        }
        cVar.qI = jSONObject.optString("closeBtnText");
        if (cVar.qI == JSONObject.NULL) {
            cVar.qI = "";
        }
        cVar.qJ = jSONObject.optString("continueBtnText");
        if (cVar.qJ == JSONObject.NULL) {
            cVar.qJ = "";
        }
        cVar.qK = jSONObject.optString("viewDetailText");
        if (cVar.qK == JSONObject.NULL) {
            cVar.qK = "";
        }
        cVar.qL = jSONObject.optString("unWatchedVideoTime");
        if (cVar.qL == JSONObject.NULL) {
            cVar.qL = "";
        }
        cVar.os = jSONObject.optString(DBDefinition.ICON_URL);
        if (cVar.os == JSONObject.NULL) {
            cVar.os = "";
        }
        cVar.qM = jSONObject.optString("desc");
        if (cVar.qM == JSONObject.NULL) {
            cVar.qM = "";
        }
        cVar.qN = jSONObject.optString("descTxt");
        if (cVar.qN == JSONObject.NULL) {
            cVar.qN = "";
        }
        cVar.qO = jSONObject.optString("currentPlayTime");
        if (cVar.qO == JSONObject.NULL) {
            cVar.qO = "";
        }
    }

    private static JSONObject b(k.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = cVar.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.h.i.f10647e, i2);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.qI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "closeBtnText", cVar.qI);
        }
        String str3 = cVar.qJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "continueBtnText", cVar.qJ);
        }
        String str4 = cVar.qK;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "viewDetailText", cVar.qK);
        }
        String str5 = cVar.qL;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "unWatchedVideoTime", cVar.qL);
        }
        String str6 = cVar.os;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DBDefinition.ICON_URL, cVar.os);
        }
        String str7 = cVar.qM;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "desc", cVar.qM);
        }
        String str8 = cVar.qN;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "descTxt", cVar.qN);
        }
        String str9 = cVar.qO;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentPlayTime", cVar.qO);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((k.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((k.c) bVar, jSONObject);
    }
}
