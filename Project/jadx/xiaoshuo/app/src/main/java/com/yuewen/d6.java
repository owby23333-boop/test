package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10100a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10101b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;

    public void a() {
        this.f10101b++;
    }

    public void b() {
        this.f++;
    }

    public void c() {
        this.c++;
    }

    public void d() {
        this.e++;
    }

    public void e() {
        this.f10100a++;
    }

    public int f() {
        int i = this.f10101b;
        this.f10101b = 0;
        return i;
    }

    public int g() {
        int i = this.d;
        this.d = 0;
        return i;
    }

    public int h() {
        int i = this.f;
        this.f = 0;
        return i;
    }

    public int i() {
        int i = this.e;
        this.e = 0;
        return i;
    }

    public int j() {
        int i = this.c;
        this.c = 0;
        return i;
    }

    public int k() {
        int i = this.f10100a;
        this.f10100a = 0;
        return i;
    }
}
