package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: UPCEReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f16256i = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int[][] f16257j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f16258h = new int[4];

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    @Override // com.google.zxing.p.p
    protected int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f16258h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < iC) {
            int iA = p.a(aVar, iArr2, i2, p.f16254g);
            sb.append((char) ((iA % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (iA >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        a(sb, i4);
        return i2;
    }

    @Override // com.google.zxing.p.p
    protected int[] a(com.google.zxing.common.a aVar, int i2) throws NotFoundException {
        return p.a(aVar, i2, true, f16256i);
    }

    @Override // com.google.zxing.p.p
    protected boolean a(String str) throws FormatException {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f16257j[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.p.p
    BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }
}
