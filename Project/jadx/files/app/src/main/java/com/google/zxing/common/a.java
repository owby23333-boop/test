package com.google.zxing.common;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: BitArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f16143s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f16144t;

    public a() {
        this.f16144t = 0;
        this.f16143s = new int[1];
    }

    private void e(int i2) {
        if (i2 > (this.f16143s.length << 5)) {
            int[] iArrF = f(i2);
            int[] iArr = this.f16143s;
            System.arraycopy(iArr, 0, iArrF, 0, iArr.length);
            this.f16143s = iArrF;
        }
    }

    private static int[] f(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public boolean a(int i2) {
        return ((1 << (i2 & 31)) & this.f16143s[i2 / 32]) != 0;
    }

    public int b(int i2) {
        int i3 = this.f16144t;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & this.f16143s[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f16143s;
            if (i4 == iArr.length) {
                return this.f16144t;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f16144t;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int c() {
        return this.f16144t;
    }

    public int d() {
        return (this.f16144t + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f16144t == aVar.f16144t && Arrays.equals(this.f16143s, aVar.f16143s);
    }

    public int hashCode() {
        return (this.f16144t * 31) + Arrays.hashCode(this.f16143s);
    }

    public String toString() {
        int i2 = this.f16144t;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.f16144t; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void a() {
        int length = this.f16143s.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f16143s[i2] = 0;
        }
    }

    public int c(int i2) {
        int i3 = this.f16144t;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & (this.f16143s[i4] ^ (-1));
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f16143s;
            if (i4 == iArr.length) {
                return this.f16144t;
            }
            i5 = iArr[i4] ^ (-1);
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f16144t;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a m63clone() {
        return new a((int[]) this.f16143s.clone(), this.f16144t);
    }

    public void d(int i2) {
        int[] iArr = this.f16143s;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public a(int i2) {
        this.f16144t = i2;
        this.f16143s = f(i2);
    }

    public boolean a(int i2, int i3, boolean z2) {
        if (i3 < i2 || i2 < 0 || i3 > this.f16144t) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.f16143s[i7] & i8;
            if (!z2) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void e() {
        int[] iArr = new int[this.f16143s.length];
        int i2 = (this.f16144t - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f16143s[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i5 = this.f16144t;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.f16143s = iArr;
    }

    a(int[] iArr, int i2) {
        this.f16143s = iArr;
        this.f16144t = i2;
    }

    public void a(boolean z2) {
        e(this.f16144t + 1);
        if (z2) {
            int[] iArr = this.f16143s;
            int i2 = this.f16144t;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f16144t++;
    }

    public void b(int i2, int i3) {
        this.f16143s[i2 / 32] = i3;
    }

    public void b(a aVar) {
        if (this.f16144t != aVar.f16144t) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f16143s;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.f16143s[i2];
            i2++;
        }
    }

    public void a(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            e(this.f16144t + i3);
            while (i3 > 0) {
                boolean z2 = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z2 = false;
                }
                a(z2);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public int[] b() {
        return this.f16143s;
    }

    public void a(a aVar) {
        int i2 = aVar.f16144t;
        e(this.f16144t + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.a(i3));
        }
    }

    public void a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = i2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            int i8 = 0;
            for (int i9 = 0; i9 < 8; i9++) {
                if (a(i7)) {
                    i8 |= 1 << (7 - i9);
                }
                i7++;
            }
            bArr[i3 + i6] = (byte) i8;
            i6++;
            i5 = i7;
        }
    }
}
