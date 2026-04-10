package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1443a;
    private int dl;
    private long g;
    private long z;

    public void z(long j) {
        this.z = j;
    }

    public void z(int i) {
        this.f1443a = i;
    }

    public void g(long j) {
        this.g = j;
    }

    public void g(int i) {
        this.dl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.z);
            jSONObject.put("video_cache_size", this.g);
            jSONObject.put("is_auto_play", this.dl);
            jSONObject.put("is_supplement_replay", this.f1443a);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
