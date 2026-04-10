package com.anythink.expressad.exoplayer;

import com.anythink.expressad.exoplayer.h.af;

/* JADX INFO: loaded from: classes2.dex */
final class q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f10010l = "MediaPeriodHolder";
    public final com.anythink.expressad.exoplayer.h.r a;
    public final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.h.y[] f10011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f10012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f10016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f10017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public af f10018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.anythink.expressad.exoplayer.i.i f10019k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final z[] f10020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.i.h f10021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.h.s f10022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.i.i f10023p;

    public q(z[] zVarArr, long j2, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.j.b bVar, com.anythink.expressad.exoplayer.h.s sVar, Object obj, r rVar) {
        this.f10020m = zVarArr;
        this.f10013e = j2 - rVar.b;
        this.f10021n = hVar;
        this.f10022o = sVar;
        this.b = com.anythink.expressad.exoplayer.k.a.a(obj);
        this.f10016h = rVar;
        this.f10011c = new com.anythink.expressad.exoplayer.h.y[zVarArr.length];
        this.f10012d = new boolean[zVarArr.length];
        com.anythink.expressad.exoplayer.h.r rVarA = sVar.a(rVar.a, bVar);
        long j3 = rVar.f10024c;
        this.a = j3 != Long.MIN_VALUE ? new com.anythink.expressad.exoplayer.h.d(rVarA, true, 0L, j3) : rVarA;
    }

    private long d() {
        return this.f10013e;
    }

    private long e() {
        return this.f10016h.f10026e;
    }

    public final boolean a() {
        if (this.f10014f) {
            return !this.f10015g || this.a.d() == Long.MIN_VALUE;
        }
        return false;
    }

    public final long b() {
        if (this.f10014f) {
            return this.a.e();
        }
        return 0L;
    }

    public final void c() {
        a((com.anythink.expressad.exoplayer.i.i) null);
        try {
            if (this.f10016h.f10024c != Long.MIN_VALUE) {
                this.f10022o.a(((com.anythink.expressad.exoplayer.h.d) this.a).a);
            } else {
                this.f10022o.a(this.a);
            }
        } catch (RuntimeException unused) {
        }
    }

    private void b(float f2) {
        this.f10014f = true;
        this.f10018j = this.a.b();
        a(f2);
        long jB = b(this.f10016h.b);
        long j2 = this.f10013e;
        r rVar = this.f10016h;
        this.f10013e = j2 + (rVar.b - jB);
        this.f10016h = new r(rVar.a, jB, rVar.f10024c, rVar.f10025d, rVar.f10026e, rVar.f10027f, rVar.f10028g);
    }

    private long d(long j2) {
        return j2 - this.f10013e;
    }

    private void e(long j2) {
        if (this.f10014f) {
            this.a.a_(j2 - this.f10013e);
        }
    }

    public final long a(boolean z2) {
        if (!this.f10014f) {
            return this.f10016h.b;
        }
        long jD = this.a.d();
        return (jD == Long.MIN_VALUE && z2) ? this.f10016h.f10026e : jD;
    }

    private static void c(com.anythink.expressad.exoplayer.i.i iVar) {
        for (int i2 = 0; i2 < iVar.a; i2++) {
            iVar.a(i2);
            iVar.f9568c.a(i2);
        }
    }

    public final boolean a(float f2) {
        com.anythink.expressad.exoplayer.i.i iVarA = this.f10021n.a(this.f10020m, this.f10018j);
        if (iVarA.a(this.f10023p)) {
            return false;
        }
        this.f10019k = iVarA;
        for (com.anythink.expressad.exoplayer.i.f fVar : this.f10019k.f9568c.a()) {
            if (fVar != null) {
                fVar.a(f2);
            }
        }
        return true;
    }

    private long c(long j2) {
        return j2 + this.f10013e;
    }

    public final long b(long j2) {
        return a(j2, false, new boolean[this.f10020m.length]);
    }

    private static void b(com.anythink.expressad.exoplayer.i.i iVar) {
        for (int i2 = 0; i2 < iVar.a; i2++) {
            boolean zA = iVar.a(i2);
            com.anythink.expressad.exoplayer.i.f fVarA = iVar.f9568c.a(i2);
            if (zA && fVarA != null) {
                fVarA.a();
            }
        }
    }

    public final long a(long j2, boolean z2, boolean[] zArr) {
        int i2 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.i.i iVar = this.f10019k;
            boolean z3 = true;
            if (i2 >= iVar.a) {
                break;
            }
            boolean[] zArr2 = this.f10012d;
            if (z2 || !iVar.a(this.f10023p, i2)) {
                z3 = false;
            }
            zArr2[i2] = z3;
            i2++;
        }
        a(this.f10011c);
        a(this.f10019k);
        com.anythink.expressad.exoplayer.i.g gVar = this.f10019k.f9568c;
        long jA = this.a.a(gVar.a(), this.f10012d, this.f10011c, zArr, j2);
        b(this.f10011c);
        this.f10015g = false;
        int i3 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.h.y[] yVarArr = this.f10011c;
            if (i3 >= yVarArr.length) {
                return jA;
            }
            if (yVarArr[i3] != null) {
                com.anythink.expressad.exoplayer.k.a.b(this.f10019k.a(i3));
                if (this.f10020m[i3].a() != 5) {
                    this.f10015g = true;
                }
            } else {
                com.anythink.expressad.exoplayer.k.a.b(gVar.a(i3) == null);
            }
            i3++;
        }
    }

    private void b(com.anythink.expressad.exoplayer.h.y[] yVarArr) {
        int i2 = 0;
        while (true) {
            z[] zVarArr = this.f10020m;
            if (i2 >= zVarArr.length) {
                return;
            }
            if (zVarArr[i2].a() == 5 && this.f10019k.a(i2)) {
                yVarArr[i2] = new com.anythink.expressad.exoplayer.h.m();
            }
            i2++;
        }
    }

    private void a(com.anythink.expressad.exoplayer.i.i iVar) {
        com.anythink.expressad.exoplayer.i.i iVar2 = this.f10023p;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.f10023p = iVar;
        com.anythink.expressad.exoplayer.i.i iVar3 = this.f10023p;
        if (iVar3 != null) {
            b(iVar3);
        }
    }

    private void a(com.anythink.expressad.exoplayer.h.y[] yVarArr) {
        int i2 = 0;
        while (true) {
            z[] zVarArr = this.f10020m;
            if (i2 >= zVarArr.length) {
                return;
            }
            if (zVarArr[i2].a() == 5) {
                yVarArr[i2] = null;
            }
            i2++;
        }
    }

    public final void a(long j2) {
        this.a.c(j2 - this.f10013e);
    }
}
