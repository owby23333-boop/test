package com.anythink.expressad.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements y, z {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f8439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private aa f8440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8442q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.h.y f8443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private m[] f8444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f8445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8446u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f8447v;

    public a(int i2) {
        this.f8439n = i2;
    }

    @Override // com.anythink.expressad.exoplayer.y, com.anythink.expressad.exoplayer.z
    public final int a() {
        return this.f8439n;
    }

    @Override // com.anythink.expressad.exoplayer.x.b
    public void a(int i2, Object obj) {
    }

    protected void a(long j2, boolean z2) {
    }

    protected void a(boolean z2) {
    }

    protected void a(m[] mVarArr, long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final int a_() {
        return this.f8442q;
    }

    protected final int b(long j2) {
        return this.f8443r.a(j2 - this.f8445t);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final z b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void b_() {
        com.anythink.expressad.exoplayer.k.a.b(this.f8442q == 1);
        this.f8442q = 2;
        n();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public com.anythink.expressad.exoplayer.k.n c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.h.y f() {
        return this.f8443r;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean g() {
        return this.f8446u;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void h() {
        this.f8447v = true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean i() {
        return this.f8447v;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void j() {
        this.f8443r.c();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void k() {
        com.anythink.expressad.exoplayer.k.a.b(this.f8442q == 2);
        this.f8442q = 1;
        o();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void l() {
        com.anythink.expressad.exoplayer.k.a.b(this.f8442q == 1);
        this.f8442q = 0;
        this.f8443r = null;
        this.f8444s = null;
        this.f8447v = false;
        p();
    }

    @Override // com.anythink.expressad.exoplayer.z
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    protected final m[] q() {
        return this.f8444s;
    }

    protected final aa r() {
        return this.f8440o;
    }

    protected final int s() {
        return this.f8441p;
    }

    protected final boolean t() {
        return this.f8446u ? this.f8447v : this.f8443r.b();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(int i2) {
        this.f8441p = i2;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(aa aaVar, m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j2, boolean z2, long j3) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8442q == 0);
        this.f8440o = aaVar;
        this.f8442q = 1;
        a(z2);
        a(mVarArr, yVar, j3);
        a(j2, z2);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f8447v);
        this.f8443r = yVar;
        this.f8446u = false;
        this.f8444s = mVarArr;
        this.f8445t = j2;
        a(mVarArr, j2);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j2) {
        this.f8447v = false;
        this.f8446u = false;
        a(j2, false);
    }

    protected final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
        int iA = this.f8443r.a(nVar, eVar, z2);
        if (iA == -4) {
            if (eVar.c()) {
                this.f8446u = true;
                return this.f8447v ? -4 : -3;
            }
            eVar.f8738f += this.f8445t;
        } else if (iA == -5) {
            m mVar = nVar.a;
            long j2 = mVar.f9994l;
            if (j2 != Long.MAX_VALUE) {
                nVar.a = mVar.a(j2 + this.f8445t);
            }
        }
        return iA;
    }

    protected static boolean a(@Nullable com.anythink.expressad.exoplayer.d.g<?> gVar, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (gVar == null) {
            return false;
        }
        return gVar.a(eVar);
    }
}
