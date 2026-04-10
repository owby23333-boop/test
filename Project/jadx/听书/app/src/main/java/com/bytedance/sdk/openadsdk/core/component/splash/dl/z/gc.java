package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

import com.bytedance.sdk.openadsdk.core.iq.j;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1005a = 1;
    public static int gc = 2;
    private j e;
    private com.bytedance.sdk.openadsdk.core.component.splash.z.gc fo;
    private String gz;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g m;

    public gc(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, com.bytedance.sdk.openadsdk.core.component.splash.z.gc gcVar) {
        this.m = gVar;
        this.e = jVar;
        if (gVar != null) {
            this.gz = gVar.a();
        }
        this.fo = gcVar;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g a() {
        return this.m;
    }

    public j gc() {
        return this.e;
    }

    public String m() {
        return this.gz;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.z.gc e() {
        return this.fo;
    }
}
