package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class t implements tg {
    public int bf;
    public long d;
    public long e;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.e);
            jSONObject.put("buffers_count", this.bf);
            jSONObject.put("total_duration", this.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bf(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void e(int i) {
        this.bf = i;
    }
}
