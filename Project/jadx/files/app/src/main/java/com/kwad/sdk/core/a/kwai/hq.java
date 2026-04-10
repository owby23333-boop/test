package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hq implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    private static void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = splashStyleControl.disableShake;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableShake", z2);
        }
        boolean z3 = splashStyleControl.disableRotate;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableRotate", z3);
        }
        boolean z4 = splashStyleControl.disableSlide;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableSlide", z4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }
}
