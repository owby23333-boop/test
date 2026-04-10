package com.anythink.expressad.foundation.d;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final String a = "cid";
    public static final String b = "click_type";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10239c = "network_type";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10240d = "network_str";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10241e = "click_duration";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10242f = "last_url";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10243g = "type";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10244h = "code";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10245i = "exception";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10246j = "header";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10247k = "content";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10248l = "network_type";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10249m = "rid";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10250n = "key";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10251o = "rid_n";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10252p = "unit_id";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10253q = "landing_type";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f10254r = "link_type";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10255s = "click_time";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f10256t = "market_result";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10257u = "2000013";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f10258v = "2000012";
    private String A;
    private int B;
    private String C;
    private String D;
    private String E;
    private int F;
    private int G;
    private String H;
    private int I;
    private int J;
    private String K;
    private int L;
    private String M;
    private int N;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f10259w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f10260x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f10261y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f10262z;

    public f() {
    }

    private int b() {
        return this.N;
    }

    private int c() {
        return this.L;
    }

    private String d() {
        return this.M;
    }

    private void e(int i2) {
        this.N = i2;
    }

    private void f(int i2) {
        this.L = i2;
    }

    private int g() {
        return this.J;
    }

    private String h() {
        return this.K;
    }

    private int i() {
        return this.G;
    }

    private void j(String str) {
        this.M = str;
    }

    private int k() {
        return this.B;
    }

    private String l() {
        return this.D;
    }

    private String m() {
        return this.E;
    }

    private int n() {
        return this.F;
    }

    private String o() {
        return this.A;
    }

    private String p() {
        return this.f10261y;
    }

    private String q() {
        return this.f10262z;
    }

    private int r() {
        return this.f10259w;
    }

    private String s() {
        return this.f10260x;
    }

    public final void a(String str) {
        this.H = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f10261y + ", click_duration=" + this.f10262z + ", lastUrl=" + this.A + ", code=" + this.B + ", excepiton=" + this.C + ", header=" + this.D + ", content=" + this.E + ", type=" + this.F + ", click_type=" + this.G + "]";
    }

    private f(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, int i4, String str8, int i5, int i6, String str9, int i7, int i8, String str10) {
        this.f10260x = str;
        this.f10261y = str2;
        this.f10262z = str3;
        this.A = str4;
        this.B = i2;
        this.C = str5;
        this.D = str6;
        this.E = str7;
        this.F = i3;
        this.G = i4;
        this.H = str8;
        this.I = i5;
        this.J = i6;
        this.K = str9;
        this.L = i7;
        this.M = str10;
        this.N = i8;
    }

    private String e() {
        return this.H;
    }

    private int f() {
        return this.I;
    }

    private String j() {
        return this.C;
    }

    public final void a(int i2) {
        this.I = i2;
    }

    public final void b(int i2) {
        this.J = i2;
    }

    public final void c(String str) {
        this.C = str;
    }

    public final void d(String str) {
        this.D = str;
    }

    public final void g(String str) {
        this.f10261y = str;
    }

    public final void h(String str) {
        this.f10262z = str;
    }

    public final void i(String str) {
        this.f10260x = str;
    }

    private void g(int i2) {
        this.f10259w = i2;
    }

    public final void a() {
        this.G = 1;
    }

    public final void b(String str) {
        this.K = str;
    }

    public final void c(int i2) {
        this.B = i2;
    }

    public final void d(int i2) {
        this.F = i2;
    }

    public final void e(String str) {
        this.E = str;
    }

    public final void f(String str) {
        this.A = str;
    }

    public static String a(List<f> list) {
        if (list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            sb.append("rid_n=" + fVar.f10260x);
            sb.append("&cid=" + fVar.f10261y);
            sb.append("&click_type=" + fVar.G);
            sb.append("&type=" + fVar.F);
            sb.append("&click_duration=" + fVar.f10262z);
            sb.append("&key=2000013");
            sb.append("&unit_id=" + fVar.H);
            sb.append("&last_url=" + fVar.A);
            sb.append("&content=" + fVar.E);
            sb.append("&code=" + fVar.B);
            sb.append("&exception=" + fVar.C);
            sb.append("&header=" + fVar.D);
            sb.append("&landing_type=" + fVar.I);
            sb.append("&link_type=" + fVar.J);
            sb.append("&click_time=" + fVar.K + "\n");
        }
        return sb.toString();
    }

    private static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = fVar.A;
        sb.append("rid_n=" + fVar.f10260x);
        sb.append("&click_type=" + fVar.G);
        sb.append("&type=" + fVar.F);
        sb.append("&cid=" + fVar.f10261y);
        sb.append("&click_duration=" + fVar.f10262z);
        sb.append("&key=2000012");
        sb.append("&unit_id=" + fVar.H);
        sb.append("&last_url=".concat(String.valueOf(str)));
        sb.append("&code=" + fVar.B);
        sb.append("&exception=" + fVar.C);
        sb.append("&landing_type=" + fVar.I);
        sb.append("&link_type=" + fVar.J);
        sb.append("&click_time=" + fVar.K + "\n");
        return sb.toString();
    }
}
