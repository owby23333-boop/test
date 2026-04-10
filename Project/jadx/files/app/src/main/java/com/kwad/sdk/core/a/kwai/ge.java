package com.kwad.sdk.core.a.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ge implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadPara> {
    private static void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    private static JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = preLoadPara.spreadTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "spreadTime", j2);
        }
        int i2 = preLoadPara.isValidReturned;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isValidReturned", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashPreloadManager.PreLoadPara) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashPreloadManager.PreLoadPara) bVar, jSONObject);
    }
}
