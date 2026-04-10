package com.yuewen;

/* JADX INFO: loaded from: classes15.dex */
public class br2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9222b;
    public String c;
    public String d;

    public br2(String str, int i) {
        this.f9221a = str;
        this.f9222b = i;
        this.c = String.valueOf(i);
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.f9222b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.f9221a;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(int i) {
        this.f9222b = i;
        this.c += String.valueOf(i);
    }
}
