package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: EAN13Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f16242i = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f16243h = new int[4];

    @Override // com.google.zxing.p.p
    protected int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f16243h;
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
        int i7 = p.a(aVar, i2, true, p.f16252e)[1];
        int i8 = 0;
        while (i8 < 6 && i7 < iC) {
            sb.append((char) (p.a(aVar, iArr2, i7, p.f16253f) + 48));
            int i9 = i7;
            for (int i10 : iArr2) {
                i9 += i10;
            }
            i8++;
            i7 = i9;
        }
        return i7;
    }

    @Override // com.google.zxing.p.p
    BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f16242i[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw NotFoundException.f();
    }
}
