package com.anythink.expressad.exoplayer.c;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public int a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8734i;

    private synchronized void a() {
    }

    private void a(d dVar) {
        this.a += dVar.a;
        this.b += dVar.b;
        this.f8728c += dVar.f8728c;
        this.f8729d += dVar.f8729d;
        this.f8730e += dVar.f8730e;
        this.f8731f += dVar.f8731f;
        this.f8732g += dVar.f8732g;
        this.f8733h = Math.max(this.f8733h, dVar.f8733h);
        this.f8734i += dVar.f8734i;
    }
}
