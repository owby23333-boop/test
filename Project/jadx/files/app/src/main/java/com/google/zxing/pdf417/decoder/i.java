package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: PDF417ScanningDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private static final com.google.zxing.pdf417.decoder.j.a a = new com.google.zxing.pdf417.decoder.j.a();

    public static com.google.zxing.common.d a(com.google.zxing.common.b bVar, com.google.zxing.i iVar, com.google.zxing.i iVar2, com.google.zxing.i iVar3, com.google.zxing.i iVar4, int i2, int i3) throws NotFoundException, ChecksumException, FormatException {
        g gVar;
        int i4;
        int i5;
        int i6;
        g gVarA = null;
        e eVarB = null;
        g gVarA2 = null;
        c cVar = new c(bVar, iVar, iVar2, iVar3, iVar4);
        int i7 = 0;
        while (i7 < 2) {
            if (iVar != null) {
                gVarA = a(bVar, cVar, iVar, true, i2, i3);
            }
            gVar = gVarA;
            if (iVar3 != null) {
                gVarA2 = a(bVar, cVar, iVar3, false, i2, i3);
            }
            eVarB = b(gVar, gVarA2);
            if (eVarB == null) {
                throw NotFoundException.f();
            }
            if (i7 != 0 || eVarB.d() == null || (eVarB.d().f() >= cVar.f() && eVarB.d().d() <= cVar.d())) {
                eVarB.a(cVar);
                break;
            }
            cVar = eVarB.d();
            i7++;
            gVarA = gVar;
        }
        gVar = gVarA;
        int iA = eVarB.a() + 1;
        eVarB.a(0, gVar);
        eVarB.a(iA, gVarA2);
        boolean z2 = gVar != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= iA; i10++) {
            int i11 = z2 ? i10 : iA - i10;
            if (eVarB.a(i11) == null) {
                f gVar2 = (i11 == 0 || i11 == iA) ? new g(cVar, i11 == 0) : new f(cVar);
                eVarB.a(i11, gVar2);
                int i12 = -1;
                int iMax = i9;
                int i13 = -1;
                int iMin = i8;
                int iF = cVar.f();
                while (iF <= cVar.d()) {
                    int iA2 = a(eVarB, i11, iF, z2);
                    if (iA2 >= 0 && iA2 <= cVar.c()) {
                        i6 = iA2;
                    } else if (i13 != i12) {
                        i6 = i13;
                    } else {
                        i4 = i13;
                        i5 = iMax;
                        iMax = i5;
                        i13 = i4;
                        iF++;
                        i12 = -1;
                    }
                    i4 = i13;
                    int i14 = iMax;
                    d dVarA = a(bVar, cVar.e(), cVar.c(), z2, i6, iF, iMin, i14);
                    if (dVarA != null) {
                        gVar2.a(iF, dVarA);
                        iMin = Math.min(iMin, dVarA.f());
                        iMax = Math.max(i14, dVarA.f());
                        i13 = i6;
                        iF++;
                        i12 = -1;
                    } else {
                        i5 = i14;
                        iMax = i5;
                        i13 = i4;
                        iF++;
                        i12 = -1;
                    }
                }
                i8 = iMin;
                i9 = iMax;
            }
        }
        return b(eVarB);
    }

    private static boolean a(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static e b(g gVar, g gVar2) throws NotFoundException {
        a aVarA;
        if ((gVar == null && gVar2 == null) || (aVarA = a(gVar, gVar2)) == null) {
            return null;
        }
        return new e(aVarA, c.a(a(gVar), a(gVar2)));
    }

    private static int c(int i2) {
        return 2 << i2;
    }

    private static int b(int[] iArr) {
        int iMax = -1;
        for (int i2 : iArr) {
            iMax = Math.max(iMax, i2);
        }
        return iMax;
    }

    private static com.google.zxing.common.d b(e eVar) throws NotFoundException, ChecksumException, FormatException {
        b[][] bVarArrA = a(eVar);
        a(eVar, bVarArrA);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.c() * eVar.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < eVar.c(); i2++) {
            int i3 = 0;
            while (i3 < eVar.a()) {
                int i4 = i3 + 1;
                int[] iArrA = bVarArrA[i2][i4].a();
                int iA = (eVar.a() * i2) + i3;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iA));
                } else if (iArrA.length == 1) {
                    iArr[iA] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iA));
                    arrayList2.add(iArrA);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return a(eVar.b(), iArr, com.google.zxing.q.a.a(arrayList), com.google.zxing.q.a.a(arrayList3), iArr2);
    }

    private static c a(g gVar) throws NotFoundException {
        int[] iArrD;
        if (gVar == null || (iArrD = gVar.d()) == null) {
            return null;
        }
        int iB = b(iArrD);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArrD) {
            i3 += iB - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] dVarArrB = gVar.b();
        for (int i5 = 0; i3 > 0 && dVarArrB[i5] == null; i5++) {
            i3--;
        }
        for (int length = iArrD.length - 1; length >= 0; length--) {
            i2 += iB - iArrD[length];
            if (iArrD[length] > 0) {
                break;
            }
        }
        for (int length2 = dVarArrB.length - 1; i2 > 0 && dVarArrB[length2] == null; length2--) {
            i2--;
        }
        return gVar.a().a(i3, i2, gVar.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] b(com.google.zxing.common.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.b(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.b(com.google.zxing.common.b, int, int, boolean, int, int):int[]");
    }

    private static int b(int i2) {
        return a(a(i2));
    }

    private static a a(g gVar, g gVar2) {
        a aVarC;
        a aVarC2;
        if (gVar == null || (aVarC = gVar.c()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.c();
        }
        if (gVar2 == null || (aVarC2 = gVar2.c()) == null || aVarC.a() == aVarC2.a() || aVarC.b() == aVarC2.b() || aVarC.c() == aVarC2.c()) {
            return aVarC;
        }
        return null;
    }

    private static g a(com.google.zxing.common.b bVar, c cVar, com.google.zxing.i iVar, boolean z2, int i2, int i3) {
        g gVar = new g(cVar, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int iA = (int) iVar.a();
            for (int iB = (int) iVar.b(); iB <= cVar.d() && iB >= cVar.f(); iB += i5) {
                d dVarA = a(bVar, 0, bVar.e(), z2, iA, iB, i2, i3);
                if (dVarA != null) {
                    gVar.a(iB, dVarA);
                    if (z2) {
                        iA = dVarA.d();
                    } else {
                        iA = dVarA.b();
                    }
                }
            }
            i4++;
        }
        return gVar;
    }

    private static void a(e eVar, b[][] bVarArr) throws NotFoundException {
        b bVar = bVarArr[0][1];
        int[] iArrA = bVar.a();
        int iA = (eVar.a() * eVar.c()) - c(eVar.b());
        if (iArrA.length != 0) {
            if (iArrA[0] != iA) {
                bVar.a(iA);
            }
        } else {
            if (iA > 0 && iA <= 928) {
                bVar.a(iA);
                return;
            }
            throw NotFoundException.f();
        }
    }

    private static com.google.zxing.common.d a(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException, FormatException {
        int[] iArr5 = new int[iArr3.length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < iArr5.length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return a(iArr, i2, iArr2);
                } catch (ChecksumException unused) {
                    if (iArr5.length == 0) {
                        throw ChecksumException.f();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= iArr5.length) {
                            break;
                        }
                        if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        }
                        iArr5[i6] = 0;
                        if (i6 == iArr5.length - 1) {
                            throw ChecksumException.f();
                        }
                        i6++;
                    }
                    i3 = i4;
                }
            } else {
                throw ChecksumException.f();
            }
        }
    }

    private static b[][] a(e eVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.c(), eVar.a() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (f fVar : eVar.e()) {
            if (fVar != null) {
                for (d dVar : fVar.b()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i4].a(dVar.e());
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static boolean a(e eVar, int i2) {
        return i2 >= 0 && i2 <= eVar.a() + 1;
    }

    private static int a(e eVar, int i2, int i3, boolean z2) {
        int i4 = z2 ? 1 : -1;
        int i5 = i2 - i4;
        d dVarA = a(eVar, i5) ? eVar.a(i5).a(i3) : null;
        if (dVarA != null) {
            return z2 ? dVarA.b() : dVarA.d();
        }
        d dVarB = eVar.a(i2).b(i3);
        if (dVarB != null) {
            return z2 ? dVarB.d() : dVarB.b();
        }
        if (a(eVar, i5)) {
            dVarB = eVar.a(i5).b(i3);
        }
        if (dVarB != null) {
            return z2 ? dVarB.b() : dVarB.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (a(eVar, i2)) {
                for (d dVar : eVar.a(i2).b()) {
                    if (dVar != null) {
                        return (z2 ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                    }
                }
                i6++;
            } else {
                c cVarD = eVar.d();
                return z2 ? cVarD.e() : cVarD.c();
            }
        }
    }

    private static d a(com.google.zxing.common.b bVar, int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
        int i8;
        int iD;
        int iA;
        int iA2 = a(bVar, i2, i3, z2, i4, i5);
        int[] iArrB = b(bVar, i2, i3, z2, iA2, i5);
        if (iArrB == null) {
            return null;
        }
        int iA3 = com.google.zxing.common.l.a.a(iArrB);
        if (z2) {
            iA2 += iA3;
            i8 = iA2;
        } else {
            for (int i9 = 0; i9 < iArrB.length / 2; i9++) {
                int i10 = iArrB[i9];
                iArrB[i9] = iArrB[(iArrB.length - 1) - i9];
                iArrB[(iArrB.length - 1) - i9] = i10;
            }
            i8 = iA2 - iA3;
        }
        if (a(iA3, i6, i7) && (iA = com.google.zxing.q.a.a((iD = h.d(iArrB)))) != -1) {
            return new d(i8, iA2, b(iD), iA);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        r0 = -r0;
        r2 = !r2;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0023, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0023, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.google.zxing.common.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r8
            r8 = r9
        L8:
            r3 = 2
            if (r1 >= r3) goto L29
        Lb:
            if (r2 == 0) goto L10
            if (r8 < r6) goto L23
            goto L12
        L10:
            if (r8 >= r7) goto L23
        L12:
            boolean r4 = r5.b(r8, r10)
            if (r2 != r4) goto L23
            int r4 = r9 - r8
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L21
            return r9
        L21:
            int r8 = r8 + r0
            goto Lb
        L23:
            int r0 = -r0
            r2 = r2 ^ 1
            int r1 = r1 + 1
            goto L8
        L29:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.a(com.google.zxing.common.b, int, int, boolean, int, int):int");
    }

    private static com.google.zxing.common.d a(int[] iArr, int i2, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int iA = a(iArr, iArr2, i3);
            a(iArr, i3);
            com.google.zxing.common.d dVarA = DecodedBitStreamParser.a(iArr, String.valueOf(i2));
            dVarA.b(Integer.valueOf(iA));
            dVarA.a(Integer.valueOf(iArr2.length));
            return dVarA;
        }
        throw FormatException.f();
    }

    private static int a(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return a.a(iArr, i2, iArr2);
        }
        throw ChecksumException.f();
    }

    private static void a(int[] iArr, int i2) throws FormatException {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw FormatException.f();
            }
            if (i3 == 0) {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw FormatException.f();
            }
            return;
        }
        throw FormatException.f();
    }

    private static int[] a(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
