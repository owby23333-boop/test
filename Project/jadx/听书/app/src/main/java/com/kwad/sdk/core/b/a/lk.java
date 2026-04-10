package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lk implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent.a) bVar, jSONObject);
    }

    private static void a(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aPG = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aPH = jSONObject.optBoolean("runIdle");
        aVar.aPI = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aPI)) {
            aVar.aPI = "";
        }
        aVar.aPJ = jSONObject.optLong("startTimestamp");
    }

    private static JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aPG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endTimestamp", aVar.aPG);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        if (aVar.aPH) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "runIdle", aVar.aPH);
        }
        if (aVar.aPI != null && !aVar.aPI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stackTraceDetail", aVar.aPI);
        }
        if (aVar.aPJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "startTimestamp", aVar.aPJ);
        }
        return jSONObject;
    }
}
