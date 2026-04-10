package com.google.zxing.p.r.g;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.oned.rss.expanded.decoders.j;
import com.google.zxing.p.k;
import com.google.zxing.p.r.f;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RSSExpandedReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.google.zxing.p.r.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f16277k = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f16278l = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f16279m = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[][] f16280n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[][] f16281o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, NormalCmdFactory.TASK_RESTART, 136, 197, 169, 85, 44, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL}, new int[]{NormalCmdFactory.TASK_CANCEL_ALL, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 37, 111, 122, TbsListener.ErrorCode.NO_NEED_STARTDOWNLOAD}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, ISchedulers.SUB_CANCEL}, new int[]{70, 210, 208, 202, NormalCmdFactory.TASK_RESUME_ALL, 130, 179, 115}, new int[]{TbsListener.ErrorCode.DOWNLOAD_USER_PAUSE, 191, TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, ISchedulers.SUB_COMPLETE}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, NormalCmdFactory.TASK_HIGHEST_PRIORITY, 124}, new int[]{161, 61, NormalCmdFactory.TASK_STOP_ALL, 127, 170, 88, 53, 159}, new int[]{55, ISchedulers.SUB_FAIL, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[][] f16282p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<b> f16283g = new ArrayList(11);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<c> f16284h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f16285i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16286j;

    private static boolean b(List<b> list) {
        boolean z2;
        for (int[] iArr : f16282p) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z2 = true;
                        break;
                    }
                    if (list.get(i2).a().c() != iArr[i2]) {
                        z2 = false;
                        break;
                    }
                    i2++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean g() {
        b bVar = this.f16283g.get(0);
        com.google.zxing.p.r.b bVarB = bVar.b();
        com.google.zxing.p.r.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f16283g.size(); i3++) {
            b bVar2 = this.f16283g.get(i3);
            iA += bVar2.b().a();
            i2++;
            com.google.zxing.p.r.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * 211) + (iA % 211) == bVarB.b();
    }

    @Override // com.google.zxing.p.k
    public h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f16283g.clear();
        this.f16286j = false;
        try {
            return a(a(i2, aVar));
        } catch (NotFoundException unused) {
            this.f16283g.clear();
            this.f16286j = true;
            return a(a(i2, aVar));
        }
    }

    @Override // com.google.zxing.p.k, com.google.zxing.g
    public void reset() {
        this.f16283g.clear();
        this.f16284h.clear();
    }

    private void b(com.google.zxing.common.a aVar, List<b> list, int i2) throws NotFoundException {
        int[] iArrB = b();
        iArrB[0] = 0;
        iArrB[1] = 0;
        iArrB[2] = 0;
        iArrB[3] = 0;
        int iC = aVar.c();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z2 = list.size() % 2 != 0;
        if (this.f16286j) {
            z2 = !z2;
        }
        boolean z3 = false;
        while (i2 < iC) {
            z3 = !aVar.a(i2);
            if (!z3) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iC) {
            if (aVar.a(i2) != z3) {
                iArrB[i4] = iArrB[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z2) {
                        b(iArrB);
                    }
                    if (com.google.zxing.p.r.a.a(iArrB)) {
                        int[] iArr = this.f16285i;
                        iArr[0] = i3;
                        iArr[1] = i2;
                        return;
                    }
                    if (z2) {
                        b(iArrB);
                    }
                    i3 += iArrB[0] + iArrB[1];
                    iArrB[0] = iArrB[2];
                    iArrB[1] = iArrB[3];
                    iArrB[2] = 0;
                    iArrB[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                iArrB[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.f();
    }

    List<b> a(int i2, com.google.zxing.common.a aVar) throws NotFoundException {
        boolean z2 = false;
        while (!z2) {
            try {
                this.f16283g.add(a(aVar, this.f16283g, i2));
            } catch (NotFoundException e2) {
                if (this.f16283g.isEmpty()) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (g()) {
            return this.f16283g;
        }
        boolean z3 = !this.f16284h.isEmpty();
        a(i2, false);
        if (z3) {
            List<b> listA = a(false);
            if (listA != null) {
                return listA;
            }
            List<b> listA2 = a(true);
            if (listA2 != null) {
                return listA2;
            }
        }
        throw NotFoundException.f();
    }

    private List<b> a(boolean z2) {
        List<b> listA = null;
        if (this.f16284h.size() > 25) {
            this.f16284h.clear();
            return null;
        }
        this.f16283g.clear();
        if (z2) {
            Collections.reverse(this.f16284h);
        }
        try {
            listA = a(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z2) {
            Collections.reverse(this.f16284h);
        }
        return listA;
    }

    private List<b> a(List<c> list, int i2) throws NotFoundException {
        while (i2 < this.f16284h.size()) {
            c cVar = this.f16284h.get(i2);
            this.f16283g.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.f16283g.addAll(it.next().a());
            }
            this.f16283g.addAll(cVar.a());
            if (b(this.f16283g)) {
                if (g()) {
                    return this.f16283g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return a(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i2++;
        }
        throw NotFoundException.f();
    }

    private static void b(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void a(int i2, boolean z2) {
        boolean zA = false;
        int i3 = 0;
        boolean zA2 = false;
        while (true) {
            if (i3 >= this.f16284h.size()) {
                break;
            }
            c cVar = this.f16284h.get(i3);
            if (cVar.b() > i2) {
                zA = cVar.a(this.f16283g);
                break;
            } else {
                zA2 = cVar.a(this.f16283g);
                i3++;
            }
        }
        if (zA || zA2 || a((Iterable<b>) this.f16283g, (Iterable<c>) this.f16284h)) {
            return;
        }
        this.f16284h.add(i3, new c(this.f16283g, i2, z2));
        a(this.f16283g, this.f16284h);
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z2;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z2 = false;
                    boolean z3 = true;
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z3 = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                    if (!z3) {
                        break;
                    }
                }
                if (z2) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z2;
        boolean z3;
        Iterator<c> it = iterable2.iterator();
        do {
            z2 = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    break;
                }
            }
        } while (!z2);
        return true;
    }

    static h a(List<b> list) throws NotFoundException, FormatException {
        String strC = j.a(a.a(list)).c();
        i[] iVarArrA = list.get(0).a().a();
        i[] iVarArrA2 = list.get(list.size() - 1).a().a();
        return new h(strC, null, new i[]{iVarArrA[0], iVarArrA[1], iVarArrA2[0], iVarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private static int a(com.google.zxing.common.a aVar, int i2) {
        if (aVar.a(i2)) {
            return aVar.b(aVar.c(i2));
        }
        return aVar.c(aVar.b(i2));
    }

    b a(com.google.zxing.common.a aVar, List<b> list, int i2) throws NotFoundException {
        com.google.zxing.p.r.c cVarA;
        com.google.zxing.p.r.b bVarA;
        boolean z2 = list.size() % 2 == 0;
        if (this.f16286j) {
            z2 = !z2;
        }
        int iA = -1;
        boolean z3 = true;
        do {
            b(aVar, list, iA);
            cVarA = a(aVar, i2, z2);
            if (cVarA == null) {
                iA = a(aVar, this.f16285i[0]);
            } else {
                z3 = false;
            }
        } while (z3);
        com.google.zxing.p.r.b bVarA2 = a(aVar, cVarA, z2, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.f();
        }
        try {
            bVarA = a(aVar, cVarA, z2, false);
        } catch (NotFoundException unused) {
            bVarA = null;
        }
        return new b(bVarA2, bVarA, cVarA, true);
    }

    private com.google.zxing.p.r.c a(com.google.zxing.common.a aVar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        if (z2) {
            int i6 = this.f16285i[0] - 1;
            while (i6 >= 0 && !aVar.a(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f16285i;
            int i8 = iArr[0] - i7;
            i4 = iArr[1];
            i5 = i7;
            i3 = i8;
        } else {
            int[] iArr2 = this.f16285i;
            int i9 = iArr2[0];
            int iC = aVar.c(iArr2[1] + 1);
            i3 = iC - this.f16285i[1];
            i4 = iC;
            i5 = i9;
        }
        int[] iArrB = b();
        System.arraycopy(iArrB, 0, iArrB, 1, iArrB.length - 1);
        iArrB[0] = i3;
        try {
            return new com.google.zxing.p.r.c(com.google.zxing.p.r.a.a(iArrB, f16280n), new int[]{i5, i4}, i5, i4, i2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    com.google.zxing.p.r.b a(com.google.zxing.common.a aVar, com.google.zxing.p.r.c cVar, boolean z2, boolean z3) throws NotFoundException {
        int[] iArrA = a();
        for (int i2 = 0; i2 < iArrA.length; i2++) {
            iArrA[i2] = 0;
        }
        if (z3) {
            k.b(aVar, cVar.b()[0], iArrA);
        } else {
            k.a(aVar, cVar.b()[1], iArrA);
            int i3 = 0;
            for (int length = iArrA.length - 1; i3 < length; length--) {
                int i4 = iArrA[i3];
                iArrA[i3] = iArrA[length];
                iArrA[length] = i4;
                i3++;
            }
        }
        float fA = com.google.zxing.common.l.a.a(iArrA) / 17.0f;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fA - f2) / f2 <= 0.3f) {
            int[] iArrE = e();
            int[] iArrC = c();
            float[] fArrF = f();
            float[] fArrD = d();
            for (int i5 = 0; i5 < iArrA.length; i5++) {
                float f3 = (iArrA[i5] * 1.0f) / fA;
                int i6 = (int) (0.5f + f3);
                int i7 = 8;
                if (i6 <= 0) {
                    if (f3 < 0.3f) {
                        throw NotFoundException.f();
                    }
                    i7 = 1;
                } else if (i6 <= 8) {
                    i7 = i6;
                } else if (f3 > 8.7f) {
                    throw NotFoundException.f();
                }
                int i8 = i5 / 2;
                if ((i5 & 1) == 0) {
                    iArrE[i8] = i7;
                    fArrF[i8] = f3 - i7;
                } else {
                    iArrC[i8] = i7;
                    fArrD[i8] = f3 - i7;
                }
            }
            a(17);
            int iC = (((cVar.c() * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
            int i9 = 0;
            int i10 = 0;
            for (int length2 = iArrE.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z2, z3)) {
                    i9 += iArrE[length2] * f16281o[iC][length2 * 2];
                }
                i10 += iArrE[length2];
            }
            int i11 = 0;
            for (int length3 = iArrC.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z2, z3)) {
                    i11 += iArrC[length3] * f16281o[iC][(length3 * 2) + 1];
                }
            }
            int i12 = i9 + i11;
            if ((i10 & 1) == 0 && i10 <= 13 && i10 >= 4) {
                int i13 = (13 - i10) / 2;
                int i14 = f16277k[i13];
                return new com.google.zxing.p.r.b((f.a(iArrE, i14, true) * f16278l[i13]) + f.a(iArrC, 9 - i14, false) + f16279m[i13], i12);
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }

    private static boolean a(com.google.zxing.p.r.c cVar, boolean z2, boolean z3) {
        return (cVar.c() == 0 && z2 && z3) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p.r.g.d.a(int):void");
    }
}
