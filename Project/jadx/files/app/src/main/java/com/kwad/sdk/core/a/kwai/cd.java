package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cd implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    private static void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sceneConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                deeplinkItemInfo.sceneConf.add((Integer) jSONArrayOptJSONArray.opt(i2));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                deeplinkItemInfo.areaConf.add((Integer) jSONArrayOptJSONArray2.opt(i3));
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (deeplinkItemInfo.url == JSONObject.NULL) {
            deeplinkItemInfo.url = "";
        }
    }

    private static JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.s.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdConversionInfo.DeeplinkItemInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdConversionInfo.DeeplinkItemInfo) bVar, jSONObject);
    }
}
