package com.bytedance.msdk.dl.e.g;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z {
    private g g;
    private Handler z;

    @Override // com.bytedance.msdk.dl.e.g.z
    public void z(Handler handler, com.bytedance.msdk.core.uy.g gVar, g gVar2) {
        this.z = handler;
        this.g = gVar2;
        if (handler == null || gVar2 == null || gVar == null) {
            return;
        }
        gVar.m().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(gVar2, gVar.gz());
    }

    @Override // com.bytedance.msdk.dl.e.g.z
    public void z() {
        g gVar;
        if (this.z == null || (gVar = this.g) == null || gVar.z()) {
            return;
        }
        this.z.removeCallbacks(this.g);
        this.g.run();
    }
}
