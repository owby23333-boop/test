package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fv implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playDetailInfo.type = jSONObject.optInt("type");
        playDetailInfo.detailWebCardInfo = new AdStyleInfo.PlayDetailInfo.DetailWebCardInfo();
        playDetailInfo.detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
        playDetailInfo.detailTopToolBarInfo = new AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo();
        playDetailInfo.detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
        playDetailInfo.actionBarInfo = new AdStyleInfo.PlayDetailInfo.ActionBarInfo();
        playDetailInfo.actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        playDetailInfo.patchAdInfo = new AdStyleInfo.PlayDetailInfo.PatchAdInfo();
        playDetailInfo.patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        playDetailInfo.detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
        playDetailInfo.drawAdInfo = new AdStyleInfo.PlayDetailInfo.DrawAdInfo();
        playDetailInfo.drawAdInfo.parseJson(jSONObject.optJSONObject("drawAdInfo"));
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = playDetailInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "actionBarInfo", playDetailInfo.actionBarInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "patchAdInfo", playDetailInfo.patchAdInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "detailCommonInfo", playDetailInfo.detailCommonInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "drawAdInfo", playDetailInfo.drawAdInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo) bVar, jSONObject);
    }
}
