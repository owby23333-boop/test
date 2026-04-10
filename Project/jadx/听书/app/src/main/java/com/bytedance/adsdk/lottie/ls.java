package com.bytedance.adsdk.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
class ls implements Interpolator {
    private final float[] g;
    private final float[] z;

    ls(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.z = new float[i];
        this.g = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.z[i2] = fArr[0];
            this.g[i2] = fArr[1];
        }
    }

    ls(float f, float f2, float f3, float f4) {
        this(z(f, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.z.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.z[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.z;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.g[i];
        }
        float f5 = (f - f3) / f4;
        float[] fArr2 = this.g;
        float f6 = fArr2[i];
        return f6 + (f5 * (fArr2[length] - f6));
    }

    private static Path z(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
