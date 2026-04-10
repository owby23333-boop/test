package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public class tb extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.dl f215a;
    private final com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> e;
    private final String gc;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> gz;
    private final boolean m;

    public tb(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.fv fvVar) {
        super(gzVar, dlVar, fvVar.e().z(), fvVar.gz().z(), fvVar.fo(), fvVar.dl(), fvVar.a(), fvVar.gc(), fvVar.m());
        this.f215a = dlVar;
        this.gc = fvVar.z();
        this.m = fvVar.uy();
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ = fvVar.g().z();
        this.e = zVarZ;
        zVarZ.z(this);
        dlVar.z(zVarZ);
    }

    @Override // com.bytedance.adsdk.lottie.z.z.z, com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        if (this.m) {
            return;
        }
        this.g.setColor(((com.bytedance.adsdk.lottie.z.g.g) this.e).fo());
        if (this.gz != null) {
            this.g.setColorFilter(this.gz.e());
        }
        super.z(canvas, matrix, i);
    }
}
