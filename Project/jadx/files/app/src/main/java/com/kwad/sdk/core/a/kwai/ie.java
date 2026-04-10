package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ie implements com.kwad.sdk.core.d<BlockEvent.a> {
    private static void a(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ari = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.arj = jSONObject.optBoolean("runIdle");
        aVar.ark = jSONObject.optString("stackTraceDetail");
        if (aVar.ark == JSONObject.NULL) {
            aVar.ark = "";
        }
        aVar.arl = jSONObject.optLong("startTimestamp");
    }

    private static JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.ari;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "endTimestamp", j2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z2 = aVar.arj;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "runIdle", z2);
        }
        String str = aVar.ark;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "stackTraceDetail", aVar.ark);
        }
        long j3 = aVar.arl;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "startTimestamp", j3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent.a) bVar, jSONObject);
    }
}
