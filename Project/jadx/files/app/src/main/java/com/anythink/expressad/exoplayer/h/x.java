package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.h.w;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements com.anythink.expressad.exoplayer.e.m {
    public static final int a = -1;
    private static final int b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.b f9471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w f9473e = new w();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w.a f9474f = new w.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.s f9475g = new com.anythink.expressad.exoplayer.k.s(32);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f9476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f9477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f9478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m f9479k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m f9481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9482n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9483o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9484p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b f9485q;

    public interface b {
        void i();
    }

    public x(com.anythink.expressad.exoplayer.j.b bVar) {
        this.f9471c = bVar;
        this.f9472d = bVar.d();
        this.f9476h = new a(0L, this.f9472d);
        a aVar = this.f9476h;
        this.f9477i = aVar;
        this.f9478j = aVar;
    }

    private void c(int i2) {
        this.f9473e.b(i2);
    }

    private void l() {
        this.f9473e.a();
        a(this.f9476h);
        this.f9476h = new a(0L, this.f9472d);
        a aVar = this.f9476h;
        this.f9477i = aVar;
        this.f9478j = aVar;
        this.f9483o = 0L;
        this.f9471c.b();
    }

    private void m() {
        this.f9484p = true;
    }

    private int n() {
        return this.f9473e.e();
    }

    private void o() {
        c(this.f9473e.l());
    }

    public final void a(int i2) {
        this.f9483o = this.f9473e.a(i2);
        long j2 = this.f9483o;
        if (j2 != 0) {
            a aVar = this.f9476h;
            if (j2 != aVar.a) {
                while (this.f9483o > aVar.b) {
                    aVar = aVar.f9488e;
                }
                a aVar2 = aVar.f9488e;
                a(aVar2);
                aVar.f9488e = new a(aVar.b, this.f9472d);
                this.f9478j = this.f9483o == aVar.b ? aVar.f9488e : aVar;
                if (this.f9477i == aVar2) {
                    this.f9477i = aVar.f9488e;
                    return;
                }
                return;
            }
        }
        a(this.f9476h);
        this.f9476h = new a(this.f9483o, this.f9472d);
        a aVar3 = this.f9476h;
        this.f9477i = aVar3;
        this.f9478j = aVar3;
    }

    public final int b() {
        return this.f9473e.b();
    }

    public final int d() {
        return this.f9473e.c();
    }

    public final int e() {
        return this.f9473e.d();
    }

    public final com.anythink.expressad.exoplayer.m f() {
        return this.f9473e.g();
    }

    public final long g() {
        return this.f9473e.h();
    }

    public final long h() {
        return this.f9473e.i();
    }

    public final void i() {
        this.f9473e.j();
        this.f9477i = this.f9476h;
    }

    public final void j() {
        c(this.f9473e.m());
    }

    public final int k() {
        return this.f9473e.k();
    }

    private int d(int i2) {
        a aVar = this.f9478j;
        if (!aVar.f9486c) {
            aVar.a(this.f9471c.a(), new a(this.f9478j.b, this.f9472d));
        }
        return Math.min(i2, (int) (this.f9478j.b - this.f9483o));
    }

    private void e(int i2) {
        this.f9483o += (long) i2;
        long j2 = this.f9483o;
        a aVar = this.f9478j;
        if (j2 == aVar.b) {
            this.f9478j = aVar.f9488e;
        }
    }

    public final boolean b(int i2) {
        return this.f9473e.c(i2);
    }

    public final boolean c() {
        return this.f9473e.f();
    }

    private static final class a {
        public final long a;
        public final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public com.anythink.expressad.exoplayer.j.a f9487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public a f9488e;

        public a(long j2, int i2) {
            this.a = j2;
            this.b = j2 + ((long) i2);
        }

        public final void a(com.anythink.expressad.exoplayer.j.a aVar, a aVar2) {
            this.f9487d = aVar;
            this.f9488e = aVar2;
            this.f9486c = true;
        }

        public final int a(long j2) {
            return ((int) (j2 - this.a)) + this.f9487d.b;
        }

        public final a a() {
            this.f9487d = null;
            a aVar = this.f9488e;
            this.f9488e = null;
            return aVar;
        }
    }

    private void b(long j2) {
        while (true) {
            a aVar = this.f9477i;
            if (j2 < aVar.b) {
                return;
            } else {
                this.f9477i = aVar.f9488e;
            }
        }
    }

    private void c(long j2) {
        a aVar;
        if (j2 == -1) {
            return;
        }
        while (true) {
            aVar = this.f9476h;
            if (j2 < aVar.b) {
                break;
            }
            this.f9471c.a(aVar.f9487d);
            this.f9476h = this.f9476h.a();
        }
        if (this.f9477i.a < aVar.a) {
            this.f9477i = aVar;
        }
    }

    public final void a(long j2, boolean z2, boolean z3) {
        c(this.f9473e.a(j2, z2, z3));
    }

    public final int a(long j2, boolean z2) {
        return this.f9473e.a(j2, z2);
    }

    public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2, boolean z3, long j2) {
        int iE;
        int iA = this.f9473e.a(nVar, eVar, z2, z3, this.f9479k, this.f9474f);
        if (iA == -5) {
            this.f9479k = nVar.a;
            return -5;
        }
        if (iA != -4) {
            if (iA == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!eVar.c()) {
            if (eVar.f8738f < j2) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                w.a aVar = this.f9474f;
                long j3 = aVar.b;
                this.f9475g.a(1);
                a(j3, this.f9475g.a, 1);
                long j4 = j3 + 1;
                byte b2 = this.f9475g.a[0];
                boolean z4 = (b2 & 128) != 0;
                int i2 = b2 & 127;
                com.anythink.expressad.exoplayer.c.b bVar = eVar.f8736d;
                if (bVar.a == null) {
                    bVar.a = new byte[16];
                }
                a(j4, eVar.f8736d.a, i2);
                long j5 = j4 + ((long) i2);
                if (z4) {
                    this.f9475g.a(2);
                    a(j5, this.f9475g.a, 2);
                    j5 += 2;
                    iE = this.f9475g.e();
                } else {
                    iE = 1;
                }
                int[] iArr = eVar.f8736d.f8721d;
                if (iArr == null || iArr.length < iE) {
                    iArr = new int[iE];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = eVar.f8736d.f8722e;
                if (iArr3 == null || iArr3.length < iE) {
                    iArr3 = new int[iE];
                }
                int[] iArr4 = iArr3;
                if (z4) {
                    int i3 = iE * 6;
                    this.f9475g.a(i3);
                    a(j5, this.f9475g.a, i3);
                    j5 += (long) i3;
                    this.f9475g.c(0);
                    for (int i4 = 0; i4 < iE; i4++) {
                        iArr2[i4] = this.f9475g.e();
                        iArr4[i4] = this.f9475g.m();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = aVar.a - ((int) (j5 - aVar.b));
                }
                m.a aVar2 = aVar.f9470c;
                com.anythink.expressad.exoplayer.c.b bVar2 = eVar.f8736d;
                bVar2.a(iE, iArr2, iArr4, aVar2.b, bVar2.a, aVar2.a, aVar2.f9022c, aVar2.f9023d);
                long j6 = aVar.b;
                int i5 = (int) (j5 - j6);
                aVar.b = j6 + ((long) i5);
                aVar.a -= i5;
            }
            eVar.d(this.f9474f.a);
            w.a aVar3 = this.f9474f;
            long j7 = aVar3.b;
            ByteBuffer byteBuffer = eVar.f8737e;
            int i6 = aVar3.a;
            b(j7);
            while (i6 > 0) {
                int iMin = Math.min(i6, (int) (this.f9477i.b - j7));
                a aVar4 = this.f9477i;
                byteBuffer.put(aVar4.f9487d.a, aVar4.a(j7), iMin);
                i6 -= iMin;
                j7 += (long) iMin;
                a aVar5 = this.f9477i;
                if (j7 == aVar5.b) {
                    this.f9477i = aVar5.f9488e;
                }
            }
        }
        return -4;
    }

    private void a(com.anythink.expressad.exoplayer.c.e eVar, w.a aVar) {
        int iE;
        long j2 = aVar.b;
        this.f9475g.a(1);
        a(j2, this.f9475g.a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f9475g.a[0];
        boolean z2 = (b2 & 128) != 0;
        int i2 = b2 & 127;
        com.anythink.expressad.exoplayer.c.b bVar = eVar.f8736d;
        if (bVar.a == null) {
            bVar.a = new byte[16];
        }
        a(j3, eVar.f8736d.a, i2);
        long j4 = j3 + ((long) i2);
        if (z2) {
            this.f9475g.a(2);
            a(j4, this.f9475g.a, 2);
            j4 += 2;
            iE = this.f9475g.e();
        } else {
            iE = 1;
        }
        int[] iArr = eVar.f8736d.f8721d;
        if (iArr == null || iArr.length < iE) {
            iArr = new int[iE];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar.f8736d.f8722e;
        if (iArr3 == null || iArr3.length < iE) {
            iArr3 = new int[iE];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i3 = iE * 6;
            this.f9475g.a(i3);
            a(j4, this.f9475g.a, i3);
            j4 += (long) i3;
            this.f9475g.c(0);
            for (int i4 = 0; i4 < iE; i4++) {
                iArr2[i4] = this.f9475g.e();
                iArr4[i4] = this.f9475g.m();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.a - ((int) (j4 - aVar.b));
        }
        m.a aVar2 = aVar.f9470c;
        com.anythink.expressad.exoplayer.c.b bVar2 = eVar.f8736d;
        bVar2.a(iE, iArr2, iArr4, aVar2.b, bVar2.a, aVar2.a, aVar2.f9022c, aVar2.f9023d);
        long j5 = aVar.b;
        int i5 = (int) (j4 - j5);
        aVar.b = j5 + ((long) i5);
        aVar.a -= i5;
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        b(j2);
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.f9477i.b - j2));
            a aVar = this.f9477i;
            byteBuffer.put(aVar.f9487d.a, aVar.a(j2), iMin);
            i2 -= iMin;
            j2 += (long) iMin;
            a aVar2 = this.f9477i;
            if (j2 == aVar2.b) {
                this.f9477i = aVar2.f9488e;
            }
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        b(j2);
        long j3 = j2;
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (this.f9477i.b - j3));
            a aVar = this.f9477i;
            System.arraycopy(aVar.f9487d.a, aVar.a(j3), bArr, i2 - i3, iMin);
            i3 -= iMin;
            j3 += (long) iMin;
            a aVar2 = this.f9477i;
            if (j3 == aVar2.b) {
                this.f9477i = aVar2.f9488e;
            }
        }
    }

    public final void a(b bVar) {
        this.f9485q = bVar;
    }

    public final void a(long j2) {
        if (this.f9482n != j2) {
            this.f9482n = j2;
            this.f9480l = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // com.anythink.expressad.exoplayer.e.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.exoplayer.m r8) {
        /*
            r7 = this;
            long r0 = r7.f9482n
            if (r8 != 0) goto L6
            r0 = 0
            goto L1e
        L6:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L1d
            long r2 = r8.f9994l
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L1d
            long r2 = r2 + r0
            com.anythink.expressad.exoplayer.m r0 = r8.a(r2)
            goto L1e
        L1d:
            r0 = r8
        L1e:
            com.anythink.expressad.exoplayer.h.w r1 = r7.f9473e
            boolean r0 = r1.a(r0)
            r7.f9481m = r8
            r8 = 0
            r7.f9480l = r8
            com.anythink.expressad.exoplayer.h.x$b r8 = r7.f9485q
            if (r8 == 0) goto L32
            if (r0 == 0) goto L32
            r8.i()
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.x.a(com.anythink.expressad.exoplayer.m):void");
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i2, boolean z2) throws EOFException {
        int iD = d(i2);
        a aVar = this.f9478j;
        int iA = fVar.a(aVar.f9487d.a, aVar.a(this.f9483o), iD);
        if (iA != -1) {
            e(iA);
            return iA;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        while (i2 > 0) {
            int iD = d(i2);
            a aVar = this.f9478j;
            sVar.a(aVar.f9487d.a, aVar.a(this.f9483o), iD);
            i2 -= iD;
            e(iD);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(long j2, int i2, int i3, int i4, m.a aVar) {
        if (this.f9480l) {
            a(this.f9481m);
        }
        if (this.f9484p) {
            if ((i2 & 1) == 0 || !this.f9473e.a(j2)) {
                return;
            } else {
                this.f9484p = false;
            }
        }
        this.f9473e.a(j2 + this.f9482n, i2, (this.f9483o - ((long) i3)) - ((long) i4), i3, aVar);
    }

    private void a(a aVar) {
        if (aVar.f9486c) {
            a aVar2 = this.f9478j;
            boolean z2 = aVar2.f9486c;
            com.anythink.expressad.exoplayer.j.a[] aVarArr = new com.anythink.expressad.exoplayer.j.a[(z2 ? 1 : 0) + (((int) (aVar2.a - aVar.a)) / this.f9472d)];
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                aVarArr[i2] = aVar.f9487d;
                aVar = aVar.a();
            }
            this.f9471c.a(aVarArr);
        }
    }

    private static com.anythink.expressad.exoplayer.m a(com.anythink.expressad.exoplayer.m mVar, long j2) {
        if (mVar == null) {
            return null;
        }
        if (j2 == 0) {
            return mVar;
        }
        long j3 = mVar.f9994l;
        return j3 != Long.MAX_VALUE ? mVar.a(j3 + j2) : mVar;
    }

    public final void a() {
        this.f9473e.a();
        a(this.f9476h);
        this.f9476h = new a(0L, this.f9472d);
        a aVar = this.f9476h;
        this.f9477i = aVar;
        this.f9478j = aVar;
        this.f9483o = 0L;
        this.f9471c.b();
    }
}
