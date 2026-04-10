package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class w64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19389a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19390b = false;
    public boolean c = false;

    public void a() {
        this.c = true;
    }

    public void b() {
        this.f19390b = true;
        this.f19389a = true;
    }

    public void c() {
        this.f19389a = true;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.f19390b;
    }

    public boolean f() {
        return this.f19389a;
    }
}
