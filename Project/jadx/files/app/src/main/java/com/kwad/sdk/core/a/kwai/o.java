package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.kwad.sdk.core.d<AdInfo.AdFeedInfo> {
    private static void a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adFeedInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adFeedInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
    }

    private static JSONObject b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adFeedInfo.videoSoundType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoSoundType", i2);
        }
        int i3 = adFeedInfo.videoAutoPlayType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "videoAutoPlayType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdFeedInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdFeedInfo) bVar, jSONObject);
    }
}
