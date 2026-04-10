package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements f {
    private static final long b = 150000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f8635c = 20000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final short f8636d = 1024;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte f8637e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8638f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8639g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8640h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ByteBuffer f8645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ByteBuffer f8646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte[] f8648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private byte[] f8649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8650r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8651s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8652t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8653u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f8654v;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface a {
    }

    public q() {
        ByteBuffer byteBuffer = f.a;
        this.f8645m = byteBuffer;
        this.f8646n = byteBuffer;
        this.f8641i = -1;
        this.f8642j = -1;
        this.f8648p = new byte[0];
        this.f8649q = new byte[0];
    }

    private void c(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iF = f(byteBuffer);
        int iPosition = iF - byteBuffer.position();
        byte[] bArr = this.f8648p;
        int length = bArr.length;
        int i2 = this.f8651s;
        int i3 = length - i2;
        if (iF < iLimit && iPosition < i3) {
            a(bArr, i2);
            this.f8651s = 0;
            this.f8650r = 0;
            return;
        }
        int iMin = Math.min(iPosition, i3);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f8648p, this.f8651s, iMin);
        this.f8651s += iMin;
        int i4 = this.f8651s;
        byte[] bArr2 = this.f8648p;
        if (i4 == bArr2.length) {
            if (this.f8653u) {
                a(bArr2, this.f8652t);
                this.f8654v += (long) ((this.f8651s - (this.f8652t * 2)) / this.f8643k);
            } else {
                this.f8654v += (long) ((i4 - this.f8652t) / this.f8643k);
            }
            a(byteBuffer, this.f8648p, this.f8651s);
            this.f8651s = 0;
            this.f8650r = 2;
        }
        byteBuffer.limit(iLimit);
    }

    public final void a(boolean z2) {
        this.f8644l = z2;
        h();
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.f8641i;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f8642j;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.f8647o = true;
        int i2 = this.f8651s;
        if (i2 > 0) {
            a(this.f8648p, i2);
        }
        if (this.f8653u) {
            return;
        }
        this.f8654v += (long) (this.f8652t / this.f8643k);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f8646n;
        this.f8646n = f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.f8647o && this.f8646n == f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        if (a()) {
            int iA = a(b) * this.f8643k;
            if (this.f8648p.length != iA) {
                this.f8648p = new byte[iA];
            }
            this.f8652t = a(f8635c) * this.f8643k;
            int length = this.f8649q.length;
            int i2 = this.f8652t;
            if (length != i2) {
                this.f8649q = new byte[i2];
            }
        }
        this.f8650r = 0;
        this.f8646n = f.a;
        this.f8647o = false;
        this.f8654v = 0L;
        this.f8651s = 0;
        this.f8653u = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        this.f8644l = false;
        h();
        this.f8645m = f.a;
        this.f8641i = -1;
        this.f8642j = -1;
        this.f8652t = 0;
        this.f8648p = new byte[0];
        this.f8649q = new byte[0];
    }

    public final long j() {
        return this.f8654v;
    }

    private void b(ByteBuffer byteBuffer) {
        int iPosition;
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f8648p.length));
        int iLimit2 = byteBuffer.limit() - 1;
        while (true) {
            if (iLimit2 < byteBuffer.position()) {
                iPosition = byteBuffer.position();
                break;
            } else {
                if (Math.abs((int) byteBuffer.get(iLimit2)) > 4) {
                    int i2 = this.f8643k;
                    iPosition = ((iLimit2 / i2) * i2) + i2;
                    break;
                }
                iLimit2 -= 2;
            }
        }
        if (iPosition == byteBuffer.position()) {
            this.f8650r = 1;
        } else {
            byteBuffer.limit(iPosition);
            a(byteBuffer.remaining());
            this.f8645m.put(byteBuffer);
            this.f8645m.flip();
            this.f8646n = this.f8645m;
        }
        byteBuffer.limit(iLimit);
    }

    private void d(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iF = f(byteBuffer);
        byteBuffer.limit(iF);
        this.f8654v += (long) (byteBuffer.remaining() / this.f8643k);
        a(byteBuffer, this.f8649q, this.f8652t);
        if (iF < iLimit) {
            a(this.f8649q, this.f8652t);
            this.f8650r = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private int g(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (Math.abs((int) byteBuffer.get(iLimit)) > 4) {
                int i2 = this.f8643k;
                return ((iLimit / i2) * i2) + i2;
            }
        }
        return byteBuffer.position();
    }

    private int f(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.get(iPosition)) > 4) {
                int i2 = this.f8643k;
                return i2 * (iPosition / i2);
            }
        }
        return byteBuffer.limit();
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i2, int i3, int i4) throws f.a {
        if (i4 == 2) {
            if (this.f8642j == i2 && this.f8641i == i3) {
                return false;
            }
            this.f8642j = i2;
            this.f8641i = i3;
            this.f8643k = i3 * 2;
            return true;
        }
        throw new f.a(i2, i3, i4);
    }

    private void e(ByteBuffer byteBuffer) {
        a(byteBuffer.remaining());
        this.f8645m.put(byteBuffer);
        this.f8645m.flip();
        this.f8646n = this.f8645m;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.f8642j != -1 && this.f8644l;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f8646n.hasRemaining()) {
            int i2 = this.f8650r;
            if (i2 == 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f8648p.length));
                int iLimit2 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit2 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.get(iLimit2)) > 4) {
                            int i3 = this.f8643k;
                            iPosition = ((iLimit2 / i3) * i3) + i3;
                            break;
                        }
                        iLimit2 -= 2;
                    } else {
                        iPosition = byteBuffer.position();
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.f8650r = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    a(byteBuffer.remaining());
                    this.f8645m.put(byteBuffer);
                    this.f8645m.flip();
                    this.f8646n = this.f8645m;
                }
                byteBuffer.limit(iLimit);
            } else if (i2 == 1) {
                int iLimit3 = byteBuffer.limit();
                int iF = f(byteBuffer);
                int iPosition2 = iF - byteBuffer.position();
                byte[] bArr = this.f8648p;
                int length = bArr.length;
                int i4 = this.f8651s;
                int i5 = length - i4;
                if (iF < iLimit3 && iPosition2 < i5) {
                    a(bArr, i4);
                    this.f8651s = 0;
                    this.f8650r = 0;
                } else {
                    int iMin = Math.min(iPosition2, i5);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.f8648p, this.f8651s, iMin);
                    this.f8651s += iMin;
                    int i6 = this.f8651s;
                    byte[] bArr2 = this.f8648p;
                    if (i6 == bArr2.length) {
                        if (this.f8653u) {
                            a(bArr2, this.f8652t);
                            this.f8654v += (long) ((this.f8651s - (this.f8652t * 2)) / this.f8643k);
                        } else {
                            this.f8654v += (long) ((i6 - this.f8652t) / this.f8643k);
                        }
                        a(byteBuffer, this.f8648p, this.f8651s);
                        this.f8651s = 0;
                        this.f8650r = 2;
                    }
                    byteBuffer.limit(iLimit3);
                }
            } else if (i2 == 2) {
                int iLimit4 = byteBuffer.limit();
                int iF2 = f(byteBuffer);
                byteBuffer.limit(iF2);
                this.f8654v += (long) (byteBuffer.remaining() / this.f8643k);
                a(byteBuffer, this.f8649q, this.f8652t);
                if (iF2 < iLimit4) {
                    a(this.f8649q, this.f8652t);
                    this.f8650r = 0;
                    byteBuffer.limit(iLimit4);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void a(byte[] bArr, int i2) {
        a(i2);
        this.f8645m.put(bArr, 0, i2);
        this.f8645m.flip();
        this.f8646n = this.f8645m;
    }

    private void a(int i2) {
        if (this.f8645m.capacity() < i2) {
            this.f8645m = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f8645m.clear();
        }
        if (i2 > 0) {
            this.f8653u = true;
        }
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int iMin = Math.min(byteBuffer.remaining(), this.f8652t);
        int i3 = this.f8652t - iMin;
        System.arraycopy(bArr, i2 - i3, this.f8649q, 0, i3);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f8649q, i3, iMin);
    }

    private int a(long j2) {
        return (int) ((j2 * ((long) this.f8642j)) / 1000000);
    }
}
