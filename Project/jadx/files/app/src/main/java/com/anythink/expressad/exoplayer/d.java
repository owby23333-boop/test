package com.anythink.expressad.exoplayer;

import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements p {
    public static final int a = 15000;
    public static final int b = 50000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8753c = 2500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8754d = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8755e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f8756f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.l f8757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f8758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f8759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f8760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f8761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f8763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.v f8764n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8766p;

    public static final class a {
        private com.anythink.expressad.exoplayer.j.l a = null;
        private int b = 15000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8767c = d.b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8768d = d.f8753c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8769e = 5000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8770f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8771g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.k.v f8772h = null;

        private a a(com.anythink.expressad.exoplayer.j.l lVar) {
            this.a = lVar;
            return this;
        }

        private a a(int i2, int i3, int i4, int i5) {
            this.b = i2;
            this.f8767c = i3;
            this.f8768d = i4;
            this.f8769e = i5;
            return this;
        }

        private a a(int i2) {
            this.f8770f = i2;
            return this;
        }

        private a a(boolean z2) {
            this.f8771g = z2;
            return this;
        }

        private a a(com.anythink.expressad.exoplayer.k.v vVar) {
            this.f8772h = vVar;
            return this;
        }

        private d a() {
            if (this.a == null) {
                this.a = new com.anythink.expressad.exoplayer.j.l((byte) 0);
            }
            return new d(this.a, this.b, this.f8767c, this.f8768d, this.f8769e, this.f8770f, this.f8771g, this.f8772h);
        }
    }

    public d() {
        this(new com.anythink.expressad.exoplayer.j.l((byte) 0));
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a() {
        a(false);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void b() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void c() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final com.anythink.expressad.exoplayer.j.b d() {
        return this.f8757g;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final long e() {
        return 0L;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean f() {
        return false;
    }

    @Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar) {
        this(lVar, (byte) 0);
    }

    private static int b(y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int iG = 0;
        for (int i2 = 0; i2 < yVarArr.length; i2++) {
            if (gVar.a(i2) != null) {
                iG += af.g(yVarArr[i2].a());
            }
        }
        return iG;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a(y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int i2 = this.f8762l;
        if (i2 == -1) {
            int iG = 0;
            for (int i3 = 0; i3 < yVarArr.length; i3++) {
                if (gVar.a(i3) != null) {
                    iG += af.g(yVarArr[i3].a());
                }
            }
            i2 = iG;
        }
        this.f8765o = i2;
        this.f8757g.a(this.f8765o);
    }

    @Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar, byte b2) {
        this(lVar, 15000, b, f8753c, 5000, -1, true, null);
    }

    @Deprecated
    public d(com.anythink.expressad.exoplayer.j.l lVar, int i2, int i3, int i4, int i5, int i6, boolean z2, com.anythink.expressad.exoplayer.k.v vVar) {
        a(i4, 0, "bufferForPlaybackMs", "0");
        a(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        a(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i3, i2, "maxBufferMs", "minBufferMs");
        this.f8757g = lVar;
        this.f8758h = ((long) i2) * 1000;
        this.f8759i = ((long) i3) * 1000;
        this.f8760j = ((long) i4) * 1000;
        this.f8761k = ((long) i5) * 1000;
        this.f8762l = i6;
        this.f8763m = z2;
        this.f8764n = vVar;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j2, float f2) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = this.f8757g.c() >= this.f8765o;
        boolean z5 = this.f8766p;
        long jMin = this.f8758h;
        if (f2 > 1.0f) {
            jMin = Math.min(af.a(jMin, f2), this.f8759i);
        }
        if (j2 < jMin) {
            if (!this.f8763m && z4) {
                z3 = false;
            }
            this.f8766p = z3;
        } else if (j2 > this.f8759i || z4) {
            this.f8766p = false;
        }
        com.anythink.expressad.exoplayer.k.v vVar = this.f8764n;
        if (vVar != null && (z2 = this.f8766p) != z5) {
            if (z2) {
                vVar.a();
            } else {
                vVar.c();
            }
        }
        return this.f8766p;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j2, float f2, boolean z2) {
        long jB = af.b(j2, f2);
        long j3 = z2 ? this.f8761k : this.f8760j;
        if (j3 <= 0 || jB >= j3) {
            return true;
        }
        return !this.f8763m && this.f8757g.c() >= this.f8765o;
    }

    private void a(boolean z2) {
        this.f8765o = 0;
        com.anythink.expressad.exoplayer.k.v vVar = this.f8764n;
        if (vVar != null && this.f8766p) {
            vVar.c();
        }
        this.f8766p = false;
        if (z2) {
            this.f8757g.e();
        }
    }

    private static void a(int i2, int i3, String str, String str2) {
        com.anythink.expressad.exoplayer.k.a.a(i2 >= i3, str + " cannot be less than " + str2);
    }
}
