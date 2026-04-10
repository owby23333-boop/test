package com.yuewen;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes5.dex */
public class v93 extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f18934b;
    public final float c;
    public final float d;
    public final float e;
    public final boolean f;
    public Camera g;

    public v93(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.f18933a = f;
        this.f18934b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = z;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f18933a;
        float f3 = f2 + ((this.f18934b - f2) * f);
        float f4 = this.c;
        float f5 = this.d;
        Camera camera = this.g;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f) {
            camera.translate(0.0f, 0.0f, this.e * f);
        } else {
            camera.translate(0.0f, 0.0f, this.e * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.g = new Camera();
    }
}
