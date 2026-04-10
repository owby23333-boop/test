package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class mb implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition) bVar, jSONObject);
    }

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
        videoPosition.width = jSONObject.optInt(MediaFormat.KEY_WIDTH);
        videoPosition.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (videoPosition.leftMarginRation != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
        }
        if (videoPosition.topMarginRation != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topMarginRation", videoPosition.topMarginRation);
        }
        if (videoPosition.widthRation != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "widthRation", videoPosition.widthRation);
        }
        if (videoPosition.heightWidthRation != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
        }
        if (videoPosition.leftMargin != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMargin", videoPosition.leftMargin);
        }
        if (videoPosition.topMargin != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topMargin", videoPosition.topMargin);
        }
        if (videoPosition.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, videoPosition.width);
        }
        if (videoPosition.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, videoPosition.height);
        }
        if (videoPosition.borderRadius != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "borderRadius", videoPosition.borderRadius);
        }
        return jSONObject;
    }
}
