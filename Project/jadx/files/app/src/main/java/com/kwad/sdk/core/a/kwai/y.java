package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo> {
    private static void a(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMaterialInfo.materialType = jSONObject.optInt("materialType", new Integer("2").intValue());
        adMaterialInfo.videoVoice = jSONObject.optBoolean("videoVoice", new Boolean(ITagManager.STATUS_FALSE).booleanValue());
        adMaterialInfo.materialFeatureList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("materialFeature");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = new AdInfo.AdMaterialInfo.MaterialFeature();
                materialFeature.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adMaterialInfo.materialFeatureList.add(materialFeature);
            }
        }
    }

    private static JSONObject b(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.s.putValue(jSONObject, "videoVoice", adMaterialInfo.videoVoice);
        com.kwad.sdk.utils.s.putValue(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdMaterialInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdMaterialInfo) bVar, jSONObject);
    }
}
