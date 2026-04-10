package com.anythink.core.common.e;

import com.anythink.core.api.ATAdConst;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ai implements Comparable<ai> {
    private String A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private String H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private long R;
    private long S;
    private double T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    int a;
    private m aa;
    private int ab;
    private int ac;
    private String ad;
    private int ae;
    private int af;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f7156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f7157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f7158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f7159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    double f7160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f7161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    double f7162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f7163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f7164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f7166n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7167o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7168p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f7169q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7170r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7171s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f7172t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f7173u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f7174v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7175w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f7176x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7177y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f7178z;
    int b = 0;
    private int ag = -1;
    private ATAdConst.CURRENCY ah = ATAdConst.CURRENCY.USD;

    private long ak() {
        return this.I;
    }

    public final long A() {
        return this.J;
    }

    public final long B() {
        return this.K;
    }

    public final int C() {
        return this.M;
    }

    public final int D() {
        return this.N;
    }

    public final int E() {
        return this.O;
    }

    public final int F() {
        return this.P;
    }

    public final String G() {
        return this.Q;
    }

    public final long H() {
        return this.R;
    }

    public final long I() {
        return this.S;
    }

    public final double J() {
        return this.T;
    }

    public final int K() {
        return this.U;
    }

    public final int L() {
        return this.V;
    }

    public final boolean M() {
        return this.W == 2;
    }

    public final m N() {
        return this.aa;
    }

    public final int O() {
        return this.ab;
    }

    public final int P() {
        return this.ac;
    }

    public final void Q() {
        this.ac = 1;
    }

    public final String R() {
        return this.ad;
    }

    public final int S() {
        return this.af;
    }

    public final int T() {
        int i2 = this.b;
        if (i2 <= 0) {
            return 1;
        }
        return i2;
    }

    public final int U() {
        return this.f7155c;
    }

    public final int V() {
        return this.f7156d;
    }

    public final String W() {
        return this.f7157e;
    }

    public final int X() {
        return this.a;
    }

    public final int Y() {
        return this.ag;
    }

    public final int Z() {
        int i2;
        m mVar = this.aa;
        return (mVar == null || (i2 = mVar.f7349n) == 0) ? this.f7158f : i2;
    }

    public final int a() {
        return this.Y;
    }

    public final boolean aa() {
        return this.f7165m == 1 && this.Z == 1;
    }

    public final String ab() {
        return "networkFirmId: " + this.f7165m + ", adSourceId: " + this.H + ", content: " + this.f7169q + ", price: " + this.f7176x + ", sortPrice: " + this.f7162j;
    }

    public final int ac() {
        return this.ae;
    }

    public final ATAdConst.CURRENCY ad() {
        return this.ah;
    }

    public final int ae() {
        return this.f7159g;
    }

    public final int af() {
        return this.f7161i;
    }

    public final double ag() {
        return this.f7162j;
    }

    public final String ah() {
        return this.f7163k;
    }

    public final boolean ai() {
        return this.f7164l;
    }

    public final void aj() {
        this.f7164l = true;
    }

    public final void b() {
        this.Y = -1;
    }

    public final int c() {
        return this.f7165m;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ai aiVar) {
        return com.anythink.core.common.k.g.a(this) > com.anythink.core.common.k.g.a(aiVar) ? -1 : 1;
    }

    public final String d() {
        return this.f7166n;
    }

    public final int e() {
        return this.f7167o;
    }

    public final int f() {
        return this.f7168p;
    }

    public final String g() {
        return this.f7169q;
    }

    public final String h() {
        return this.f7170r;
    }

    public final int i() {
        return this.f7177y;
    }

    public final boolean j() {
        return this.f7177y == 1;
    }

    public final long k() {
        return this.D;
    }

    public final int l() {
        return this.Z;
    }

    public final int m() {
        return this.X;
    }

    public final long n() {
        return this.L;
    }

    public final int o() {
        return this.B;
    }

    public final long p() {
        return this.E;
    }

    public final long q() {
        return this.F;
    }

    public final int r() {
        return this.G;
    }

    public final long s() {
        return this.f7172t;
    }

    public final String t() {
        return this.H;
    }

    public final String u() {
        return this.f7173u;
    }

    public final int v() {
        return this.f7174v;
    }

    public final int w() {
        return this.f7175w;
    }

    public final double x() {
        return this.f7176x;
    }

    public final String y() {
        return this.f7178z;
    }

    public final String z() {
        return this.A;
    }

    private void B(int i2) {
        this.ab = i2;
    }

    public final void A(int i2) {
        this.f7161i = i2;
    }

    public final void a(int i2) {
        this.f7165m = i2;
    }

    public final void b(int i2) {
        this.f7167o = i2;
    }

    public final void c(int i2) {
        this.f7168p = i2;
    }

    public final void d(String str) {
        this.f7171s = str;
    }

    public final void e(int i2) {
        this.Z = i2;
    }

    public final void f(int i2) {
        this.X = i2;
    }

    public final void g(int i2) {
        this.B = i2;
    }

    public final void h(int i2) {
        this.G = i2;
    }

    public final void i(int i2) {
        this.f7174v = i2;
    }

    public final void j(int i2) {
        this.f7175w = i2;
    }

    public final void k(int i2) {
        this.M = i2;
    }

    public final void l(int i2) {
        this.N = i2;
    }

    public final void m(int i2) {
        this.O = i2;
    }

    public final void n(int i2) {
        this.P = i2;
    }

    public final void o(int i2) {
        this.U = i2;
    }

    public final void p(int i2) {
        this.V = i2;
    }

    public final void q(int i2) {
        this.W = i2;
    }

    public final void r(int i2) {
        this.af = i2;
    }

    public final void s(int i2) {
        this.b = i2;
    }

    public final void t(int i2) {
        this.f7155c = i2;
    }

    public final void u(int i2) {
        this.f7156d = i2;
    }

    public final void v(int i2) {
        this.a = i2;
    }

    public final void w(int i2) {
        this.ag = i2;
    }

    public final void x(int i2) {
        this.f7158f = i2;
    }

    public final void y(int i2) {
        this.ae = i2;
    }

    public final void z(int i2) {
        this.f7159g = i2;
    }

    private void l(String str) {
        this.ad = str;
    }

    public final void a(String str) {
        this.f7166n = str;
    }

    public final void b(String str) {
        this.f7169q = str;
    }

    public final void c(String str) {
        this.f7170r = str;
    }

    public final void d(int i2) {
        this.f7177y = i2;
    }

    public final void e(long j2) {
        this.f7172t = j2;
    }

    public final void f(String str) {
        this.f7173u = str;
    }

    public final void g(String str) {
        this.f7178z = str;
    }

    public final void h(String str) {
        this.A = str;
    }

    public final void i(String str) {
        this.Q = str;
    }

    public final void j(long j2) {
        this.S = j2;
    }

    public final void k(String str) {
        this.f7163k = str;
    }

    public final void a(long j2) {
        this.D = j2;
    }

    public final void b(long j2) {
        this.L = j2;
    }

    public final void c(long j2) {
        this.E = j2;
    }

    public final void d(long j2) {
        this.F = j2;
    }

    public final void e(String str) {
        this.H = str;
    }

    public final void f(long j2) {
        this.I = j2;
    }

    public final void g(long j2) {
        this.J = j2;
    }

    public final void h(long j2) {
        this.K = j2;
    }

    public final void i(long j2) {
        this.R = j2;
    }

    public final void j(String str) {
        this.f7157e = str;
    }

    public final void a(double d2) {
        this.f7176x = d2;
    }

    public final void b(double d2) {
        this.T = d2;
    }

    public final void c(double d2) {
        this.f7160h = d2;
    }

    public final void d(double d2) {
        this.f7162j = d2;
    }

    private void a(m mVar) {
        this.aa = mVar;
    }

    private int a(ai aiVar) {
        return com.anythink.core.common.k.g.a(this) > com.anythink.core.common.k.g.a(aiVar) ? -1 : 1;
    }

    public final synchronized void a(ai aiVar, int i2, int i3, int i4) {
        if (aiVar.H.equals(this.H)) {
            this.f7176x = aiVar.f7176x;
            this.f7162j = aiVar.f7162j;
            this.B = i3;
            this.f7178z = aiVar.f7178z;
            this.ad = aiVar.ad;
            this.Y = 0;
            if (i2 == 0) {
                this.ab = aiVar.ab;
            } else {
                this.ab = i2;
            }
            this.A = aiVar.A;
            this.aa = aiVar.aa;
            this.ac = i4;
        }
    }

    public final void a(ATAdConst.CURRENCY currency) {
        this.ah = currency;
    }

    public final double a(com.anythink.core.c.d dVar) {
        double d2 = this.f7160h;
        if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            return d2;
        }
        if (dVar != null) {
            double dAs = dVar.as();
            if (dAs > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                return dAs;
            }
        }
        double d3 = this.f7160h;
        return d3 > PangleAdapterUtils.CPM_DEFLAUT_VALUE ? d3 : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    public final void a(m mVar, int i2, int i3, int i4) {
        this.B = i3;
        this.f7176x = mVar.getPrice();
        this.f7162j = mVar.getSortPrice();
        this.f7178z = mVar.token;
        this.ad = mVar.f7348m;
        this.Y = 0;
        this.ab = i2;
        this.aa = mVar;
        this.ac = i4;
        if (i4 == 1) {
            this.A = "";
        }
    }
}
