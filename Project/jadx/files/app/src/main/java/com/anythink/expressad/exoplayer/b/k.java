package com.anythink.expressad.exoplayer.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.b.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class k implements f {
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private int[] f8573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private int[] f8575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f8576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f8577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8578i;

    public k() {
        ByteBuffer byteBuffer = f.a;
        this.f8576g = byteBuffer;
        this.f8577h = byteBuffer;
        this.b = -1;
        this.f8572c = -1;
    }

    public final void a(@Nullable int[] iArr) {
        this.f8573d = iArr;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        int[] iArr = this.f8575f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f8572c;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.f8578i = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f8577h;
        this.f8577h = f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.f8578i && this.f8577h == f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.f8577h = f.a;
        this.f8578i = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.f8576g = f.a;
        this.b = -1;
        this.f8572c = -1;
        this.f8575f = null;
        this.f8573d = null;
        this.f8574e = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i2, int i3, int i4) throws f.a {
        boolean z2 = !Arrays.equals(this.f8573d, this.f8575f);
        this.f8575f = this.f8573d;
        if (this.f8575f == null) {
            this.f8574e = false;
            return z2;
        }
        if (i4 != 2) {
            throw new f.a(i2, i3, i4);
        }
        if (!z2 && this.f8572c == i2 && this.b == i3) {
            return false;
        }
        this.f8572c = i2;
        this.b = i3;
        this.f8574e = i3 != this.f8575f.length;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f8575f;
            if (i5 >= iArr.length) {
                return true;
            }
            int i6 = iArr[i5];
            if (i6 >= i3) {
                throw new f.a(i2, i3, i4);
            }
            this.f8574e = (i6 != i5) | this.f8574e;
            i5++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.f8574e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8575f != null);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = ((iLimit - iPosition) / (this.b * 2)) * this.f8575f.length * 2;
        if (this.f8576g.capacity() < length) {
            this.f8576g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f8576g.clear();
        }
        while (iPosition < iLimit) {
            for (int i2 : this.f8575f) {
                this.f8576g.putShort(byteBuffer.getShort((i2 * 2) + iPosition));
            }
            iPosition += this.b * 2;
        }
        byteBuffer.position(iLimit);
        this.f8576g.flip();
        this.f8577h = this.f8576g;
    }
}
