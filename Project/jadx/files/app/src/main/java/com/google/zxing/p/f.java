package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: EAN8Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f16244h = new int[4];

    @Override // com.google.zxing.p.p
    protected int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f16244h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        while (i3 < 4 && i2 < iC) {
            sb.append((char) (p.a(aVar, iArr2, i2, p.f16253f) + 48));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = p.a(aVar, i2, true, p.f16252e)[1];
        int i7 = 0;
        while (i7 < 4 && i6 < iC) {
            sb.append((char) (p.a(aVar, iArr2, i6, p.f16253f) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    @Override // com.google.zxing.p.p
    BarcodeFormat a() {
        return BarcodeFormat.EAN_8;
    }
}
