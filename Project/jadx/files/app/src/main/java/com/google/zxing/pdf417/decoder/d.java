package com.google.zxing.pdf417.decoder;

/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {
    private final int a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16307e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.f16305c = i4;
        this.f16306d = i5;
    }

    boolean a(int i2) {
        return i2 != -1 && this.f16305c == (i2 % 3) * 3;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.f16307e;
    }

    int d() {
        return this.a;
    }

    int e() {
        return this.f16306d;
    }

    int f() {
        return this.b - this.a;
    }

    boolean g() {
        return a(this.f16307e);
    }

    void h() {
        this.f16307e = ((this.f16306d / 30) * 3) + (this.f16305c / 3);
    }

    public String toString() {
        return this.f16307e + com.anythink.expressad.foundation.g.a.bQ + this.f16306d;
    }

    int a() {
        return this.f16305c;
    }

    void b(int i2) {
        this.f16307e = i2;
    }
}
