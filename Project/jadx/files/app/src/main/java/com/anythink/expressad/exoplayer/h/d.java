package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements r, r.a {
    public final r a;
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f9296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private r.a f9297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a[] f9298e = new a[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9299f;

    private final class a implements y {
        public final y a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9300c;

        public a(y yVar) {
            this.a = yVar;
        }

        public final void a() {
            this.f9300c = false;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return !d.this.f() && this.a.b();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            this.a.c();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
            if (d.this.f()) {
                return -3;
            }
            if (this.f9300c) {
                eVar.a(4);
                return -4;
            }
            int iA = this.a.a(nVar, eVar, z2);
            if (iA == -5) {
                com.anythink.expressad.exoplayer.m mVar = nVar.a;
                if (mVar.f10006x != 0 || mVar.f10007y != 0) {
                    nVar.a = mVar.a(d.this.b != 0 ? 0 : mVar.f10006x, d.this.f9296c == Long.MIN_VALUE ? mVar.f10007y : 0);
                }
                return -5;
            }
            long j2 = d.this.f9296c;
            if (j2 == Long.MIN_VALUE || ((iA != -4 || eVar.f8738f < j2) && !(iA == -3 && d.this.d() == Long.MIN_VALUE))) {
                return iA;
            }
            eVar.a();
            eVar.a(4);
            this.f9300c = true;
            return -4;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j2) {
            if (d.this.f()) {
                return -3;
            }
            return this.a.a(j2);
        }
    }

    public d(r rVar, boolean z2, long j2, long j3) {
        this.a = rVar;
        this.f9299f = z2 ? j2 : com.anythink.expressad.exoplayer.b.b;
        this.b = j2;
        this.f9296c = j3;
    }

    private void g() {
        this.f9297d.a(this);
    }

    public final void a(long j2, long j3) {
        this.b = j2;
        this.f9296c = j3;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
        this.a.a_(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.a.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (f()) {
            long j2 = this.f9299f;
            this.f9299f = com.anythink.expressad.exoplayer.b.b;
            long jC = c();
            return jC != com.anythink.expressad.exoplayer.b.b ? jC : j2;
        }
        long jC2 = this.a.c();
        if (jC2 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        boolean z2 = true;
        com.anythink.expressad.exoplayer.k.a.b(jC2 >= this.b);
        long j3 = this.f9296c;
        if (j3 != Long.MIN_VALUE && jC2 > j3) {
            z2 = false;
        }
        com.anythink.expressad.exoplayer.k.a.b(z2);
        return jC2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long jD = this.a.d();
        if (jD != Long.MIN_VALUE) {
            long j2 = this.f9296c;
            if (j2 == Long.MIN_VALUE || jD < j2) {
                return jD;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long jE = this.a.e();
        if (jE != Long.MIN_VALUE) {
            long j2 = this.f9296c;
            if (j2 == Long.MIN_VALUE || jE < j2) {
                return jE;
            }
        }
        return Long.MIN_VALUE;
    }

    final boolean f() {
        return this.f9299f != com.anythink.expressad.exoplayer.b.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f9299f = r0
            com.anythink.expressad.exoplayer.h.d$a[] r0 = r6.f9298e
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.anythink.expressad.exoplayer.h.r r0 = r6.a
            long r0 = r0.b(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.b
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.f9296c
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            com.anythink.expressad.exoplayer.k.a.b(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.d.b(long):long");
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j2) {
        this.f9297d = aVar;
        this.a.a(this, j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        this.a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.anythink.expressad.exoplayer.i.f[] r16, boolean[] r17, com.anythink.expressad.exoplayer.h.y[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r18
            int r1 = r9.length
            com.anythink.expressad.exoplayer.h.d$a[] r1 = new com.anythink.expressad.exoplayer.h.d.a[r1]
            r0.f9298e = r1
            int r1 = r9.length
            com.anythink.expressad.exoplayer.h.y[] r10 = new com.anythink.expressad.exoplayer.h.y[r1]
            r11 = 0
            r1 = 0
        Lf:
            int r2 = r9.length
            r12 = 0
            if (r1 >= r2) goto L28
            com.anythink.expressad.exoplayer.h.d$a[] r2 = r0.f9298e
            r3 = r9[r1]
            com.anythink.expressad.exoplayer.h.d$a r3 = (com.anythink.expressad.exoplayer.h.d.a) r3
            r2[r1] = r3
            r3 = r2[r1]
            if (r3 == 0) goto L23
            r2 = r2[r1]
            com.anythink.expressad.exoplayer.h.y r12 = r2.a
        L23:
            r10[r1] = r12
            int r1 = r1 + 1
            goto Lf
        L28:
            com.anythink.expressad.exoplayer.h.r r1 = r0.a
            r2 = r16
            r3 = r17
            r4 = r10
            r5 = r19
            r6 = r20
            long r1 = r1.a(r2, r3, r4, r5, r6)
            boolean r3 = r15.f()
            r4 = 1
            if (r3 == 0) goto L68
            long r5 = r0.b
            int r3 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r3 != 0) goto L68
            r13 = 0
            int r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r3 == 0) goto L63
            int r3 = r8.length
            r5 = 0
        L4c:
            if (r5 >= r3) goto L63
            r6 = r8[r5]
            if (r6 == 0) goto L60
            com.anythink.expressad.exoplayer.m r6 = r6.h()
            java.lang.String r6 = r6.f9990h
            boolean r6 = com.anythink.expressad.exoplayer.k.o.a(r6)
            if (r6 != 0) goto L60
            r3 = 1
            goto L64
        L60:
            int r5 = r5 + 1
            goto L4c
        L63:
            r3 = 0
        L64:
            if (r3 == 0) goto L68
            r5 = r1
            goto L6d
        L68:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L6d:
            r0.f9299f = r5
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L87
            long r5 = r0.b
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L86
            long r5 = r0.f9296c
            r7 = -9223372036854775808
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L87
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L86
            goto L87
        L86:
            r4 = 0
        L87:
            com.anythink.expressad.exoplayer.k.a.b(r4)
        L8a:
            int r3 = r9.length
            if (r11 >= r3) goto Lb8
            r3 = r10[r11]
            if (r3 != 0) goto L96
            com.anythink.expressad.exoplayer.h.d$a[] r3 = r0.f9298e
            r3[r11] = r12
            goto Laf
        L96:
            r3 = r9[r11]
            if (r3 == 0) goto La4
            com.anythink.expressad.exoplayer.h.d$a[] r3 = r0.f9298e
            r3 = r3[r11]
            com.anythink.expressad.exoplayer.h.y r3 = r3.a
            r4 = r10[r11]
            if (r3 == r4) goto Laf
        La4:
            com.anythink.expressad.exoplayer.h.d$a[] r3 = r0.f9298e
            com.anythink.expressad.exoplayer.h.d$a r4 = new com.anythink.expressad.exoplayer.h.d$a
            r5 = r10[r11]
            r4.<init>(r5)
            r3[r11] = r4
        Laf:
            com.anythink.expressad.exoplayer.h.d$a[] r3 = r0.f9298e
            r3 = r3[r11]
            r9[r11] = r3
            int r11 = r11 + 1
            goto L8a
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.d.a(com.anythink.expressad.exoplayer.i.f[], boolean[], com.anythink.expressad.exoplayer.h.y[], boolean[], long):long");
    }

    private com.anythink.expressad.exoplayer.ac b(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        long jA = com.anythink.expressad.exoplayer.k.af.a(acVar.f8463f, j2 - this.b);
        long j3 = acVar.f8464g;
        long j4 = this.f9296c;
        long jA2 = com.anythink.expressad.exoplayer.k.af.a(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2);
        return (jA == acVar.f8463f && jA2 == acVar.f8464g) ? acVar : new com.anythink.expressad.exoplayer.ac(jA, jA2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        return this.a.c(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j2, boolean z2) {
        this.a.a(j2, z2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        long j3 = this.b;
        if (j2 == j3) {
            return j3;
        }
        long jA = com.anythink.expressad.exoplayer.k.af.a(acVar.f8463f, j2 - j3);
        long j4 = acVar.f8464g;
        long j5 = this.f9296c;
        long jA2 = com.anythink.expressad.exoplayer.k.af.a(j4, j5 == Long.MIN_VALUE ? Long.MAX_VALUE : j5 - j2);
        if (jA != acVar.f8463f || jA2 != acVar.f8464g) {
            acVar = new com.anythink.expressad.exoplayer.ac(jA, jA2);
        }
        return this.a.a(j2, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(r rVar) {
        this.f9297d.a((r) this);
    }

    private static boolean a(long j2, com.anythink.expressad.exoplayer.i.f[] fVarArr) {
        if (j2 != 0) {
            for (com.anythink.expressad.exoplayer.i.f fVar : fVarArr) {
                if (fVar != null && !com.anythink.expressad.exoplayer.k.o.a(fVar.h().f9990h)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(z zVar) {
        this.f9297d.a(this);
    }
}
