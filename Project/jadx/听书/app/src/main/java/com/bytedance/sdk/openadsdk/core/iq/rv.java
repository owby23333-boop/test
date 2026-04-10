package com.bytedance.sdk.openadsdk.core.iq;

/* JADX INFO: loaded from: classes2.dex */
public class rv {
    private int dl;
    private int g;
    private int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1192a = 1;
    private int gc = 0;

    public int z() {
        return this.z;
    }

    public void z(int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            this.z = 2;
        } else {
            this.z = i;
        }
    }

    public int g() {
        return this.g;
    }

    public void g(int i) {
        if (i <= 0 || i >= e()) {
            this.g = 16;
        } else {
            this.g = i;
        }
    }

    public int dl() {
        return this.dl;
    }

    public void dl(int i) {
        if (i <= 0 || i >= m()) {
            int i2 = this.z;
            if (i2 == 3 || i2 == 4) {
                this.dl = 30;
                return;
            } else {
                this.dl = 16;
                return;
            }
        }
        this.dl = i;
    }

    private int m() {
        return com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), com.bytedance.sdk.openadsdk.core.un.oq.gc(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }

    private int e() {
        return com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }

    public int a() {
        return this.f1192a == 2 ? 2 : 1;
    }

    public void a(int i) {
        this.f1192a = i;
    }

    public int gc() {
        return this.gc;
    }

    public void gc(int i) {
        this.gc = i;
    }

    public static boolean z(na naVar) {
        return (naVar == null || naVar.nm() == null || naVar.nm().gc() != 1) ? false : true;
    }
}
