package com.anythink.expressad.exoplayer.k;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public byte[] a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9905c;

    public s() {
    }

    private int A() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        int i7 = i5 | ((bArr[i6] & 255) << 16);
        int i8 = this.b;
        this.b = i8 + 1;
        return ((bArr[i8] & 255) << 24) | i7;
    }

    private long B() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        long j2 = ((long) bArr[i2]) & 255;
        int i3 = this.b;
        this.b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.b;
        this.b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 16);
        int i5 = this.b;
        this.b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.b;
        this.b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 32);
        int i7 = this.b;
        this.b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 40);
        int i8 = this.b;
        this.b = i8 + 1;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 48);
        int i9 = this.b;
        this.b = i9 + 1;
        return j8 | ((255 & ((long) bArr[i9])) << 56);
    }

    private int C() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        int i7 = i5 | ((bArr[i6] & 255) << 16);
        int i8 = this.b;
        this.b = i8 + 1;
        int i9 = ((bArr[i8] & 255) << 24) | i7;
        if (i9 >= 0) {
            return i9;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i9)));
    }

    private float D() {
        return Float.intBitsToFloat(i());
    }

    private double E() {
        return Double.longBitsToDouble(j());
    }

    private String F() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.b;
        while (i2 < this.f9905c && !af.a((int) this.a[i2])) {
            i2++;
        }
        int i3 = this.b;
        if (i2 - i3 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.b = i3 + 3;
            }
        }
        byte[] bArr2 = this.a;
        int i4 = this.b;
        String strA = af.a(bArr2, i4, i2 - i4);
        this.b = i2;
        int i5 = this.b;
        int i6 = this.f9905c;
        if (i5 == i6) {
            return strA;
        }
        if (this.a[i5] == 13) {
            this.b = i5 + 1;
            if (this.b == i6) {
                return strA;
            }
        }
        byte[] bArr3 = this.a;
        int i7 = this.b;
        if (bArr3[i7] == 10) {
            this.b = i7 + 1;
        }
        return strA;
    }

    private long G() {
        int i2;
        int i3;
        long j2 = this.a[this.b];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j2)));
        }
        for (i2 = 1; i2 < i3; i2++) {
            byte b = this.a[this.b + i2];
            if ((b & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j2)));
            }
            j2 = (j2 << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
        }
        this.b += i3;
        return j2;
    }

    private void q() {
        this.b = 0;
        this.f9905c = 0;
    }

    private int r() {
        byte[] bArr = this.a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private int s() {
        return this.a[this.b] & 255;
    }

    private char t() {
        byte[] bArr = this.a;
        int i2 = this.b;
        return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    private int u() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        return ((bArr[i4] & 255) << 8) | i3;
    }

    private short v() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        return (short) (((bArr[i4] & 255) << 8) | i3);
    }

    private int w() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = ((bArr[i2] & 255) << 24) >> 8;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        return (bArr[i6] & 255) | i5;
    }

    private int x() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        return ((bArr[i6] & 255) << 16) | i5;
    }

    private int y() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = bArr[i2] & 255;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        return ((bArr[i6] & 255) << 16) | i5;
    }

    private long z() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        long j2 = ((long) bArr[i2]) & 255;
        int i3 = this.b;
        this.b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.b;
        this.b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 16);
        int i5 = this.b;
        this.b = i5 + 1;
        return j4 | ((255 & ((long) bArr[i5])) << 24);
    }

    public final void a(byte[] bArr, int i2) {
        this.a = bArr;
        this.f9905c = i2;
        this.b = 0;
    }

    public final int b() {
        return this.f9905c;
    }

    public final int c() {
        return this.b;
    }

    public final void d(int i2) {
        c(this.b + i2);
    }

    public final int e() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = (bArr[i2] & 255) << 8;
        int i4 = this.b;
        this.b = i4 + 1;
        return (bArr[i4] & 255) | i3;
    }

    public final short f() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = (bArr[i2] & 255) << 8;
        int i4 = this.b;
        this.b = i4 + 1;
        return (short) ((bArr[i4] & 255) | i3);
    }

    public final int g() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = (bArr[i2] & 255) << 16;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 8);
        int i6 = this.b;
        this.b = i6 + 1;
        return (bArr[i6] & 255) | i5;
    }

    public final long h() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 24;
        int i3 = this.b;
        this.b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.b;
        this.b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 8);
        int i5 = this.b;
        this.b = i5 + 1;
        return j4 | (255 & ((long) bArr[i5]));
    }

    public final int i() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = (bArr[i2] & 255) << 24;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 16);
        int i6 = this.b;
        this.b = i6 + 1;
        int i7 = i5 | ((bArr[i6] & 255) << 8);
        int i8 = this.b;
        this.b = i8 + 1;
        return (bArr[i8] & 255) | i7;
    }

    public final long j() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i3 = this.b;
        this.b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 48);
        int i4 = this.b;
        this.b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 40);
        int i5 = this.b;
        this.b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i6 = this.b;
        this.b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 24);
        int i7 = this.b;
        this.b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 16);
        int i8 = this.b;
        this.b = i8 + 1;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 8);
        int i9 = this.b;
        this.b = i9 + 1;
        return j8 | (255 & ((long) bArr[i9]));
    }

    public final int k() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        int i3 = (bArr[i2] & 255) << 8;
        int i4 = this.b;
        this.b = i4 + 1;
        int i5 = (bArr[i4] & 255) | i3;
        this.b += 2;
        return i5;
    }

    public final int l() {
        return (d() << 21) | (d() << 14) | (d() << 7) | d();
    }

    public final int m() {
        int i2 = i();
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i2)));
    }

    public final long n() {
        long j2 = j();
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(j2)));
    }

    public final String o() {
        String str = new String(this.a, this.b, 4, Charset.forName("UTF-8"));
        this.b += 4;
        return str;
    }

    public final String p() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.b;
        while (i2 < this.f9905c && this.a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.a;
        int i3 = this.b;
        String strA = af.a(bArr, i3, i2 - i3);
        this.b = i2;
        int i4 = this.b;
        if (i4 < this.f9905c) {
            this.b = i4 + 1;
        }
        return strA;
    }

    public s(int i2) {
        this.a = new byte[i2];
        this.f9905c = i2;
    }

    public final void b(int i2) {
        a.a(i2 >= 0 && i2 <= this.a.length);
        this.f9905c = i2;
    }

    public final void c(int i2) {
        a.a(i2 >= 0 && i2 <= this.f9905c);
        this.b = i2;
    }

    public final int d() {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final String e(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = (this.b + i2) - 1;
        String strA = af.a(this.a, this.b, (i3 >= this.f9905c || this.a[i3] != 0) ? i2 : i2 - 1);
        this.b += i2;
        return strA;
    }

    public final int a() {
        return this.f9905c - this.b;
    }

    public s(byte[] bArr) {
        this.a = bArr;
        this.f9905c = bArr.length;
    }

    private void a(r rVar, int i2) {
        a(rVar.a, 0, i2);
        rVar.a(0);
    }

    public final void a(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.a, this.b, bArr, i2, i3);
        this.b += i3;
    }

    public s(byte[] bArr, int i2) {
        this.a = bArr;
        this.f9905c = i2;
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        byteBuffer.put(this.a, this.b, i2);
        this.b += i2;
    }

    private String a(Charset charset) {
        String str = new String(this.a, this.b, 4, charset);
        this.b += 4;
        return str;
    }

    public final void a(int i2) {
        byte[] bArr = this.a;
        a((bArr == null ? 0 : bArr.length) < i2 ? new byte[i2] : this.a, i2);
    }
}
