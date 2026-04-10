package com.anythink.expressad.exoplayer.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.b.f;
import com.anythink.expressad.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements f {
    public static final float b = 8.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f8691c = 0.1f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f8692d = 8.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f8693e = 0.1f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8694f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f8695g = 0.01f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8696h = 1024;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private s f8703o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f8707s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f8708t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8709u;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f8699k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f8700l = 1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8697i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8698j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8701m = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ByteBuffer f8704p = f.a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ShortBuffer f8705q = this.f8704p.asShortBuffer();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ByteBuffer f8706r = f.a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8702n = -1;

    public final float a(float f2) {
        float fA = af.a(f2);
        if (this.f8699k != fA) {
            this.f8699k = fA;
            this.f8703o = null;
        }
        h();
        return fA;
    }

    public final float b(float f2) {
        float fA = af.a(f2);
        if (this.f8700l != fA) {
            this.f8700l = fA;
            this.f8703o = null;
        }
        h();
        return fA;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f8701m;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        com.anythink.expressad.exoplayer.k.a.b(this.f8703o != null);
        this.f8703o.a();
        this.f8709u = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f8706r;
        this.f8706r = f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        if (!this.f8709u) {
            return false;
        }
        s sVar = this.f8703o;
        return sVar == null || sVar.c() == 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        if (a()) {
            s sVar = this.f8703o;
            if (sVar == null) {
                this.f8703o = new s(this.f8698j, this.f8697i, this.f8699k, this.f8700l, this.f8701m);
            } else {
                sVar.b();
            }
        }
        this.f8706r = f.a;
        this.f8707s = 0L;
        this.f8708t = 0L;
        this.f8709u = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        this.f8699k = 1.0f;
        this.f8700l = 1.0f;
        this.f8697i = -1;
        this.f8698j = -1;
        this.f8701m = -1;
        this.f8704p = f.a;
        this.f8705q = this.f8704p.asShortBuffer();
        this.f8706r = f.a;
        this.f8702n = -1;
        this.f8703o = null;
        this.f8707s = 0L;
        this.f8708t = 0L;
        this.f8709u = false;
    }

    private void a(int i2) {
        this.f8702n = i2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.f8697i;
    }

    public final long a(long j2) {
        long j3 = this.f8708t;
        if (j3 >= 1024) {
            int i2 = this.f8701m;
            int i3 = this.f8698j;
            if (i2 == i3) {
                return af.a(j2, this.f8707s, j3);
            }
            return af.a(j2, this.f8707s * ((long) i2), j3 * ((long) i3));
        }
        double d2 = this.f8699k;
        double d3 = j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (long) (d2 * d3);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i2, int i3, int i4) throws f.a {
        if (i4 == 2) {
            int i5 = this.f8702n;
            if (i5 == -1) {
                i5 = i2;
            }
            if (this.f8698j == i2 && this.f8697i == i3 && this.f8701m == i5) {
                return false;
            }
            this.f8698j = i2;
            this.f8697i = i3;
            this.f8701m = i5;
            this.f8703o = null;
            return true;
        }
        throw new f.a(i2, i3, i4);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        if (this.f8698j != -1) {
            return Math.abs(this.f8699k - 1.0f) >= f8695g || Math.abs(this.f8700l - 1.0f) >= f8695g || this.f8701m != this.f8698j;
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8703o != null);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f8707s += (long) iRemaining;
            this.f8703o.a(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iC = this.f8703o.c() * this.f8697i * 2;
        if (iC > 0) {
            if (this.f8704p.capacity() < iC) {
                this.f8704p = ByteBuffer.allocateDirect(iC).order(ByteOrder.nativeOrder());
                this.f8705q = this.f8704p.asShortBuffer();
            } else {
                this.f8704p.clear();
                this.f8705q.clear();
            }
            this.f8703o.b(this.f8705q);
            this.f8708t += (long) iC;
            this.f8704p.limit(iC);
            this.f8706r = this.f8704p;
        }
    }
}
