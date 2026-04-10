package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lc implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.aIK = jSONObject.optLong("lastModifiedTime");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (fVar.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", fVar.adStyle);
        }
        if (fVar.taskType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", fVar.taskType);
        }
        if (fVar.count != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "count", fVar.count);
        }
        if (fVar.aIK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastModifiedTime", fVar.aIK);
        }
        return jSONObject;
    }
}
