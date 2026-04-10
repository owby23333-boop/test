package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cp implements com.kwad.sdk.core.d<AdMatrixInfo.EndCardInfo> {
    private static void a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        endCardInfo.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = endCardInfo.cardShowPlayCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardShowPlayCount", i2);
        }
        int i3 = endCardInfo.cardType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.EndCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.EndCardInfo) bVar, jSONObject);
    }
}
