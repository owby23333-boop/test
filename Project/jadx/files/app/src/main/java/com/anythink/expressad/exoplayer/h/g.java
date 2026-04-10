package com.anythink.expressad.exoplayer.h;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements z {
    protected final z[] a;

    public g(z[] zVarArr) {
        this.a = zVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
        for (z zVar : this.a) {
            zVar.a_(j2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        boolean zC;
        boolean z2 = false;
        do {
            long jE = e();
            if (jE == Long.MIN_VALUE) {
                break;
            }
            zC = false;
            for (z zVar : this.a) {
                long jE2 = zVar.e();
                boolean z3 = jE2 != Long.MIN_VALUE && jE2 <= j2;
                if (jE2 == jE || z3) {
                    zC |= zVar.c(j2);
                }
            }
            z2 |= zC;
        } while (zC);
        return z2;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long jMin = Long.MAX_VALUE;
        for (z zVar : this.a) {
            long jD = zVar.d();
            if (jD != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jD);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long jMin = Long.MAX_VALUE;
        for (z zVar : this.a) {
            long jE = zVar.e();
            if (jE != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jE);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }
}
