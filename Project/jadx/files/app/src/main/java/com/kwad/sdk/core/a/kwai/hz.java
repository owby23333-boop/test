package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hz implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfigMap> {
    private static void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfigMap.couponOpenConfig = new TemplateConfig();
        templateConfigMap.couponOpenConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        templateConfigMap.couponInfoConfig = new TemplateConfig();
        templateConfigMap.couponInfoConfig.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        templateConfigMap.rewardReflowConfig = new TemplateConfig();
        templateConfigMap.rewardReflowConfig.parseJson(jSONObject.optJSONObject("rewardReflowConfig"));
    }

    private static JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
        com.kwad.sdk.utils.s.a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
        com.kwad.sdk.utils.s.a(jSONObject, "rewardReflowConfig", templateConfigMap.rewardReflowConfig);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SdkConfigData.TemplateConfigMap) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SdkConfigData.TemplateConfigMap) bVar, jSONObject);
    }
}
