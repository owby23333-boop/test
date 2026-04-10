package com.anythink.expressad.exoplayer.k;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public byte[] a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9904d;

    public r() {
    }

    private void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    private int f() {
        a.b(this.f9903c == 0);
        return this.b;
    }

    private void g() {
        int i2;
        int i3 = this.b;
        a.b(i3 >= 0 && (i3 < (i2 = this.f9904d) || (i3 == i2 && this.f9903c == 0)));
    }

    public final int b() {
        return (this.b * 8) + this.f9903c;
    }

    public final void c() {
        int i2 = this.f9903c + 1;
        this.f9903c = i2;
        if (i2 == 8) {
            this.f9903c = 0;
            this.b++;
        }
        g();
    }

    public final boolean d() {
        boolean z2 = (this.a[this.b] & (128 >> this.f9903c)) != 0;
        c();
        return z2;
    }

    public final void e() {
        if (this.f9903c == 0) {
            return;
        }
        this.f9903c = 0;
        this.b++;
        g();
    }

    public r(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private void a(s sVar) {
        a(sVar.a, sVar.b());
        a(sVar.c() * 8);
    }

    public final void b(int i2) {
        int i3 = i2 / 8;
        this.b += i3;
        this.f9903c += i2 - (i3 * 8);
        int i4 = this.f9903c;
        if (i4 > 7) {
            this.b++;
            this.f9903c = i4 - 8;
        }
        g();
    }

    private r(byte[] bArr, int i2) {
        this.a = bArr;
        this.f9904d = i2;
    }

    public final void d(int i2) {
        int i3 = i2 & 16383;
        int iMin = Math.min(8 - this.f9903c, 14);
        int i4 = this.f9903c;
        int i5 = (8 - i4) - iMin;
        int i6 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i4) | ((1 << i5) - 1);
        byte[] bArr = this.a;
        int i7 = this.b;
        bArr[i7] = (byte) (i6 & bArr[i7]);
        int i8 = 14 - iMin;
        bArr[i7] = (byte) (((i3 >>> i8) << i5) | bArr[i7]);
        int i9 = i7 + 1;
        while (i8 > 8) {
            this.a[i9] = (byte) (i3 >>> (i8 - 8));
            i8 -= 8;
            i9++;
        }
        int i10 = 8 - i8;
        byte[] bArr2 = this.a;
        bArr2[i9] = (byte) (bArr2[i9] & ((1 << i10) - 1));
        bArr2[i9] = (byte) (((i3 & ((1 << i8) - 1)) << i10) | bArr2[i9]);
        b(14);
        g();
    }

    public final void a(byte[] bArr, int i2) {
        this.a = bArr;
        this.b = 0;
        this.f9903c = 0;
        this.f9904d = i2;
    }

    private void e(int i2) {
        a.b(this.f9903c == 0);
        this.b += i2;
        g();
    }

    public final int c(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f9903c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f9903c;
            if (i3 <= 8) {
                break;
            }
            this.f9903c = i3 - 8;
            byte[] bArr = this.a;
            int i5 = this.b;
            this.b = i5 + 1;
            i4 |= (bArr[i5] & 255) << this.f9903c;
        }
        byte[] bArr2 = this.a;
        int i6 = this.b;
        int i7 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i6] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f9903c = 0;
            this.b = i6 + 1;
        }
        g();
        return i7;
    }

    public final int a() {
        return ((this.f9904d - this.b) * 8) - this.f9903c;
    }

    private void b(byte[] bArr, int i2, int i3) {
        a.b(this.f9903c == 0);
        System.arraycopy(this.a, this.b, bArr, i2, i3);
        this.b += i3;
        g();
    }

    public final void a(int i2) {
        this.b = i2 / 8;
        this.f9903c = i2 - (this.b * 8);
        g();
    }

    private void a(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.a;
            int i5 = this.b;
            this.b = i5 + 1;
            byte b = bArr2[i5];
            int i6 = this.f9903c;
            bArr[i2] = (byte) (b << i6);
            bArr[i2] = (byte) (((255 & bArr2[this.b]) >> (8 - i6)) | bArr[i2]);
            i2++;
        }
        int i7 = i3 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i4] = (byte) (bArr[i4] & (255 >> i7));
        int i8 = this.f9903c;
        if (i8 + i7 > 8) {
            int i9 = bArr[i4];
            byte[] bArr3 = this.a;
            int i10 = this.b;
            this.b = i10 + 1;
            bArr[i4] = (byte) (i9 | ((bArr3[i10] & 255) << i8));
            this.f9903c = i8 - 8;
        }
        this.f9903c += i7;
        byte[] bArr4 = this.a;
        int i11 = this.b;
        int i12 = bArr4[i11] & 255;
        int i13 = this.f9903c;
        bArr[i4] = (byte) (((byte) ((i12 >> (8 - i13)) << (8 - i7))) | bArr[i4]);
        if (i13 == 8) {
            this.f9903c = 0;
            this.b = i11 + 1;
        }
        g();
    }
}
