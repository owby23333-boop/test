package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    private final com.google.zxing.common.b a;
    private final com.google.zxing.common.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f16195c;

    a(com.google.zxing.common.b bVar) throws FormatException {
        int iC = bVar.c();
        if (iC < 8 || iC > 144 || (iC & 1) != 0) {
            throw FormatException.f();
        }
        this.f16195c = b(bVar);
        this.a = a(bVar);
        this.b = new com.google.zxing.common.b(this.a.e(), this.a.c());
    }

    private static d b(com.google.zxing.common.b bVar) throws FormatException {
        return d.a(bVar.c(), bVar.e());
    }

    private int c(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (a(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (a(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return a(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int d(int i2, int i3) {
        int i4 = (a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    d a() {
        return this.f16195c;
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.b.c(i3, i2);
        return this.a.b(i3, i2);
    }

    private int a(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (a(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (a(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (a(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return a(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    byte[] b() throws FormatException {
        byte[] bArr = new byte[this.f16195c.f()];
        int iC = this.a.c();
        int iE = this.a.e();
        int i2 = 4;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i2 == iC && i3 == 0 && !z2) {
                bArr[i4] = (byte) a(iC, iE);
                i2 -= 2;
                i3 += 2;
                i4++;
                z2 = true;
            } else {
                int i5 = iC - 2;
                if (i2 == i5 && i3 == 0 && (iE & 3) != 0 && !z3) {
                    bArr[i4] = (byte) b(iC, iE);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z3 = true;
                } else if (i2 == iC + 4 && i3 == 2 && (iE & 7) == 0 && !z4) {
                    bArr[i4] = (byte) c(iC, iE);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z4 = true;
                } else if (i2 == i5 && i3 == 0 && (iE & 7) == 4 && !z5) {
                    bArr[i4] = (byte) d(iC, iE);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z5 = true;
                } else {
                    do {
                        if (i2 < iC && i3 >= 0 && !this.b.b(i3, i2)) {
                            bArr[i4] = (byte) b(i2, i3, iC, iE);
                            i4++;
                        }
                        i2 -= 2;
                        i3 += 2;
                        if (i2 < 0) {
                            break;
                        }
                    } while (i3 < iE);
                    int i6 = i2 + 1;
                    int i7 = i3 + 3;
                    do {
                        if (i6 >= 0 && i7 < iE && !this.b.b(i7, i6)) {
                            bArr[i4] = (byte) b(i6, i7, iC, iE);
                            i4++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= iC) {
                            break;
                        }
                    } while (i7 >= 0);
                    i2 = i6 + 3;
                    i3 = i7 + 1;
                }
            }
            if (i2 >= iC && i3 >= iE) {
                break;
            }
        }
        if (i4 == this.f16195c.f()) {
            return bArr;
        }
        throw FormatException.f();
    }

    private com.google.zxing.common.b a(com.google.zxing.common.b bVar) {
        int iE = this.f16195c.e();
        int iD = this.f16195c.d();
        if (bVar.c() == iE) {
            int iB = this.f16195c.b();
            int iA = this.f16195c.a();
            int i2 = iE / iB;
            int i3 = iD / iA;
            com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i3 * iA, i2 * iB);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * iB;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i6 * iA;
                    for (int i8 = 0; i8 < iB; i8++) {
                        int i9 = ((iB + 2) * i4) + 1 + i8;
                        int i10 = i5 + i8;
                        for (int i11 = 0; i11 < iA; i11++) {
                            if (bVar.b(((iA + 2) * i6) + 1 + i11, i9)) {
                                bVar2.c(i7 + i11, i10);
                            }
                        }
                    }
                }
            }
            return bVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (a(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (a(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (a(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (a(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return a(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private int b(int i2, int i3) {
        int i4 = (a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return a(1, i10, i2, i3) ? i11 | 1 : i11;
    }
}
