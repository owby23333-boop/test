package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends k {
    private static final int[] b = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16245c = {1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f16246d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[][] f16247e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private int[] b(com.google.zxing.common.a aVar) throws NotFoundException {
        int[] iArrC = c(aVar, c(aVar), f16245c);
        this.a = (iArrC[1] - iArrC[0]) / 4;
        a(aVar, iArrC[0]);
        return iArrC;
    }

    private static int c(com.google.zxing.common.a aVar) throws NotFoundException {
        int iC = aVar.c();
        int iB = aVar.b(0);
        if (iB != iC) {
            return iB;
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z2;
        int[] iArrB = b(aVar);
        int[] iArrA = a(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, iArrB[1], iArrA[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z2 = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z2 = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z2 && length > i4) {
            z2 = true;
        }
        if (!z2) {
            throw FormatException.f();
        }
        float f2 = i2;
        return new com.google.zxing.h(string, null, new com.google.zxing.i[]{new com.google.zxing.i(iArrB[1], f2), new com.google.zxing.i(iArrA[0], f2)}, BarcodeFormat.ITF);
    }

    private static int[] c(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iC = aVar.c();
        int i3 = i2;
        boolean z2 = false;
        int i4 = 0;
        while (i2 < iC) {
            if (aVar.a(i2) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.a(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.f();
    }

    private static void a(com.google.zxing.common.a aVar, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            k.a(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private void a(com.google.zxing.common.a aVar, int i2) throws NotFoundException {
        int i3 = this.a * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        for (int i4 = i2 - 1; i3 > 0 && i4 >= 0 && !aVar.a(i4); i4--) {
            i3--;
        }
        if (i3 != 0) {
            throw NotFoundException.f();
        }
    }

    private int[] a(com.google.zxing.common.a aVar) throws NotFoundException {
        int[] iArrC;
        aVar.e();
        try {
            int iC = c(aVar);
            try {
                iArrC = c(aVar, iC, f16246d[0]);
            } catch (NotFoundException unused) {
                iArrC = c(aVar, iC, f16246d[1]);
            }
            a(aVar, iArrC[0]);
            int i2 = iArrC[0];
            iArrC[0] = aVar.c() - iArrC[1];
            iArrC[1] = aVar.c() - i2;
            return iArrC;
        } finally {
            aVar.e();
        }
    }

    private static int a(int[] iArr) throws NotFoundException {
        int length = f16247e.length;
        int i2 = -1;
        float f2 = 0.38f;
        for (int i3 = 0; i3 < length; i3++) {
            float fA = k.a(iArr, f16247e[i3], 0.5f);
            if (fA < f2) {
                i2 = i3;
                f2 = fA;
            } else if (fA == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw NotFoundException.f();
    }
}
