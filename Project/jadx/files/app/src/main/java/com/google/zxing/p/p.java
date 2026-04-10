package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f16251d = {1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f16252e = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[][] f16253f = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[][] f16254g = new int[20][];
    private final StringBuilder a = new StringBuilder(20);
    private final o b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f16255c = new g();

    static {
        System.arraycopy(f16253f, 0, f16254g, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = f16253f[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f16254g[i2] = iArr2;
        }
    }

    protected p() {
    }

    static int[] a(com.google.zxing.common.a aVar) throws NotFoundException {
        int[] iArr = new int[f16251d.length];
        int[] iArrA = null;
        boolean zA = false;
        int i2 = 0;
        while (!zA) {
            Arrays.fill(iArr, 0, f16251d.length, 0);
            iArrA = a(aVar, i2, false, f16251d, iArr);
            int i3 = iArrA[0];
            int i4 = iArrA[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zA = aVar.a(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrA;
    }

    static int b(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.f();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int iCharAt2 = charSequence.charAt(i5) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.f();
            }
            i4 += iCharAt2;
        }
        return (1000 - i4) % 10;
    }

    protected abstract int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    abstract BarcodeFormat a();

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return a(i2, aVar, a(aVar), map);
    }

    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strA;
        com.google.zxing.j jVar = map == null ? null : (com.google.zxing.j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z2 = true;
        if (jVar != null) {
            jVar.a(new com.google.zxing.i((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        if (jVar != null) {
            jVar.a(new com.google.zxing.i(iA, i2));
        }
        int[] iArrA = a(aVar, iA);
        if (jVar != null) {
            jVar.a(new com.google.zxing.i((iArrA[0] + iArrA[1]) / 2.0f, i2));
        }
        int i3 = iArrA[1];
        int i4 = (i3 - iArrA[0]) + i3;
        if (i4 < aVar.c() && aVar.a(i3, i4, false)) {
            String string = sb.toString();
            if (string.length() >= 8) {
                if (a(string)) {
                    BarcodeFormat barcodeFormatA = a();
                    float f2 = i2;
                    com.google.zxing.h hVar = new com.google.zxing.h(string, null, new com.google.zxing.i[]{new com.google.zxing.i((iArr[1] + iArr[0]) / 2.0f, f2), new com.google.zxing.i((iArrA[1] + iArrA[0]) / 2.0f, f2)}, barcodeFormatA);
                    try {
                        com.google.zxing.h hVarA = this.b.a(i2, aVar, iArrA[1]);
                        hVar.a(ResultMetadataType.UPC_EAN_EXTENSION, hVarA.e());
                        hVar.a(hVarA.c());
                        hVar.a(hVarA.d());
                        length = hVarA.e().length();
                    } catch (ReaderException unused) {
                        length = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length2 = iArr2.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length2) {
                                z2 = false;
                                break;
                            }
                            if (length == iArr2[i5]) {
                                break;
                            }
                            i5++;
                        }
                        if (!z2) {
                            throw NotFoundException.f();
                        }
                    }
                    if ((barcodeFormatA == BarcodeFormat.EAN_13 || barcodeFormatA == BarcodeFormat.UPC_A) && (strA = this.f16255c.a(string)) != null) {
                        hVar.a(ResultMetadataType.POSSIBLE_COUNTRY, strA);
                    }
                    return hVar;
                }
                throw ChecksumException.f();
            }
            throw FormatException.f();
        }
        throw NotFoundException.f();
    }

    boolean a(String str) throws FormatException {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return b(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    int[] a(com.google.zxing.common.a aVar, int i2) throws NotFoundException {
        return a(aVar, i2, false, f16251d);
    }

    static int[] a(com.google.zxing.common.a aVar, int i2, boolean z2, int[] iArr) throws NotFoundException {
        return a(aVar, i2, z2, iArr, new int[iArr.length]);
    }

    private static int[] a(com.google.zxing.common.a aVar, int i2, boolean z2, int[] iArr, int[] iArr2) throws NotFoundException {
        int iC = aVar.c();
        int iC2 = z2 ? aVar.c(i2) : aVar.b(i2);
        int length = iArr.length;
        int i3 = iC2;
        int i4 = 0;
        while (iC2 < iC) {
            if (aVar.a(iC2) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.a(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iC2};
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
            iC2++;
        }
        throw NotFoundException.f();
    }

    static int a(com.google.zxing.common.a aVar, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        k.a(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fA = k.a(iArr, iArr2[i4], 0.7f);
            if (fA < f2) {
                i3 = i4;
                f2 = fA;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.f();
    }
}
