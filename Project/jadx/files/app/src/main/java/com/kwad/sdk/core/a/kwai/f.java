package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
    private static void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    private static JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = activityInfo.actTypeId;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "actTypeId", i2);
        }
        int i3 = activityInfo.sceneTypeId;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sceneTypeId", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ActivityInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ActivityInfo) bVar, jSONObject);
    }
}
