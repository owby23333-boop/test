package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class az implements com.kwad.sdk.core.d<AdMatrixInfo.BaseMatrixTemplate> {
    private static void a(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseMatrixTemplate.templateId = jSONObject.optString("templateId");
        if (baseMatrixTemplate.templateId == JSONObject.NULL) {
            baseMatrixTemplate.templateId = "";
        }
        baseMatrixTemplate.renderType = jSONObject.optInt("renderType");
    }

    private static JSONObject b(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = baseMatrixTemplate.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateId", baseMatrixTemplate.templateId);
        }
        int i2 = baseMatrixTemplate.renderType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "renderType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.BaseMatrixTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.BaseMatrixTemplate) bVar, jSONObject);
    }
}
