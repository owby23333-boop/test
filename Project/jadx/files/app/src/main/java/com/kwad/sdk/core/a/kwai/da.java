package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class da implements com.kwad.sdk.core.d<FeedSlideConf> {
    private static void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    private static JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = feedSlideConf.maxRange;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "maxRange", i2);
        }
        int i3 = feedSlideConf.minRange;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "minRange", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedSlideConf) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedSlideConf) bVar, jSONObject);
    }
}
