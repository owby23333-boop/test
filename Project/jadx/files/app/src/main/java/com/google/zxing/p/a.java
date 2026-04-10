package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final char[] f16232d = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f16233e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f16234f = {'A', 'B', 'C', 'D'};
    private final StringBuilder a = new StringBuilder(20);
    private int[] b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16235c = 0;

    private int b(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f16235c) {
            return -1;
        }
        int[] iArr = this.b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f16233e;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    private void c(int i2) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.a.length() - 1;
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            int i6 = f16233e[this.a.charAt(i5)];
            for (int i7 = 6; i7 >= 0; i7--) {
                int i8 = (i7 & 1) + ((i6 & 1) << 1);
                iArr[i8] = iArr[i8] + this.b[i4 + i7];
                iArr2[i8] = iArr2[i8] + 1;
                i6 >>= 1;
            }
            if (i5 >= length) {
                break;
            }
            i4 += 8;
            i5++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i9 = 0; i9 < 2; i9++) {
            fArr2[i9] = 0.0f;
            int i10 = i9 + 2;
            fArr2[i10] = ((iArr[i9] / iArr2[i9]) + (iArr[i10] / iArr2[i10])) / 2.0f;
            fArr[i9] = fArr2[i10];
            fArr[i10] = ((iArr[i10] * 2.0f) + 1.5f) / iArr2[i10];
        }
        loop3: while (true) {
            int i11 = f16233e[this.a.charAt(i3)];
            for (int i12 = 6; i12 >= 0; i12--) {
                int i13 = (i12 & 1) + ((i11 & 1) << 1);
                float f2 = this.b[i2 + i12];
                if (f2 < fArr2[i13] || f2 > fArr[i13]) {
                    break loop3;
                }
                i11 >>= 1;
            }
            if (i3 >= length) {
                return;
            }
            i2 += 8;
            i3++;
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.b, 0);
        a(aVar);
        int iA = a();
        this.a.setLength(0);
        int i3 = iA;
        do {
            int iB = b(i3);
            if (iB == -1) {
                throw NotFoundException.f();
            }
            this.a.append((char) iB);
            i3 += 8;
            if (this.a.length() > 1 && a(f16234f, f16232d[iB])) {
                break;
            }
        } while (i3 < this.f16235c);
        int i4 = i3 - 1;
        int i5 = this.b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.b[i3 + i7];
        }
        if (i3 < this.f16235c && i5 < i6 / 2) {
            throw NotFoundException.f();
        }
        c(iA);
        for (int i8 = 0; i8 < this.a.length(); i8++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i8, f16232d[sb.charAt(i8)]);
        }
        if (!a(f16234f, this.a.charAt(0))) {
            throw NotFoundException.f();
        }
        StringBuilder sb2 = this.a;
        if (!a(f16234f, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.f();
        }
        if (this.a.length() <= 3) {
            throw NotFoundException.f();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iA; i10++) {
            i9 += this.b[i10];
        }
        float f2 = i9;
        while (iA < i4) {
            i9 += this.b[iA];
            iA++;
        }
        float f3 = i2;
        return new com.google.zxing.h(this.a.toString(), null, new com.google.zxing.i[]{new com.google.zxing.i(f2, f3), new com.google.zxing.i(i9, f3)}, BarcodeFormat.CODABAR);
    }

    private void a(com.google.zxing.common.a aVar) throws NotFoundException {
        int i2 = 0;
        this.f16235c = 0;
        int iC = aVar.c(0);
        int iC2 = aVar.c();
        if (iC < iC2) {
            boolean z2 = true;
            while (iC < iC2) {
                if (aVar.a(iC) != z2) {
                    i2++;
                } else {
                    a(i2);
                    z2 = !z2;
                    i2 = 1;
                }
                iC++;
            }
            a(i2);
            return;
        }
        throw NotFoundException.f();
    }

    private void a(int i2) {
        int[] iArr = this.b;
        int i3 = this.f16235c;
        iArr[i3] = i2;
        this.f16235c = i3 + 1;
        int i4 = this.f16235c;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.b = iArr2;
        }
    }

    private int a() throws NotFoundException {
        for (int i2 = 1; i2 < this.f16235c; i2 += 2) {
            int iB = b(i2);
            if (iB != -1 && a(f16234f, f16232d[iB])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.b[i4];
                }
                if (i2 == 1 || this.b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw NotFoundException.f();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
