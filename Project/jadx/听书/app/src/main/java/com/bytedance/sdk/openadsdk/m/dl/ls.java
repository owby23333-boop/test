package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ls implements a {
    private boolean g;
    private long z;

    public void z(long j) {
        this.z = j;
    }

    public void z(boolean z) {
        this.g = z;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.z);
            jSONObject.put("is_auto_play", this.g);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
