package com.anythink.expressad.a.a;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int a = 0;
    public static int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashSet<String> f8020e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8021f = System.currentTimeMillis();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8027l;

    public b(String str, String str2) {
        this.f8018c = str;
        b(str2);
    }

    private String i() {
        return this.f8018c;
    }

    private HashSet<String> j() {
        return this.f8020e;
    }

    public final boolean a() {
        return this.f8025j;
    }

    public final boolean b() {
        return this.f8026k;
    }

    public final int c() {
        return this.f8027l;
    }

    public final int d() {
        return this.f8024i;
    }

    public final String e() {
        return this.f8023h;
    }

    public final com.anythink.expressad.foundation.d.c f() {
        return this.f8022g;
    }

    public final int g() {
        return this.f8019d;
    }

    public final long h() {
        return this.f8021f;
    }

    public final void a(boolean z2) {
        this.f8025j = z2;
    }

    public final void b(boolean z2) {
        this.f8026k = z2;
    }

    public final void a(int i2) {
        this.f8027l = i2;
    }

    public final void b(int i2) {
        this.f8024i = i2;
    }

    public final void a(String str) {
        this.f8023h = str;
    }

    public final void b(String str) {
        this.f8019d++;
        this.f8020e.add(str);
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.f8022g = cVar;
    }
}
