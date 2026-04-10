package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class he implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    private static void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    private static JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = spikeInfo.endTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "endTime", j2);
        }
        int i2 = spikeInfo.soldStock;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "soldStock", i2);
        }
        int i3 = spikeInfo.originalStock;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "originalStock", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }
}
