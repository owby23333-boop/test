package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fd implements com.kwad.sdk.core.d<StatusInfo.NativeAdRequestInfo> {
    private static void a(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdRequestInfo.nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        nativeAdRequestInfo.nativeAdStyleControl.parseJson(jSONObject.optJSONObject("nativeAdStyleControl"));
    }

    private static JSONObject b(StatusInfo.NativeAdRequestInfo nativeAdRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "nativeAdStyleControl", nativeAdRequestInfo.nativeAdStyleControl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.NativeAdRequestInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.NativeAdRequestInfo) bVar, jSONObject);
    }
}
