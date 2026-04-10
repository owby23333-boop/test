package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import com.anythink.expressad.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
final class n implements f {
    private static final int b = Float.floatToIntBits(Float.NaN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f8614c = 4.656612875245797E-10d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8615d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8616e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8617f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f8618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f8619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8620i;

    public n() {
        ByteBuffer byteBuffer = f.a;
        this.f8618g = byteBuffer;
        this.f8619h = byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i2, int i3, int i4) throws f.a {
        if (!af.c(i4)) {
            throw new f.a(i2, i3, i4);
        }
        if (this.f8615d == i2 && this.f8616e == i3 && this.f8617f == i4) {
            return false;
        }
        this.f8615d = i2;
        this.f8616e = i3;
        this.f8617f = i4;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.f8616e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 4;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f8615d;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.f8620i = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f8619h;
        this.f8619h = f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.f8620i && this.f8619h == f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.f8619h = f.a;
        this.f8620i = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.f8615d = -1;
        this.f8616e = -1;
        this.f8617f = 0;
        this.f8618g = f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return af.c(this.f8617f);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        boolean z2 = this.f8617f == 1073741824;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        if (!z2) {
            i2 = (i2 / 3) * 4;
        }
        if (this.f8618g.capacity() < i2) {
            this.f8618g = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f8618g.clear();
        }
        if (z2) {
            while (iPosition < iLimit) {
                a((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), this.f8618g);
                iPosition += 4;
            }
        } else {
            while (iPosition < iLimit) {
                a(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), this.f8618g);
                iPosition += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f8618g.flip();
        this.f8619h = this.f8618g;
    }

    private static void a(int i2, ByteBuffer byteBuffer) {
        double d2 = i2;
        Double.isNaN(d2);
        int iFloatToIntBits = Float.floatToIntBits((float) (d2 * f8614c));
        if (iFloatToIntBits == b) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }
}
