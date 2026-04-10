package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.k.s;

/* JADX INFO: loaded from: classes2.dex */
final class l {
    public c a;
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f8988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f8989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f8990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f8991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f8992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean[] f8993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean[] f8995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public k f8996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s f8998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8999r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9000s;

    l() {
    }

    public final void a() {
        this.f8986e = 0;
        this.f9000s = 0L;
        this.f8994m = false;
        this.f8999r = false;
        this.f8996o = null;
    }

    public final long b(int i2) {
        return this.f8992k[i2] + ((long) this.f8991j[i2]);
    }

    public final void a(int i2, int i3) {
        this.f8986e = i2;
        this.f8987f = i3;
        int[] iArr = this.f8989h;
        if (iArr == null || iArr.length < i2) {
            this.f8988g = new long[i2];
            this.f8989h = new int[i2];
        }
        int[] iArr2 = this.f8990i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f8990i = new int[i4];
            this.f8991j = new int[i4];
            this.f8992k = new long[i4];
            this.f8993l = new boolean[i4];
            this.f8995n = new boolean[i4];
        }
    }

    public final void a(int i2) {
        s sVar = this.f8998q;
        if (sVar == null || sVar.b() < i2) {
            this.f8998q = new s(i2);
        }
        this.f8997p = i2;
        this.f8994m = true;
        this.f8999r = true;
    }

    private void a(com.anythink.expressad.exoplayer.e.f fVar) {
        fVar.b(this.f8998q.a, 0, this.f8997p);
        this.f8998q.c(0);
        this.f8999r = false;
    }

    public final void a(s sVar) {
        sVar.a(this.f8998q.a, 0, this.f8997p);
        this.f8998q.c(0);
        this.f8999r = false;
    }
}
