package com.bytedance.sdk.openadsdk.core.kb;

import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z.g {
    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
    }

    private g() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        if (zVarA != null) {
            zVarA.z(this);
        }
    }

    private static class z {
        private static g z = new g();
    }

    public static g dl() {
        return z.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
        com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("dl_work") { // from class: com.bytedance.sdk.openadsdk.core.kb.g.1
            @Override // java.lang.Runnable
            public void run() {
                uy.ls().z(fo.z());
            }
        });
    }
}
