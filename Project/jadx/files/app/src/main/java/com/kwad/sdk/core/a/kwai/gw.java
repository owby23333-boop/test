package com.kwad.sdk.core.a.kwai;

import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gw implements com.kwad.sdk.core.d<SceneImpl> {
    private static void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sceneImpl.urlPackage = new URLPackage();
        sceneImpl.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt(NativeAdvancedJsUtils.f8246p);
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        sceneImpl.nativeAdExtraData = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (sceneImpl.backUrl == JSONObject.NULL) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (sceneImpl.bidResponse == JSONObject.NULL) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (sceneImpl.bidResponseV2 == JSONObject.NULL) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    private static JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j2 = sceneImpl.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posId", j2);
        }
        long j3 = sceneImpl.entryScene;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "entryScene", j3);
        }
        int i2 = sceneImpl.adNum;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adNum", i2);
        }
        int i3 = sceneImpl.action;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NativeAdvancedJsUtils.f8246p, i3);
        }
        int i4 = sceneImpl.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", i4);
        }
        int i5 = sceneImpl.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", i5);
        }
        int i6 = sceneImpl.adStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", i6);
        }
        int i7 = sceneImpl.screenOrientation;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenOrientation", i7);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        String str = sceneImpl.backUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str2 = sceneImpl.bidResponse;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str3 = sceneImpl.bidResponseV2;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SceneImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SceneImpl) bVar, jSONObject);
    }
}
