package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends dl {
    private final RectF e;
    private final float[] fo;
    private final Paint gz;
    private final gz kb;
    private final Path uy;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> wp;

    kb(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        super(gzVar, gzVar2);
        this.e = new RectF();
        com.bytedance.adsdk.lottie.z.z zVar = new com.bytedance.adsdk.lottie.z.z();
        this.gz = zVar;
        this.fo = new float[8];
        this.uy = new Path();
        this.kb = gzVar2;
        zVar.setAlpha(0);
        zVar.setStyle(Paint.Style.FILL);
        zVar.setColor(gzVar2.ls());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
        int iAlpha = Color.alpha(this.kb.ls());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.f182a.z() == null ? 100 : this.f182a.z().e().intValue())) / 100.0f) * 255.0f);
        this.gz.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> zVar = this.wp;
        if (zVar != null) {
            this.gz.setColorFilter(zVar.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.fo;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.kb.fv();
            float[] fArr2 = this.fo;
            fArr2[3] = 0.0f;
            fArr2[4] = this.kb.fv();
            this.fo[5] = this.kb.p();
            float[] fArr3 = this.fo;
            fArr3[6] = 0.0f;
            fArr3[7] = this.kb.p();
            matrix.mapPoints(this.fo);
            this.uy.reset();
            Path path = this.uy;
            float[] fArr4 = this.fo;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.uy;
            float[] fArr5 = this.fo;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.uy;
            float[] fArr6 = this.fo;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.uy;
            float[] fArr7 = this.fo;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.uy;
            float[] fArr8 = this.fo;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.uy.close();
            canvas.drawPath(this.uy, this.gz);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        super.z(rectF, matrix, z);
        this.e.set(0.0f, 0.0f, this.kb.fv(), this.kb.p());
        this.z.mapRect(this.e);
        rectF.set(this.e);
    }
}
