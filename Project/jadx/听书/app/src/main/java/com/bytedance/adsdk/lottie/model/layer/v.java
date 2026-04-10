package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.q;

/* JADX INFO: loaded from: classes3.dex */
public class v extends e {
    private int fo;
    private Path gz;
    private int uy;

    public v(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, Context context) {
        super(gzVar, gzVar2);
        this.gz = null;
        this.fo = -1;
        this.uy = -1;
        if (this.e != null) {
            float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
            this.fo = (int) (this.e.z() * fZ);
            this.uy = (int) (this.e.g() * fZ);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.fo, this.uy);
            Path path = new Path();
            this.gz = path;
            float f = fZ * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.e, com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        q qVarZ = this.g.z();
        View viewZ = qVarZ != null ? qVarZ.z("videoview:", null) : null;
        if (this.fo <= 0 || viewZ == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        z(i);
        float fGz = gz();
        z(viewZ, this.fo, this.uy);
        viewZ.setAlpha(fGz);
        canvas.clipPath(this.gz);
        viewZ.draw(canvas);
        canvas.restore();
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
