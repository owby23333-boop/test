package com.kwad.sdk.core.a.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gd implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    private static void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (preLoadItem.preloadId == JSONObject.NULL) {
            preLoadItem.preloadId = "";
        }
    }

    private static JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = preLoadItem.cacheTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cacheTime", j2);
        }
        long j3 = preLoadItem.expiredTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "expiredTime", j3);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashPreloadManager.PreLoadItem) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashPreloadManager.PreLoadItem) bVar, jSONObject);
    }
}
