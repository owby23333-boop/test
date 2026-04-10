package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.ActionBarInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = actionBarInfo.translateBtnShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "translateBtnShowTime", j2);
        }
        long j3 = actionBarInfo.lightBtnShowTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "lightBtnShowTime", j3);
        }
        long j4 = actionBarInfo.cardShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardShowTime", j4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }
}
