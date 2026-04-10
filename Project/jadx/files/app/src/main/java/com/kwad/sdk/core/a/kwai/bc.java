package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.reward.RewardItem;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bc implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.c> {
    private static void a(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.arr = jSONObject.optString("printerName");
        if (cVar.arr == JSONObject.NULL) {
            cVar.arr = "";
        }
        cVar.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
        if (cVar.errorMsg == JSONObject.NULL) {
            cVar.errorMsg = "";
        }
        cVar.ars = jSONObject.optBoolean("isDisable");
        cVar.art = jSONObject.optBoolean("hasMatrix");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.arr;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "printerName", cVar.arr);
        }
        String str2 = cVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ERROR_MSG, cVar.errorMsg);
        }
        boolean z2 = cVar.ars;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isDisable", z2);
        }
        boolean z3 = cVar.art;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "hasMatrix", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.block.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.block.c) bVar, jSONObject);
    }
}
