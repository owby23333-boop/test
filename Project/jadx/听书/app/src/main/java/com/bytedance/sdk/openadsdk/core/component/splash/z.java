package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.gk;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private com.bytedance.sdk.openadsdk.a.z.g.z.g z;

    public void z(com.bytedance.sdk.openadsdk.a.z.g.z.g gVar) {
        this.z = gVar;
    }

    public void z() {
        com.bytedance.sdk.openadsdk.a.z.g.z.g gVar;
        if (gk.dl < 4700 || (gVar = this.z) == null) {
            return;
        }
        gVar.g();
        this.z = null;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        com.bytedance.sdk.openadsdk.a.z.g.z.g gVar2;
        if (gk.dl < 4700 || (gVar2 = this.z) == null) {
            return;
        }
        gVar2.z(gVar);
    }

    public void g() {
        com.bytedance.sdk.openadsdk.a.z.g.z.g gVar;
        if (gk.dl < 4700 || (gVar = this.z) == null) {
            return;
        }
        gVar.z();
    }

    public boolean dl() {
        return gk.dl < 4700 || this.z == null;
    }
}
