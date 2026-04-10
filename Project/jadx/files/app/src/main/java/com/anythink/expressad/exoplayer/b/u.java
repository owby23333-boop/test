package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import com.anythink.expressad.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
final class u implements f {
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f8715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ByteBuffer f8716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f8717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8719l;

    public u() {
        ByteBuffer byteBuffer = f.a;
        this.f8715h = byteBuffer;
        this.f8716i = byteBuffer;
        this.f8712e = -1;
        this.f8713f = -1;
        this.f8717j = new byte[0];
    }

    public final void a(int i2, int i3) {
        this.f8710c = i2;
        this.f8711d = i3;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.f8712e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f8713f;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.f8719l = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f8716i;
        this.f8716i = f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.f8719l && this.f8716i == f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.f8716i = f.a;
        this.f8719l = false;
        this.f8714g = 0;
        this.f8718k = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.f8715h = f.a;
        this.f8712e = -1;
        this.f8713f = -1;
        this.f8717j = new byte[0];
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i2, int i3, int i4) throws f.a {
        if (i4 == 2) {
            this.f8712e = i3;
            this.f8713f = i2;
            int i5 = this.f8711d;
            this.f8717j = new byte[i5 * i3 * 2];
            this.f8718k = 0;
            int i6 = this.f8710c;
            this.f8714g = i3 * i6 * 2;
            boolean z2 = this.b;
            this.b = (i6 == 0 && i5 == 0) ? false : true;
            return z2 != this.b;
        }
        throw new f.a(i2, i3, i4);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.b;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int iMin = Math.min(i2, this.f8714g);
        this.f8714g -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f8714g > 0) {
            return;
        }
        int i3 = i2 - iMin;
        int length = (this.f8718k + i3) - this.f8717j.length;
        if (this.f8715h.capacity() < length) {
            this.f8715h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f8715h.clear();
        }
        int iA = af.a(length, 0, this.f8718k);
        this.f8715h.put(this.f8717j, 0, iA);
        int iA2 = af.a(length - iA, 0, i3);
        byteBuffer.limit(byteBuffer.position() + iA2);
        this.f8715h.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i4 = i3 - iA2;
        this.f8718k -= iA;
        byte[] bArr = this.f8717j;
        System.arraycopy(bArr, iA, bArr, 0, this.f8718k);
        byteBuffer.get(this.f8717j, this.f8718k, i4);
        this.f8718k += i4;
        this.f8715h.flip();
        this.f8716i = this.f8715h;
    }
}
