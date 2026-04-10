package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class kt implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo) bVar, jSONObject);
    }

    private static void a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.aIF = jSONObject.optInt("personalRecommend");
        statusInfo.aIG = jSONObject.optInt("programmaticRecommend");
        statusInfo.aIH = new StatusInfo.SplashAdInfo();
        statusInfo.aIH.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.aII = new StatusInfo.NativeAdRequestInfo();
        statusInfo.aII.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.aIJ = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("taskStats");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                statusInfo.aIJ.add(fVar);
            }
        }
    }

    private static JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (statusInfo.aIF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "personalRecommend", statusInfo.aIF);
        }
        if (statusInfo.aIG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "programmaticRecommend", statusInfo.aIG);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "splashAdInfo", statusInfo.aIH);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", statusInfo.aII);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "taskStats", statusInfo.aIJ);
        return jSONObject;
    }
}
