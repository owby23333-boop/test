package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hi implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.b> {
    private static void a(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.disableShake = jSONObject.optBoolean("disableShake");
        bVar.disableRotate = jSONObject.optBoolean("disableRotate");
        bVar.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = bVar.disableShake;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableShake", z2);
        }
        boolean z3 = bVar.disableRotate;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableRotate", z3);
        }
        boolean z4 = bVar.disableSlide;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableSlide", z4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.internal.api.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.internal.api.b) bVar, jSONObject);
    }
}
