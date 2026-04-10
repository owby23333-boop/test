package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.kwad.sdk.core.d<AdMatrixInfo.AdInteractionInfo> {
    private static void a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        adInteractionInfo.shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        adInteractionInfo.rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        adInteractionInfo.slideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        adInteractionInfo.splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
    }

    private static JSONObject b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adInteractionInfo.interactiveStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "interactiveStyle", i2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        boolean z2 = adInteractionInfo.isMediaDisable;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isMediaDisable", z2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        com.kwad.sdk.utils.s.a(jSONObject, "shakeInfo", adInteractionInfo.shakeInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "rotateInfo", adInteractionInfo.rotateInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "slideInfo", adInteractionInfo.slideInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }
}
