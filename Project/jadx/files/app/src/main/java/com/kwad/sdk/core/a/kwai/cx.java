package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cx implements com.kwad.sdk.core.d<AdStyleInfo.FeedAdInfo> {
    private static void a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedAdInfo.templateConfig = jSONObject.optString("templateConfig");
        if (feedAdInfo.templateConfig == JSONObject.NULL) {
            feedAdInfo.templateConfig = "";
        }
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }

    private static JSONObject b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedAdInfo.templateConfig;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        }
        double d2 = feedAdInfo.heightRatio;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "heightRatio", d2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.FeedAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.FeedAdInfo) bVar, jSONObject);
    }
}
