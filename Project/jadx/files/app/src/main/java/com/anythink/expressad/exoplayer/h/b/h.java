package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f9283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final d f9284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile int f9285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f9286o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f9287p;

    private h(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i2, Object obj, long j2, long j3, long j4, long j5, int i3, long j6, d dVar) {
        super(hVar, kVar, mVar, i2, obj, j2, j3, j4, j5);
        this.f9282k = i3;
        this.f9283l = j6;
        this.f9284m = dVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
        this.f9286o = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        k kVarA = this.b.a(this.f9285n);
        try {
            com.anythink.expressad.exoplayer.e.b bVar = new com.anythink.expressad.exoplayer.e.b(this.f9249i, kVarA.f9669e, this.f9249i.a(kVarA));
            if (this.f9285n == 0) {
                b bVarC = c();
                bVarC.a(this.f9283l);
                this.f9284m.a(bVarC, this.a == com.anythink.expressad.exoplayer.b.b ? 0L : this.a - this.f9283l);
            }
            try {
                com.anythink.expressad.exoplayer.e.e eVar = this.f9284m.a;
                int iA = 0;
                while (iA == 0 && !this.f9286o) {
                    iA = eVar.a(bVar, (com.anythink.expressad.exoplayer.e.j) null);
                }
                com.anythink.expressad.exoplayer.k.a.b(iA != 1);
                af.a(this.f9249i);
                this.f9287p = true;
            } finally {
                this.f9285n = (int) (bVar.c() - this.b.f9669e);
            }
        } catch (Throwable th) {
            af.a(this.f9249i);
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.b.c
    public final long d() {
        return this.f9285n;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final long e() {
        return this.f9288j + ((long) this.f9282k);
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final boolean f() {
        return this.f9287p;
    }
}
