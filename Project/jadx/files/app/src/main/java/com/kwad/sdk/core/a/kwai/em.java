package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class em implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    private static void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = kSAdJSCornerModel.topLeft;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "topLeft", d2);
        }
        double d3 = kSAdJSCornerModel.topRight;
        if (d3 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "topRight", d3);
        }
        double d4 = kSAdJSCornerModel.bottomRight;
        if (d4 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bottomRight", d4);
        }
        double d5 = kSAdJSCornerModel.bottomLeft;
        if (d5 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bottomLeft", d5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }
}
