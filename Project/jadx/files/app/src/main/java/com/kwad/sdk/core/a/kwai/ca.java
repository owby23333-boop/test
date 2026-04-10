package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ca implements com.kwad.sdk.core.d<com.kwad.sdk.crash.a> {
    private static void a(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.apT = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appIdList");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                aVar.apT.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        aVar.apU = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                aVar.apU.add((String) jSONArrayOptJSONArray2.opt(i3));
            }
        }
        aVar.apV = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                aVar.apV.add((String) jSONArrayOptJSONArray3.opt(i4));
            }
        }
        aVar.apW = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    private static JSONObject b(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appIdList", aVar.apT);
        com.kwad.sdk.utils.s.putValue(jSONObject, "sdkVersionList", aVar.apU);
        com.kwad.sdk.utils.s.putValue(jSONObject, "stacktraceList", aVar.apV);
        com.kwad.sdk.utils.s.putValue(jSONObject, "crashUploadRate", aVar.apW);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.a) bVar, jSONObject);
    }
}
