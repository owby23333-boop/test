package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public int a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f16776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClassLoader f16777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f16778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f16779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f16781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ActivityInfo[] f16782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f16783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f16784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f16785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PackageInfo f16788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f16789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16792v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16793w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16794x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16795y;

    public s() {
    }

    public s(PackageInfo packageInfo, int i2, String str, String str2, String str3, String str4) {
        this.f16788r = packageInfo;
        this.a = i2;
        this.f16773c = str;
        this.f16774d = str2;
        this.f16779i = str3;
        this.f16780j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        String str = this.f16773c;
        String str2 = ((s) obj).f16773c;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f16773c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
