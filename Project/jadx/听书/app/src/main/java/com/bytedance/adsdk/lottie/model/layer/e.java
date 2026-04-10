package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class e extends dl {
    protected final com.bytedance.adsdk.lottie.fo e;
    private final Rect fo;
    private final Paint gz;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> kb;
    private final Rect uy;
    private com.bytedance.adsdk.lottie.z.g.z<Bitmap, Bitmap> wp;

    e(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        super(gzVar, gzVar2);
        this.gz = new com.bytedance.adsdk.lottie.z.z(3);
        this.fo = new Rect();
        this.uy = new Rect();
        this.e = gzVar.m(gzVar2.e());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
        Bitmap bitmapV = v();
        if (bitmapV == null || bitmapV.isRecycled() || this.e == null) {
            return;
        }
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        this.gz.setAlpha(i);
        com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> zVar = this.kb;
        if (zVar != null) {
            this.gz.setColorFilter(zVar.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.fo.set(0, 0, bitmapV.getWidth(), bitmapV.getHeight());
        if (this.g.m()) {
            this.uy.set(0, 0, (int) (this.e.z() * fZ), (int) (this.e.g() * fZ));
        } else {
            this.uy.set(0, 0, (int) (bitmapV.getWidth() * fZ), (int) (bitmapV.getHeight() * fZ));
        }
        canvas.drawBitmap(bitmapV, this.fo, this.uy, this.gz);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        super.z(rectF, matrix, z);
        if (this.e != null) {
            float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
            rectF.set(0.0f, 0.0f, this.e.z() * fZ, this.e.g() * fZ);
            this.z.mapRect(rectF);
        }
    }

    private Bitmap v() {
        Bitmap bitmapE;
        com.bytedance.adsdk.lottie.z.g.z<Bitmap, Bitmap> zVar = this.wp;
        if (zVar != null && (bitmapE = zVar.e()) != null) {
            return bitmapE;
        }
        Bitmap bitmapGc = this.g.gc(this.dl.e());
        if (bitmapGc != null) {
            return bitmapGc;
        }
        com.bytedance.adsdk.lottie.fo foVar = this.e;
        if (foVar != null) {
            return foVar.v();
        }
        return null;
    }
}
