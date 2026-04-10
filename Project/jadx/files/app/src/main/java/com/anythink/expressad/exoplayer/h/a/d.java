package com.anythink.expressad.exoplayer.h.a;

import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.p;

/* JADX INFO: loaded from: classes2.dex */
final class d extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f9196c;

    public d(ae aeVar, a aVar) {
        super(aeVar);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.c() == 1);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.b() == 1);
        this.f9196c = aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i2, ae.a aVar, boolean z2) {
        this.b.a(i2, aVar, z2);
        aVar.a(aVar.a, aVar.b, aVar.f8469c, aVar.f8470d, aVar.b(), this.f9196c);
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final ae.b a(int i2, ae.b bVar, boolean z2, long j2) {
        ae.b bVarA = super.a(i2, bVar, z2, j2);
        if (bVarA.f8479i == com.anythink.expressad.exoplayer.b.b) {
            bVarA.f8479i = this.f9196c.f9172k;
        }
        return bVarA;
    }
}
