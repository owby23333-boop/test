package com.anythink.expressad.a;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    protected static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final int f8056c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final int f8057d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f8058e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final int f8059f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final int f8060g = 32;
    private int a = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected e f8061h;

    private int a() {
        return this.a;
    }

    private boolean c() {
        int i2 = this.a;
        return i2 == 8 || i2 == 16;
    }

    private boolean d() {
        return this.a == 2;
    }

    private boolean e() {
        return this.a == 32;
    }

    private boolean f() {
        return this.a == 4;
    }

    public void b() {
        this.a = 8;
    }

    private void a(int i2) {
        this.a = i2;
    }

    private void a(e eVar) {
        this.f8061h = eVar;
    }
}
