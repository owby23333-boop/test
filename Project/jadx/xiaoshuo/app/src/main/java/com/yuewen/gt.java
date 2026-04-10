package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class gt {
    public static final String g = "吸底广告滑动点击实验";
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11750a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11751b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 90;

    public void a() {
        if (this.f11750a <= 0) {
            return;
        }
        this.e++;
        m6.h().b();
    }

    public int b() {
        return this.f11751b;
    }

    public int c() {
        qt1.a(g, "getSlideAngle:" + this.f);
        return this.f;
    }

    public void d() {
        this.f11751b++;
        qt1.a(g, "第多少次插页 mPageAdCount:" + this.f11751b);
    }

    public boolean e() {
        qt1.i(g, "isSlideClickExprmSlideClick：" + this.f11750a);
        qt1.i(g, "isSlideClickExprmShowBottomAdCount：" + this.f11751b);
        int i2 = this.f11750a;
        if (i2 <= 0 || this.f11751b % i2 != 0) {
            return false;
        }
        return f();
    }

    public final boolean f() {
        int i2;
        int iK = m6.h().k();
        qt1.i(g, "isUpToLimit: mHasClick : " + this.e + " mSingleLimit : " + this.d + " dayCount : " + iK + " mDailyLimit : " + this.c);
        int i3 = this.d;
        return (i3 <= 0 || this.e < i3) && ((i2 = this.c) <= 0 || iK < i2);
    }

    public boolean g() {
        return this.f11750a == 0;
    }

    public void h() {
        this.f11751b = 0;
    }

    public void i(int i2) {
        qt1.a(g, "setDailyLimit:" + i2);
        this.c = i2;
    }

    public void j(int i2) {
        qt1.a(g, "setSingleLimit:" + i2);
        this.d = i2;
    }

    public void k(int i2) {
        qt1.a(g, "setSlideAngle:" + i2);
        this.f = i2;
    }

    public void l(int i2) {
        qt1.a(g, "setSlideClick:" + i2);
        this.f11750a = i2;
    }
}
