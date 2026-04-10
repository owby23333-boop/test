package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class e implements Interpolator {
    private final PointF bf;
    private final PointF d;
    private int e = 0;
    private float tg;

    public e(float f, float f2, float f3, float f4) {
        PointF pointF = new PointF();
        this.bf = pointF;
        PointF pointF2 = new PointF();
        this.d = pointF2;
        this.tg = 0.0f;
        pointF.x = f;
        pointF.y = f2;
        pointF2.x = f3;
        pointF2.y = f4;
    }

    public static double e(double d, double d2, double d3) {
        double d4 = 1.0d - d;
        double d5 = d * d;
        return (d4 * d4 * 3.0d * d * d2) + (d4 * 3.0d * d5 * d3) + (d5 * d);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f < this.e) {
            this.e = 0;
        }
        int i = this.e;
        float f2 = f;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = i * 2.4414062E-4f;
            if (e(f2, this.bf.x, this.d.x) >= f) {
                this.e = i;
                break;
            }
            i++;
        }
        return (float) e(f2, this.bf.y, this.d.y);
    }
}
