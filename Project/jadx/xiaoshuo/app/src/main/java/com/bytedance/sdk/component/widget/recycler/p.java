package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.e;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class p {
    final e e;

    public interface e {
        e.bf e(int i, int i2, int i3, Object obj);

        void e(e.bf bfVar);
    }

    public p(e eVar) {
        this.e = eVar;
    }

    private void d(List<e.bf> list, int i, e.bf bfVar, int i2, e.bf bfVar2) {
        int i3 = bfVar.tg;
        int i4 = bfVar2.bf;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = bfVar.bf;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            bfVar.bf = i6 + bfVar2.tg;
        }
        int i7 = bfVar2.bf;
        if (i7 <= i3) {
            bfVar.tg = i3 + bfVar2.tg;
        }
        bfVar2.bf = i7 + i5;
        list.set(i, bfVar2);
        list.set(i2, bfVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bf(java.util.List<com.bytedance.sdk.component.widget.recycler.e.bf> r9, int r10, com.bytedance.sdk.component.widget.recycler.e.bf r11, int r12, com.bytedance.sdk.component.widget.recycler.e.bf r13) {
        /*
            r8 = this;
            int r0 = r11.tg
            int r1 = r13.bf
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.bf = r1
            goto L20
        Ld:
            int r5 = r13.tg
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.tg = r5
            com.bytedance.sdk.component.widget.recycler.p$e r0 = r8.e
            int r1 = r11.bf
            java.lang.Object r5 = r13.d
            com.bytedance.sdk.component.widget.recycler.e$bf r0 = r0.e(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.bf
            int r5 = r13.bf
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.bf = r5
            goto L41
        L2b:
            int r6 = r13.tg
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            com.bytedance.sdk.component.widget.recycler.p$e r4 = r8.e
            int r1 = r1 + r3
            java.lang.Object r3 = r13.d
            com.bytedance.sdk.component.widget.recycler.e$bf r4 = r4.e(r2, r1, r5, r3)
            int r1 = r13.tg
            int r1 = r1 - r5
            r13.tg = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.tg
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            com.bytedance.sdk.component.widget.recycler.p$e r11 = r8.e
            r11.e(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.p.bf(java.util.List, int, com.bytedance.sdk.component.widget.recycler.e$bf, int, com.bytedance.sdk.component.widget.recycler.e$bf):void");
    }

    public void e(List<e.bf> list) {
        while (true) {
            int iBf = bf(list);
            if (iBf == -1) {
                return;
            } else {
                e(list, iBf, iBf + 1);
            }
        }
    }

    private void e(List<e.bf> list, int i, int i2) {
        e.bf bfVar = list.get(i);
        e.bf bfVar2 = list.get(i2);
        int i3 = bfVar2.e;
        if (i3 == 1) {
            d(list, i, bfVar, i2, bfVar2);
        } else if (i3 == 2) {
            e(list, i, bfVar, i2, bfVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            bf(list, i, bfVar, i2, bfVar2);
        }
    }

    public void e(List<e.bf> list, int i, e.bf bfVar, int i2, e.bf bfVar2) {
        boolean z;
        int i3 = bfVar.bf;
        int i4 = bfVar.tg;
        boolean z2 = false;
        if (i3 < i4) {
            if (bfVar2.bf == i3 && bfVar2.tg == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bfVar2.bf == i4 + 1 && bfVar2.tg == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = bfVar2.bf;
        if (i4 < i5) {
            bfVar2.bf = i5 - 1;
        } else {
            int i6 = bfVar2.tg;
            if (i4 < i5 + i6) {
                bfVar2.tg = i6 - 1;
                bfVar.e = 2;
                bfVar.tg = 1;
                if (bfVar2.tg == 0) {
                    list.remove(i2);
                    this.e.e(bfVar2);
                    return;
                }
                return;
            }
        }
        int i7 = bfVar.bf;
        int i8 = bfVar2.bf;
        e.bf bfVarE = null;
        if (i7 <= i8) {
            bfVar2.bf = i8 + 1;
        } else {
            int i9 = bfVar2.tg;
            if (i7 < i8 + i9) {
                bfVarE = this.e.e(2, i7 + 1, (i8 + i9) - i7, null);
                bfVar2.tg = bfVar.bf - bfVar2.bf;
            }
        }
        if (z2) {
            list.set(i, bfVar2);
            list.remove(i2);
            this.e.e(bfVar);
            return;
        }
        if (z) {
            if (bfVarE != null) {
                int i10 = bfVar.bf;
                if (i10 > bfVarE.bf) {
                    bfVar.bf = i10 - bfVarE.tg;
                }
                int i11 = bfVar.tg;
                if (i11 > bfVarE.bf) {
                    bfVar.tg = i11 - bfVarE.tg;
                }
            }
            int i12 = bfVar.bf;
            if (i12 > bfVar2.bf) {
                bfVar.bf = i12 - bfVar2.tg;
            }
            int i13 = bfVar.tg;
            if (i13 > bfVar2.bf) {
                bfVar.tg = i13 - bfVar2.tg;
            }
        } else {
            if (bfVarE != null) {
                int i14 = bfVar.bf;
                if (i14 >= bfVarE.bf) {
                    bfVar.bf = i14 - bfVarE.tg;
                }
                int i15 = bfVar.tg;
                if (i15 >= bfVarE.bf) {
                    bfVar.tg = i15 - bfVarE.tg;
                }
            }
            int i16 = bfVar.bf;
            if (i16 >= bfVar2.bf) {
                bfVar.bf = i16 - bfVar2.tg;
            }
            int i17 = bfVar.tg;
            if (i17 >= bfVar2.bf) {
                bfVar.tg = i17 - bfVar2.tg;
            }
        }
        list.set(i, bfVar2);
        if (bfVar.bf != bfVar.tg) {
            list.set(i2, bfVar);
        } else {
            list.remove(i2);
        }
        if (bfVarE != null) {
            list.add(i, bfVarE);
        }
    }

    private int bf(List<e.bf> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).e != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
