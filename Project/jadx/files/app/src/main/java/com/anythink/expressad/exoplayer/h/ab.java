package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;

/* JADX INFO: loaded from: classes2.dex */
public final class ab extends com.anythink.expressad.exoplayer.ae {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f9199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f9200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f9202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f9203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f9204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f9205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Object f9206k;

    private ab(long j2, boolean z2, boolean z3) {
        this(j2, z2, z3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[PHI: r1
  0x002f: PHI (r1v4 long) = (r1v3 long), (r1v3 long), (r1v6 long) binds: [B:7:0x0018, B:9:0x001e, B:14:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.anythink.expressad.exoplayer.ae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.ae.b a(int r17, com.anythink.expressad.exoplayer.ae.b r18, boolean r19, long r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = 1
            r2 = r17
            com.anythink.expressad.exoplayer.k.a.a(r2, r1)
            if (r19 == 0) goto Ld
            java.lang.Object r1 = r0.f9206k
            goto Le
        Ld:
            r1 = 0
        Le:
            r3 = r1
            long r1 = r0.f9203h
            boolean r4 = r0.f9205j
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L2f
            r7 = 0
            int r4 = (r20 > r7 ? 1 : (r20 == r7 ? 0 : -1))
            if (r4 == 0) goto L2f
            long r7 = r0.f9201f
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L28
        L26:
            r10 = r5
            goto L30
        L28:
            long r1 = r1 + r20
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 <= 0) goto L2f
            goto L26
        L2f:
            r10 = r1
        L30:
            long r4 = r0.f9198c
            long r6 = r0.f9199d
            boolean r8 = r0.f9204i
            boolean r9 = r0.f9205j
            long r12 = r0.f9201f
            long r14 = r0.f9202g
            r2 = r18
            com.anythink.expressad.exoplayer.ae$b r1 = r2.a(r3, r4, r6, r8, r9, r10, r12, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.ab.a(int, com.anythink.expressad.exoplayer.ae$b, boolean, long):com.anythink.expressad.exoplayer.ae$b");
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b() {
        return 1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int c() {
        return 1;
    }

    public ab(long j2, boolean z2, boolean z3, @Nullable Object obj) {
        this(j2, j2, z2, z3, obj, (byte) 0);
    }

    private ab(long j2, long j3, boolean z2, boolean z3, @Nullable Object obj, byte b2) {
        this(j2, j3, z2, z3, obj);
    }

    private ab(long j2, long j3, boolean z2, boolean z3, @Nullable Object obj) {
        this.f9198c = com.anythink.expressad.exoplayer.b.b;
        this.f9199d = com.anythink.expressad.exoplayer.b.b;
        this.f9200e = j2;
        this.f9201f = j3;
        this.f9202g = 0L;
        this.f9203h = 0L;
        this.f9204i = z2;
        this.f9205j = z3;
        this.f9206k = obj;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i2, ae.a aVar, boolean z2) {
        com.anythink.expressad.exoplayer.k.a.a(i2, 1);
        return aVar.a(null, z2 ? b : null, this.f9200e, -this.f9202g);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }
}
