package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ia implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    private static void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (templateData.data == JSONObject.NULL) {
            templateData.data = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = templateData.templateShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateShowTime", j2);
        }
        long j3 = templateData.templateDelayTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "templateDelayTime", j3);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }
}
