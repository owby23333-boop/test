package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1442a;
    private int dl;
    private int e;
    private long g;
    private long gc;
    private long m;
    private long z;

    public void z(long j) {
        this.m = j;
    }

    public void z(int i) {
        this.e = i;
    }

    public void g(long j) {
        this.gc = j;
    }

    public void dl(long j) {
        this.z = j;
    }

    public void a(long j) {
        this.g = j;
    }

    public void g(int i) {
        this.dl = i;
    }

    public void dl(int i) {
        this.f1442a = i;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.z);
            jSONObject.put("total_duration", this.g);
            jSONObject.put("vbtt_skip_type", this.dl);
            jSONObject.put("skip_reason", this.f1442a);
            jSONObject.put("video_cache_size", this.gc);
            jSONObject.put("current", this.m);
            jSONObject.put("percent", this.e);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
