package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.e.m;

/* JADX INFO: loaded from: classes2.dex */
final class w {
    private static final int a = 1000;
    private int b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f9453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f9454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f9455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f9456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long[] f9457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m.a[] f9458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m[] f9459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9467q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m f9468r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9469s;

    public static final class a {
        public int a;
        public long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public m.a f9470c;
    }

    public w() {
        int i2 = this.b;
        this.f9453c = new int[i2];
        this.f9454d = new long[i2];
        this.f9457g = new long[i2];
        this.f9456f = new int[i2];
        this.f9455e = new int[i2];
        this.f9458h = new m.a[i2];
        this.f9459i = new com.anythink.expressad.exoplayer.m[i2];
        this.f9464n = Long.MIN_VALUE;
        this.f9465o = Long.MIN_VALUE;
        this.f9467q = true;
        this.f9466p = true;
    }

    public final void a() {
        this.f9460j = 0;
        this.f9461k = 0;
        this.f9462l = 0;
        this.f9463m = 0;
        this.f9466p = true;
        this.f9464n = Long.MIN_VALUE;
        this.f9465o = Long.MIN_VALUE;
    }

    public final int b() {
        return this.f9461k + this.f9460j;
    }

    public final int c() {
        return this.f9461k;
    }

    public final int d() {
        return this.f9461k + this.f9463m;
    }

    public final int e() {
        return f() ? this.f9453c[f(this.f9463m)] : this.f9469s;
    }

    public final synchronized boolean f() {
        return this.f9463m != this.f9460j;
    }

    public final synchronized com.anythink.expressad.exoplayer.m g() {
        if (this.f9467q) {
            return null;
        }
        return this.f9468r;
    }

    public final synchronized long h() {
        return this.f9465o;
    }

    public final synchronized long i() {
        if (this.f9460j == 0) {
            return Long.MIN_VALUE;
        }
        return this.f9457g[this.f9462l];
    }

    public final synchronized void j() {
        this.f9463m = 0;
    }

    public final synchronized int k() {
        int i2;
        i2 = this.f9460j - this.f9463m;
        this.f9463m = this.f9460j;
        return i2;
    }

    public final synchronized long l() {
        if (this.f9463m == 0) {
            return -1L;
        }
        return d(this.f9463m);
    }

    public final synchronized long m() {
        if (this.f9460j == 0) {
            return -1L;
        }
        return d(this.f9460j);
    }

    private long d(int i2) {
        this.f9464n = Math.max(this.f9464n, e(i2));
        this.f9460j -= i2;
        this.f9461k += i2;
        this.f9462l += i2;
        int i3 = this.f9462l;
        int i4 = this.b;
        if (i3 >= i4) {
            this.f9462l = i3 - i4;
        }
        this.f9463m -= i2;
        if (this.f9463m < 0) {
            this.f9463m = 0;
        }
        if (this.f9460j != 0) {
            return this.f9454d[this.f9462l];
        }
        int i5 = this.f9462l;
        if (i5 == 0) {
            i5 = this.b;
        }
        int i6 = i5 - 1;
        return this.f9454d[i6] + ((long) this.f9455e[i6]);
    }

    private int f(int i2) {
        int i3 = this.f9462l + i2;
        int i4 = this.b;
        return i3 < i4 ? i3 : i3 - i4;
    }

    public final void b(int i2) {
        this.f9469s = i2;
    }

    public final synchronized boolean c(int i2) {
        if (this.f9461k > i2 || i2 > this.f9461k + this.f9460j) {
            return false;
        }
        this.f9463m = i2 - this.f9461k;
        return true;
    }

    private synchronized void b(long j2) {
        this.f9465o = Math.max(this.f9465o, j2);
    }

    private long e(int i2) {
        long jMax = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int iF = f(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            jMax = Math.max(jMax, this.f9457g[iF]);
            if ((this.f9456f[iF] & 1) != 0) {
                break;
            }
            iF--;
            if (iF == -1) {
                iF = this.b - 1;
            }
        }
        return jMax;
    }

    public final long a(int i2) {
        int iB = b() - i2;
        com.anythink.expressad.exoplayer.k.a.a(iB >= 0 && iB <= this.f9460j - this.f9463m);
        this.f9460j -= iB;
        this.f9465o = Math.max(this.f9464n, e(this.f9460j));
        int i3 = this.f9460j;
        if (i3 == 0) {
            return 0L;
        }
        int iF = f(i3 - 1);
        return this.f9454d[iF] + ((long) this.f9455e[iF]);
    }

