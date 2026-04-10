package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ev implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
    private static void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }

    private static JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = materialSize.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", i2);
        }
        int i3 = materialSize.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.MaterialSize) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.MaterialSize) bVar, jSONObject);
    }
}
