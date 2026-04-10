package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class p implements tg {
    private long bf;
    private int d = 0;
    private long e;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.e);
            jSONObject.put("buffers_time", this.bf);
            jSONObject.put("video_backup", this.d);
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

    public void e(int i) {
        this.d = i;
    }
}
