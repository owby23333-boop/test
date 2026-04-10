package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    private static void a(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (aBParams.drawActionBarTimes == JSONObject.NULL) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    private static JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aBParams.videoBlackAreaClick;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoBlackAreaClick", i2);
        }
        int i3 = aBParams.videoBlackAreaNewStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoBlackAreaNewStyle", i3);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i4 = aBParams.showVideoAtH5;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "showVideoAtH5", i4);
        }
        int i5 = aBParams.playableStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playableStyle", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ABParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ABParams) bVar, jSONObject);
    }
}
