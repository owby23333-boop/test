package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7833b;
    private long c;
    private long d;
    private final long e = System.currentTimeMillis();

    public int a() {
        return com.xiaomi.push.service.ay.a() ? 1 : 0;
    }

    public long b() {
        return this.f7833b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m237a() {
        return this.f7832a;
    }

    public void b(long j) {
        this.f7833b += j;
    }

    public void c(long j) {
        this.d += j;
    }

    public void a(long j) {
        this.f7832a = j;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m238a() {
        this.c++;
    }
}
