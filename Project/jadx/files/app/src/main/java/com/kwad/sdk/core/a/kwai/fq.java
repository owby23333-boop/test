package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.components.core.webview.jshandler.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fq implements com.kwad.sdk.core.d<z.a> {
    private static void a(z.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
        if (aVar.errorMsg == JSONObject.NULL) {
            aVar.errorMsg = "";
        }
    }

    private static JSONObject b(z.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        String str = aVar.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ERROR_MSG, aVar.errorMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((z.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((z.a) bVar, jSONObject);
    }
}
