package com.anythink.expressad.foundation.d;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final String a = "key";
    public static final String b = "time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10299c = "ad_source_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10300d = "num";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10301e = "unit_id";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10302f = "fb";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10303g = "timeout";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10304h = "network_type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10305i = "network_str";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10306j = "2000006";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10307k = "hb";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10308l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f10309m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f10310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f10311o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10312p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10313q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f10314r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f10315s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f10316t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f10317u;

    private l(int i2, String str, int i3, String str2, int i4, int i5, int i6) {
        this.f10308l = i2;
        this.f10309m = str;
        this.f10310n = i3;
        this.f10311o = str2;
        this.f10312p = i4;
        this.f10313q = i5;
        this.f10314r = i6;
    }

    private int a() {
        return this.f10316t;
    }

    private int b() {
        return this.f10308l;
    }

    private String c() {
        return this.f10309m;
    }

    private String d() {
        return this.f10317u;
    }

    private int e() {
        return this.f10310n;
    }

    private String f() {
        return this.f10311o;
    }

    private int g() {
        return this.f10312p;
    }

    private int h() {
        return this.f10313q;
    }

    private int i() {
        return this.f10314r;
    }

    private String j() {
        return this.f10315s;
    }

    private void a(int i2) {
        this.f10316t = i2;
    }

    private void b(int i2) {
        this.f10308l = i2;
    }

    private void c(int i2) {
        this.f10310n = i2;
    }

    private void d(int i2) {
        this.f10312p = i2;
    }

    private void e(int i2) {
        this.f10313q = i2;
    }

    private void f(int i2) {
        this.f10314r = i2;
    }

    private void a(String str) {
        this.f10309m = str;
    }

    private void b(String str) {
        this.f10317u = str;
    }

    private void c(String str) {
        this.f10311o = str;
    }

    private void d(String str) {
        this.f10315s = str;
    }

    private static String a(List<l> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (l lVar : list) {
            stringBuffer.append("ad_source_id=" + lVar.f10308l);
            stringBuffer.append("&time=" + lVar.f10309m);
            stringBuffer.append("&num=" + lVar.f10310n);
            stringBuffer.append("&unit_id=" + lVar.f10311o);
            stringBuffer.append("&key=2000006");
            stringBuffer.append("&fb=" + lVar.f10312p);
            if (lVar.f10316t == 1) {
                stringBuffer.append("&hb=1");
            }
            stringBuffer.append("&timeout=" + lVar.f10313q + "\n");
        }
        return stringBuffer.toString();
    }

    public l() {
    }
}
