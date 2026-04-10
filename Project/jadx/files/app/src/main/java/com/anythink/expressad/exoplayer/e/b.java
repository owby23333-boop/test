package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.k.af;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements f {
    private static final int a = 65536;
    private static final int b = 524288;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9007c = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f9009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9011g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9014j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f9012h = new byte[65536];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9008d = new byte[4096];

    public b(com.anythink.expressad.exoplayer.j.h hVar, long j2, long j3) {
        this.f9009e = hVar;
        this.f9011g = j2;
        this.f9010f = j3;
    }

    private void f(int i2) {
        int i3 = this.f9013i + i2;
        byte[] bArr = this.f9012h;
        if (i3 > bArr.length) {
            this.f9012h = Arrays.copyOf(this.f9012h, af.a(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int g(int i2) {
        int iMin = Math.min(this.f9014j, i2);
        h(iMin);
        return iMin;
    }

    private void h(int i2) {
        this.f9014j -= i2;
        this.f9013i = 0;
        byte[] bArr = this.f9012h;
        int i3 = this.f9014j;
        if (i3 < bArr.length - 524288) {
            bArr = new byte[i3 + 65536];
        }
        System.arraycopy(this.f9012h, i2, bArr, 0, this.f9014j);
        this.f9012h = bArr;
    }

    private void i(int i2) {
        if (i2 != -1) {
            this.f9011g += (long) i2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(byte[] bArr, int i2, int i3) throws InterruptedException, EOFException {
        int iE = e(bArr, i2, i3);
        if (iE == 0) {
            iE = a(bArr, i2, i3, 0, true);
        }
        i(iE);
        return iE;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void b(byte[] bArr, int i2, int i3) throws InterruptedException, EOFException {
        a(bArr, i2, i3, false);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean c(byte[] bArr, int i2, int i3) {
        if (!d(i3)) {
            return false;
        }
        System.arraycopy(this.f9012h, this.f9013i - i3, bArr, i2, i3);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean d(int i2) throws InterruptedException, EOFException {
        f(i2);
        int iMin = Math.min(this.f9014j - this.f9013i, i2);
        while (iMin < i2) {
            iMin = a(this.f9012h, this.f9013i, i2, iMin, false);
            if (iMin == -1) {
                return false;
            }
        }
        this.f9013i += i2;
        this.f9014j = Math.max(this.f9014j, this.f9013i);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void e(int i2) throws InterruptedException, EOFException {
        d(i2);
    }

    private int e(byte[] bArr, int i2, int i3) {
        int i4 = this.f9014j;
        if (i4 == 0) {
            return 0;
        }
        int iMin = Math.min(i4, i3);
        System.arraycopy(this.f9012h, 0, bArr, i2, iMin);
        h(iMin);
        return iMin;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean b(int i2) throws InterruptedException, EOFException {
        int iG = g(i2);
        while (iG < i2 && iG != -1) {
            iG = a(this.f9008d, -iG, Math.min(i2, this.f9008d.length + iG), iG, false);
        }
        i(iG);
        return iG != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long c() {
        return this.f9011g;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean a(byte[] bArr, int i2, int i3, boolean z2) throws InterruptedException, EOFException {
        int iE = e(bArr, i2, i3);
        while (iE < i3 && iE != -1) {
            iE = a(bArr, i2, i3, iE, z2);
        }
        i(iE);
        return iE != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void c(int i2) throws InterruptedException, EOFException {
        int iG = g(i2);
        while (iG < i2 && iG != -1) {
            iG = a(this.f9008d, -iG, Math.min(i2, this.f9008d.length + iG), iG, false);
        }
        i(iG);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long d() {
        return this.f9010f;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(int i2) throws InterruptedException, EOFException {
        int iG = g(i2);
        if (iG == 0) {
            byte[] bArr = this.f9008d;
            iG = a(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        i(iG);
        return iG;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long b() {
        return this.f9011g + ((long) this.f9013i);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void d(byte[] bArr, int i2, int i3) {
        if (d(i3)) {
            System.arraycopy(this.f9012h, this.f9013i - i3, bArr, i2, i3);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void a() {
        this.f9013i = 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    @Override // com.anythink.expressad.exoplayer.e.f
    public final <E extends Throwable> void a(long j2, E e2) throws E {
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        this.f9011g = j2;
        throw e2;
    }

    private int a(byte[] bArr, int i2, int i3, int i4, boolean z2) throws InterruptedException, EOFException {
        if (!Thread.interrupted()) {
            int iA = this.f9009e.a(bArr, i2 + i4, i3 - i4);
            if (iA != -1) {
                return i4 + iA;
            }
            if (i4 == 0 && z2) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}
