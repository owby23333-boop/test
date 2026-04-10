package com.google.zxing.l.c;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.common.h;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.i;
import com.tencent.smtt.utils.TbsLog;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f16214g = {3808, 476, 2107, 1799};
    private final b a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16218f;

    /* JADX INFO: renamed from: com.google.zxing.l.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Detector.java */
    static final class C0335a {
        private final int a;
        private final int b;

        C0335a(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        i c() {
            return new i(a(), b());
        }

        public String toString() {
            return "<" + this.a + ' ' + this.b + '>';
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    private C0335a b() {
        i iVarC;
        i iVar;
        i iVar2;
        i iVar3;
        i iVarC2;
        i iVarC3;
        i iVarC4;
        i iVarC5;
        try {
            i[] iVarArrA = new com.google.zxing.common.l.b(this.a).a();
            iVar2 = iVarArrA[0];
            iVar3 = iVarArrA[1];
            iVar = iVarArrA[2];
            iVarC = iVarArrA[3];
        } catch (NotFoundException unused) {
            int iE = this.a.e() / 2;
            int iC = this.a.c() / 2;
            int i2 = iE + 7;
            int i3 = iC - 7;
            i iVarC6 = a(new C0335a(i2, i3), false, 1, -1).c();
            int i4 = iC + 7;
            i iVarC7 = a(new C0335a(i2, i4), false, 1, 1).c();
            int i5 = iE - 7;
            i iVarC8 = a(new C0335a(i5, i4), false, -1, 1).c();
            iVarC = a(new C0335a(i5, i3), false, -1, -1).c();
            iVar = iVarC8;
            iVar2 = iVarC6;
            iVar3 = iVarC7;
        }
        int iA = com.google.zxing.common.l.a.a((((iVar2.a() + iVarC.a()) + iVar3.a()) + iVar.a()) / 4.0f);
        int iA2 = com.google.zxing.common.l.a.a((((iVar2.b() + iVarC.b()) + iVar3.b()) + iVar.b()) / 4.0f);
        try {
            i[] iVarArrA2 = new com.google.zxing.common.l.b(this.a, 15, iA, iA2).a();
            iVarC2 = iVarArrA2[0];
            iVarC3 = iVarArrA2[1];
            iVarC4 = iVarArrA2[2];
            iVarC5 = iVarArrA2[3];
        } catch (NotFoundException unused2) {
            int i6 = iA + 7;
            int i7 = iA2 - 7;
            iVarC2 = a(new C0335a(i6, i7), false, 1, -1).c();
            int i8 = iA2 + 7;
            iVarC3 = a(new C0335a(i6, i8), false, 1, 1).c();
            int i9 = iA - 7;
            iVarC4 = a(new C0335a(i9, i8), false, -1, 1).c();
            iVarC5 = a(new C0335a(i9, i7), false, -1, -1).c();
        }
        return new C0335a(com.google.zxing.common.l.a.a((((iVarC2.a() + iVarC5.a()) + iVarC3.a()) + iVarC4.a()) / 4.0f), com.google.zxing.common.l.a.a((((iVarC2.b() + iVarC5.b()) + iVarC3.b()) + iVarC4.b()) / 4.0f));
    }

    public com.google.zxing.l.a a(boolean z2) throws NotFoundException {
        i[] iVarArrA = a(b());
        if (z2) {
            i iVar = iVarArrA[0];
            iVarArrA[0] = iVarArrA[2];
            iVarArrA[2] = iVar;
        }
        a(iVarArrA);
        b bVar = this.a;
        int i2 = this.f16218f;
        return new com.google.zxing.l.a(a(bVar, iVarArrA[i2 % 4], iVarArrA[(i2 + 1) % 4], iVarArrA[(i2 + 2) % 4], iVarArrA[(i2 + 3) % 4]), b(iVarArrA), this.b, this.f16216d, this.f16215c);
    }

    private void a(i[] iVarArr) throws NotFoundException {
        long j2;
        long j3;
        if (a(iVarArr[0]) && a(iVarArr[1]) && a(iVarArr[2]) && a(iVarArr[3])) {
            int i2 = this.f16217e * 2;
            int[] iArr = {a(iVarArr[0], iVarArr[1], i2), a(iVarArr[1], iVarArr[2], i2), a(iVarArr[2], iVarArr[3], i2), a(iVarArr[3], iVarArr[0], i2)};
            this.f16218f = a(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f16218f + i3) % 4];
                if (this.b) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int iA = a(j4, this.b);
            if (this.b) {
                this.f16215c = (iA >> 6) + 1;
                this.f16216d = (iA & 63) + 1;
                return;
            } else {
                this.f16215c = (iA >> 11) + 1;
                this.f16216d = (iA & 2047) + 1;
                return;
            }
        }
        throw NotFoundException.f();
    }

    private i[] b(i[] iVarArr) {
        return a(iVarArr, this.f16217e * 2, a());
    }

    private int b(C0335a c0335a, C0335a c0335a2) {
        float fA = a(c0335a, c0335a2);
        float fA2 = (c0335a2.a() - c0335a.a()) / fA;
        float fB = (c0335a2.b() - c0335a.b()) / fA;
        float fA3 = c0335a.a();
        float fB2 = c0335a.b();
        boolean zB = this.a.b(c0335a.a(), c0335a.b());
        int iCeil = (int) Math.ceil(fA);
        float f2 = fA3;
        float f3 = fB2;
        int i2 = 0;
        for (int i3 = 0; i3 < iCeil; i3++) {
            f2 += fA2;
            f3 += fB;
            if (this.a.b(com.google.zxing.common.l.a.a(f2), com.google.zxing.common.l.a.a(f3)) != zB) {
                i2++;
            }
        }
        float f4 = i2 / fA;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return (f4 <= 0.1f) == zB ? 1 : -1;
        }
        return 0;
    }

    private static int a(int[] iArr, int i2) throws NotFoundException {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f16214g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw NotFoundException.f();
    }

    private static int a(long j2, boolean z2) throws NotFoundException {
        int i2;
        int i3;
        if (z2) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(com.google.zxing.common.reedsolomon.a.f16174k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.f();
        }
    }

    private i[] a(C0335a c0335a) throws NotFoundException {
        this.f16217e = 1;
        C0335a c0335a2 = c0335a;
        C0335a c0335a3 = c0335a2;
        C0335a c0335a4 = c0335a3;
        C0335a c0335a5 = c0335a4;
        boolean z2 = true;
        while (this.f16217e < 9) {
            C0335a c0335aA = a(c0335a2, z2, 1, -1);
            C0335a c0335aA2 = a(c0335a3, z2, 1, 1);
            C0335a c0335aA3 = a(c0335a4, z2, -1, 1);
            C0335a c0335aA4 = a(c0335a5, z2, -1, -1);
            if (this.f16217e > 2) {
                double dA = (a(c0335aA4, c0335aA) * this.f16217e) / (a(c0335a5, c0335a2) * (this.f16217e + 2));
                if (dA < 0.75d || dA > 1.25d || !a(c0335aA, c0335aA2, c0335aA3, c0335aA4)) {
                    break;
                }
            }
            z2 = !z2;
            this.f16217e++;
            c0335a5 = c0335aA4;
            c0335a2 = c0335aA;
            c0335a3 = c0335aA2;
            c0335a4 = c0335aA3;
        }
        int i2 = this.f16217e;
        if (i2 != 5 && i2 != 7) {
            throw NotFoundException.f();
        }
        this.b = this.f16217e == 5;
        i[] iVarArr = {new i(c0335a2.a() + 0.5f, c0335a2.b() - 0.5f), new i(c0335a3.a() + 0.5f, c0335a3.b() + 0.5f), new i(c0335a4.a() - 0.5f, c0335a4.b() + 0.5f), new i(c0335a5.a() - 0.5f, c0335a5.b() - 0.5f)};
        int i3 = this.f16217e;
        return a(iVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private b a(b bVar, i iVar, i iVar2, i iVar3, i iVar4) throws NotFoundException {
        h hVarA = h.a();
        int iA = a();
        float f2 = iA / 2.0f;
        int i2 = this.f16217e;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return hVarA.a(bVar, iA, iA, f3, f3, f4, f3, f4, f4, f3, f4, iVar.a(), iVar.b(), iVar2.a(), iVar2.b(), iVar3.a(), iVar3.b(), iVar4.a(), iVar4.b());
    }

    private int a(i iVar, i iVar2, int i2) {
        float fA = a(iVar, iVar2);
        float f2 = fA / i2;
        float fA2 = iVar.a();
        float fB = iVar.b();
        float fA3 = ((iVar2.a() - iVar.a()) * f2) / fA;
        float fB2 = (f2 * (iVar2.b() - iVar.b())) / fA;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.a.b(com.google.zxing.common.l.a.a((f3 * fA3) + fA2), com.google.zxing.common.l.a.a((f3 * fB2) + fB))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean a(C0335a c0335a, C0335a c0335a2, C0335a c0335a3, C0335a c0335a4) {
        C0335a c0335a5 = new C0335a(c0335a.a() - 3, c0335a.b() + 3);
        C0335a c0335a6 = new C0335a(c0335a2.a() - 3, c0335a2.b() - 3);
        C0335a c0335a7 = new C0335a(c0335a3.a() + 3, c0335a3.b() - 3);
        C0335a c0335a8 = new C0335a(c0335a4.a() + 3, c0335a4.b() + 3);
        int iB = b(c0335a8, c0335a5);
        return iB != 0 && b(c0335a5, c0335a6) == iB && b(c0335a6, c0335a7) == iB && b(c0335a7, c0335a8) == iB;
    }

    private C0335a a(C0335a c0335a, boolean z2, int i2, int i3) {
        int iA = c0335a.a() + i2;
        int iB = c0335a.b();
        while (true) {
            iB += i3;
            if (!a(iA, iB) || this.a.b(iA, iB) != z2) {
                break;
            }
            iA += i2;
        }
        int i4 = iA - i2;
        int i5 = iB - i3;
        while (a(i4, i5) && this.a.b(i4, i5) == z2) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (a(i6, i5) && this.a.b(i6, i5) == z2) {
            i5 += i3;
        }
        return new C0335a(i6, i5 - i3);
    }

    private static i[] a(i[] iVarArr, int i2, int i3) {
        float f2 = i3 / (i2 * 2.0f);
        float fA = iVarArr[0].a() - iVarArr[2].a();
        float fB = iVarArr[0].b() - iVarArr[2].b();
        float fA2 = (iVarArr[0].a() + iVarArr[2].a()) / 2.0f;
        float fB2 = (iVarArr[0].b() + iVarArr[2].b()) / 2.0f;
        float f3 = fA * f2;
        float f4 = fB * f2;
        i iVar = new i(fA2 + f3, fB2 + f4);
        i iVar2 = new i(fA2 - f3, fB2 - f4);
        float fA3 = iVarArr[1].a() - iVarArr[3].a();
        float fB3 = iVarArr[1].b() - iVarArr[3].b();
        float fA4 = (iVarArr[1].a() + iVarArr[3].a()) / 2.0f;
        float fB4 = (iVarArr[1].b() + iVarArr[3].b()) / 2.0f;
        float f5 = fA3 * f2;
        float f6 = f2 * fB3;
        return new i[]{iVar, new i(fA4 + f5, fB4 + f6), iVar2, new i(fA4 - f5, fB4 - f6)};
    }

    private boolean a(int i2, int i3) {
        return i2 >= 0 && i2 < this.a.e() && i3 > 0 && i3 < this.a.c();
    }

    private boolean a(i iVar) {
        return a(com.google.zxing.common.l.a.a(iVar.a()), com.google.zxing.common.l.a.a(iVar.b()));
    }

    private static float a(C0335a c0335a, C0335a c0335a2) {
        return com.google.zxing.common.l.a.a(c0335a.a(), c0335a.b(), c0335a2.a(), c0335a2.b());
    }

    private static float a(i iVar, i iVar2) {
        return com.google.zxing.common.l.a.a(iVar.a(), iVar.b(), iVar2.a(), iVar2.b());
    }

    private int a() {
        if (this.b) {
            return (this.f16215c * 4) + 11;
        }
        int i2 = this.f16215c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }
}
