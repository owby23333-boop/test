package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    private static void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
    }

    private static JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adBrowseInfo.enableAdBrowse;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enableAdBrowse", i2);
        }
        int i3 = adBrowseInfo.adBrowseDuration;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adBrowseDuration", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.AdBrowseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.AdBrowseInfo) bVar, jSONObject);
    }
}
