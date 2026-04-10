package com.google.zxing.p;

import com.anythink.expressad.foundation.h.m;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f16236e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 19, 274, 82, 7, 262, 70, 22, 385, 193, m.a.a, 145, TbsListener.ErrorCode.INFO_CODE_BASE, 208, 133, 388, 196, 168, 162, 138, 42};
    private final boolean a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f16237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f16238d;

    public c() {
        this(false);
    }

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f16238d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f16237c;
        sb.setLength(0);
        int iB = aVar.b(a(aVar, iArr)[1]);
        int iC = aVar.c();
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
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (iB2 - iB) - i5;
                if (iB2 != iC && (i7 << 1) < i5) {
                    throw NotFoundException.f();
                }
                if (this.a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f16237c.charAt(i8));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw ChecksumException.f();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.f();
                }
                float f2 = i2;
                return new com.google.zxing.h(this.b ? a(sb) : sb.toString(), null, new com.google.zxing.i[]{new com.google.zxing.i((r2[1] + r2[0]) / 2.0f, f2), new com.google.zxing.i(iB + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_39);
            }
            iB = iB2;
        }
    }

    public c(boolean z2) {
        this(z2, false);
    }

    public c(boolean z2, boolean z3) {
        this.a = z2;
        this.b = z3;
        this.f16237c = new StringBuilder(20);
        this.f16238d = new int[9];
    }

    private static int[] a(com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        int iC = aVar.c();
        int iB = aVar.b(0);
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
                    if (a(iArr) == 148 && aVar.a(Math.max(0, i2 - ((iB - i2) / 2)), i2, false)) {
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
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    private static char a(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f16236e;
            if (i3 >= iArr.length) {
                if (i2 == 148) {
                    return '*';
                }
                throw NotFoundException.f();
            }
            if (iArr[i3] == i2) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i3);
            }
            i3++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.CharSequence r12) throws com.google.zxing.FormatException {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        Lb:
            if (r3 >= r0) goto Lbe
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb5
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lab
            r7 = 79
            if (r4 == r6) goto L5d
            if (r4 == r8) goto L51
            if (r4 == r5) goto L3e
        L3b:
            r4 = 0
            goto Lb2
        L3e:
            if (r9 < r11) goto L46
            if (r9 > r7) goto L46
            int r9 = r9 + (-32)
            goto Lb1
        L46:
            if (r9 != r10) goto L4c
            r4 = 58
            goto Lb2
        L4c:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.f()
            throw r12
        L51:
            if (r9 < r11) goto L58
            if (r9 > r10) goto L58
            int r9 = r9 + 32
            goto Lb1
        L58:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.f()
            throw r12
        L5d:
            if (r9 < r11) goto L66
            r4 = 69
            if (r9 > r4) goto L66
            int r9 = r9 + (-38)
            goto Lb1
        L66:
            r4 = 70
            if (r9 < r4) goto L71
            r4 = 74
            if (r9 > r4) goto L71
            int r9 = r9 + (-11)
            goto Lb1
        L71:
            r4 = 75
            if (r9 < r4) goto L7a
            if (r9 > r7) goto L7a
            int r9 = r9 + 16
            goto Lb1
        L7a:
            r4 = 80
            if (r9 < r4) goto L85
            r4 = 84
            if (r9 > r4) goto L85
            int r9 = r9 + 43
            goto Lb1
        L85:
            r4 = 85
            if (r9 != r4) goto L8a
            goto L3b
        L8a:
            r4 = 86
            if (r9 != r4) goto L91
            r4 = 64
            goto Lb2
        L91:
            r4 = 87
            if (r9 != r4) goto L98
            r4 = 96
            goto Lb2
        L98:
            r4 = 88
            if (r9 == r4) goto La8
            r4 = 89
            if (r9 == r4) goto La8
            if (r9 != r10) goto La3
            goto La8
        La3:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.f()
            throw r12
        La8:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb2
        Lab:
            if (r9 < r11) goto Lb9
            if (r9 > r10) goto Lb9
            int r9 = r9 + (-64)
        Lb1:
            char r4 = (char) r9
        Lb2:
            r1.append(r4)
        Lb5:
            int r3 = r3 + 1
            goto Lb
        Lb9:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.f()
            throw r12
        Lbe:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p.c.a(java.lang.CharSequence):java.lang.String");
    }
}
