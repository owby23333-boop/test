package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cn implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DrawAdInfo> {
    private static void a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        drawAdInfo.forcedWatch = jSONObject.optBoolean("forcedWatch");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = drawAdInfo.forcedWatch;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "forcedWatch", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DrawAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DrawAdInfo) bVar, jSONObject);
    }
}
