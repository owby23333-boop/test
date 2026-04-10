package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANExtension2Support.java */
/* JADX INFO: loaded from: classes2.dex */
final class m {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    m() {
    }

    com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapA = a(string);
        float f2 = i2;
        com.google.zxing.h hVar = new com.google.zxing.h(string, null, new com.google.zxing.i[]{new com.google.zxing.i((iArr[0] + iArr[1]) / 2.0f, f2), new com.google.zxing.i(iA, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapA != null) {
            hVar.a(mapA);
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
        while (i2 < 2 && iC2 < iC) {
            int iA = p.a(aVar, iArr2, iC2, p.f16254g);
            sb.append((char) ((iA % 10) + 48));
            int i4 = iC2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            iC2 = i2 != 1 ? aVar.c(aVar.b(i4)) : i4;
            i2++;
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i3) {
                return iC2;
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }

    private static Map<ResultMetadataType, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
