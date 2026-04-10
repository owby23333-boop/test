package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d implements tg {
    private long bf;
    private int d;
    private long e;
    private int tg;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.e);
            jSONObject.put("total_duration", this.bf);
            jSONObject.put("vbtt_skip_type", this.d);
            jSONObject.put("skip_reason", this.tg);
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

    public void bf(int i) {
        this.tg = i;
    }

    public void e(int i) {
        this.d = i;
    }
}
