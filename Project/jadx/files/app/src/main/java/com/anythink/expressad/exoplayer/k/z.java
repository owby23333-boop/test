package com.anythink.expressad.exoplayer.k;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements n {
    private final c a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.v f9924e = com.anythink.expressad.exoplayer.v.a;

    public z(c cVar) {
        this.a = cVar;
    }

    public final void a() {
        if (this.b) {
            return;
        }
        this.f9923d = this.a.a();
        this.b = true;
    }

    public final void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        long j2 = this.f9922c;
        if (!this.b) {
            return j2;
        }
        long jA = this.a.a() - this.f9923d;
        com.anythink.expressad.exoplayer.v vVar = this.f9924e;
        return j2 + (vVar.b == 1.0f ? com.anythink.expressad.exoplayer.b.b(jA) : vVar.a(jA));
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        return this.f9924e;
    }

    public final void a(long j2) {
        this.f9922c = j2;
        if (this.b) {
            this.f9923d = this.a.a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        if (this.b) {
            a(d());
        }
        this.f9924e = vVar;
        return vVar;
    }
}
