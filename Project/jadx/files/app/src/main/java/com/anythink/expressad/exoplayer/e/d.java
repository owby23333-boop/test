package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.k.s;
import java.io.EOFException;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements m {
    @Override // com.anythink.expressad.exoplayer.e.m
    public final int a(f fVar, int i2, boolean z2) throws EOFException {
        int iA = fVar.a(i2);
        if (iA != -1) {
            return iA;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(long j2, int i2, int i3, int i4, m.a aVar) {
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.m mVar) {
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(s sVar, int i2) {
        sVar.d(i2);
    }
}
