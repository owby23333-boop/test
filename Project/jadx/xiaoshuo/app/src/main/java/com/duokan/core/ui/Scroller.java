package com.duokan.core.ui;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes12.dex */
class Scroller {
    public static final int D = 100;
    public static float F = 0.0f;
    public static float G = 0.0f;
    public static final int w = 250;
    public static final int x = 0;
    public static final int y = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2927b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public long l;
    public int m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public Interpolator r;
    public boolean s;
    public float t;
    public float u;
    public final float v;
    public static float z = (float) (Math.log(0.75d) / Math.log(0.9d));
    public static float A = 800.0f;
    public static float B = 0.4f;
    public static float C = 1.0f - 0.4f;
    public static final float[] E = new float[101];

    static {
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i = 0; i <= 100; i++) {
            float f4 = i / 100.0f;
            float f5 = 1.0f;
            while (true) {
                float f6 = ((f5 - f3) / 2.0f) + f3;
                float f7 = 1.0f - f6;
                f = 3.0f * f6 * f7;
                f2 = f6 * f6 * f6;
                float f8 = (((f7 * B) + (C * f6)) * f) + f2;
                if (Math.abs(f8 - f4) < 1.0E-5d) {
                    break;
                } else if (f8 > f4) {
                    f5 = f6;
                } else {
                    f3 = f6;
                }
            }
            E[i] = f + f2;
        }
        E[100] = 1.0f;
        F = 8.0f;
        G = 1.0f;
        G = 1.0f / w(1.0f);
    }

    public Scroller(Context context) {
        this(context, null);
    }

    public static float w(float f) {
        float f2 = f * F;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f)) * G;
    }

    public void a() {
        this.j = this.d;
        this.k = this.e;
        this.q = true;
    }

    public final float b(float f) {
        return this.v * 386.0878f * f;
    }

    public boolean c() {
        if (this.q) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
        int i = this.m;
        if (iCurrentAnimationTimeMillis < i) {
            int i2 = this.f2926a;
            if (i2 == 0) {
                float f = iCurrentAnimationTimeMillis * this.n;
                Interpolator interpolator = this.r;
                float fW = interpolator == null ? w(f) : interpolator.getInterpolation(f);
                this.j = this.f2927b + Math.round(this.o * fW);
                this.k = this.c + Math.round(fW * this.p);
            } else if (i2 == 1) {
                float f2 = iCurrentAnimationTimeMillis / i;
                int i3 = (int) (f2 * 100.0f);
                float f3 = i3 / 100.0f;
                int i4 = i3 + 1;
                float[] fArr = E;
                float f4 = fArr[i3];
                float f5 = f4 + (((f2 - f3) / ((i4 / 100.0f) - f3)) * (fArr[i4] - f4));
                int iRound = this.f2927b + Math.round((this.d - r0) * f5);
                this.j = iRound;
                int iMin = Math.min(iRound, this.g);
                this.j = iMin;
                this.j = Math.max(iMin, this.f);
                int iRound2 = this.c + Math.round(f5 * (this.e - r0));
                this.k = iRound2;
                int iMin2 = Math.min(iRound2, this.i);
                this.k = iMin2;
                int iMax = Math.max(iMin2, this.h);
                this.k = iMax;
                if (this.j == this.d && iMax == this.e) {
                    this.q = true;
                }
            }
        } else {
            this.j = this.d;
            this.k = this.e;
            this.q = true;
        }
        return true;
    }

    public void d(int i) {
        int iV = v() + i;
        this.m = iV;
        this.n = 1.0f / iV;
        this.q = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.ui.Scroller.e(int, int, int, int, int, int, int, int):void");
    }

    public final void f(boolean z2) {
        this.q = z2;
    }

    public float g() {
        return this.t - ((this.u * v()) / 2000.0f);
    }

    public final int h() {
        return this.j;
    }

    public final int i() {
        return this.k;
    }

    public final int j() {
        return this.m;
    }

    public final int k() {
        return this.d;
    }

    public final int l() {
        return this.e;
    }

    public final int m() {
        return this.f2927b;
    }

    public final int n() {
        return this.c;
    }

    public final boolean o() {
        return this.q;
    }

    public boolean p(float f, float f2) {
        return !this.q && Math.signum(f) == Math.signum((float) (this.d - this.f2927b)) && Math.signum(f2) == Math.signum((float) (this.e - this.c));
    }

    public void q(int i) {
        this.d = i;
        this.o = i - this.f2927b;
        this.q = false;
    }

    public void r(int i) {
        this.e = i;
        this.p = i - this.c;
        this.q = false;
    }

    public final void s(float f) {
        this.u = b(f);
    }

    public void t(int i, int i2, int i3, int i4) {
        u(i, i2, i3, i4, 250);
    }

    public void u(int i, int i2, int i3, int i4, int i5) {
        this.f2926a = 0;
        this.q = false;
        this.m = i5;
        this.l = AnimationUtils.currentAnimationTimeMillis();
        this.f2927b = i;
        this.c = i2;
        this.d = i + i3;
        this.e = i2 + i4;
        this.o = i3;
        this.p = i4;
        this.n = 1.0f / this.m;
    }

    public int v() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z2) {
        this.q = true;
        this.r = interpolator;
        this.v = context.getResources().getDisplayMetrics().density * 160.0f;
        this.u = b(ViewConfiguration.getScrollFriction());
        this.s = z2;
    }
}
