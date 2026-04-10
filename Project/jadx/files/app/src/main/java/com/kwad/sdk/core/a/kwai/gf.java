package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gf implements com.kwad.sdk.core.d<AdMatrixInfo.PushTKInfo> {
    private static void a(AdMatrixInfo.PushTKInfo pushTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pushTKInfo.showMidPage = jSONObject.optBoolean("showMidPage");
    }

    private static JSONObject b(AdMatrixInfo.PushTKInfo pushTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = pushTKInfo.showMidPage;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showMidPage", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.PushTKInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.PushTKInfo) bVar, jSONObject);
    }
}
