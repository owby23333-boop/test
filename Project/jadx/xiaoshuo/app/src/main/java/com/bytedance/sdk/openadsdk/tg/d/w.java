package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class w implements tg {
    private long e;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e(long j) {
        this.e = j;
    }
}
