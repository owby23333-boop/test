package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hs implements com.kwad.sdk.core.d<StatusInfo> {
    private static void a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.ale = jSONObject.optInt("personalRecommend");
        statusInfo.alf = jSONObject.optInt("programmaticRecommend");
        statusInfo.alg = new StatusInfo.SplashAdInfo();
        statusInfo.alg.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.alh = new StatusInfo.NativeAdRequestInfo();
        statusInfo.alh.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.ali = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("taskStats");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                statusInfo.ali.add(fVar);
            }
        }
    }

    private static JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = statusInfo.ale;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "personalRecommend", i2);
        }
        int i3 = statusInfo.alf;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "programmaticRecommend", i3);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "splashAdInfo", statusInfo.alg);
        com.kwad.sdk.utils.s.a(jSONObject, "nativeAdInfo", statusInfo.alh);
        com.kwad.sdk.utils.s.putValue(jSONObject, "taskStats", statusInfo.ali);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo) bVar, jSONObject);
    }
}
