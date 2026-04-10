package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: HybridBinarizer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f16158e;

    public i(com.google.zxing.d dVar) {
        super(dVar);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    @Override // com.google.zxing.common.g, com.google.zxing.a
    public b a() throws NotFoundException {
        b bVar = this.f16158e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.d dVarC = c();
        int iC = dVarC.c();
        int iA = dVarC.a();
        if (iC < 40 || iA < 40) {
            this.f16158e = super.a();
        } else {
            byte[] bArrB = dVarC.b();
            int i2 = iC >> 3;
            if ((iC & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = iA >> 3;
            if ((iA & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrA = a(bArrB, i3, i5, iC, iA);
            b bVar2 = new b(iC, iA);
            a(bArrB, i3, i5, iC, iA, iArrA, bVar2);
            this.f16158e = bVar2;
        }
        return this.f16158e;
    }

    @Override // com.google.zxing.common.g, com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.d dVar) {
        return new i(dVar);
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int iA = a(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int iA2 = a(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[iA + i15];
                    i14 += iArr2[iA2 - 2] + iArr2[iA2 - 1] + iArr2[iA2] + iArr2[iA2 + 1] + iArr2[iA2 + 2];
                }
                a(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.c(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    private static int[][] a(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = i9 << 3;
            if (i10 > i7) {
                i10 = i7;
            }
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                if (i12 > i8) {
                    i12 = i8;
                }
                int i13 = (i10 * i4) + i12;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 255;
                while (i14 < i6) {
                    int i18 = i15;
                    int i19 = 0;
                    while (i19 < i6) {
                        int i20 = bArr[i13 + i19] & 255;
                        i18 += i20;
                        if (i20 < i17) {
                            i17 = i20;
                        }
                        if (i20 > i16) {
                            i16 = i20;
                        }
                        i19++;
                        i6 = 8;
                    }
                    if (i16 - i17 > 24) {
                        i14++;
                        i13 += i4;
                        i6 = 8;
                        while (i14 < 8) {
                            for (int i21 = 0; i21 < 8; i21++) {
                                i18 += bArr[i13 + i21] & 255;
                            }
                            i14++;
                            i13 += i4;
                        }
                    } else {
                        i6 = 8;
                    }
                    i15 = i18;
                    i14++;
                    i13 += i4;
                }
                int i22 = i15 >> 6;
                if (i16 - i17 <= 24) {
                    i22 = i17 / 2;
                    if (i9 > 0 && i11 > 0) {
                        int i23 = i9 - 1;
                        int i24 = i11 - 1;
                        int i25 = ((iArr[i23][i11] + (iArr[i9][i24] * 2)) + iArr[i23][i24]) / 4;
                        if (i17 < i25) {
                            i22 = i25;
                        }
                    }
                }
                iArr[i9][i11] = i22;
            }
        }
        return iArr;
    }
}
