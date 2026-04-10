package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: GlobalHistogramBinarizer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends com.google.zxing.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f16156d = new byte[0];
    private byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f16157c;

    public g(com.google.zxing.d dVar) {
        super(dVar);
        this.b = f16156d;
        this.f16157c = new int[32];
    }

    @Override // com.google.zxing.a
    public a a(int i2, a aVar) throws NotFoundException {
        com.google.zxing.d dVarC = c();
        int iC = dVarC.c();
        if (aVar == null || aVar.c() < iC) {
            aVar = new a(iC);
        } else {
            aVar.a();
        }
        a(iC);
        byte[] bArrA = dVarC.a(i2, this.b);
        int[] iArr = this.f16157c;
        for (int i3 = 0; i3 < iC; i3++) {
            int i4 = (bArrA[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iA = a(iArr);
        if (iC < 3) {
            for (int i5 = 0; i5 < iC; i5++) {
                if ((bArrA[i5] & 255) < iA) {
                    aVar.d(i5);
                }
            }
        } else {
            int i6 = bArrA[0] & 255;
            int i7 = bArrA[1] & 255;
            int i8 = i6;
            int i9 = 1;
            while (i9 < iC - 1) {
                int i10 = i9 + 1;
                int i11 = bArrA[i10] & 255;
                if ((((i7 << 2) - i8) - i11) / 2 < iA) {
                    aVar.d(i9);
                }
                i8 = i7;
                i9 = i10;
                i7 = i11;
            }
        }
        return aVar;
    }

    @Override // com.google.zxing.a
    public b a() throws NotFoundException {
        com.google.zxing.d dVarC = c();
        int iC = dVarC.c();
        int iA = dVarC.a();
        b bVar = new b(iC, iA);
        a(iC);
        int[] iArr = this.f16157c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] bArrA = dVarC.a((iA * i2) / 5, this.b);
            int i3 = (iC << 2) / 5;
            for (int i4 = iC / 5; i4 < i3; i4++) {
                int i5 = (bArrA[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int iA2 = a(iArr);
        byte[] bArrB = dVarC.b();
        for (int i6 = 0; i6 < iA; i6++) {
            int i7 = i6 * iC;
            for (int i8 = 0; i8 < iC; i8++) {
                if ((bArrB[i7 + i8] & 255) < iA2) {
                    bVar.c(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.d dVar) {
        return new g(dVar);
    }

    private void a(int i2) {
        if (this.b.length < i2) {
            this.b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f16157c[i3] = 0;
        }
    }

    private static int a(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 > i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i6 - i4 <= length / 16) {
            throw NotFoundException.f();
        }
        int i12 = i6 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i4) {
            int i15 = i12 - i4;
            int i16 = i15 * i15 * (i6 - i12) * (i3 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }
}
