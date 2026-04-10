package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.z;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class e {
    final z z;

    interface z {
        z.g z(int i, int i2, int i3, Object obj);

        void z(z.g gVar);
    }

    e(z zVar) {
        this.z = zVar;
    }

    void z(List<z.g> list) {
        while (true) {
            int iG = g(list);
            if (iG == -1) {
                return;
            } else {
                z(list, iG, iG + 1);
            }
        }
    }

    private void z(List<z.g> list, int i, int i2) {
        z.g gVar = list.get(i);
        z.g gVar2 = list.get(i2);
        int i3 = gVar2.z;
        if (i3 == 1) {
            dl(list, i, gVar, i2, gVar2);
        } else if (i3 == 2) {
            z(list, i, gVar, i2, gVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            g(list, i, gVar, i2, gVar2);
        }
    }

    void z(List<z.g> list, int i, z.g gVar, int i2, z.g gVar2) {
        boolean z2;
        boolean z3 = false;
        if (gVar.g < gVar.f841a) {
            if (gVar2.g == gVar.g && gVar2.f841a == gVar.f841a - gVar.g) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (gVar2.g == gVar.f841a + 1 && gVar2.f841a == gVar.g - gVar.f841a) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        if (gVar.f841a < gVar2.g) {
            gVar2.g--;
        } else if (gVar.f841a < gVar2.g + gVar2.f841a) {
            gVar2.f841a--;
            gVar.z = 2;
            gVar.f841a = 1;
            if (gVar2.f841a == 0) {
                list.remove(i2);
                this.z.z(gVar2);
                return;
            }
            return;
        }
        z.g gVarZ = null;
        if (gVar.g <= gVar2.g) {
            gVar2.g++;
        } else if (gVar.g < gVar2.g + gVar2.f841a) {
            gVarZ = this.z.z(2, gVar.g + 1, (gVar2.g + gVar2.f841a) - gVar.g, null);
            gVar2.f841a = gVar.g - gVar2.g;
        }
        if (z3) {
            list.set(i, gVar2);
            list.remove(i2);
            this.z.z(gVar);
            return;
        }
        if (z2) {
            if (gVarZ != null) {
                if (gVar.g > gVarZ.g) {
                    gVar.g -= gVarZ.f841a;
                }
                if (gVar.f841a > gVarZ.g) {
                    gVar.f841a -= gVarZ.f841a;
                }
            }
            if (gVar.g > gVar2.g) {
                gVar.g -= gVar2.f841a;
            }
            if (gVar.f841a > gVar2.g) {
                gVar.f841a -= gVar2.f841a;
            }
        } else {
            if (gVarZ != null) {
                if (gVar.g >= gVarZ.g) {
                    gVar.g -= gVarZ.f841a;
                }
                if (gVar.f841a >= gVarZ.g) {
                    gVar.f841a -= gVarZ.f841a;
                }
            }
            if (gVar.g >= gVar2.g) {
                gVar.g -= gVar2.f841a;
            }
            if (gVar.f841a >= gVar2.g) {
                gVar.f841a -= gVar2.f841a;
            }
        }
        list.set(i, gVar2);
        if (gVar.g != gVar.f841a) {
            list.set(i2, gVar);
        } else {
            list.remove(i2);
        }
        if (gVarZ != null) {
            list.add(i, gVarZ);
        }
    }

    private void dl(List<z.g> list, int i, z.g gVar, int i2, z.g gVar2) {
        int i3 = gVar.f841a < gVar2.g ? -1 : 0;
        if (gVar.g < gVar2.g) {
            i3++;
        }
        if (gVar2.g <= gVar.g) {
            gVar.g += gVar2.f841a;
        }
        if (gVar2.g <= gVar.f841a) {
            gVar.f841a += gVar2.f841a;
        }
        gVar2.g += i3;
        list.set(i, gVar2);
        list.set(i2, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void g(java.util.List<com.bytedance.sdk.component.widget.recycler.z.g> r8, int r9, com.bytedance.sdk.component.widget.recycler.z.g r10, int r11, com.bytedance.sdk.component.widget.recycler.z.g r12) {
        /*
            r7 = this;
            int r0 = r10.f841a
            int r1 = r12.g
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Lf
            int r0 = r12.g
            int r0 = r0 - r3
            r12.g = r0
            goto L28
        Lf:
            int r0 = r10.f841a
            int r1 = r12.g
            int r5 = r12.f841a
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.f841a
            int r0 = r0 - r3
            r12.f841a = r0
            com.bytedance.sdk.component.widget.recycler.e$z r0 = r7.z
            int r1 = r10.g
            java.lang.Object r5 = r12.dl
            com.bytedance.sdk.component.widget.recycler.z$g r0 = r0.z(r2, r1, r3, r5)
            goto L29
        L28:
            r0 = r4
        L29:
            int r1 = r10.g
            int r5 = r12.g
            if (r1 > r5) goto L35
            int r1 = r12.g
            int r1 = r1 + r3
            r12.g = r1
            goto L56
        L35:
            int r1 = r10.g
            int r5 = r12.g
            int r6 = r12.f841a
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.g
            int r4 = r12.f841a
            int r1 = r1 + r4
            int r4 = r10.g
            int r1 = r1 - r4
            com.bytedance.sdk.component.widget.recycler.e$z r4 = r7.z
            int r5 = r10.g
            int r5 = r5 + r3
            java.lang.Object r3 = r12.dl
            com.bytedance.sdk.component.widget.recycler.z$g r4 = r4.z(r2, r5, r1, r3)
            int r2 = r12.f841a
            int r2 = r2 - r1
            r12.f841a = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.f841a
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            com.bytedance.sdk.component.widget.recycler.e$z r10 = r7.z
            r10.z(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r4 == 0) goto L73
            r8.add(r9, r4)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.e.g(java.util.List, int, com.bytedance.sdk.component.widget.recycler.z$g, int, com.bytedance.sdk.component.widget.recycler.z$g):void");
    }

    private int g(List<z.g> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).z != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }
}
