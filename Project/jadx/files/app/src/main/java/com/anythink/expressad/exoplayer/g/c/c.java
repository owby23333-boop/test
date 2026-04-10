package com.anythink.expressad.exoplayer.g.c;

import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.r;
import com.anythink.expressad.exoplayer.k.s;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.anythink.expressad.exoplayer.g.b {
    private static final int a = 0;
    private static final int b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9115c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9116d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9117e = 255;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s f9118f = new s();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f9119g = new r();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ac f9120h;

    @Override // com.anythink.expressad.exoplayer.g.b
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e eVar) {
        ac acVar = this.f9120h;
        if (acVar == null || eVar.f9142g != acVar.a()) {
            this.f9120h = new ac(eVar.f8738f);
            this.f9120h.b(eVar.f8738f - eVar.f9142g);
        }
        ByteBuffer byteBuffer = eVar.f8737e;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f9118f.a(bArrArray, iLimit);
        this.f9119g.a(bArrArray, iLimit);
        this.f9119g.b(39);
        long jC = (((long) this.f9119g.c(1)) << 32) | ((long) this.f9119g.c(32));
        this.f9119g.b(20);
        int iC = this.f9119g.c(12);
        int iC2 = this.f9119g.c(8);
        a.InterfaceC0191a eVar2 = null;
        this.f9118f.d(14);
        if (iC2 == 0) {
            eVar2 = new e();
        } else if (iC2 == 255) {
            eVar2 = a.a(this.f9118f, iC, jC);
        } else if (iC2 == 4) {
            eVar2 = f.a(this.f9118f);
        } else if (iC2 == 5) {
            eVar2 = d.a(this.f9118f, jC, this.f9120h);
        } else if (iC2 == 6) {
            eVar2 = g.a(this.f9118f, jC, this.f9120h);
        }
        return eVar2 == null ? new com.anythink.expressad.exoplayer.g.a(new a.InterfaceC0191a[0]) : new com.anythink.expressad.exoplayer.g.a(eVar2);
    }
}
