package com.yuewen;

import android.opengl.Matrix;

/* JADX INFO: loaded from: classes5.dex */
public class o91 extends q91 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f15233b;
    public final float c;
    public final float d;
    public final float e;

    public o91() {
        this(new float[]{0.0f, 0.0f, 0.0f}, 0.0f);
    }

    @Override // com.yuewen.q91
    public float[] a() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = this.f15233b;
        Matrix.translateM(fArr, 0, fArr2[0], fArr2[1], fArr2[2]);
        Matrix.rotateM(fArr, 0, this.c, 0.0f, 0.0f, -1.0f);
        Matrix.scaleM(fArr, 0, this.d, this.e, 1.0f);
        return fArr;
    }

    public float[] d() {
        return this.f15233b;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }

    public float g() {
        return this.e;
    }

    public o91(float[] fArr, float f) {
        this(fArr, f, 1.0f, 1.0f);
    }

    public o91(float[] fArr, float f, float f2, float f3) {
        this(fArr, f, f2, f3, 1.0f);
    }

    public o91(float[] fArr, float f, float f2, float f3, float f4) {
        super(f4);
        this.f15233b = (float[]) fArr.clone();
        this.c = f;
        this.d = f2;
        this.e = f3;
    }
}
