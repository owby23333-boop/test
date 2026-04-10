package com.bytedance.sdk.openadsdk.core.component.splash.dl.dl;

import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ls.dl.g.g f1000a;
    private a<fo, e> dl;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl g;
    private com.bytedance.sdk.openadsdk.core.component.splash.a.g z;

    public z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar, a<fo, e> aVar, com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar) {
        if (dlVar == null || aVar == null) {
            return;
        }
        this.g = dlVar;
        this.dl = aVar;
        com.bytedance.sdk.openadsdk.core.component.splash.a.g gVar = new com.bytedance.sdk.openadsdk.core.component.splash.a.g(dlVar.getContext(), dlVar.e(), dlVar.m(), this.g.gz(), dlVar, aVar, zVar);
        this.z = gVar;
        this.f1000a = gVar;
    }

    public void z(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.a.g gVar = this.z;
        if (gVar != null) {
            gVar.g(i);
        }
    }

    public void z(m mVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar = this.g;
        if (dlVar == null || dlVar.f1002a == null || mVar == null) {
            return;
        }
        boolean z = mVar.z();
        this.g.f1002a.z(z);
        com.bytedance.sdk.openadsdk.core.component.splash.a.g gVar = this.z;
        if (gVar != null) {
            gVar.g(z);
        }
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.g z() {
        return this.f1000a;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.component.splash.a.g gVar = this.z;
        if (gVar != null) {
            gVar.z(this.g, this.dl);
        }
    }
}
