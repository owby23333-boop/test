package com.bytedance.sdk.openadsdk.i.z;

import com.bytedance.sdk.component.m.gz;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.openadsdk.core.io.z.z;
import com.bytedance.sdk.openadsdk.core.iq.lw;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.core.io.z.z {
    private lw z;

    private void z(ls lsVar) {
        gz httpTime = lsVar.getHttpTime();
        if (httpTime == null || !a()) {
            return;
        }
        z(httpTime.getStartRequestTime(), httpTime.getFirstFrameTime());
    }

    private boolean a() {
        lw lwVar = this.z;
        return lwVar != null && lwVar.iq();
    }

    private void z(long j, long j2) {
        this.z.v(j2);
        lw lwVar = this.z;
        lwVar.fo(j2 - lwVar.q());
        this.z.js(j2 - j);
    }

    private void gc() {
        if (a()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            lw lwVar = this.z;
            lwVar.gz(jCurrentTimeMillis - lwVar.js());
            this.z.i(jCurrentTimeMillis);
        }
    }

    public lw dl() {
        return this.z;
    }

    public void z(lw lwVar) {
        this.z = lwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.io.z.z
    protected void z(ls lsVar, z.g gVar) {
        z(lsVar);
        super.z(lsVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.io.z.z
    protected void z() {
        gc();
    }
}
