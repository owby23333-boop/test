package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.iq.z f1007a;
    private long e;
    private long fo;
    private boolean gc;
    private long gz;
    private long m;

    public m(com.bytedance.sdk.openadsdk.core.iq.z zVar, boolean z) {
        this.f1007a = zVar;
        if (zVar != null && zVar.g() != null && !this.f1007a.g().isEmpty()) {
            this.g = this.f1007a.g().get(0);
        }
        this.gc = z;
    }

    public com.bytedance.sdk.openadsdk.core.iq.z a() {
        return this.f1007a;
    }

    public boolean gc() {
        return this.gc;
    }

    public long m() {
        return this.m;
    }

    public void g(long j) {
        this.m = j;
    }

    public long e() {
        return this.e;
    }

    public void dl(long j) {
        this.e = j;
    }

    public long gz() {
        return this.gz;
    }

    public void a(long j) {
        this.gz = j;
    }

    public long fo() {
        return this.fo;
    }

    public void gc(long j) {
        this.fo = j;
    }
}
