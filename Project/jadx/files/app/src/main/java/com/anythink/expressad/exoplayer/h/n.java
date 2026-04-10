package com.anythink.expressad.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.h.x;
import com.anythink.expressad.exoplayer.j.t;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class n implements com.anythink.expressad.exoplayer.e.g, r, x.b, t.a<a>, t.d {
    private static final long a = 10000;
    private af A;
    private boolean[] C;
    private boolean[] D;
    private boolean[] E;
    private boolean F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final Uri b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f9363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t.a f9365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f9366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.b f9367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f9368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f9369i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f9371k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private r.a f9376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.e.k f9377q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9383w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f9384x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f9385y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f9386z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.t f9370j = new com.anythink.expressad.exoplayer.j.t("Loader:ExtractorMediaPeriod");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.f f9372l = new com.anythink.expressad.exoplayer.k.f();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f9373m = new Runnable() { // from class: com.anythink.expressad.exoplayer.h.n.1
        @Override // java.lang.Runnable
        public final void run() {
            n.a(n.this);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f9374n = new Runnable() { // from class: com.anythink.expressad.exoplayer.h.n.2
        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.M) {
                return;
            }
            n.this.f9376p.a(n.this);
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Handler f9375o = new Handler();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f9379s = new int[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private x[] f9378r = new x[0];
    private long I = com.anythink.expressad.exoplayer.b.b;
    private long G = -1;
    private long B = com.anythink.expressad.exoplayer.b.b;

    final class a implements t.c {
        private final Uri b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.j.h f9387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f9388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.k.f f9389e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f9391g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f9393i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.j.k f9394j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f9396l;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.e.j f9390f = new com.anythink.expressad.exoplayer.e.j();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9392h = true;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f9395k = -1;

        public a(Uri uri, com.anythink.expressad.exoplayer.j.h hVar, b bVar, com.anythink.expressad.exoplayer.k.f fVar) {
            this.b = (Uri) com.anythink.expressad.exoplayer.k.a.a(uri);
            this.f9387c = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
            this.f9388d = (b) com.anythink.expressad.exoplayer.k.a.a(bVar);
            this.f9389e = fVar;
        }

        public final void a(long j2, long j3) {
            this.f9390f.a = j2;
            this.f9393i = j3;
            this.f9392h = true;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() throws Throwable {
            com.anythink.expressad.exoplayer.e.b bVar;
            long jC;
            int iA = 0;
            while (iA == 0 && !this.f9391g) {
                try {
                    jC = this.f9390f.a;
                    this.f9394j = new com.anythink.expressad.exoplayer.j.k(this.b, jC, n.this.f9368h);
                    this.f9395k = this.f9387c.a(this.f9394j);
                    if (this.f9395k != -1) {
                        this.f9395k += jC;
                    }
                    bVar = new com.anythink.expressad.exoplayer.e.b(this.f9387c, jC, this.f9395k);
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                }
                try {
                    com.anythink.expressad.exoplayer.e.e eVarA = this.f9388d.a(bVar, this.f9387c.a());
                    if (this.f9392h) {
                        eVarA.a(jC, this.f9393i);
                        this.f9392h = false;
                    }
                    while (iA == 0 && !this.f9391g) {
                        this.f9389e.c();
                        iA = eVarA.a(bVar, this.f9390f);
                        if (bVar.c() > n.this.f9369i + jC) {
                            jC = bVar.c();
                            this.f9389e.b();
                            n.this.f9375o.post(n.this.f9374n);
                        }
                    }
                    if (iA == 1) {
                        iA = 0;
                    } else {
                        this.f9390f.a = bVar.c();
                        this.f9396l = this.f9390f.a - this.f9394j.f9669e;
                    }
                    com.anythink.expressad.exoplayer.k.af.a(this.f9387c);
                } catch (Throwable th2) {
                    th = th2;
                    if (iA != 1 && bVar != null) {
                        this.f9390f.a = bVar.c();
                        this.f9396l = this.f9390f.a - this.f9394j.f9669e;
                    }
                    com.anythink.expressad.exoplayer.k.af.a(this.f9387c);
                    throw th;
                }
            }
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
            this.f9391g = true;
        }
    }

    interface c {
        void a(long j2, boolean z2);
    }

    private final class d implements y {
        private final int b;

        public d(int i2) {
            this.b = i2;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return n.this.a(this.b);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() throws IOException {
            n.this.h();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
            return n.this.a(this.b, nVar, eVar, z2);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j2) {
            return n.this.a(this.b, j2);
        }
    }

    public n(Uri uri, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.e.e[] eVarArr, int i2, t.a aVar, c cVar, com.anythink.expressad.exoplayer.j.b bVar, @Nullable String str, int i3) {
        this.b = uri;
        this.f9363c = hVar;
        this.f9364d = i2;
        this.f9365e = aVar;
        this.f9366f = cVar;
        this.f9367g = bVar;
        this.f9368h = str;
        this.f9369i = i3;
        this.f9371k = new b(eVarArr, this);
        this.f9382v = i2 == -1 ? 3 : i2;
        aVar.a();
    }

    private boolean j() {
        return this.f9384x || o();
    }

    private void k() {
        if (this.M || this.f9381u || this.f9377q == null || !this.f9380t) {
            return;
        }
        for (x xVar : this.f9378r) {
            if (xVar.f() == null) {
                return;
            }
        }
        this.f9372l.b();
        int length = this.f9378r.length;
        ae[] aeVarArr = new ae[length];
        this.D = new boolean[length];
        this.C = new boolean[length];
        this.E = new boolean[length];
        this.B = this.f9377q.b();
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.m mVarF = this.f9378r[i2].f();
            aeVarArr[i2] = new ae(mVarF);
            String str = mVarF.f9990h;
            if (!com.anythink.expressad.exoplayer.k.o.b(str) && !com.anythink.expressad.exoplayer.k.o.a(str)) {
                z2 = false;
            }
            this.D[i2] = z2;
            this.F = z2 | this.F;
            i2++;
        }
        this.A = new af(aeVarArr);
        if (this.f9364d == -1 && this.G == -1 && this.f9377q.b() == com.anythink.expressad.exoplayer.b.b) {
            this.f9382v = 6;
        }
        this.f9381u = true;
        this.f9366f.a(this.B, this.f9377q.a());
        this.f9376p.a((r) this);
    }

    private void l() {
        a aVar = new a(this.b, this.f9363c, this.f9371k, this.f9372l);
        if (this.f9381u) {
            com.anythink.expressad.exoplayer.k.a.b(o());
            long j2 = this.B;
            if (j2 != com.anythink.expressad.exoplayer.b.b && this.I >= j2) {
                this.L = true;
                this.I = com.anythink.expressad.exoplayer.b.b;
                return;
            } else {
                aVar.a(this.f9377q.a(this.I).a.f9021c, this.I);
                this.I = com.anythink.expressad.exoplayer.b.b;
            }
        }
        this.K = m();
        this.f9365e.a(aVar.f9394j, 1, -1, null, 0, null, aVar.f9393i, this.B, this.f9370j.a(aVar, this, this.f9382v));
    }

    private int m() {
        int iB = 0;
        for (x xVar : this.f9378r) {
            iB += xVar.b();
        }
        return iB;
    }

    private long n() {
        long jMax = Long.MIN_VALUE;
        for (x xVar : this.f9378r) {
            jMax = Math.max(jMax, xVar.g());
        }
        return jMax;
    }

    private boolean o() {
        return this.I != com.anythink.expressad.exoplayer.b.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097 A[RETURN] */
    @Override // com.anythink.expressad.exoplayer.j.t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ int a(com.anythink.expressad.exoplayer.j.t.c r23, long r24, long r26, java.io.IOException r28) {
        /*
            r22 = this;
            r0 = r22
            r12 = r24
            r14 = r26
            r18 = r28
            r7 = r23
            com.anythink.expressad.exoplayer.h.n$a r7 = (com.anythink.expressad.exoplayer.h.n.a) r7
            r1 = r28
            boolean r6 = r1 instanceof com.anythink.expressad.exoplayer.h.ag
            r19 = r6
            com.anythink.expressad.exoplayer.h.t$a r1 = r0.f9365e
            com.anythink.expressad.exoplayer.j.k r2 = com.anythink.expressad.exoplayer.h.n.a.a(r7)
            long r8 = com.anythink.expressad.exoplayer.h.n.a.b(r7)
            long r10 = r0.B
            long r16 = com.anythink.expressad.exoplayer.h.n.a.c(r7)
            r3 = 1
            r4 = -1
            r5 = 0
            r20 = 0
            r21 = r6
            r6 = r20
            r20 = 0
            r0 = r7
            r7 = r20
            r1.a(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r16, r18, r19)
            r1 = r0
            r0 = r22
            r0.a(r1)
            if (r21 == 0) goto L3d
            r1 = 3
            return r1
        L3d:
            int r2 = r22.m()
            int r3 = r0.K
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L49
            r3 = 1
            goto L4a
        L49:
            r3 = 0
        L4a:
            long r6 = r0.G
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L8e
            com.anythink.expressad.exoplayer.e.k r6 = r0.f9377q
            if (r6 == 0) goto L64
            long r6 = r6.b()
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L64
            goto L8e
        L64:
            boolean r2 = r0.f9381u
            if (r2 == 0) goto L72
            boolean r2 = r22.j()
            if (r2 != 0) goto L72
            r0.J = r5
            r1 = 0
            goto L91
        L72:
            boolean r2 = r0.f9381u
            r0.f9384x = r2
            r6 = 0
            r0.H = r6
            r0.K = r4
            com.anythink.expressad.exoplayer.h.x[] r2 = r0.f9378r
            int r8 = r2.length
            r9 = 0
        L80:
            if (r9 >= r8) goto L8a
            r10 = r2[r9]
            r10.a()
            int r9 = r9 + 1
            goto L80
        L8a:
            r1.a(r6, r6)
            goto L90
        L8e:
            r0.K = r2
        L90:
            r1 = 1
        L91:
            if (r1 == 0) goto L97
            if (r3 == 0) goto L96
            return r5
        L96:
            return r4
        L97:
            r1 = 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.n.a(com.anythink.expressad.exoplayer.j.t$c, long, long, java.io.IOException):int");
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        this.f9380t = true;
        this.f9375o.post(this.f9373m);
    }

    final void h() throws IOException {
        this.f9370j.a(this.f9382v);
    }

    @Override // com.anythink.expressad.exoplayer.h.x.b
    public final void i() {
        this.f9375o.post(this.f9373m);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.A;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        if (this.L || this.J) {
            return false;
        }
        if (this.f9381u && this.f9386z == 0) {
            return false;
        }
        boolean zA = this.f9372l.a();
        if (this.f9370j.a()) {
            return zA;
        }
        l();
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long jN;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (o()) {
            return this.I;
        }
        if (this.F) {
            jN = Long.MAX_VALUE;
            int length = this.f9378r.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.D[i2]) {
                    jN = Math.min(jN, this.f9378r[i2].g());
                }
            }
        } else {
            jN = n();
        }
        return jN == Long.MIN_VALUE ? this.H : jN;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (this.f9386z == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final void f() {
        if (this.f9381u) {
            for (x xVar : this.f9378r) {
                xVar.j();
            }
        }
        this.f9370j.a(this);
        this.f9375o.removeCallbacksAndMessages(null);
        this.f9376p = null;
        this.M = true;
        this.f9365e.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        for (x xVar : this.f9378r) {
            xVar.a();
        }
        this.f9371k.a();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j2) {
        if (!this.f9377q.a()) {
            j2 = 0;
        }
        this.H = j2;
        this.f9384x = false;
        if (!o() && d(j2)) {
            return j2;
        }
        this.J = false;
        this.I = j2;
        this.L = false;
        if (this.f9370j.a()) {
            this.f9370j.b();
        } else {
            for (x xVar : this.f9378r) {
                xVar.a();
            }
        }
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (!this.f9385y) {
            this.f9365e.c();
            this.f9385y = true;
        }
        if (!this.f9384x) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (!this.L && m() <= this.K) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        this.f9384x = false;
        return this.H;
    }

    private static final class b {
        private final com.anythink.expressad.exoplayer.e.e[] a;
        private final com.anythink.expressad.exoplayer.e.g b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.e.e f9397c;

        public b(com.anythink.expressad.exoplayer.e.e[] eVarArr, com.anythink.expressad.exoplayer.e.g gVar) {
            this.a = eVarArr;
            this.b = gVar;
        }

        public final com.anythink.expressad.exoplayer.e.e a(com.anythink.expressad.exoplayer.e.f fVar, Uri uri) throws ag {
            com.anythink.expressad.exoplayer.e.e eVar = this.f9397c;
            if (eVar != null) {
                return eVar;
            }
            com.anythink.expressad.exoplayer.e.e[] eVarArr = this.a;
            int length = eVarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                com.anythink.expressad.exoplayer.e.e eVar2 = eVarArr[i2];
                try {
                    if (eVar2.a(fVar)) {
                        this.f9397c = eVar2;
                        fVar.a();
                        break;
                    }
                    continue;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                fVar.a();
                i2++;
            }
            com.anythink.expressad.exoplayer.e.e eVar3 = this.f9397c;
            if (eVar3 != null) {
                eVar3.a(this.b);
                return this.f9397c;
            }
            throw new ag("None of the available extractors (" + com.anythink.expressad.exoplayer.k.af.a(this.a) + ") could read the stream.", uri);
        }

        public final void a() {
            if (this.f9397c != null) {
                this.f9397c = null;
            }
        }
    }

    private void c(int i2) {
        if (this.J && this.D[i2] && !this.f9378r[i2].c()) {
            this.I = 0L;
            this.J = false;
            this.f9384x = true;
            this.H = 0L;
            this.K = 0;
            for (x xVar : this.f9378r) {
                xVar.a();
            }
            this.f9376p.a(this);
        }
    }

    private boolean d(long j2) {
        int length = this.f9378r.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            x xVar = this.f9378r[i2];
            xVar.i();
            if (!(xVar.a(j2, false) != -1) && (this.D[i2] || !this.F)) {
                break;
            }
            i2++;
        }
        return false;
    }

    private void b(int i2) {
        if (this.E[i2]) {
            return;
        }
        com.anythink.expressad.exoplayer.m mVarA = this.A.a(i2).a(0);
        this.f9365e.a(com.anythink.expressad.exoplayer.k.o.d(mVarA.f9990h), mVarA, 0, (Object) null, this.H);
        this.E[i2] = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3) {
        a aVar = (a) cVar;
        if (this.B == com.anythink.expressad.exoplayer.b.b) {
            long jN = n();
            this.B = jN == Long.MIN_VALUE ? 0L : jN + a;
            this.f9366f.a(this.B, this.f9377q.a());
        }
        this.f9365e.a(aVar.f9394j, 1, -1, null, 0, null, aVar.f9393i, this.B, j2, j3, aVar.f9396l);
        a(aVar);
        this.L = true;
        this.f9376p.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3, boolean z2) {
        a aVar = (a) cVar;
        this.f9365e.b(aVar.f9394j, 1, -1, null, 0, null, aVar.f9393i, this.B, j2, j3, aVar.f9396l);
        if (z2) {
            return;
        }
        a(aVar);
        for (x xVar : this.f9378r) {
            xVar.a();
        }
        if (this.f9386z > 0) {
            this.f9376p.a(this);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j2) {
        this.f9376p = aVar;
        this.f9372l.a();
        l();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() throws IOException {
        h();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(this.f9381u);
        int i2 = this.f9386z;
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (yVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                int i5 = ((d) yVarArr[i4]).b;
                com.anythink.expressad.exoplayer.k.a.b(this.C[i5]);
                this.f9386z--;
                this.C[i5] = false;
                yVarArr[i4] = null;
            }
        }
        boolean z2 = !this.f9383w ? j2 == 0 : i2 != 0;
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            if (yVarArr[i6] == null && fVarArr[i6] != null) {
                com.anythink.expressad.exoplayer.i.f fVar = fVarArr[i6];
                com.anythink.expressad.exoplayer.k.a.b(fVar.g() == 1);
                com.anythink.expressad.exoplayer.k.a.b(fVar.b(0) == 0);
                int iA = this.A.a(fVar.f());
                com.anythink.expressad.exoplayer.k.a.b(!this.C[iA]);
                this.f9386z++;
                this.C[iA] = true;
                yVarArr[i6] = new d(iA);
                zArr2[i6] = true;
                if (!z2) {
                    x xVar = this.f9378r[iA];
                    xVar.i();
                    z2 = xVar.a(j2, true) == -1 && xVar.e() != 0;
                }
            }
        }
        if (this.f9386z == 0) {
            this.J = false;
            this.f9384x = false;
            if (this.f9370j.a()) {
                x[] xVarArr = this.f9378r;
                int length = xVarArr.length;
                while (i3 < length) {
                    xVarArr[i3].j();
                    i3++;
                }
                this.f9370j.b();
            } else {
                x[] xVarArr2 = this.f9378r;
                int length2 = xVarArr2.length;
                while (i3 < length2) {
                    xVarArr2[i3].a();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = b(j2);
            while (i3 < yVarArr.length) {
                if (yVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.f9383w = true;
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j2, boolean z2) {
        int length = this.f9378r.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f9378r[i2].a(j2, z2, this.C[i2]);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        if (!this.f9377q.a()) {
            return 0L;
        }
        k.a aVarA = this.f9377q.a(j2);
        return com.anythink.expressad.exoplayer.k.af.a(j2, acVar, aVarA.a.b, aVarA.b.b);
    }

    final boolean a(int i2) {
        if (j()) {
            return false;
        }
        return this.L || this.f9378r[i2].c();
    }

    final int a(int i2, com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
        if (j()) {
            return -3;
        }
        int iA = this.f9378r[i2].a(nVar, eVar, z2, this.L, this.H);
        if (iA == -4) {
            b(i2);
        } else if (iA == -3) {
            c(i2);
        }
        return iA;
    }

    final int a(int i2, long j2) {
        int iK = 0;
        if (j()) {
            return 0;
        }
        x xVar = this.f9378r[i2];
        if (this.L && j2 > xVar.g()) {
            iK = xVar.k();
        } else {
            int iA = xVar.a(j2, true);
            if (iA != -1) {
                iK = iA;
            }
        }
        if (iK > 0) {
            b(i2);
        } else {
            c(i2);
        }
        return iK;
    }

    private void a(a aVar, long j2, long j3) {
        if (this.B == com.anythink.expressad.exoplayer.b.b) {
            long jN = n();
            this.B = jN == Long.MIN_VALUE ? 0L : jN + a;
            this.f9366f.a(this.B, this.f9377q.a());
        }
        this.f9365e.a(aVar.f9394j, 1, -1, null, 0, null, aVar.f9393i, this.B, j2, j3, aVar.f9396l);
        a(aVar);
        this.L = true;
        this.f9376p.a(this);
    }

    private void a(a aVar, long j2, long j3, boolean z2) {
        this.f9365e.b(aVar.f9394j, 1, -1, null, 0, null, aVar.f9393i, this.B, j2, j3, aVar.f9396l);
        if (z2) {
            return;
        }
        a(aVar);
        for (x xVar : this.f9378r) {
            xVar.a();
        }
        if (this.f9386z > 0) {
            this.f9376p.a(this);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i2, int i3) {
        int length = this.f9378r.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.f9379s[i4] == i2) {
                return this.f9378r[i4];
            }
        }
        x xVar = new x(this.f9367g);
        xVar.a(this);
        int i5 = length + 1;
        this.f9379s = Arrays.copyOf(this.f9379s, i5);
        this.f9379s[length] = i2;
        this.f9378r = (x[]) Arrays.copyOf(this.f9378r, i5);
        this.f9378r[length] = xVar;
        return xVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(com.anythink.expressad.exoplayer.e.k kVar) {
        this.f9377q = kVar;
        this.f9375o.post(this.f9373m);
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f9395k;
        }
    }

    private boolean a(a aVar, int i2) {
        com.anythink.expressad.exoplayer.e.k kVar;
        if (this.G == -1 && ((kVar = this.f9377q) == null || kVar.b() == com.anythink.expressad.exoplayer.b.b)) {
            if (this.f9381u && !j()) {
                this.J = true;
                return false;
            }
            this.f9384x = this.f9381u;
            this.H = 0L;
            this.K = 0;
            for (x xVar : this.f9378r) {
                xVar.a();
            }
            aVar.a(0L, 0L);
            return true;
        }
        this.K = i2;
        return true;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof ag;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(com.anythink.expressad.exoplayer.h.n.a r23, long r24, long r26, java.io.IOException r28) {
        /*
            r22 = this;
            r0 = r22
            r12 = r24
            r14 = r26
            r18 = r28
            r1 = r28
            boolean r7 = r1 instanceof com.anythink.expressad.exoplayer.h.ag
            r19 = r7
            com.anythink.expressad.exoplayer.h.t$a r1 = r0.f9365e
            com.anythink.expressad.exoplayer.j.k r2 = com.anythink.expressad.exoplayer.h.n.a.a(r23)
            long r8 = com.anythink.expressad.exoplayer.h.n.a.b(r23)
            long r10 = r0.B
            long r16 = com.anythink.expressad.exoplayer.h.n.a.c(r23)
            r3 = 1
            r4 = -1
            r5 = 0
            r6 = 0
            r20 = 0
            r21 = r7
            r7 = r20
            r1.a(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r16, r18, r19)
            r22.a(r23)
            if (r21 == 0) goto L32
            r1 = 3
            return r1
        L32:
            int r1 = r22.m()
            int r2 = r0.K
            r3 = 0
            r4 = 1
            if (r1 <= r2) goto L3e
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            long r5 = r0.G
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L85
            com.anythink.expressad.exoplayer.e.k r5 = r0.f9377q
            if (r5 == 0) goto L59
            long r5 = r5.b()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L59
            goto L85
        L59:
            boolean r1 = r0.f9381u
            if (r1 == 0) goto L67
            boolean r1 = r22.j()
            if (r1 != 0) goto L67
            r0.J = r4
            r1 = 0
            goto L88
        L67:
            boolean r1 = r0.f9381u
            r0.f9384x = r1
            r5 = 0
            r0.H = r5
            r0.K = r3
            com.anythink.expressad.exoplayer.h.x[] r1 = r0.f9378r
            int r7 = r1.length
            r8 = 0
        L75:
            if (r8 >= r7) goto L7f
            r9 = r1[r8]
            r9.a()
            int r8 = r8 + 1
            goto L75
        L7f:
            r8 = r23
            r8.a(r5, r5)
            goto L87
        L85:
            r0.K = r1
        L87:
            r1 = 1
        L88:
            if (r1 == 0) goto L8e
            if (r2 == 0) goto L8d
            return r4
        L8d:
            return r3
        L8e:
            r1 = 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.n.a(com.anythink.expressad.exoplayer.h.n$a, long, long, java.io.IOException):int");
    }

    static /* synthetic */ void a(n nVar) {
        if (nVar.M || nVar.f9381u || nVar.f9377q == null || !nVar.f9380t) {
            return;
        }
        for (x xVar : nVar.f9378r) {
            if (xVar.f() == null) {
                return;
            }
        }
        nVar.f9372l.b();
        int length = nVar.f9378r.length;
        ae[] aeVarArr = new ae[length];
        nVar.D = new boolean[length];
        nVar.C = new boolean[length];
        nVar.E = new boolean[length];
        nVar.B = nVar.f9377q.b();
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.m mVarF = nVar.f9378r[i2].f();
            aeVarArr[i2] = new ae(mVarF);
            String str = mVarF.f9990h;
            if (!com.anythink.expressad.exoplayer.k.o.b(str) && !com.anythink.expressad.exoplayer.k.o.a(str)) {
                z2 = false;
            }
            nVar.D[i2] = z2;
            nVar.F = z2 | nVar.F;
            i2++;
        }
        nVar.A = new af(aeVarArr);
        if (nVar.f9364d == -1 && nVar.G == -1 && nVar.f9377q.b() == com.anythink.expressad.exoplayer.b.b) {
            nVar.f9382v = 6;
        }
        nVar.f9381u = true;
        nVar.f9366f.a(nVar.B, nVar.f9377q.a());
        nVar.f9376p.a((r) nVar);
    }
}
