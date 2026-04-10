package com.anythink.expressad.exoplayer.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends com.anythink.expressad.exoplayer.a implements com.anythink.expressad.exoplayer.k.n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8655n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f8656o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8657p = 2;
    private com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> A;
    private com.anythink.expressad.exoplayer.c.e B;
    private com.anythink.expressad.exoplayer.c.h C;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> D;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> f8658q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f8659r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final g.a f8660s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final h f8661t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.n f8662u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.c.e f8663v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.c.d f8664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m f8665x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f8666y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8667z;

    private final class a implements h.c {
        private a() {
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i2) {
            r.this.f8660s.a(i2);
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            r.b(r.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i2, long j2, long j3) {
            r.this.f8660s.a(i2, j2, j3);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface b {
    }

    public r() {
        this((Handler) null, (g) null, new f[0]);
    }

    private static void A() {
    }

    private com.anythink.expressad.exoplayer.m B() {
        com.anythink.expressad.exoplayer.m mVar = this.f8665x;
        return com.anythink.expressad.exoplayer.m.a((String) null, com.anythink.expressad.exoplayer.k.o.f9878w, (String) null, -1, mVar.f10003u, mVar.f10004v, 2, (List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (String) null);
    }

    private boolean C() throws com.anythink.expressad.exoplayer.g {
        if (this.C == null) {
            this.C = (com.anythink.expressad.exoplayer.c.h) this.A.c();
            com.anythink.expressad.exoplayer.c.h hVar = this.C;
            if (hVar == null) {
                return false;
            }
            this.f8664w.f8731f += hVar.b;
        }
        if (this.C.c()) {
            if (this.F == 2) {
                H();
                G();
                this.H = true;
            } else {
                this.C.e();
                this.C = null;
                E();
            }
            return false;
        }
        if (this.H) {
            com.anythink.expressad.exoplayer.m mVar = this.f8665x;
            com.anythink.expressad.exoplayer.m mVarA = com.anythink.expressad.exoplayer.m.a((String) null, com.anythink.expressad.exoplayer.k.o.f9878w, (String) null, -1, mVar.f10003u, mVar.f10004v, 2, (List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (String) null);
            this.f8661t.a(mVarA.f10005w, mVarA.f10003u, mVarA.f10004v, null, this.f8666y, this.f8667z);
            this.H = false;
        }
        h hVar2 = this.f8661t;
        com.anythink.expressad.exoplayer.c.h hVar3 = this.C;
        if (!hVar2.a(hVar3.f8751c, ((com.anythink.expressad.exoplayer.c.f) hVar3).a)) {
            return false;
        }
        this.f8664w.f8730e++;
        this.C.e();
        this.C = null;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean D() throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.r.D():boolean");
    }

    private void E() throws com.anythink.expressad.exoplayer.g {
        this.M = true;
        try {
            this.f8661t.c();
        } catch (h.d e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    private void F() throws com.anythink.expressad.exoplayer.g {
        this.N = false;
        if (this.F != 0) {
            H();
            G();
            return;
        }
        this.B = null;
        com.anythink.expressad.exoplayer.c.h hVar = this.C;
        if (hVar != null) {
            hVar.e();
            this.C = null;
        }
        this.A.d();
        this.G = false;
    }

    private void G() throws com.anythink.expressad.exoplayer.g {
        if (this.A != null) {
            return;
        }
        this.D = this.E;
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.D;
        if (fVar != null && fVar.g() == null && this.D.f() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ad.a("createAudioDecoder");
            this.A = x();
            ad.a();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f8660s.a(this.A.a(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f8664w.a++;
        } catch (e e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    private void H() {
        com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> gVar = this.A;
        if (gVar == null) {
            return;
        }
        this.B = null;
        this.C = null;
        gVar.e();
        this.A = null;
        this.f8664w.b++;
        this.F = 0;
        this.G = false;
    }

    private void I() {
        long jA = this.f8661t.a(v());
        if (jA != Long.MIN_VALUE) {
            if (!this.K) {
                jA = Math.max(this.I, jA);
            }
            this.I = jA;
            this.K = false;
        }
    }

    static /* synthetic */ boolean b(r rVar) {
        rVar.K = true;
        return true;
    }

    private static void y() {
    }

    private static void z() {
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            I();
        }
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        return this.f8661t.f();
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void n() {
        this.f8661t.a();
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void o() {
        I();
        this.f8661t.h();
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void p() {
        this.f8665x = null;
        this.H = true;
        this.N = false;
        try {
            H();
            this.f8661t.j();
            try {
                if (this.D != null) {
                    this.f8658q.a(this.D);
                }
                try {
                    if (this.E != null && this.E != this.D) {
                        this.f8658q.a(this.E);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.E != null && this.E != this.D) {
                        this.f8658q.a(this.E);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.D != null) {
                    this.f8658q.a(this.D);
                }
                try {
                    if (this.E != null && this.E != this.D) {
                        this.f8658q.a(this.E);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.E != null && this.E != this.D) {
                        this.f8658q.a(this.E);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        if (this.f8661t.e()) {
            return true;
        }
        if (this.f8665x == null || this.N) {
            return false;
        }
        return t() || this.C != null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.M && this.f8661t.d();
    }

    protected abstract int w();

    protected abstract com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> x();

    private r(Handler handler, g gVar, f... fVarArr) {
        this(handler, gVar, null, null, fVarArr);
    }

    private boolean b(int i2) {
        return this.f8661t.a(i2);
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int iW = w();
        if (iW <= 2) {
            return iW;
        }
        return iW | (af.a >= 21 ? 32 : 0) | 8;
    }

    private r(Handler handler, g gVar, c cVar) {
        this(handler, gVar, cVar, null, new f[0]);
    }

    private boolean b(boolean z2) throws com.anythink.expressad.exoplayer.g {
        if (this.D == null || (!z2 && this.f8659r)) {
            return false;
        }
        int iE = this.D.e();
        if (iE != 1) {
            return iE != 4;
        }
        throw com.anythink.expressad.exoplayer.g.a(this.D.f(), s());
    }

    private r(Handler handler, g gVar, c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, f... fVarArr) {
        this(handler, gVar, gVar2, new l(cVar, fVarArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[Catch: d -> 0x01c2, b -> 0x01c4, e | a | b | d -> 0x01c6, e -> 0x01c8, TryCatch #3 {e | a | b | d -> 0x01c6, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0066, B:39:0x00e1, B:41:0x00e5, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0101, B:53:0x0106, B:54:0x0118, B:62:0x012d, B:94:0x01be, B:64:0x0137, B:66:0x013f, B:67:0x014c, B:70:0x0158, B:73:0x015d, B:80:0x0179, B:83:0x0180, B:85:0x018b, B:87:0x0191, B:89:0x01a1, B:90:0x01a5, B:91:0x01a7, B:77:0x0169, B:78:0x0177, B:57:0x011e, B:25:0x0071, B:27:0x0079, B:29:0x007d, B:30:0x0086, B:31:0x0091, B:33:0x0095, B:34:0x00be, B:36:0x00ce), top: B:108:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091 A[Catch: d -> 0x01c2, b -> 0x01c4, e | a | b | d -> 0x01c6, e -> 0x01c8, TryCatch #3 {e | a | b | d -> 0x01c6, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0066, B:39:0x00e1, B:41:0x00e5, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0101, B:53:0x0106, B:54:0x0118, B:62:0x012d, B:94:0x01be, B:64:0x0137, B:66:0x013f, B:67:0x014c, B:70:0x0158, B:73:0x015d, B:80:0x0179, B:83:0x0180, B:85:0x018b, B:87:0x0191, B:89:0x01a1, B:90:0x01a5, B:91:0x01a7, B:77:0x0169, B:78:0x0177, B:57:0x011e, B:25:0x0071, B:27:0x0079, B:29:0x007d, B:30:0x0086, B:31:0x0091, B:33:0x0095, B:34:0x00be, B:36:0x00ce), top: B:108:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101 A[Catch: d -> 0x01c2, b -> 0x01c4, e | a | b | d -> 0x01c6, e -> 0x01c8, TryCatch #3 {e | a | b | d -> 0x01c6, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0066, B:39:0x00e1, B:41:0x00e5, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0101, B:53:0x0106, B:54:0x0118, B:62:0x012d, B:94:0x01be, B:64:0x0137, B:66:0x013f, B:67:0x014c, B:70:0x0158, B:73:0x015d, B:80:0x0179, B:83:0x0180, B:85:0x018b, B:87:0x0191, B:89:0x01a1, B:90:0x01a5, B:91:0x01a7, B:77:0x0169, B:78:0x0177, B:57:0x011e, B:25:0x0071, B:27:0x0079, B:29:0x007d, B:30:0x0086, B:31:0x0091, B:33:0x0095, B:34:0x00be, B:36:0x00ce), top: B:108:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0180 A[Catch: d -> 0x01c2, b -> 0x01c4, e | a | b | d -> 0x01c6, e -> 0x01c8, TryCatch #3 {e | a | b | d -> 0x01c6, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0066, B:39:0x00e1, B:41:0x00e5, B:43:0x00e9, B:46:0x00ef, B:48:0x00f3, B:51:0x0101, B:53:0x0106, B:54:0x0118, B:62:0x012d, B:94:0x01be, B:64:0x0137, B:66:0x013f, B:67:0x014c, B:70:0x0158, B:73:0x015d, B:80:0x0179, B:83:0x0180, B:85:0x018b, B:87:0x0191, B:89:0x01a1, B:90:0x01a5, B:91:0x01a7, B:77:0x0169, B:78:0x0177, B:57:0x011e, B:25:0x0071, B:27:0x0079, B:29:0x007d, B:30:0x0086, B:31:0x0091, B:33:0x0095, B:34:0x00be, B:36:0x00ce), top: B:108:0x004c }] */
    @Override // com.anythink.expressad.exoplayer.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r19, long r21) throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.r.a(long, long):void");
    }

    private r(Handler handler, g gVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, h hVar) {
        super(1);
        this.f8658q = gVar2;
        this.f8659r = false;
        this.f8660s = new g.a(handler, gVar);
        this.f8661t = hVar;
        hVar.a(new a(this, (byte) 0));
        this.f8662u = new com.anythink.expressad.exoplayer.n();
        this.f8663v = com.anythink.expressad.exoplayer.c.e.e();
        this.F = 0;
        this.H = true;
    }

    private void b(com.anythink.expressad.exoplayer.m mVar) throws com.anythink.expressad.exoplayer.g {
        com.anythink.expressad.exoplayer.m mVar2 = this.f8665x;
        this.f8665x = mVar;
        if (!af.a(this.f8665x.f9993k, mVar2 == null ? null : mVar2.f9993k)) {
            if (this.f8665x.f9993k != null) {
                com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar = this.f8658q;
                if (gVar != null) {
                    this.E = gVar.a(Looper.myLooper(), this.f8665x.f9993k);
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.E;
                    if (fVar == this.D) {
                        this.f8658q.a(fVar);
                    }
                } else {
                    throw com.anythink.expressad.exoplayer.g.a(new IllegalStateException("Media requires a DrmSessionManager"), s());
                }
            } else {
                this.E = null;
            }
        }
        if (this.G) {
            this.F = 1;
        } else {
            H();
            G();
            this.H = true;
        }
        this.f8666y = mVar.f10006x;
        this.f8667z = mVar.f10007y;
        this.f8660s.a(mVar);
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        return this.f8661t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void a(boolean z2) {
        this.f8664w = new com.anythink.expressad.exoplayer.c.d();
        this.f8660s.a(this.f8664w);
        int i2 = r().b;
        if (i2 != 0) {
            this.f8661t.c(i2);
        } else {
            this.f8661t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void a(long j2, boolean z2) throws com.anythink.expressad.exoplayer.g {
        this.f8661t.i();
        this.I = j2;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        if (this.A != null) {
            this.N = false;
            if (this.F != 0) {
                H();
                G();
                return;
            }
            this.B = null;
            com.anythink.expressad.exoplayer.c.h hVar = this.C;
            if (hVar != null) {
                hVar.e();
                this.C = null;
            }
            this.A.d();
            this.G = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i2, Object obj) {
        if (i2 == 2) {
            this.f8661t.a(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.a(i2, obj);
        } else {
            this.f8661t.a((com.anythink.expressad.exoplayer.b.b) obj);
        }
    }

    private void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.J || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f8738f - this.I) > 500000) {
            this.I = eVar.f8738f;
        }
        this.J = false;
    }
}
