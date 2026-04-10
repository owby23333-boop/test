package com.yuewen;

import com.duokan.advertisement.util.AdPreference;

/* JADX INFO: loaded from: classes12.dex */
public class ft {
    public static final String f = "吸底广告按钮增加抖动动效实验";
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11218a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11219b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;

    public void a() {
        this.f11219b++;
    }

    public boolean b() {
        int i2 = this.c;
        boolean zC = (i2 <= 0 || this.f11219b % i2 != 0) ? false : c();
        qt1.i(f, "BottomAdShakeExperiment,mShakeAnimationCount:" + this.f11219b + "; isBottomAdShakeAnimExper:" + zC);
        return zC;
    }

    public final boolean c() {
        int i2;
        int iC = AdPreference.f2716a.c();
        int i3 = this.e;
        return (i3 <= 0 || this.f11218a < i3) && ((i2 = this.d) <= 0 || iC < i2);
    }

    public void d(int i2) {
        this.c = i2;
    }

    public void e(int i2) {
        this.d = i2;
    }

    public void f(int i2) {
        this.e = i2;
    }

    public void g() {
        if (this.c <= 0) {
            return;
        }
        this.f11218a++;
        AdPreference.f2716a.a();
    }
}
