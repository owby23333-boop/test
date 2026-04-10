package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bo implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    private static void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    private static JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = complianceInfo.materialJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "materialJumpType", i2);
        }
        int i3 = complianceInfo.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = complianceInfo.describeBarType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "describeBarType", i4);
        }
        int i5 = complianceInfo.titleBarTextSwitch;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "titleBarTextSwitch", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.ComplianceInfo) bVar, jSONObject);
    }
}
