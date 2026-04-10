package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.gc.gc;
import com.bytedance.sdk.openadsdk.core.iq.gz;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1008a;
    public gc.z gc;
    public gz.dl m;
    public int z = 0;
    public long g = 0;
    public int dl = -1;

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ad, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int z(int r11) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.g.z(int):int");
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        gz.g gVarZ = com.bytedance.sdk.openadsdk.core.iq.gz.z();
        if (gVarZ == null || gVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.gc.gc.z(gVar.a(), gVarZ.uy()).g(gVarZ.uy());
    }

    public boolean z() {
        return this.z == 4;
    }

    public boolean g() {
        gz.dl dlVar;
        if (this.g <= 0 || this.z != 3) {
            return false;
        }
        gc.z zVar = this.gc;
        g((zVar == null || (dlVar = this.m) == null) ? -1 : zVar.z(dlVar.gc(), this.m));
        this.dl = 2;
        return true;
    }

    private void g(int i) {
        if (i > 0) {
            this.g = System.currentTimeMillis() - ((((long) i) * 60) * 1000);
        } else if (i == 0) {
            this.g = 0L;
        } else {
            this.g = System.currentTimeMillis();
        }
    }
}
