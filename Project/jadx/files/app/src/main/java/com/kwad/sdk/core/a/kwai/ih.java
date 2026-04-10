package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ih implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    private static void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    private static JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = unDownloadRegionConf.materialJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "materialJumpType", i2);
        }
        int i3 = unDownloadRegionConf.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = unDownloadRegionConf.describeBarType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "describeBarType", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.UnDownloadRegionConf) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.UnDownloadRegionConf) bVar, jSONObject);
    }
}
