package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ib implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.c> {
    private static void a(com.kwad.sdk.core.threads.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.alP = jSONObject.optString("pool_name");
        if (cVar.alP == JSONObject.NULL) {
            cVar.alP = "";
        }
        cVar.alQ = jSONObject.optInt("core_pool_size");
        cVar.alR = jSONObject.optInt("max_pool_size");
        cVar.alS = jSONObject.optInt("current_pool_size");
        cVar.alT = jSONObject.optInt("active_count");
        cVar.alU = jSONObject.optLong("task_wait_avg_ms");
        cVar.alV = jSONObject.optLong("task_succ_count");
        cVar.interval = jSONObject.optLong("interval_ms");
        cVar.alW = jSONObject.optInt("queue_size");
        cVar.alX = jSONObject.optLong("pass_timestamp");
        cVar.alY = jSONObject.optInt("func_ratio_count");
    }

    private static JSONObject b(com.kwad.sdk.core.threads.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.alP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pool_name", cVar.alP);
        }
        int i2 = cVar.alQ;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "core_pool_size", i2);
        }
        int i3 = cVar.alR;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "max_pool_size", i3);
        }
        int i4 = cVar.alS;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "current_pool_size", i4);
        }
        int i5 = cVar.alT;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "active_count", i5);
        }
        long j2 = cVar.alU;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "task_wait_avg_ms", j2);
        }
        long j3 = cVar.alV;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "task_succ_count", j3);
        }
        long j4 = cVar.interval;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "interval_ms", j4);
        }
        int i6 = cVar.alW;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "queue_size", i6);
        }
        long j5 = cVar.alX;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pass_timestamp", j5);
        }
        int i7 = cVar.alY;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "func_ratio_count", i7);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.c) bVar, jSONObject);
    }
}
