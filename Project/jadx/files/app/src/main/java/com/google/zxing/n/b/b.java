package com.google.zxing.n.b;

import com.google.zxing.common.d;
import com.umeng.analytics.pro.cb;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    private static final String[] a = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    static d a(byte[] bArr, int i2) {
        String strD;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                strD = new DecimalFormat("0000000000".substring(0, c(bArr))).format(b(bArr));
            } else {
                strD = d(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(a(bArr));
            String str2 = decimalFormat.format(e(bArr));
            sb.append(a(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strD + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb.insert(0, strD + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i2 == 4) {
            sb.append(a(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(a(bArr, 1, 77));
        }
        return new d(bArr, sb.toString(), null, String.valueOf(i2));
    }

    private static int b(byte[] bArr) {
        return a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, cb.f19602k, cb.f19603l, cb.f19604m, cb.f19605n, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static int c(byte[] bArr) {
        return a(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static String d(byte[] bArr) {
        return String.valueOf(new char[]{a[0].charAt(a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), a[0].charAt(a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), a[0].charAt(a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), a[0].charAt(a(bArr, new byte[]{21, 22, 23, 24, cb.f19602k, cb.f19603l})), a[0].charAt(a(bArr, new byte[]{cb.f19604m, cb.f19605n, 17, 18, 7, 8})), a[0].charAt(a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    private static int e(byte[] bArr) {
        return a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int a(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int iA = 0;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                iA += a(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
            }
            return iA;
        }
        throw new IllegalArgumentException();
    }

    private static int a(byte[] bArr) {
        return a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char cCharAt = a[i5].charAt(bArr[i4]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i5;
                    i5 = cCharAt - 65520;
                    i6 = 1;
                    break;
                case 65525:
                    i6 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i6 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i5 = 0;
                    i6 = -1;
                    break;
                case 65528:
                    i5 = 1;
                    i6 = -1;
                    break;
                case 65529:
                    i6 = -1;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << 24;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << 18);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(new DecimalFormat("000000000").format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i6 - 1;
            if (i6 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
