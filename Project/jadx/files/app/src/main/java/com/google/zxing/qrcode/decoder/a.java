package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    private final com.google.zxing.common.b a;
    private g b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f16341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16342d;

    a(com.google.zxing.common.b bVar) throws FormatException {
        int iC = bVar.c();
        if (iC < 21 || (iC & 3) != 1) {
            throw FormatException.f();
        }
        this.a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.f16342d ? this.a.b(i3, i2) : this.a.b(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    byte[] b() throws FormatException {
        e eVarC = c();
        g gVarD = d();
        DataMask dataMask = DataMask.values()[eVarC.a()];
        int iC = this.a.c();
        dataMask.a(this.a, iC);
        com.google.zxing.common.b bVarA = gVarD.a();
        byte[] bArr = new byte[gVarD.d()];
        int i2 = iC - 1;
        int i3 = i2;
        int i4 = 0;
        boolean z2 = true;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            int i7 = i6;
            int i8 = i5;
            int i9 = i4;
            int i10 = 0;
            while (i10 < iC) {
                int i11 = z2 ? i2 - i10 : i10;
                int i12 = i7;
                int i13 = i8;
                int i14 = i9;
                for (int i15 = 0; i15 < 2; i15++) {
                    int i16 = i3 - i15;
                    if (!bVarA.b(i16, i11)) {
                        i13++;
                        int i17 = i12 << 1;
                        int i18 = this.a.b(i16, i11) ? i17 | 1 : i17;
                        if (i13 == 8) {
                            bArr[i14] = (byte) i18;
                            i14++;
                            i13 = 0;
                            i12 = 0;
                        } else {
                            i12 = i18;
                        }
                    }
                }
                i10++;
                i9 = i14;
                i8 = i13;
                i7 = i12;
            }
            z2 = !z2;
            i3 -= 2;
            i4 = i9;
            i5 = i8;
            i6 = i7;
        }
        if (i4 == gVarD.d()) {
            return bArr;
        }
        throw FormatException.f();
    }

    e c() throws FormatException {
        e eVar = this.f16341c;
        if (eVar != null) {
            return eVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int iC = this.a.c();
        int i4 = iC - 7;
        for (int i5 = iC - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = iC - 8; i6 < iC; i6++) {
            iA = a(i6, 8, iA);
        }
        this.f16341c = e.a(iA3, iA);
        e eVar2 = this.f16341c;
        if (eVar2 != null) {
            return eVar2;
        }
        throw FormatException.f();
    }

    g d() throws FormatException {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        int iC = this.a.c();
        int i2 = (iC - 17) / 4;
        if (i2 <= 6) {
            return g.c(i2);
        }
        int i3 = iC - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = iC - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        g gVarA = g.a(iA2);
        if (gVarA != null && gVarA.c() == iC) {
            this.b = gVarA;
            return gVarA;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = iC - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        g gVarA2 = g.a(iA);
        if (gVarA2 == null || gVarA2.c() != iC) {
            throw FormatException.f();
        }
        this.b = gVarA2;
        return gVarA2;
    }

    void e() {
        if (this.f16341c == null) {
            return;
        }
        DataMask.values()[this.f16341c.a()].a(this.a, this.a.c());
    }

    void a(boolean z2) {
        this.b = null;
        this.f16341c = null;
        this.f16342d = z2;
    }

    void a() {
        int i2 = 0;
        while (i2 < this.a.e()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.a.c(); i4++) {
                if (this.a.b(i2, i4) != this.a.b(i4, i2)) {
                    this.a.a(i4, i2);
                    this.a.a(i2, i4);
                }
            }
            i2 = i3;
        }
    }
}
