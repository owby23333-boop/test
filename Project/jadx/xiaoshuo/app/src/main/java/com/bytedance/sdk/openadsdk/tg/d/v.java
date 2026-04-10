package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class v implements tg {
    private long bf;
    private long e;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.e);
            jSONObject.put("total_duration", this.bf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bf(long j) {
        this.bf = j;
    }

    public void e(long j) {
        this.e = j;
    }
}
