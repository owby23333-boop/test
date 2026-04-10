package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.n.kwai.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class as implements com.kwad.sdk.core.d<c.a> {
    private static void a(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.OU = jSONObject.optInt("maxVolume");
        aVar.OV = jSONObject.optInt("minVolume");
        aVar.OW = jSONObject.optInt("currentVolume");
    }

    private static JSONObject b(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.streamType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "streamType", i2);
        }
        int i3 = aVar.OU;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxVolume", i3);
        }
        int i4 = aVar.OV;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "minVolume", i4);
        }
        int i5 = aVar.OW;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentVolume", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((c.a) bVar, jSONObject);
    }
}
