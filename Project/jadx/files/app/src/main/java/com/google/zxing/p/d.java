package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f16239c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f16240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f16241e;
    private final StringBuilder a = new StringBuilder(20);
    private final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, com.anythink.expressad.foundation.g.a.aP, 292, 290, 336, 274, 266, 424, FlowControl.STATUS_FLOW_CTRL_ALL, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, TbsListener.ErrorCode.ERROR_CPU_NOT_SUPPORT, 300, com.anythink.expressad.foundation.g.a.aS, 436, 434, 428, FlowControl.STATUS_FLOW_CTRL_BRUSH, 406, 410, 364, 358, TbsListener.ErrorCode.ERROR_NEW_EXTENSION_INSTANCE_FAILED, TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 350};
        f16240d = iArr;
        f16241e = iArr[47];
    }

    private static String b(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i3 >= length - 1) {
                    throw FormatException.f();
                }
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.f();
                        }
                        i2 = cCharAt2 - '@';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i2 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i2 = cCharAt2 - 11;
                        } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 + 16;
                        } else if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                            i2 = cCharAt2 + '+';
                        } else {
                            if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                throw FormatException.f();
                            }
                            c2 = 127;
                            sb.append(c2);
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.f();
                            }
                            c2 = ':';
                            sb.append(c2);
                        }
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.f();
                        }
                        i2 = cCharAt2 + ' ';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int iB = aVar.b(a(aVar)[1]);
        int iC = aVar.c();
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.a;
        sb.setLength(0);
        while (true) {
            k.a(aVar, iB, iArr);
            int iA = a(iArr);
            if (iA < 0) {
                throw NotFoundException.f();
            }
            char cA = a(iA);
            sb.append(cA);
            int i3 = iB;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int iB2 = aVar.b(i3);
            if (cA == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                if (iB2 == iC || !aVar.a(iB2)) {
                    throw NotFoundException.f();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.f();
                }
                a(sb);
                sb.setLength(sb.length() - 2);
                float f2 = i2;
                return new com.google.zxing.h(b(sb), null, new com.google.zxing.i[]{new com.google.zxing.i((r14[1] + r14[0]) / 2.0f, f2), new com.google.zxing.i(iB + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_93);
            }
            iB = iB2;
        }
    }

    private int[] a(com.google.zxing.common.a aVar) throws NotFoundException {
        int iC = aVar.c();
        int iB = aVar.b(0);
        Arrays.fill(this.b, 0);
        int[] iArr = this.b;
        int length = iArr.length;
        int i2 = iB;
        boolean z2 = false;
        int i3 = 0;
        while (iB < iC) {
            if (aVar.a(iB) != z2) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (a(iArr) == f16241e) {
                        return new int[]{i2, iB};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z2 = !z2;
            }
            iB++;
        }
        throw NotFoundException.f();
    }

    private static int a(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int iRound = Math.round((iArr[i5] * 9.0f) / i2);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                int i6 = i4;
                for (int i7 = 0; i7 < iRound; i7++) {
                    i6 = (i6 << 1) | 1;
                }
                i4 = i6;
            } else {
                i4 <<= iRound;
            }
        }
        return i4;
    }

    private static char a(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f16240d;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f16239c[i3];
                }
                i3++;
            } else {
                throw NotFoundException.f();
            }
        }
    }

    private static void a(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        int iIndexOf = 0;
        int i4 = 1;
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i2) != f16239c[iIndexOf % 47]) {
            throw ChecksumException.f();
        }
    }
}
