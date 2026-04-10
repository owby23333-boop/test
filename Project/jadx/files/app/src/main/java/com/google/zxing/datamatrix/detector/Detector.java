package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.f;
import com.google.zxing.common.h;
import com.google.zxing.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Detector {
    private final com.google.zxing.common.b a;
    private final com.google.zxing.common.l.b b;

    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    private static final class b {
        private final i a;
        private final i b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f16202c;

        i a() {
            return this.a;
        }

        i b() {
            return this.b;
        }

        int c() {
            return this.f16202c;
        }

        public String toString() {
            return this.a + "/" + this.b + '/' + this.f16202c;
        }

        private b(i iVar, i iVar2, int i2) {
            this.a = iVar;
            this.b = iVar2;
            this.f16202c = i2;
        }
    }

    public Detector(com.google.zxing.common.b bVar) throws NotFoundException {
        this.a = bVar;
        this.b = new com.google.zxing.common.l.b(bVar);
    }

    private b b(i iVar, i iVar2) {
        int iA = (int) iVar.a();
        int iB = (int) iVar.b();
        int iA2 = (int) iVar2.a();
        int iB2 = (int) iVar2.b();
        int i2 = 0;
        boolean z2 = Math.abs(iB2 - iB) > Math.abs(iA2 - iA);
        if (z2) {
            iB = iA;
            iA = iB;
            iB2 = iA2;
            iA2 = iB2;
        }
        int iAbs = Math.abs(iA2 - iA);
        int iAbs2 = Math.abs(iB2 - iB);
        int i3 = (-iAbs) / 2;
        int i4 = iB < iB2 ? 1 : -1;
        int i5 = iA >= iA2 ? -1 : 1;
        boolean zB = this.a.b(z2 ? iB : iA, z2 ? iA : iB);
        while (iA != iA2) {
            boolean zB2 = this.a.b(z2 ? iB : iA, z2 ? iA : iB);
            if (zB2 != zB) {
                i2++;
                zB = zB2;
            }
            i3 += iAbs2;
            if (i3 > 0) {
                if (iB == iB2) {
                    break;
                }
                iB += i4;
                i3 -= iAbs;
            }
            iA += i5;
        }
        return new b(iVar, iVar2, i2);
    }

    public f a() throws NotFoundException {
        i iVar;
        i iVarA;
        com.google.zxing.common.b bVarA;
        i[] iVarArrA = this.b.a();
        i iVar2 = iVarArrA[0];
        i iVar3 = iVarArrA[1];
        i iVar4 = iVarArrA[2];
        i iVar5 = iVarArrA[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(iVar2, iVar3));
        arrayList.add(b(iVar2, iVar4));
        arrayList.add(b(iVar3, iVar5));
        arrayList.add(b(iVar4, iVar5));
        i iVar6 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        a(map, bVar.a());
        a(map, bVar.b());
        a(map, bVar2.a());
        a(map, bVar2.b());
        i iVar7 = null;
        i iVar8 = null;
        for (Map.Entry entry : map.entrySet()) {
            i iVar9 = (i) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                iVar7 = iVar9;
            } else if (iVar6 == null) {
                iVar6 = iVar9;
            } else {
                iVar8 = iVar9;
            }
        }
        if (iVar6 == null || iVar7 == null || iVar8 == null) {
            throw NotFoundException.f();
        }
        i[] iVarArr = {iVar6, iVar7, iVar8};
        i.a(iVarArr);
        i iVar10 = iVarArr[0];
        i iVar11 = iVarArr[1];
        i iVar12 = iVarArr[2];
        i iVar13 = !map.containsKey(iVar2) ? iVar2 : !map.containsKey(iVar3) ? iVar3 : !map.containsKey(iVar4) ? iVar4 : iVar5;
        int iC = b(iVar12, iVar13).c();
        int iC2 = b(iVar10, iVar13).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i2 = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i3 = iC2 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            iVar = iVar12;
            iVarA = a(iVar11, iVar10, iVar12, iVar13, i2, i3);
            if (iVarA == null) {
                iVarA = iVar13;
            }
            int iC3 = b(iVar, iVarA).c();
            int iC4 = b(iVar10, iVarA).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i4 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            bVarA = a(this.a, iVar, iVar11, iVar10, iVarA, i4, iC4);
        } else {
            iVarA = a(iVar11, iVar10, iVar12, iVar13, Math.min(i3, i2));
            if (iVarA == null) {
                iVarA = iVar13;
            }
            int iMax = Math.max(b(iVar12, iVarA).c(), b(iVar10, iVarA).c()) + 1;
            if ((iMax & 1) == 1) {
                iMax++;
            }
            int i5 = iMax;
            bVarA = a(this.a, iVar12, iVar11, iVar10, iVarA, i5, i5);
            iVar = iVar12;
        }
        return new f(bVarA, new i[]{iVar, iVar11, iVar10, iVarA});
    }

    private i a(i iVar, i iVar2, i iVar3, i iVar4, int i2, int i3) {
        float fA = a(iVar, iVar2) / i2;
        float fA2 = a(iVar3, iVar4);
        i iVar5 = new i(iVar4.a() + (((iVar4.a() - iVar3.a()) / fA2) * fA), iVar4.b() + (fA * ((iVar4.b() - iVar3.b()) / fA2)));
        float fA3 = a(iVar, iVar3) / i3;
        float fA4 = a(iVar2, iVar4);
        i iVar6 = new i(iVar4.a() + (((iVar4.a() - iVar2.a()) / fA4) * fA3), iVar4.b() + (fA3 * ((iVar4.b() - iVar2.b()) / fA4)));
        if (a(iVar5)) {
            return (a(iVar6) && Math.abs(i2 - b(iVar3, iVar5).c()) + Math.abs(i3 - b(iVar2, iVar5).c()) > Math.abs(i2 - b(iVar3, iVar6).c()) + Math.abs(i3 - b(iVar2, iVar6).c())) ? iVar6 : iVar5;
        }
        if (a(iVar6)) {
            return iVar6;
        }
        return null;
    }

    private i a(i iVar, i iVar2, i iVar3, i iVar4, int i2) {
        float f2 = i2;
        float fA = a(iVar, iVar2) / f2;
        float fA2 = a(iVar3, iVar4);
        i iVar5 = new i(iVar4.a() + (((iVar4.a() - iVar3.a()) / fA2) * fA), iVar4.b() + (fA * ((iVar4.b() - iVar3.b()) / fA2)));
        float fA3 = a(iVar, iVar3) / f2;
        float fA4 = a(iVar2, iVar4);
        i iVar6 = new i(iVar4.a() + (((iVar4.a() - iVar2.a()) / fA4) * fA3), iVar4.b() + (fA3 * ((iVar4.b() - iVar2.b()) / fA4)));
        if (a(iVar5)) {
            return (a(iVar6) && Math.abs(b(iVar3, iVar5).c() - b(iVar2, iVar5).c()) > Math.abs(b(iVar3, iVar6).c() - b(iVar2, iVar6).c())) ? iVar6 : iVar5;
        }
        if (a(iVar6)) {
            return iVar6;
        }
        return null;
    }

    private boolean a(i iVar) {
        return iVar.a() >= 0.0f && iVar.a() < ((float) this.a.e()) && iVar.b() > 0.0f && iVar.b() < ((float) this.a.c());
    }

    private static int a(i iVar, i iVar2) {
        return com.google.zxing.common.l.a.a(i.a(iVar, iVar2));
    }

    private static void a(Map<i, Integer> map, i iVar) {
        Integer num = map.get(iVar);
        map.put(iVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private static com.google.zxing.common.b a(com.google.zxing.common.b bVar, i iVar, i iVar2, i iVar3, i iVar4, int i2, int i3) throws NotFoundException {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return h.a().a(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, iVar.a(), iVar.b(), iVar4.a(), iVar4.b(), iVar3.a(), iVar3.b(), iVar2.a(), iVar2.b());
    }
}
