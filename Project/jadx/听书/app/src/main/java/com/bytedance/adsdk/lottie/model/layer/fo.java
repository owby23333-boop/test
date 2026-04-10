package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends dl {
    fo(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        super(gzVar, gzVar2);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        super.z(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
