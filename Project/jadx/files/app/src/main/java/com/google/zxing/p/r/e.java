package com.google.zxing.p.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.p.k;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RSS14Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f16266i = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f16267j = {4, 20, 48, 81};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f16268k = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f16269l = {0, 336, DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, 1516};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f16270m = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f16271n = {2, 4, 6, 8};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[][] f16272o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<d> f16273g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<d> f16274h = new ArrayList();

    private static h b(d dVar, d dVar2) {
        String strValueOf = String.valueOf((((long) dVar.b()) * 4537077) + ((long) dVar2.b()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        i[] iVarArrA = dVar.d().a();
        i[] iVarArrA2 = dVar2.d().a();
        return new h(sb.toString(), null, new i[]{iVarArrA[0], iVarArrA[1], iVarArrA2[0], iVarArrA2[1]}, BarcodeFormat.RSS_14);
    }

    @Override // com.google.zxing.p.k
    public h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        a(this.f16273g, a(aVar, false, i2, map));
        aVar.e();
        a(this.f16274h, a(aVar, true, i2, map));
        aVar.e();
        for (d dVar : this.f16273g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f16274h) {
                    if (dVar2.c() > 1 && a(dVar, dVar2)) {
                        return b(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.p.k, com.google.zxing.g
    public void reset() {
        this.f16273g.clear();
        this.f16274h.clear();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z2 = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        collection.add(dVar);
    }

    private static boolean a(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private d a(com.google.zxing.common.a aVar, boolean z2, int i2, Map<DecodeHintType, ?> map) {
        try {
            c cVarA = a(aVar, i2, z2, a(aVar, z2));
            j jVar = map == null ? null : (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (jVar != null) {
                float fC = (r1[0] + r1[1]) / 2.0f;
                if (z2) {
                    fC = (aVar.c() - 1) - fC;
                }
                jVar.a(new i(fC, i2));
            }
            b bVarA = a(aVar, cVarA, true);
            b bVarA2 = a(aVar, cVarA, false);
            return new d((bVarA.b() * 1597) + bVarA2.b(), bVarA.a() + (bVarA2.a() * 4), cVarA);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private b a(com.google.zxing.common.a aVar, c cVar, boolean z2) throws NotFoundException {
        int[] iArrA = a();
        for (int i2 = 0; i2 < iArrA.length; i2++) {
            iArrA[i2] = 0;
        }
        if (z2) {
            k.b(aVar, cVar.b()[0], iArrA);
        } else {
            k.a(aVar, cVar.b()[1] + 1, iArrA);
            int i3 = 0;
            for (int length = iArrA.length - 1; i3 < length; length--) {
                int i4 = iArrA[i3];
                iArrA[i3] = iArrA[length];
                iArrA[length] = i4;
                i3++;
            }
        }
        int i5 = z2 ? 16 : 15;
        float fA = com.google.zxing.common.l.a.a(iArrA) / i5;
        int[] iArrE = e();
        int[] iArrC = c();
        float[] fArrF = f();
        float[] fArrD = d();
        for (int i6 = 0; i6 < iArrA.length; i6++) {
            float f2 = iArrA[i6] / fA;
            int i7 = (int) (0.5f + f2);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                iArrE[i8] = i7;
                fArrF[i8] = f2 - i7;
            } else {
                iArrC[i8] = i7;
                fArrD[i8] = f2 - i7;
            }
        }
        a(z2, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArrE.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + iArrE[length2];
            i10 += iArrE[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArrC.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + iArrC[length3];
            i12 += iArrC[length3];
        }
        int i13 = i9 + (i11 * 3);
        if (!z2) {
            if ((i12 & 1) == 0 && i12 <= 10 && i12 >= 4) {
                int i14 = (10 - i12) / 2;
                int i15 = f16271n[i14];
                return new b((f.a(iArrC, 9 - i15, false) * f16267j[i14]) + f.a(iArrE, i15, true) + f16269l[i14], i13);
            }
            throw NotFoundException.f();
        }
        if ((i10 & 1) == 0 && i10 <= 12 && i10 >= 4) {
            int i16 = (12 - i10) / 2;
            int i17 = f16270m[i16];
            return new b((f.a(iArrE, i17, false) * f16266i[i16]) + f.a(iArrC, 9 - i17, true) + f16268k[i16], i13);
        }
        throw NotFoundException.f();
    }

    private int[] a(com.google.zxing.common.a aVar, boolean z2) throws NotFoundException {
        int[] iArrB = b();
        iArrB[0] = 0;
        iArrB[1] = 0;
        iArrB[2] = 0;
        iArrB[3] = 0;
        int iC = aVar.c();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < iC) {
            z3 = !aVar.a(i2);
            if (z2 == z3) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iC) {
            if (aVar.a(i2) != z3) {
                iArrB[i4] = iArrB[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.a(iArrB)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArrB[0] + iArrB[1];
                    iArrB[0] = iArrB[2];
                    iArrB[1] = iArrB[3];
                    iArrB[2] = 0;
                    iArrB[3] = 0;
                    i4--;
                }
                iArrB[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.f();
    }

    private c a(com.google.zxing.common.a aVar, int i2, boolean z2, int[] iArr) throws NotFoundException {
        int iC;
        int i3;
        boolean zA = aVar.a(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zA != aVar.a(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrB = b();
        System.arraycopy(iArrB, 0, iArrB, 1, iArrB.length - 1);
        iArrB[0] = i6;
        int iA = a.a(iArrB, f16272o);
        int i7 = iArr[1];
        if (z2) {
            int iC2 = (aVar.c() - 1) - i5;
            iC = (aVar.c() - 1) - i7;
            i3 = iC2;
        } else {
            iC = i7;
            i3 = i5;
        }
        return new c(iA, new int[]{i5, iArr[1]}, i3, iC, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0043 A[PHI: r5 r6
  0x0043: PHI (r5v7 boolean) = (r5v5 boolean), (r5v17 boolean) binds: [B:27:0x0041, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x0043: PHI (r6v3 boolean) = (r6v1 boolean), (r6v14 boolean) binds: [B:27:0x0041, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045 A[PHI: r5 r6
  0x0045: PHI (r5v9 boolean) = (r5v5 boolean), (r5v17 boolean) binds: [B:27:0x0041, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x0045: PHI (r6v5 boolean) = (r6v1 boolean), (r6v14 boolean) binds: [B:27:0x0041, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p.r.e.a(boolean, int):void");
    }
}
