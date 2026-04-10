package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ga implements tg {
    public long bf;
    public int d;
    public long e;
    public int tg = 0;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.e);
            jSONObject.put("buffers_time", this.bf);
            jSONObject.put("break_reason", this.d);
            jSONObject.put("video_backup", this.tg);
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
