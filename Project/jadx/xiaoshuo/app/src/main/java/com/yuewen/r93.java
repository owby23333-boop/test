package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16986a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16987b = false;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public float f = 1.2f;
    public float g = 0.0f;
    public float h = 4.0f;
    public float i = 0.0f;
    public int j = 12;
    public int k = 0;

    public abstract void a();

    public abstract void b();

    public abstract void c(Bitmap bitmap, Rect rect);

    public final void d() {
        e();
        if (this.f16987b) {
            return;
        }
        a();
        this.f16987b = true;
    }

    public final void e() {
        if (this.f16986a) {
            return;
        }
        b();
        this.f16986a = true;
    }

    public float f() {
        return this.i;
    }

    public float g() {
        return this.f;
    }

    public int h() {
        return this.c;
    }

    public int i() {
        e();
        return this.e;
    }

    public int j() {
        e();
        return this.d;
    }

    public float k() {
        return this.g;
    }

    public float l() {
        return this.h;
    }

    public int m() {
        return this.k;
    }

    public float n() {
        return this.j;
    }

    public void o(Bitmap bitmap, Rect rect) {
        d();
        c(bitmap, rect);
    }

    public final void p() {
        this.f16986a = false;
        this.f16987b = false;
    }

    public void q(float f) {
        if (this.i != f) {
            this.i = f;
            p();
        }
    }

    public void r(float f) {
        if (this.f != f) {
            this.f = f;
            p();
        }
    }

    public void s(int i) {
        if (this.c != i) {
            this.c = i;
            p();
        }
    }

    public void t(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void u(float f) {
        if (this.g != f) {
            this.g = f;
            p();
        }
    }

    public void v(float f) {
        if (this.h != f) {
            this.h = f;
            p();
        }
    }

    public void w(int i) {
        this.k = i;
    }

    public void x(int i) {
        if (this.j != i) {
            this.j = i;
            p();
        }
    }
}
