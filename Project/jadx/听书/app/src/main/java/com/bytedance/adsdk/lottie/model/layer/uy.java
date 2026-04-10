package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.g.ls;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends dl {
    private final com.bytedance.adsdk.lottie.z.z.a e;
    private final a gz;

    uy(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, a aVar, com.bytedance.adsdk.lottie.m mVar) {
        super(gzVar, gzVar2);
        this.gz = aVar;
        com.bytedance.adsdk.lottie.z.z.a aVar2 = new com.bytedance.adsdk.lottie.z.z.a(gzVar, this, new ls("__container", gzVar2.v(), false), mVar);
        this.e = aVar2;
        aVar2.z(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
        this.e.z(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        super.z(rectF, matrix, z);
        this.e.z(rectF, this.z, z);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public com.bytedance.adsdk.lottie.model.g.z wp() {
        com.bytedance.adsdk.lottie.model.g.z zVarWp = super.wp();
        return zVarWp != null ? zVarWp : this.gz.wp();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public com.bytedance.adsdk.lottie.a.uy i() {
        com.bytedance.adsdk.lottie.a.uy uyVarI = super.i();
        return uyVarI != null ? uyVarI : this.gz.i();
    }
}
