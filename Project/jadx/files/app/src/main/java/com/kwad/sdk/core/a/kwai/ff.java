package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ff implements com.kwad.sdk.core.d<StatusInfo.NativeAdStyleControl> {
    private static void a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdStyleControl.enableShake = jSONObject.optBoolean("enableShake");
    }

    private static JSONObject b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = nativeAdStyleControl.enableShake;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enableShake", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.NativeAdStyleControl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.NativeAdStyleControl) bVar, jSONObject);
    }
}
