package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fb implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    private static void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    private static JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z2 = nativeAdExtraDataImpl.enableShake;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enableShake", z2);
        }
        int i2 = nativeAdExtraDataImpl.showLiveStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLiveStatus", i2);
        }
        int i3 = nativeAdExtraDataImpl.showLiveStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showLiveStyle", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((NativeAdExtraDataImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((NativeAdExtraDataImpl) bVar, jSONObject);
    }
}
