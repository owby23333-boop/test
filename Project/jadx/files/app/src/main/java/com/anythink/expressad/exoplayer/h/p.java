package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.ae;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends com.anythink.expressad.exoplayer.ae {
    protected final com.anythink.expressad.exoplayer.ae b;

    public p(com.anythink.expressad.exoplayer.ae aeVar) {
        this.b = aeVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int a(int i2, int i3, boolean z2) {
        return this.b.a(i2, i3, z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b() {
        return this.b.b();
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int c() {
        return this.b.c();
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(boolean z2) {
        return this.b.a(z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int b(int i2, int i3, boolean z2) {
        return this.b.b(i2, i3, z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public ae.b a(int i2, ae.b bVar, boolean z2, long j2) {
        return this.b.a(i2, bVar, z2, j2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(boolean z2) {
        return this.b.b(z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public ae.a a(int i2, ae.a aVar, boolean z2) {
        return this.b.a(i2, aVar, z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public int a(Object obj) {
        return this.b.a(obj);
    }
}
