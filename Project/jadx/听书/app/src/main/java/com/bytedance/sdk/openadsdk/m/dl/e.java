package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a {
    private int dl = 0;
    private long g;
    private long z;

    public void z(long j) {
        this.z = j;
    }

    public void g(long j) {
        this.g = j;
    }

    public void z(int i) {
        this.dl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.z);
            jSONObject.put("buffers_time", this.g);
            jSONObject.put("video_backup", this.dl);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
