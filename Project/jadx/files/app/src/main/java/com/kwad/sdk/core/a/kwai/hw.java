package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    private static void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.alj = jSONObject.optLong("lastModifiedTime");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = fVar.adStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = fVar.taskType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "taskType", i3);
        }
        int i4 = fVar.count;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "count", i4);
        }
        long j2 = fVar.alj;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "lastModifiedTime", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }
}
