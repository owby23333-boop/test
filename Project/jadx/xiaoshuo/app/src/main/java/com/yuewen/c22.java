package com.yuewen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes12.dex */
public class c22 {
    public static final int e = 0;
    public static final int f = -1;
    public static final int g = -2;
    public static final int h = -3;
    public static final int i = -4;
    public static final int j = -5;
    public static final int k = -6;
    public static final int l = 1;
    public static final int m = 4;
    public static final int n = 3;
    public static final int o = 5;
    public static final int p = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9518b;
    public final int c;
    public final int d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public c22(String str, int i2) {
        this(str, i2, 0, 0);
    }

    public int a() {
        return this.c;
    }

    public String b() {
        return this.f9517a;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.f9518b;
    }

    public c22(String str, int i2, int i3, int i4) {
        this.f9517a = str;
        this.f9518b = i2;
        this.c = i4;
        this.d = i3;
    }
}
