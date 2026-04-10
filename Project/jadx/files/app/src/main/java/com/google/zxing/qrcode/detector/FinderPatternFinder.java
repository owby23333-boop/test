package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.i;
import com.google.zxing.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FinderPatternFinder {
    private final com.google.zxing.common.b a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16348c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f16350e;
    private final List<d> b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f16349d = new int[5];

    private static final class CenterComparator implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f16351s;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int iCompare = Integer.compare(dVar2.c(), dVar.c());
            return iCompare == 0 ? Float.compare(Math.abs(dVar.d() - this.f16351s), Math.abs(dVar2.d() - this.f16351s)) : iCompare;
        }

        private CenterComparator(float f2) {
            this.f16351s = f2;
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f16352s;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.d() - this.f16352s), Math.abs(dVar.d() - this.f16352s));
        }

        private FurthestFromAverageComparator(float f2) {
            this.f16352s = f2;
        }
    }

    public FinderPatternFinder(com.google.zxing.common.b bVar, j jVar) {
        this.a = bVar;
        this.f16350e = jVar;
    }

    private int[] b() {
        a(this.f16349d);
        return this.f16349d;
    }

    protected static boolean c(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    protected static boolean d(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    final e a(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iC = this.a.c();
        int iE = this.a.e();
        int i2 = (iC * 3) / 388;
        if (i2 < 3 || z2) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        int i4 = i2;
        boolean zC = false;
        while (i3 < iC && !zC) {
            a(iArr);
            boolean zC2 = zC;
            int i5 = i4;
            int i6 = 0;
            int i7 = 0;
            while (i6 < iE) {
                if (this.a.b(i6, i3)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) != 0) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 != 4) {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                } else if (c(iArr) && a(iArr, i3, i6)) {
                    if (this.f16348c) {
                        zC2 = c();
                    } else {
                        int iA = a();
                        if (iA > iArr[2]) {
                            i3 += (iA - iArr[2]) - 2;
                            i6 = iE - 1;
                        }
                    }
                    a(iArr);
                    i7 = 0;
                    i5 = 2;
                } else {
                    b(iArr);
                    i7 = 3;
                }
                i6++;
            }
            if (c(iArr) && a(iArr, i3, iE)) {
                int i8 = iArr[0];
                if (this.f16348c) {
                    i4 = i8;
                    zC = c();
                    i3 += i4;
                } else {
                    i4 = i8;
                }
            } else {
                i4 = i5;
            }
            zC = zC2;
            i3 += i4;
        }
        d[] dVarArrD = d();
        i.a(dVarArrD);
        return new e(dVarArrD);
    }

    protected final void b(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private float b(int i2, int i3, int i4, int i5) {
        com.google.zxing.common.b bVar = this.a;
        int iC = bVar.c();
        int[] iArrB = b();
        int i6 = i2;
        while (i6 >= 0 && bVar.b(i3, i6)) {
            iArrB[2] = iArrB[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.b(i3, i6) && iArrB[1] <= i4) {
            iArrB[1] = iArrB[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArrB[1] <= i4) {
            while (i6 >= 0 && bVar.b(i3, i6) && iArrB[0] <= i4) {
                iArrB[0] = iArrB[0] + 1;
                i6--;
            }
            if (iArrB[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < iC && bVar.b(i3, i7)) {
                iArrB[2] = iArrB[2] + 1;
                i7++;
            }
            if (i7 == iC) {
                return Float.NaN;
            }
            while (i7 < iC && !bVar.b(i3, i7) && iArrB[3] < i4) {
                iArrB[3] = iArrB[3] + 1;
                i7++;
            }
            if (i7 != iC && iArrB[3] < i4) {
                while (i7 < iC && bVar.b(i3, i7) && iArrB[4] < i4) {
                    iArrB[4] = iArrB[4] + 1;
                    i7++;
                }
                if (iArrB[4] < i4 && Math.abs(((((iArrB[0] + iArrB[1]) + iArrB[2]) + iArrB[3]) + iArrB[4]) - i5) * 5 < i5 * 2 && c(iArrB)) {
                    return a(iArrB, i7);
                }
            }
        }
        return Float.NaN;
    }

    private boolean c() {
        int size = this.b.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float fD = 0.0f;
        for (d dVar : this.b) {
            if (dVar.c() >= 2) {
                i2++;
                fD += dVar.d();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = fD / size;
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().d() - f2);
        }
        return fAbs <= fD * 0.05f;
    }

    private d[] d() throws NotFoundException {
        int size = this.b.size();
        if (size >= 3) {
            float fD = 0.0f;
            if (size > 3) {
                Iterator<d> it = this.b.iterator();
                float f2 = 0.0f;
                float f3 = 0.0f;
                while (it.hasNext()) {
                    float fD2 = it.next().d();
                    f2 += fD2;
                    f3 += fD2 * fD2;
                }
                float f4 = f2 / size;
                float fSqrt = (float) Math.sqrt((f3 / r0) - (f4 * f4));
                Collections.sort(this.b, new FurthestFromAverageComparator(f4));
                float fMax = Math.max(0.2f * f4, fSqrt);
                int i2 = 0;
                while (i2 < this.b.size() && this.b.size() > 3) {
                    if (Math.abs(this.b.get(i2).d() - f4) > fMax) {
                        this.b.remove(i2);
                        i2--;
                    }
                    i2++;
                }
            }
            if (this.b.size() > 3) {
                Iterator<d> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    fD += it2.next().d();
                }
                Collections.sort(this.b, new CenterComparator(fD / this.b.size()));
                List<d> list = this.b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{this.b.get(0), this.b.get(1), this.b.get(2)};
        }
        throw NotFoundException.f();
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected final void a(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    private boolean a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArrB = b();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.a.b(i3 - i7, i2 - i7)) {
            iArrB[2] = iArrB[2] + 1;
            i7++;
        }
        if (iArrB[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.a.b(i3 - i7, i2 - i7)) {
            iArrB[1] = iArrB[1] + 1;
            i7++;
        }
        if (iArrB[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.a.b(i3 - i7, i2 - i7)) {
            iArrB[0] = iArrB[0] + 1;
            i7++;
        }
        if (iArrB[0] == 0) {
            return false;
        }
        int iC = this.a.c();
        int iE = this.a.e();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= iC || (i6 = i3 + i8) >= iE || !this.a.b(i6, i9)) {
                break;
            }
            iArrB[2] = iArrB[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= iC || (i5 = i3 + i8) >= iE || this.a.b(i5, i10)) {
                break;
            }
            iArrB[3] = iArrB[3] + 1;
            i8++;
        }
        if (iArrB[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= iC || (i4 = i3 + i8) >= iE || !this.a.b(i4, i11)) {
                break;
            }
            iArrB[4] = iArrB[4] + 1;
            i8++;
        }
        if (iArrB[4] == 0) {
            return false;
        }
        return d(iArrB);
    }

    private float a(int i2, int i3, int i4, int i5) {
        com.google.zxing.common.b bVar = this.a;
        int iE = bVar.e();
        int[] iArrB = b();
        int i6 = i2;
        while (i6 >= 0 && bVar.b(i6, i3)) {
            iArrB[2] = iArrB[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.b(i6, i3) && iArrB[1] <= i4) {
            iArrB[1] = iArrB[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArrB[1] <= i4) {
            while (i6 >= 0 && bVar.b(i6, i3) && iArrB[0] <= i4) {
                iArrB[0] = iArrB[0] + 1;
                i6--;
            }
            if (iArrB[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < iE && bVar.b(i7, i3)) {
                iArrB[2] = iArrB[2] + 1;
                i7++;
            }
            if (i7 == iE) {
                return Float.NaN;
            }
            while (i7 < iE && !bVar.b(i7, i3) && iArrB[3] < i4) {
                iArrB[3] = iArrB[3] + 1;
                i7++;
            }
            if (i7 != iE && iArrB[3] < i4) {
                while (i7 < iE && bVar.b(i7, i3) && iArrB[4] < i4) {
                    iArrB[4] = iArrB[4] + 1;
                    i7++;
                }
                if (iArrB[4] < i4 && Math.abs(((((iArrB[0] + iArrB[1]) + iArrB[2]) + iArrB[3]) + iArrB[4]) - i5) * 5 < i5 && c(iArrB)) {
                    return a(iArrB, i7);
                }
            }
        }
        return Float.NaN;
    }

    protected final boolean a(int[] iArr, int i2, int i3) {
        boolean z2 = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i3);
        float fB = b(i2, iA, iArr[2], i4);
        if (!Float.isNaN(fB)) {
            int i5 = (int) fB;
            float fA = a(iA, i5, iArr[2], i4);
            if (!Float.isNaN(fA) && a(i5, (int) fA)) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.b.size()) {
                        break;
                    }
                    d dVar = this.b.get(i6);
                    if (dVar.a(f2, fB, fA)) {
                        this.b.set(i6, dVar.b(fB, fA, f2));
                        z2 = true;
                        break;
                    }
                    i6++;
                }
                if (!z2) {
                    d dVar2 = new d(fA, fB, f2);
                    this.b.add(dVar2);
                    j jVar = this.f16350e;
                    if (jVar != null) {
                        jVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int a() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.c() >= 2) {
                if (dVar != null) {
                    this.f16348c = true;
                    return ((int) (Math.abs(dVar.a() - dVar2.a()) - Math.abs(dVar.b() - dVar2.b()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }
}
