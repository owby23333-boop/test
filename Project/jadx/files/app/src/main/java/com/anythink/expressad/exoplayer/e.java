package com.anythink.expressad.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class e implements com.anythink.expressad.exoplayer.k.n {
    private final com.anythink.expressad.exoplayer.k.z a;
    private final a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private y f8830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private com.anythink.expressad.exoplayer.k.n f8831d;

    public interface a {
        void a(v vVar);
    }

    public e(a aVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.b = aVar;
        this.a = new com.anythink.expressad.exoplayer.k.z(cVar);
    }

    private void f() {
        this.a.a(this.f8831d.d());
        v vVarE = this.f8831d.e();
        if (vVarE.equals(this.a.e())) {
            return;
        }
        this.a.a(vVarE);
        this.b.a(vVarE);
    }

    private boolean g() {
        y yVar = this.f8830c;
        if (yVar == null || yVar.v()) {
            return false;
        }
        return this.f8830c.u() || !this.f8830c.g();
    }

    public final void a() {
        this.a.a();
    }

    public final void b() {
        this.a.b();
    }

    public final long c() {
        if (!g()) {
            return this.a.d();
        }
        f();
        return this.f8831d.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        return g() ? this.f8831d.d() : this.a.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        com.anythink.expressad.exoplayer.k.n nVar = this.f8831d;
        return nVar != null ? nVar.e() : this.a.e();
    }

    public final void a(long j2) {
        this.a.a(j2);
    }

    public final void b(y yVar) {
        if (yVar == this.f8830c) {
            this.f8831d = null;
            this.f8830c = null;
        }
    }

    public final void a(y yVar) throws g {
        com.anythink.expressad.exoplayer.k.n nVar;
        com.anythink.expressad.exoplayer.k.n nVarC = yVar.c();
        if (nVarC == null || nVarC == (nVar = this.f8831d)) {
            return;
        }
        if (nVar == null) {
            this.f8831d = nVarC;
            this.f8830c = yVar;
            this.f8831d.a(this.a.e());
            f();
            return;
        }
        throw g.a(new IllegalStateException("Multiple renderer media clocks enabled."));
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        com.anythink.expressad.exoplayer.k.n nVar = this.f8831d;
        if (nVar != null) {
            vVar = nVar.a(vVar);
        }
        this.a.a(vVar);
        this.b.a(vVar);
        return vVar;
    }
}
