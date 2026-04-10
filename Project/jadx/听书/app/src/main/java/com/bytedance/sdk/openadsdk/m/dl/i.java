package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1447a;
    private long dl;
    private long g;
    private String z;

    public void z(String str) {
        this.z = str;
    }

    public void z(long j) {
        this.g = j;
    }

    public void g(long j) {
        this.dl = j;
    }

    public void dl(long j) {
        this.f1447a = j;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.z);
            jSONObject.put("preload_size", this.g);
            jSONObject.put("load_time", this.dl);
            jSONObject.put("local_cache", this.f1447a);
            z(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
