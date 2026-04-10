package com.anythink.core.common.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.e.k;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T extends k> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7278c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7279d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7280e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7281f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7282g = 10;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f7283w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f7284x = 2;
    protected String A;
    protected int B;
    protected String C;
    protected String D;
    protected String E;
    protected String F;
    protected String G;
    protected String H;
    protected Bitmap I;
    protected k J;
    protected String K;
    protected String L;
    protected int M;
    protected String N;
    protected String O;
    protected String P;
    protected String Q;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f7285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected String f7286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f7287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f7288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f7289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected String f7290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected String f7291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f7292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected String f7293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f7294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f7295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected String f7296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected String f7297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected String f7298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f7299v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f7300y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f7301z;

    protected i() {
    }

    private String N() {
        return this.A;
    }

    private int a() {
        return this.M;
    }

    public final String A() {
        return this.f7297t;
    }

    public final String B() {
        return this.f7298u;
    }

    public final int C() {
        return this.f7299v;
    }

    public final int D() {
        return this.f7300y;
    }

    public final boolean E() {
        return !TextUtils.isEmpty(this.f7294q);
    }

    public final String F() {
        return this.D;
    }

    public final String G() {
        return this.E;
    }

    public final String H() {
        return this.F;
    }

    public final String I() {
        return this.G;
    }

    public final Bitmap J() {
        return this.I;
    }

    public final boolean K() {
        return (TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D) || TextUtils.isEmpty(this.F) || TextUtils.isEmpty(this.G)) ? false : true;
    }

    public boolean L() {
        return false;
    }

    public final String M() {
        return this.L;
    }

    public abstract List<String> b(T t2);

    public final void b(int i2) {
        this.M = i2;
    }

    public final void c(String str) {
        this.P = str;
    }

    public abstract int d();

    public final void d(String str) {
        this.Q = str;
    }

    public final String e() {
        return this.P;
    }

    public final String f() {
        return this.Q;
    }

    public final boolean g() {
        return this.M == 1;
    }

    public final String h() {
        return this.N;
    }

    public final String i() {
        return this.O;
    }

    public final String j() {
        return this.K;
    }

    public final k k() {
        return this.J;
    }

    public final String l() {
        return this.H;
    }

    public abstract String m();

    public final void m(String str) {
        this.f7288k = str;
    }

    public final int n() {
        return this.B;
    }

    public final String o() {
        return this.C;
    }

    public final String p() {
        return this.f7285h;
    }

    public final String q() {
        return this.f7286i;
    }

    public final String r() {
        return this.f7287j;
    }

    public final String s() {
        return this.f7288k;
    }

    public final String t() {
        return this.f7289l;
    }

    public final String u() {
        return this.f7291n;
    }

    public final String v() {
        return this.f7292o;
    }

    public final String w() {
        return this.f7293p;
    }

    public final String x() {
        return this.f7294q;
    }

    public final String y() {
        return this.f7295r;
    }

    public final String z() {
        return this.f7296s;
    }

    private String b() {
        return this.f7290m;
    }

    public final void A(String str) {
        this.F = str;
    }

    public final void B(String str) {
        this.G = str;
    }

    public final void C(String str) {
        this.L = str;
    }

    public final boolean D(String str) {
        return TextUtils.equals(this.f7294q, str) && !TextUtils.isEmpty(str);
    }

    public final void a(k kVar) {
        this.J = kVar;
    }

    public final void c(int i2) {
        this.B = i2;
    }

    public final void d(int i2) {
        this.f7299v = i2;
    }

    public final void e(String str) {
        this.N = str;
    }

    public final void f(String str) {
        this.O = str;
    }

    public final void g(String str) {
        this.K = str;
    }

    public final void h(String str) {
        this.H = str;
    }

    public final void i(String str) {
        this.C = str;
    }

    public final void j(String str) {
        this.f7285h = str;
    }

    public final void k(String str) {
        this.f7286i = str;
    }

    public final void l(String str) {
        this.f7287j = str;
    }

    public final void n(String str) {
        this.f7289l = str;
    }

    public final void o(String str) {
        this.f7290m = str;
    }

    public final void p(String str) {
        this.f7291n = str;
    }

    public final void q(String str) {
        this.f7292o = str;
    }

    public final void r(String str) {
        this.f7293p = str;
    }

    public final void s(String str) {
        this.f7294q = str;
    }

    public final void t(String str) {
        this.f7295r = str;
    }

    public final void u(String str) {
        this.f7296s = str;
    }

    public final void v(String str) {
        this.f7297t = str;
    }

    public final void w(String str) {
        this.f7298u = str;
    }

    public final void x(String str) {
        this.A = str;
    }

    public final void y(String str) {
        this.D = str;
    }

    public final void z(String str) {
        this.E = str;
    }

    private int c() {
        return this.f7301z;
    }

    public final void a(Bitmap bitmap) {
        this.I = bitmap;
    }

    public final void e(int i2) {
        this.f7300y = i2;
    }

    public final void f(int i2) {
        this.f7301z = i2;
    }
}
