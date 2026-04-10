package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v implements a {
    public long dl;
    public int g;
    public long z;

    public void z(long j) {
        this.z = j;
    }

    public void z(int i) {
        this.g = i;
    }

    public void g(long j) {
        this.dl = j;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.z);
            jSONObject.put("buffers_count", this.g);
            jSONObject.put("total_duration", this.dl);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
