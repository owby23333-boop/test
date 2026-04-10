package com.yuewen;

import android.opengl.Matrix;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n91 {
    public static final /* synthetic */ boolean e = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f14794b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14793a = false;
    public float[] c = new float[16];
    public float d = 1.0f;

    public n91() {
        float[] fArr = new float[16];
        this.f14794b = fArr;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(this.c, 0);
    }

    public void a() {
        b();
        this.f14793a = false;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public void e() {
        if (this.f14793a) {
            c();
        }
    }

    public float f() {
        return this.d;
    }

    public float[] g() {
        return this.c;
    }

    public float[] h() {
        return this.f14794b;
    }

    public boolean i() {
        return this.f14793a;
    }

    public void j(float[] fArr) {
        this.f14794b = (float[]) fArr.clone();
        d();
        this.f14793a = true;
    }

    public void k(float f) {
        this.d = f;
    }

    public void l(float[] fArr) {
        this.c = (float[]) fArr.clone();
    }
}
