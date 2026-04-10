package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class zk implements tg {
    private long bf;
    private int d;
    private long e;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.e);
            jSONObject.put("video_cache_size", this.bf);
            jSONObject.put("is_auto_play", this.d);
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
