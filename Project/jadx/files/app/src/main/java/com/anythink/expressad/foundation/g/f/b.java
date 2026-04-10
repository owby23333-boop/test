package com.anythink.expressad.foundation.g.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements l {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10510h;

    public b() {
        this((byte) 0);
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int a() {
        return this.f10505c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int b() {
        return this.a;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int c() {
        return this.b;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final boolean d() {
        this.b++;
        return this.b <= this.f10505c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int e() {
        return this.f10507e;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int f() {
        return this.f10508f;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int g() {
        return this.f10509g;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int h() {
        return this.f10510h;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int i() {
        return this.f10506d;
    }

    private b(byte b) {
        this.f10506d = 2;
        this.f10507e = 0;
        this.f10508f = 0;
        this.f10509g = 0;
        this.f10510h = 0;
        this.a = 30000;
        this.f10505c = 0;
    }

    private b(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f10506d = 2;
        this.f10507e = 0;
        this.f10508f = 0;
        this.f10509g = 0;
        this.f10510h = 0;
        this.f10507e = Math.max(i2, 0);
        this.f10508f = Math.max(i3, 0);
        this.f10509g = Math.max(i4, 0);
        this.f10510h = Math.max(i5, 0);
        this.f10505c = Math.max(i6, 0);
        this.f10506d = i7;
    }

    private b(int i2, int i3, int i4, int i5, int i6) {
        this.f10506d = 2;
        this.f10507e = 0;
        this.f10508f = 0;
        this.f10509g = 0;
        this.f10510h = 0;
        this.f10507e = Math.max(i2, 0);
        this.f10508f = Math.max(i3, 0);
        this.f10509g = Math.max(i4, 0);
        this.f10510h = Math.max(i5, 0);
        this.f10505c = Math.max(i6, 0);
    }
}
