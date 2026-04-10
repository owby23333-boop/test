package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final m f9290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile int f9291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f9292n;

    private j(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i2, Object obj, long j2, long j3, long j4, int i3, m mVar2) {
        super(hVar, kVar, mVar, i2, obj, j2, j3, com.anythink.expressad.exoplayer.b.b, j4);
        this.f9289k = i3;
        this.f9290l = mVar2;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        try {
            long jA = this.f9249i.a(this.b.a(this.f9291m));
            if (jA != -1) {
                jA += (long) this.f9291m;
            }
            com.anythink.expressad.exoplayer.e.b bVar = new com.anythink.expressad.exoplayer.e.b(this.f9249i, this.f9291m, jA);
            b bVarC = c();
            bVarC.a(0L);
            com.anythink.expressad.exoplayer.e.m mVarA = bVarC.a(this.f9289k);
            mVarA.a(this.f9290l);
            for (int iA = 0; iA != -1; iA = mVarA.a(bVar, Integer.MAX_VALUE, true)) {
                this.f9291m += iA;
            }
            mVarA.a(this.f9247g, 1, this.f9291m, 0, null);
            af.a(this.f9249i);
            this.f9292n = true;
        } catch (Throwable th) {
            af.a(this.f9249i);
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.b.c
    public final long d() {
        return this.f9291m;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final boolean f() {
        return this.f9292n;
    }
}
