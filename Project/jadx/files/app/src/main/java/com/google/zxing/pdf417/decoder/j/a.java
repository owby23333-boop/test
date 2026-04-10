package com.google.zxing.pdf417.decoder.j;

import com.google.zxing.ChecksumException;

/* JADX INFO: compiled from: ErrorCorrection.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final b a = b.f16311f;

    public int a(int[] iArr, int i2, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int iA = cVar.a(this.a.a(i3));
            iArr3[i2 - i3] = iA;
            if (iA != 0) {
                z2 = true;
            }
        }
        if (!z2) {
            return 0;
        }
        c cVarA = this.a.a();
        if (iArr2 != null) {
            c cVarB = cVarA;
            for (int i4 : iArr2) {
                int iA2 = this.a.a((iArr.length - 1) - i4);
                b bVar = this.a;
                cVarB = cVarB.b(new c(bVar, new int[]{bVar.d(0, iA2), 1}));
            }
        }
        c[] cVarArrA = a(this.a.b(i2, 1), new c(this.a, iArr3), i2);
        c cVar2 = cVarArrA[0];
        c cVar3 = cVarArrA[1];
        int[] iArrA = a(cVar2);
        int[] iArrA2 = a(cVar3, cVar2, iArrA);
        for (int i5 = 0; i5 < iArrA.length; i5++) {
            int length = (iArr.length - 1) - this.a.c(iArrA[i5]);
            if (length < 0) {
                throw ChecksumException.f();
            }
            iArr[length] = this.a.d(iArr[length], iArrA2[i5]);
        }
        return iArrA.length;
    }

    private c[] a(c cVar, c cVar2, int i2) throws ChecksumException {
        if (cVar.a() < cVar2.a()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarC = this.a.c();
        c cVarA = this.a.a();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarA;
            c cVar5 = cVarC;
            cVarC = cVar4;
            if (cVar.a() >= i2 / 2) {
                if (!cVar.b()) {
                    c cVarC2 = this.a.c();
                    int iB = this.a.b(cVar.b(cVar.a()));
                    while (cVar2.a() >= cVar.a() && !cVar2.b()) {
                        int iA = cVar2.a() - cVar.a();
                        int iC = this.a.c(cVar2.b(cVar2.a()), iB);
                        cVarC2 = cVarC2.a(this.a.b(iA, iC));
                        cVar2 = cVar2.c(cVar.a(iA, iC));
                    }
                    cVarA = cVarC2.b(cVarC).c(cVar5).c();
                } else {
                    throw ChecksumException.f();
                }
            } else {
                int iB2 = cVarC.b(0);
                if (iB2 != 0) {
                    int iB3 = this.a.b(iB2);
                    return new c[]{cVarC.c(iB3), cVar.c(iB3)};
                }
                throw ChecksumException.f();
            }
        }
    }

    private int[] a(c cVar) throws ChecksumException {
        int iA = cVar.a();
        int[] iArr = new int[iA];
        int i2 = 0;
        for (int i3 = 1; i3 < this.a.b() && i2 < iA; i3++) {
            if (cVar.a(i3) == 0) {
                iArr[i2] = this.a.b(i3);
                i2++;
            }
        }
        if (i2 == iA) {
            return iArr;
        }
        throw ChecksumException.f();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int iA = cVar2.a();
        int[] iArr2 = new int[iA];
        for (int i2 = 1; i2 <= iA; i2++) {
            iArr2[iA - i2] = this.a.c(i2, cVar2.b(i2));
        }
        c cVar3 = new c(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int iB = this.a.b(iArr[i3]);
            iArr3[i3] = this.a.c(this.a.d(0, cVar.a(iB)), this.a.b(cVar3.a(iB)));
        }
        return iArr3;
    }
}
