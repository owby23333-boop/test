package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1448a;
    private long dl;
    private long g;
    private String gc;
    private String m;
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

    public void z(int i) {
        this.f1448a = i;
    }

    public void g(String str) {
        this.gc = str;
    }

    public void dl(String str) {
        this.m = str;
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
            jSONObject.put("error_code", this.f1448a);
            jSONObject.put("error_message", this.gc);
            jSONObject.put("error_message_server", this.m);
            z(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
