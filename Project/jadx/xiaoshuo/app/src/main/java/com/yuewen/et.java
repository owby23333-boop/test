package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public class et {
    public static final String j = "time";
    public static final String k = "page";
    public String[] d;
    public String[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10848a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10849b = "page";
    public int c = 3;
    public long f = 5000;
    public int g = 0;
    public gt h = new gt();
    public ft i = new ft();

    public void A(int i) {
        this.i.d(i);
    }

    public void B(int i) {
        this.i.e(i);
    }

    public void C(int i) {
        this.i.f(i);
    }

    public void D() {
        this.i.g();
    }

    public void a() {
        this.h.a();
    }

    public int b() {
        return this.f10848a;
    }

    public String[] c() {
        if (this.e == null) {
            this.e = o5.d();
        }
        return this.e;
    }

    public long d() {
        return this.f;
    }

    public String e() {
        return this.f10849b;
    }

    public String[] f() {
        if (this.d == null) {
            this.d = o5.e();
        }
        return this.d;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        return this.h.c();
    }

    public void j() {
        this.h.d();
    }

    public void k() {
        this.i.a();
    }

    public boolean l() {
        return this.i.b();
    }

    public boolean m() {
        return this.h.g();
    }

    public boolean n() {
        qt1.a(bm3.h, "是否触发试验：" + this.h.e());
        return this.h.e();
    }

    public final String o(String str) {
        return TextUtils.equals(j, str) || TextUtils.equals("page", str) ? str : "page";
    }

    public void p(int i) {
        this.f10848a = i;
    }

    public void q(int i) {
        this.h.i(i);
    }

    public void r(int i) {
        this.h.j(i);
    }

    public void s(int i) {
        this.h.k(i);
    }

    public void t(int i) {
        this.h.l(i);
    }

    public void u(String[] strArr) {
        this.e = strArr;
    }

    public void v(long j2) {
        this.f = j2;
    }

    public void w(String str) {
        this.f10849b = o(str);
    }

    public void x(String[] strArr) {
        this.d = strArr;
    }

    public void y(int i) {
        this.c = i;
    }

    public void z(int i) {
        this.g = i;
    }
}
