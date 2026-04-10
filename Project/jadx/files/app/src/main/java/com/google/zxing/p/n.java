package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANExtension5Support.java */
/* JADX INFO: loaded from: classes2.dex */
final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16249c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    n() {
    }

    private static Map<ResultMetadataType, Object> b(String str) {
        String strA;
        if (str.length() != 5 || (strA = a(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, strA);
        return enumMap;
    }

    com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapB = b(string);
        float f2 = i2;
        com.google.zxing.h hVar = new com.google.zxing.h(string, null, new com.google.zxing.i[]{new com.google.zxing.i((iArr[0] + iArr[1]) / 2.0f, f2), new com.google.zxing.i(iA, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapB != null) {
            hVar.a(mapB);
        }
        return hVar;
    }

    private int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int iC2 = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && iC2 < iC) {
            int iA = p.a(aVar, iArr2, iC2, p.f16254g);
            sb.append((char) ((iA % 10) + 48));
            int i4 = iC2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA >= 10) {
                i3 |= 1 << (4 - i2);
            }
            iC2 = i2 != 4 ? aVar.c(aVar.b(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i3)) {
                return iC2;
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            iCharAt += charSequence.charAt(i2) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            iCharAt2 += charSequence.charAt(i3) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static int a(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f16249c[i3]) {
                return i3;
            }
        }
        throw NotFoundException.f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            char r1 = r6.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L4f
            r2 = 53
            if (r1 == r2) goto L4c
            r2 = 57
            if (r1 == r2) goto L15
            goto L51
        L15:
            r1 = -1
            int r2 = r6.hashCode()
            r5 = 2
            switch(r2) {
                case 54118329: goto L33;
                case 54395376: goto L29;
                case 54395377: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L3c
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L3c
            r0 = 1
            goto L3d
        L29:
            java.lang.String r0 = "99990"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L3c
            r0 = 2
            goto L3d
        L33:
            java.lang.String r2 = "90000"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L3c
            goto L3d
        L3c:
            r0 = -1
        L3d:
            if (r0 == 0) goto L4a
            if (r0 == r4) goto L47
            if (r0 == r5) goto L44
            goto L51
        L44:
            java.lang.String r6 = "Used"
            return r6
        L47:
            java.lang.String r6 = "0.00"
            return r6
        L4a:
            r6 = 0
            return r6
        L4c:
            java.lang.String r3 = "$"
            goto L51
        L4f:
            java.lang.String r3 = "£"
        L51:
            java.lang.String r6 = r6.substring(r4)
            int r6 = java.lang.Integer.parseInt(r6)
            int r0 = r6 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r6 = r6 % 100
            r1 = 10
            if (r6 >= r1) goto L70
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "0"
            java.lang.String r6 = r1.concat(r6)
            goto L74
        L70:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L74:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p.n.a(java.lang.String):java.lang.String");
    }
}
