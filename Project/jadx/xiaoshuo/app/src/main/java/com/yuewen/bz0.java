package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class bz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9476a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9477b = false;
    public boolean c = false;

    public void a() {
        this.c = true;
    }

    public void b() {
        this.f9477b = true;
        this.f9476a = true;
    }

    public void c() {
        this.f9476a = true;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.f9477b;
    }

    public boolean f() {
        return this.f9476a;
    }

    public String toString() {
        return "EpubTypesettingResult{mIsHandled=" + this.f9476a + ", mIsDone=" + this.f9477b + ", mIsDiscarded=" + this.c + '}';
    }
}
