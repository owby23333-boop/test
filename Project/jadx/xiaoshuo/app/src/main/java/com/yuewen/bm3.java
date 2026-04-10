package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class bm3 {
    public static final String h = "HYY---滑动点击实验";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9181a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9182b = 0;
    public int c = 0;
    public boolean d = false;
    public int e = 0;
    public int f = 0;
    public int g = 0;

    public void a() {
        this.g++;
        m6.h().d();
    }

    public int b() {
        return this.c;
    }

    public void c() {
        this.c++;
        qt1.a(h, "第多少次插页 mPageAdCount:" + this.c);
    }

    public void d(boolean z) {
        this.c++;
        this.d = z;
        qt1.a(h, "第多少次插页 mPageAdCount:" + this.c + ", top value = " + this.d);
    }

    public boolean e() {
        int i;
        if ((this.f9181a == 2 && !this.d) || (i = this.f9182b) == 0) {
            return false;
        }
        if (i == 1 || this.c % i == 0) {
            return f();
        }
        return false;
    }

    public final boolean f() {
        if (this.e == 0) {
            int i = this.f;
            if (i == 0) {
                qt1.t(h, "未配置当日/单次上限");
                return true;
            }
            if (this.g >= i) {
                qt1.t(h, "达到单次上限");
                return false;
            }
            qt1.t(h, "触发滑动点击 mDailyLimit:0");
            return true;
        }
        int iT = m6.h().t();
        qt1.i(h, "当日已点击的次数: " + iT);
        int i2 = this.f;
        if (i2 == 0) {
            if (iT >= this.e) {
                qt1.t(h, "达到当日上限");
                return false;
            }
            qt1.t(h, "未到当日上限");
            return true;
        }
        if (iT >= this.e) {
            qt1.t(h, "达到当日上限");
            return false;
        }
        if (this.g < i2) {
            return true;
        }
        qt1.t(h, "达到单次上限");
        return false;
    }

    public boolean g() {
        return this.f9182b == 0;
    }

    public void h() {
        this.c = 0;
    }

    public void i(int i) {
        qt1.a(h, "setDailyLimit:" + i);
        this.e = i;
    }

    public void j(int i) {
        qt1.a(h, "setSingleLimit:" + i);
        this.f = i;
    }

    public void k(int i) {
        qt1.a(h, "setSlideClick:" + i);
        this.f9182b = i;
    }

    public void l(int i) {
        this.f9181a = i;
    }
}
