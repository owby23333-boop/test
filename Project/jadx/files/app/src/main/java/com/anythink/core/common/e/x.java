package com.anythink.core.common.e;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private int a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7390e;

    public x() {
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.f7388c;
    }

    public final int c() {
        return this.f7389d;
    }

    public final int d() {
        return this.f7390e;
    }

    public final int e() {
        return this.a;
    }

    public x(int i2, String str) {
        this.a = i2;
        this.b = str;
        this.f7389d = 0;
        this.f7390e = 0;
        this.f7388c = -1L;
    }

    private void a(String str) {
        this.b = str;
    }

    private void c(int i2) {
        this.a = i2;
    }

    public final void b(int i2) {
        this.f7390e = i2;
    }

    public final void a(long j2) {
        this.f7388c = j2;
    }

    public final void a(int i2) {
        this.f7389d = i2;
    }
}
