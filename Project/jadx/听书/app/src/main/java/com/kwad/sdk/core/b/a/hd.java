package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hd implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.MaterialSize) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.MaterialSize) bVar, jSONObject);
    }

    private static void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt(MediaFormat.KEY_WIDTH);
        materialSize.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
    }

    private static JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (materialSize.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, materialSize.width);
        }
        if (materialSize.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, materialSize.height);
        }
        return jSONObject;
    }
}
