package com.bytedance.sdk.openadsdk.core.z;

import com.bytedance.sdk.openadsdk.core.sy;

/* JADX INFO: loaded from: classes2.dex */
public class z implements sy.g {
    private int g;
    private sy.g z;

    public z(sy.g gVar) {
        this.z = gVar;
    }

    public void z(int i) {
        this.g = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
        sy.g gVar2 = this.z;
        if (gVar2 != null) {
            gVar2.z(i, str, gVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(final com.bytedance.sdk.openadsdk.core.iq.z zVar, final com.bytedance.sdk.openadsdk.core.iq.g gVar) {
        int i = this.g;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.bytedance.sdk.openadsdk.core.dl.gc.z().wp() & 1) != 1;
        }
        if (z) {
            if (this.z != null) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z.z(zVar, gVar);
                    }
                };
                if (z2) {
                    com.bytedance.sdk.openadsdk.hh.e.z(runnable);
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.hh.e.g(runnable);
                    return;
                }
            }
            return;
        }
        sy.g gVar2 = this.z;
        if (gVar2 != null) {
            gVar2.z(zVar, gVar);
        }
    }
}
