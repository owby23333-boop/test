package com.bytedance.msdk.dl.e.g;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Runnable {
    private boolean dl = false;
    private Runnable g;
    private com.bytedance.msdk.core.uy.g z;

    public g(com.bytedance.msdk.core.uy.g gVar, Runnable runnable) {
        this.z = gVar;
        this.g = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.msdk.core.uy.g gVar = this.z;
        if (gVar != null && gVar.e() == 4) {
            this.z.m().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.dl = true;
        Runnable runnable = this.g;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean z() {
        return this.dl;
    }
}
