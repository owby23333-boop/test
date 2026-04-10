package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lh implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aJz = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aJz)) {
            bVar.aJz = "";
        }
        bVar.aJA = jSONObject.optInt("core_pool_size");
        bVar.aJB = jSONObject.optInt("max_pool_size");
        bVar.aJC = jSONObject.optInt("current_pool_size");
        bVar.aJD = jSONObject.optInt("active_count");
        bVar.aJE = jSONObject.optLong("task_wait_avg_ms");
        bVar.aJF = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aJG = jSONObject.optInt("queue_size");
        bVar.aJH = jSONObject.optLong("pass_timestamp");
        bVar.aJI = jSONObject.optInt("func_ratio_count");
    }

    private static JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aJz != null && !bVar.aJz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pool_name", bVar.aJz);
        }
        if (bVar.aJA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "core_pool_size", bVar.aJA);
        }
        if (bVar.aJB != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "max_pool_size", bVar.aJB);
        }
        if (bVar.aJC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "current_pool_size", bVar.aJC);
        }
        if (bVar.aJD != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "active_count", bVar.aJD);
        }
        if (bVar.aJE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_wait_avg_ms", bVar.aJE);
        }
        if (bVar.aJF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_succ_count", bVar.aJF);
        }
        if (bVar.interval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interval_ms", bVar.interval);
        }
        if (bVar.aJG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "queue_size", bVar.aJG);
        }
        if (bVar.aJH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pass_timestamp", bVar.aJH);
        }
        if (bVar.aJI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", bVar.aJI);
        }
        return jSONObject;
    }
}
