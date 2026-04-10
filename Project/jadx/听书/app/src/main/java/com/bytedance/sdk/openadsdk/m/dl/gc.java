package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1445a = 0;
    public int dl;
    public long g;
    private int gc;
    public long z;

    public void z(int i) {
        this.gc = i;
    }

    public void z(long j) {
        this.z = j;
    }

    public void g(long j) {
        this.g = j;
    }

    public void g(int i) {
        this.dl = i;
    }

    public void dl(int i) {
        this.f1445a = i;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.z);
            jSONObject.put("buffers_time", this.g);
            jSONObject.put("break_reason", this.dl);
            jSONObject.put("video_backup", this.f1445a);
            jSONObject.put("vbtt_skip_type", this.gc);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
