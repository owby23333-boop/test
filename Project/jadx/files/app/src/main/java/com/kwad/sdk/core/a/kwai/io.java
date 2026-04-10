package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class io implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    private static void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = videoPosition.leftMarginRation;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "leftMarginRation", d2);
        }
        double d3 = videoPosition.topMarginRation;
        if (d3 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "topMarginRation", d3);
        }
        double d4 = videoPosition.widthRation;
        if (d4 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "widthRation", d4);
        }
        double d5 = videoPosition.heightWidthRation;
        if (d5 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "heightWidthRation", d5);
        }
        int i2 = videoPosition.leftMargin;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "leftMargin", i2);
        }
        int i3 = videoPosition.topMargin;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "topMargin", i3);
        }
        int i4 = videoPosition.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", i4);
        }
        int i5 = videoPosition.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", i5);
        }
        int i6 = videoPosition.borderRadius;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "borderRadius", i6);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }
}
