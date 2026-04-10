package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f14917c = new Matrix();

    @NonNull
    public Matrix a(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.b;
            float f3 = fArr[i2];
            float[] fArr2 = this.a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f14917c.setValues(this.b);
        return this.f14917c;
    }
}