    public final synchronized int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2, boolean z3, com.anythink.expressad.exoplayer.m mVar, a aVar) {
        if (!f()) {
            if (z3) {
                eVar.a(4);
                return -4;
            }
            if (this.f9468r == null || (!z2 && this.f9468r == mVar)) {
                return -3;
            }
            nVar.a = this.f9468r;
            return -5;
        }
        int iF = f(this.f9463m);
        if (!z2 && this.f9459i[iF] == mVar) {
            if (eVar.f()) {
                return -3;
            }
            eVar.f8738f = this.f9457g[iF];
            eVar.a(this.f9456f[iF]);
            aVar.a = this.f9455e[iF];
            aVar.b = this.f9454d[iF];
            aVar.f9470c = this.f9458h[iF];
            this.f9463m++;
            return -4;
        }
        nVar.a = this.f9459i[iF];
        return -5;
    }

    public final synchronized int a(long j2, boolean z2) {
        int iF = f(this.f9463m);
        if (f() && j2 >= this.f9457g[iF] && (j2 <= this.f9465o || z2)) {
            int iA = a(iF, this.f9460j - this.f9463m, j2, true);
            if (iA == -1) {
                return -1;
            }
            this.f9463m += iA;
            return iA;
        }
        return -1;
    }

    public final synchronized long a(long j2, boolean z2, boolean z3) {
        if (this.f9460j != 0 && j2 >= this.f9457g[this.f9462l]) {
            int iA = a(this.f9462l, (!z3 || this.f9463m == this.f9460j) ? this.f9460j : this.f9463m + 1, j2, z2);
            if (iA == -1) {
                return -1L;
            }
            return d(iA);
        }
        return -1L;
    }

    public final synchronized boolean a(com.anythink.expressad.exoplayer.m mVar) {
        if (mVar == null) {
            this.f9467q = true;
            return false;
        }
        this.f9467q = false;
        if (com.anythink.expressad.exoplayer.k.af.a(mVar, this.f9468r)) {
            return false;
        }
        this.f9468r = mVar;
        return true;
    }

    public final synchronized void a(long j2, int i2, long j3, int i3, m.a aVar) {
        if (this.f9466p) {
            if ((i2 & 1) == 0) {
                return;
            } else {
                this.f9466p = false;
            }
        }
        com.anythink.expressad.exoplayer.k.a.b(!this.f9467q);
        b(j2);
        int iF = f(this.f9460j);
        this.f9457g[iF] = j2;
        this.f9454d[iF] = j3;
        this.f9455e[iF] = i3;
        this.f9456f[iF] = i2;
        this.f9458h[iF] = aVar;
        this.f9459i[iF] = this.f9468r;
        this.f9453c[iF] = this.f9469s;
        this.f9460j++;
        if (this.f9460j == this.b) {
            int i4 = this.b + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            m.a[] aVarArr = new m.a[i4];
            com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[i4];
            int i5 = this.b - this.f9462l;
            System.arraycopy(this.f9454d, this.f9462l, jArr, 0, i5);
            System.arraycopy(this.f9457g, this.f9462l, jArr2, 0, i5);
            System.arraycopy(this.f9456f, this.f9462l, iArr2, 0, i5);
            System.arraycopy(this.f9455e, this.f9462l, iArr3, 0, i5);
            System.arraycopy(this.f9458h, this.f9462l, aVarArr, 0, i5);
            System.arraycopy(this.f9459i, this.f9462l, mVarArr, 0, i5);
            System.arraycopy(this.f9453c, this.f9462l, iArr, 0, i5);
            int i6 = this.f9462l;
            System.arraycopy(this.f9454d, 0, jArr, i5, i6);
            System.arraycopy(this.f9457g, 0, jArr2, i5, i6);
            System.arraycopy(this.f9456f, 0, iArr2, i5, i6);
            System.arraycopy(this.f9455e, 0, iArr3, i5, i6);
            System.arraycopy(this.f9458h, 0, aVarArr, i5, i6);
            System.arraycopy(this.f9459i, 0, mVarArr, i5, i6);
            System.arraycopy(this.f9453c, 0, iArr, i5, i6);
            this.f9454d = jArr;
            this.f9457g = jArr2;
            this.f9456f = iArr2;
            this.f9455e = iArr3;
            this.f9458h = aVarArr;
            this.f9459i = mVarArr;
            this.f9453c = iArr;
            this.f9462l = 0;
            this.f9460j = this.b;
            this.b = i4;
        }
    }

    public final synchronized boolean a(long j2) {
        if (this.f9460j == 0) {
            return j2 > this.f9464n;
        }
        if (Math.max(this.f9464n, e(this.f9463m)) >= j2) {
            return false;
        }
        int i2 = this.f9460j;
        int iF = f(this.f9460j - 1);
        while (i2 > this.f9463m && this.f9457g[iF] >= j2) {
            i2--;
            iF--;
            if (iF == -1) {
                iF = this.b - 1;
            }
        }
        a(this.f9461k + i2);
        return true;
    }

    private int a(int i2, int i3, long j2, boolean z2) {
        int i4 = i2;
        int i5 = -1;
        for (int i6 = 0; i6 < i3 && this.f9457g[i4] <= j2; i6++) {
            if (!z2 || (this.f9456f[i4] & 1) != 0) {
                i5 = i6;
            }
            i4++;
            if (i4 == this.b) {
                i4 = 0;
            }
        }
        return i5;
    }
}
