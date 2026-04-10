package com.google.zxing.p;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: Code128Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends k {
    static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int[] a(com.google.zxing.common.a aVar) throws NotFoundException {
        int iC = aVar.c();
        int iB = aVar.b(0);
        int[] iArr = new int[6];
        int i2 = iB;
        boolean z2 = false;
        int i3 = 0;
        while (iB < iC) {
            if (aVar.a(iB) != z2) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    float f2 = 0.25f;
                    int i4 = -1;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float fA = k.a(iArr, a[i5], 0.7f);
                        if (fA < f2) {
                            i4 = i5;
                            f2 = fA;
                        }
                    }
                    if (i4 >= 0 && aVar.a(Math.max(0, i2 - ((iB - i2) / 2)), i2, false)) {
                        return new int[]{i2, iB, i4};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i6 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i6);
                    iArr[i6] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z2 = !z2;
            }
            iB++;
        }
        throw NotFoundException.f();
    }

    private static int a(com.google.zxing.common.a aVar, int[] iArr, int i2) throws NotFoundException {
        k.a(aVar, i2, iArr);
        float f2 = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fA = k.a(iArr, iArr2[i4], 0.7f);
            if (fA < f2) {
                i3 = i4;
                f2 = fA;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e1, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0133, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0135, code lost:
    
        r5 = false;
        r11 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x00c1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:69:0x010e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013f A[PHI: r19
  0x013f: PHI (r19v9 boolean) = (r19v5 boolean), (r19v17 boolean) binds: [B:69:0x010e, B:44:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0148 A[PHI: r19
  0x0148: PHI (r19v7 boolean) = (r19v5 boolean), (r19v17 boolean) binds: [B:68:0x010c, B:43:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.p.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.h a(int r25, com.google.zxing.common.a r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p.b.a(int, com.google.zxing.common.a, java.util.Map):com.google.zxing.h");
    }
}
