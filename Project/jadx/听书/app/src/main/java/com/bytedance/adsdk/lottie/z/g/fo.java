package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends com.bytedance.adsdk.lottie.m.z<PointF> {
    private final com.bytedance.adsdk.lottie.m.z<PointF> kb;
    private Path uy;

    public fo(com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.m.z<PointF> zVar) {
        super(mVar, zVar.z, zVar.g, zVar.dl, zVar.f160a, zVar.gc, zVar.m, zVar.e);
        this.kb = zVar;
        z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z() {
        boolean z = (this.g == 0 || this.z == 0 || !((PointF) this.z).equals(((PointF) this.g).x, ((PointF) this.g).y)) ? false : true;
        if (this.z == 0 || this.g == 0 || z) {
            return;
        }
        this.uy = com.bytedance.adsdk.lottie.gc.fo.z((PointF) this.z, (PointF) this.g, this.kb.gz, this.kb.fo);
    }

    Path g() {
        return this.uy;
    }
}
