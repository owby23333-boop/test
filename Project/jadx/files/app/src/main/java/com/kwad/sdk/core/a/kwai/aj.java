package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class aj implements com.kwad.sdk.core.d<AdInfo.AdTrackInfo> {
    private static void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("url");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                adTrackInfo.urls.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
    }

    private static JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adTrackInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdTrackInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdTrackInfo) bVar, jSONObject);
    }
}
