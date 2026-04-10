package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gx implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    private static void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (shakeInfo.title == JSONObject.NULL) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString("subtitle");
        if (shakeInfo.subtitle == JSONObject.NULL) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
    }

    private static JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "subtitle", shakeInfo.subtitle);
        }
        int i2 = shakeInfo.acceleration;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "acceleration", i2);
        }
        boolean z2 = shakeInfo.clickDisabled;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "clickDisabled", z2);
        }
        int i3 = shakeInfo.componentIndex;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "componentIndex", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }
}
