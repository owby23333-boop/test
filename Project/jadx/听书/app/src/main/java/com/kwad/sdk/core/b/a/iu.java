package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class iu implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aIQ = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aIR = jSONObject.optBoolean("enablePreload");
        aVar.aIS = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aIT = jSONObject.optInt("adLoadStrategy");
        aVar.aIU = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", aVar.posId);
        }
        if (aVar.aIQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPhotoCountForMedia", aVar.aIQ);
        }
        if (aVar.aIR) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enablePreload", aVar.aIR);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "increaseAdLoadTime", aVar.aIS);
        if (aVar.aIT != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadStrategy", aVar.aIT);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aIU);
        return jSONObject;
    }
}
