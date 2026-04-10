package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.d<AdMatrixInfo.ActionBarInfoNew> {
    private static void a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfoNew.maxTimeOut = jSONObject.optLong("maxTimeOut");
        actionBarInfoNew.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = actionBarInfoNew.maxTimeOut;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxTimeOut", j2);
        }
        int i2 = actionBarInfoNew.cardType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ActionBarInfoNew) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ActionBarInfoNew) bVar, jSONObject);
    }
}
