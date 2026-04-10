package com.bytedance.adsdk.ugeno.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.adsdk.ugeno.m.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class a {
    static final /* synthetic */ boolean dl = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.ugeno.flexbox.z f237a;
    long[] g;
    private boolean[] gc;
    private long[] m;
    int[] z;

    int g(long j) {
        return (int) (j >> 32);
    }

    long g(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    int z(long j) {
        return (int) j;
    }

    a(com.bytedance.adsdk.ugeno.flexbox.z zVar) {
        this.f237a = zVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] z(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f237a.getFlexItemCount();
        List<g> listG = g(flexItemCount);
        g gVar = new g();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.g)) {
            gVar.g = ((com.bytedance.adsdk.ugeno.flexbox.g) layoutParams).dl();
        } else {
            gVar.g = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.f237a.getFlexItemCount()) {
            gVar.z = i;
            while (i < flexItemCount) {
                listG.get(i).z++;
                i++;
            }
        } else {
            gVar.z = flexItemCount;
        }
        listG.add(gVar);
        return z(flexItemCount + 1, listG, sparseIntArray);
    }

    int[] z(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f237a.getFlexItemCount();
        return z(flexItemCount, g(flexItemCount), sparseIntArray);
    }

    private List<g> g(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) this.f237a.z(i2).getLayoutParams();
            g gVar2 = new g();
            gVar2.g = gVar.dl();
            gVar2.z = i2;
            arrayList.add(gVar2);
        }
        return arrayList;
    }

    boolean g(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f237a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewZ = this.f237a.z(i);
            if (viewZ != null && ((com.bytedance.adsdk.ugeno.flexbox.g) viewZ.getLayoutParams()).dl() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] z(int i, List<g> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (g gVar : list) {
            iArr[i2] = gVar.z;
            sparseIntArray.append(gVar.z, gVar.g);
            i2++;
        }
        return iArr;
    }

    void z(z zVar, int i, int i2) {
        z(zVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<dl>) null);
    }

    void g(z zVar, int i, int i2) {
        z(zVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<dl>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void z(z zVar, int i, int i2, int i3, int i4, int i5, List<dl> list) {
        int i6;
        z zVar2;
        int i7;
        int i8;
        int i9;
        List<dl> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i;
        int i19 = i2;
        int i20 = i5;
        boolean z2 = this.f237a.z();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<dl> arrayList = list == null ? new ArrayList() : list;
        zVar.z = arrayList;
        int i21 = i20 == -1 ? 1 : 0;
        int iZ = z(z2);
        int iG = g(z2);
        int iDl = dl(z2);
        int iA = a(z2);
        dl dlVar = new dl();
        int i22 = i4;
        dlVar.pf = i22;
        int i23 = iG + iZ;
        dlVar.gc = i23;
        int flexItemCount = this.f237a.getFlexItemCount();
        int i24 = i21;
        int i25 = Integer.MIN_VALUE;
        int i26 = 0;
        int iCombineMeasuredStates = 0;
        int i27 = 0;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                zVar2 = zVar;
                break;
            }
            View viewG = this.f237a.g(i22);
            if (viewG == null) {
                if (z(i22, flexItemCount, dlVar)) {
                    z(arrayList, dlVar, i22, i26);
                }
            } else if (viewG.getVisibility() == 8) {
                dlVar.fo++;
                dlVar.gz++;
                if (z(i22, flexItemCount, dlVar)) {
                    z(arrayList, dlVar, i22, i26);
                }
            } else {
                if (viewG instanceof CompoundButton) {
                    z((CompoundButton) viewG);
                }
                com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) viewG.getLayoutParams();
                int i28 = flexItemCount;
                if (gVar.m() == 4) {
                    dlVar.v.add(Integer.valueOf(i22));
                }
                int iZ2 = z(gVar, z2);
                if (gVar.wp() != -1.0f && mode == 1073741824) {
                    iZ2 = Math.round(size * gVar.wp());
                }
                if (z2) {
                    int iZ3 = this.f237a.z(i18, i23 + dl(gVar, true) + a(gVar, true), iZ2);
                    i7 = size;
                    i8 = mode;
                    int iG2 = this.f237a.g(i19, iDl + iA + gc(gVar, true) + m(gVar, true) + i26, g(gVar, true));
                    viewG.measure(iZ3, iG2);
                    z(i22, iZ3, iG2, viewG);
                    i9 = iZ3;
                } else {
                    i7 = size;
                    i8 = mode;
                    int iZ4 = this.f237a.z(i19, iDl + iA + gc(gVar, false) + m(gVar, false) + i26, g(gVar, false));
                    int iG3 = this.f237a.g(i18, dl(gVar, false) + i23 + a(gVar, false), iZ2);
                    viewG.measure(iZ4, iG3);
                    z(i22, iZ4, iG3, viewG);
                    i9 = iG3;
                }
                z(viewG, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewG.getMeasuredState());
                int i29 = i26;
                int i30 = i23;
                dl dlVar2 = dlVar;
                int i31 = i22;
                list2 = arrayList;
                int i32 = i9;
                if (z(viewG, i8, i7, dlVar.gc, a(gVar, z2) + z(viewG, z2) + dl(gVar, z2), gVar, i31, i27, arrayList.size())) {
                    if (dlVar2.g() > 0) {
                        z(list2, dlVar2, i31 > 0 ? i31 - 1 : 0, i29);
                        i26 = dlVar2.e + i29;
                    } else {
                        i26 = i29;
                    }
                    if (z2) {
                        if (gVar.g() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.z zVar3 = this.f237a;
                            i10 = i2;
                            i22 = i31;
                            view = viewG;
                            view.measure(i32, zVar3.g(i10, zVar3.getPaddingTop() + this.f237a.getPaddingBottom() + gVar.v() + gVar.ls() + i26, gVar.g()));
                            z(view, i22);
                        } else {
                            i10 = i2;
                            view = viewG;
                            i22 = i31;
                        }
                    } else {
                        i10 = i2;
                        view = viewG;
                        i22 = i31;
                        if (gVar.z() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.z zVar4 = this.f237a;
                            view.measure(zVar4.z(i10, zVar4.getPaddingLeft() + this.f237a.getPaddingRight() + gVar.i() + gVar.pf() + i26, gVar.z()), i32);
                            z(view, i22);
                        }
                    }
                    dlVar = new dl();
                    i12 = 1;
                    dlVar.gz = 1;
                    i11 = i30;
                    dlVar.gc = i11;
                    dlVar.pf = i22;
                    i14 = Integer.MIN_VALUE;
                    i13 = 0;
                } else {
                    i10 = i2;
                    view = viewG;
                    i22 = i31;
                    dlVar = dlVar2;
                    i11 = i30;
                    i12 = 1;
                    dlVar.gz++;
                    i13 = i27 + 1;
                    i26 = i29;
                    i14 = i25;
                }
                dlVar.p = (dlVar.p ? 1 : 0) | (gVar.a() != 0.0f ? i12 : 0);
                dlVar.fv = (dlVar.fv ? 1 : 0) | (gVar.gc() != 0.0f ? i12 : 0);
                int[] iArr = this.z;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                dlVar.gc += z(view, z2) + dl(gVar, z2) + a(gVar, z2);
                dlVar.uy += gVar.a();
                dlVar.kb += gVar.gc();
                this.f237a.z(view, i22, i13, dlVar);
                int iMax = Math.max(i14, g(view, z2) + gc(gVar, z2) + m(gVar, z2) + this.f237a.z(view));
                dlVar.e = Math.max(dlVar.e, iMax);
                if (z2) {
                    if (this.f237a.getFlexWrap() != 2) {
                        dlVar.wp = Math.max(dlVar.wp, view.getBaseline() + gVar.v());
                    } else {
                        dlVar.wp = Math.max(dlVar.wp, (view.getMeasuredHeight() - view.getBaseline()) + gVar.ls());
                    }
                }
                i15 = i28;
                if (z(i22, i15, dlVar)) {
                    z(list2, dlVar, i22, i26);
                    i26 += dlVar.e;
                }
                i16 = i5;
                if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).ls < i16 || i22 < i16 || i24 != 0) {
                    i17 = i3;
                } else {
                    i26 = -dlVar.z();
                    i17 = i3;
                    i24 = i12;
                }
                if (i26 > i17 && i24 != 0) {
                    zVar2 = zVar;
                    i6 = iCombineMeasuredStates;
                    break;
                }
                i27 = i13;
                i25 = iMax;
                i22++;
                i18 = i;
                flexItemCount = i15;
                i19 = i10;
                i23 = i11;
                arrayList = list2;
                size = i7;
                i20 = i16;
                mode = i8;
            }
            i7 = size;
            i8 = mode;
            i10 = i19;
            i16 = i20;
            list2 = arrayList;
            i11 = i23;
            i15 = flexItemCount;
            i22++;
            i18 = i;
            flexItemCount = i15;
            i19 = i10;
            i23 = i11;
            arrayList = list2;
            size = i7;
            i20 = i16;
            mode = i8;
        }
        zVar2.g = i6;
    }

    private void z(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) compoundButton.getLayoutParams();
        int iE = gVar.e();
        int iGz = gVar.gz();
        Drawable drawableZ = com.bytedance.adsdk.ugeno.m.gc.z(compoundButton);
        int minimumWidth = drawableZ == null ? 0 : drawableZ.getMinimumWidth();
        int minimumHeight = drawableZ != null ? drawableZ.getMinimumHeight() : 0;
        if (iE == -1) {
            iE = minimumWidth;
        }
        gVar.z(iE);
        if (iGz == -1) {
            iGz = minimumHeight;
        }
        gVar.g(iGz);
    }

    private int z(boolean z2) {
        if (z2) {
            return this.f237a.getPaddingStart();
        }
        return this.f237a.getPaddingTop();
    }

    private int g(boolean z2) {
        if (z2) {
            return this.f237a.getPaddingEnd();
        }
        return this.f237a.getPaddingBottom();
    }

    private int dl(boolean z2) {
        if (z2) {
            return this.f237a.getPaddingTop();
        }
        return this.f237a.getPaddingStart();
    }

    private int a(boolean z2) {
        if (z2) {
            return this.f237a.getPaddingBottom();
        }
        return this.f237a.getPaddingEnd();
    }

    private int z(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int g(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int z(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.z();
        }
        return gVar.g();
    }

    private int g(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.g();
        }
        return gVar.z();
    }

    private int dl(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.i();
        }
        return gVar.v();
    }

    private int a(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.pf();
        }
        return gVar.ls();
    }

    private int gc(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.v();
        }
        return gVar.i();
    }

    private int m(com.bytedance.adsdk.ugeno.flexbox.g gVar, boolean z2) {
        if (z2) {
            return gVar.ls();
        }
        return gVar.pf();
    }

    private boolean z(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.flexbox.g gVar, int i5, int i6, int i7) {
        if (this.f237a.getFlexWrap() == 0) {
            return false;
        }
        if (gVar.kb()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.f237a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iZ = this.f237a.z(view, i5, i6);
        if (iZ > 0) {
            i4 += iZ;
        }
        return i2 < i3 + i4;
    }

    private boolean z(int i, int i2, dl dlVar) {
        return i == i2 - 1 && dlVar.g() != 0;
    }

    private void z(List<dl> list, dl dlVar, int i, int i2) {
        dlVar.i = i2;
        this.f237a.z(dlVar);
        dlVar.ls = i;
        list.add(dlVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.flexbox.g r0 = (com.bytedance.adsdk.ugeno.flexbox.g) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.e()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.e()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.fo()
            if (r1 <= r3) goto L26
            int r1 = r0.fo()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.gz()
            if (r2 >= r5) goto L32
            int r2 = r0.gz()
            goto L3e
        L32:
            int r5 = r0.uy()
            if (r2 <= r5) goto L3d
            int r2 = r0.uy()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.z(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.a.z(android.view.View, int):void");
    }

    void z(int i, int i2) {
        z(i, i2, 0);
    }

    void z(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        dl(this.f237a.getFlexItemCount());
        if (i3 >= this.f237a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f237a.getFlexDirection();
        int flexDirection2 = this.f237a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f237a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f237a.getPaddingLeft();
            paddingRight = this.f237a.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.f237a.getLargestMainSize();
            }
            paddingLeft = this.f237a.getPaddingTop();
            paddingRight = this.f237a.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.z;
        List<dl> flexLinesInternal = this.f237a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            dl dlVar = flexLinesInternal.get(i5);
            if (dlVar.gc < size && dlVar.p) {
                z(i, i2, dlVar, size, i4, false);
            } else if (dlVar.gc > size && dlVar.fv) {
                g(i, i2, dlVar, size, i4, false);
            }
        }
    }

    private void dl(int i) {
        boolean[] zArr = this.gc;
        if (zArr == null) {
            this.gc = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.gc = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void z(int i, int i2, dl dlVar, int i3, int i4, boolean z2) {
        int i5;
        int iMax;
        double d;
        int i6;
        double d2;
        float f = 0.0f;
        if (dlVar.uy <= 0.0f || i3 < dlVar.gc) {
            return;
        }
        int i7 = dlVar.gc;
        float f2 = (i3 - dlVar.gc) / dlVar.uy;
        dlVar.gc = i4 + dlVar.m;
        if (!z2) {
            dlVar.e = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z3 = false;
        int i9 = 0;
        while (i8 < dlVar.gz) {
            int i10 = dlVar.pf + i8;
            View viewG = this.f237a.g(i10);
            if (viewG == null || viewG.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) viewG.getLayoutParams();
                int flexDirection = this.f237a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewG.getMeasuredWidth();
                    long[] jArr = this.m;
                    if (jArr != null) {
                        measuredWidth = z(jArr[i10]);
                    }
                    int measuredHeight = viewG.getMeasuredHeight();
                    long[] jArr2 = this.m;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = g(jArr2[i10]);
                    }
                    if (!this.gc[i10] && gVar.a() > 0.0f) {
                        float fA = measuredWidth + (gVar.a() * f2);
                        if (i8 == dlVar.gz - 1) {
                            fA += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fA);
                        if (iRound > gVar.fo()) {
                            iRound = gVar.fo();
                            this.gc[i10] = true;
                            dlVar.uy -= gVar.a();
                            z3 = true;
                        } else {
                            f3 += fA - iRound;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f3 = (float) d;
                        }
                        int iG = g(i2, gVar, dlVar.i);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewG.measure(iMakeMeasureSpec, iG);
                        int measuredWidth2 = viewG.getMeasuredWidth();
                        int measuredHeight2 = viewG.getMeasuredHeight();
                        z(i10, iMakeMeasureSpec, iG, viewG);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + gVar.v() + gVar.ls() + this.f237a.z(viewG));
                    dlVar.gc += measuredWidth + gVar.i() + gVar.pf();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewG.getMeasuredHeight();
                    long[] jArr3 = this.m;
                    if (jArr3 != null) {
                        measuredHeight3 = g(jArr3[i10]);
                    }
                    int measuredWidth3 = viewG.getMeasuredWidth();
                    long[] jArr4 = this.m;
                    if (jArr4 != null) {
                        measuredWidth3 = z(jArr4[i10]);
                    }
                    if (this.gc[i10] || gVar.a() <= f) {
                        i6 = i7;
                    } else {
                        float fA2 = measuredHeight3 + (gVar.a() * f2);
                        if (i8 == dlVar.gz - 1) {
                            fA2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fA2);
                        if (iRound2 > gVar.uy()) {
                            iRound2 = gVar.uy();
                            this.gc[i10] = true;
                            dlVar.uy -= gVar.a();
                            i6 = i7;
                            z3 = true;
                        } else {
                            f3 += fA2 - iRound2;
                            i6 = i7;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int iZ = z(i, gVar, dlVar.i);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewG.measure(iZ, iMakeMeasureSpec2);
                        measuredWidth3 = viewG.getMeasuredWidth();
                        int measuredHeight4 = viewG.getMeasuredHeight();
                        z(i10, iZ, iMakeMeasureSpec2, viewG);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + gVar.i() + gVar.pf() + this.f237a.z(viewG));
                    dlVar.gc += measuredHeight3 + gVar.v() + gVar.ls();
                    i5 = i6;
                }
                dlVar.e = Math.max(dlVar.e, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z3 || i12 == dlVar.gc) {
            return;
        }
        z(i, i2, dlVar, i3, i4, true);
    }

    private void g(int i, int i2, dl dlVar, int i3, int i4, boolean z2) {
        int i5;
        int iMax;
        int i6 = dlVar.gc;
        float f = 0.0f;
        if (dlVar.kb <= 0.0f || i3 > dlVar.gc) {
            return;
        }
        float f2 = (dlVar.gc - i3) / dlVar.kb;
        dlVar.gc = i4 + dlVar.m;
        if (!z2) {
            dlVar.e = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z3 = false;
        int i8 = 0;
        while (i7 < dlVar.gz) {
            int i9 = dlVar.pf + i7;
            View viewG = this.f237a.g(i9);
            if (viewG == null || viewG.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) viewG.getLayoutParams();
                int flexDirection = this.f237a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewG.getMeasuredWidth();
                    long[] jArr = this.m;
                    if (jArr != null) {
                        measuredWidth = z(jArr[i9]);
                    }
                    int measuredHeight = viewG.getMeasuredHeight();
                    long[] jArr2 = this.m;
                    if (jArr2 != null) {
                        measuredHeight = g(jArr2[i9]);
                    }
                    if (!this.gc[i9] && gVar.gc() > 0.0f) {
                        float fGc = measuredWidth - (gVar.gc() * f2);
                        if (i5 == dlVar.gz - 1) {
                            fGc += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fGc);
                        if (iRound < gVar.e()) {
                            iRound = gVar.e();
                            this.gc[i9] = true;
                            dlVar.kb -= gVar.gc();
                            z3 = true;
                        } else {
                            f3 += fGc - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iG = g(i2, gVar, dlVar.i);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewG.measure(iMakeMeasureSpec, iG);
                        int measuredWidth2 = viewG.getMeasuredWidth();
                        int measuredHeight2 = viewG.getMeasuredHeight();
                        z(i9, iMakeMeasureSpec, iG, viewG);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + gVar.v() + gVar.ls() + this.f237a.z(viewG));
                    dlVar.gc += measuredWidth + gVar.i() + gVar.pf();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewG.getMeasuredHeight();
                    long[] jArr3 = this.m;
                    if (jArr3 != null) {
                        measuredHeight3 = g(jArr3[i9]);
                    }
                    int measuredWidth3 = viewG.getMeasuredWidth();
                    long[] jArr4 = this.m;
                    if (jArr4 != null) {
                        measuredWidth3 = z(jArr4[i9]);
                    }
                    if (this.gc[i9] || gVar.gc() <= f) {
                        i5 = i7;
                    } else {
                        float fGc2 = measuredHeight3 - (gVar.gc() * f2);
                        if (i7 == dlVar.gz - 1) {
                            fGc2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fGc2);
                        if (iRound2 < gVar.gz()) {
                            iRound2 = gVar.gz();
                            this.gc[i9] = true;
                            dlVar.kb -= gVar.gc();
                            i5 = i7;
                            z3 = true;
                        } else {
                            f3 += fGc2 - iRound2;
                            i5 = i7;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int iZ = z(i, gVar, dlVar.i);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewG.measure(iZ, iMakeMeasureSpec2);
                        measuredWidth3 = viewG.getMeasuredWidth();
                        int measuredHeight4 = viewG.getMeasuredHeight();
                        z(i9, iZ, iMakeMeasureSpec2, viewG);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + gVar.i() + gVar.pf() + this.f237a.z(viewG));
                    dlVar.gc += measuredHeight3 + gVar.v() + gVar.ls();
                }
                dlVar.e = Math.max(dlVar.e, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z3 || i6 == dlVar.gc) {
            return;
        }
        g(i, i2, dlVar, i3, i4, true);
    }

    private int z(int i, com.bytedance.adsdk.ugeno.flexbox.g gVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.z zVar = this.f237a;
        int iZ = zVar.z(i, zVar.getPaddingLeft() + this.f237a.getPaddingRight() + gVar.i() + gVar.pf() + i2, gVar.z());
        int size = View.MeasureSpec.getSize(iZ);
        if (size > gVar.fo()) {
            return View.MeasureSpec.makeMeasureSpec(gVar.fo(), View.MeasureSpec.getMode(iZ));
        }
        return size < gVar.e() ? View.MeasureSpec.makeMeasureSpec(gVar.e(), View.MeasureSpec.getMode(iZ)) : iZ;
    }

    private int g(int i, com.bytedance.adsdk.ugeno.flexbox.g gVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.z zVar = this.f237a;
        int iG = zVar.g(i, zVar.getPaddingTop() + this.f237a.getPaddingBottom() + gVar.v() + gVar.ls() + i2, gVar.g());
        int size = View.MeasureSpec.getSize(iG);
        if (size > gVar.uy()) {
            return View.MeasureSpec.makeMeasureSpec(gVar.uy(), View.MeasureSpec.getMode(iG));
        }
        return size < gVar.gz() ? View.MeasureSpec.makeMeasureSpec(gVar.gz(), View.MeasureSpec.getMode(iG)) : iG;
    }

    void g(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.f237a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<dl> flexLinesInternal = this.f237a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f237a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).e = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f237a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    dl dlVar = new dl();
                    dlVar.e = i5;
                    flexLinesInternal.add(0, dlVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f237a.setFlexLines(z(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                dl dlVar2 = new dl();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    dlVar2.e = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    dlVar2.e = Math.round(size3);
                                }
                                f += size3 - dlVar2.e;
                                if (f > 1.0f) {
                                    dlVar2.e++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    dlVar2.e--;
                                    f += 1.0f;
                                }
                                arrayList.add(dlVar2);
                            }
                            i4++;
                        }
                        this.f237a.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f237a.setFlexLines(z(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    dl dlVar3 = new dl();
                    dlVar3.e = size5;
                    for (dl dlVar4 : flexLinesInternal) {
                        arrayList2.add(dlVar3);
                        arrayList2.add(dlVar4);
                        arrayList2.add(dlVar3);
                    }
                    this.f237a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        dl dlVar5 = flexLinesInternal.get(i4);
                        float f3 = dlVar5.e + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        dlVar5.e = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<dl> z(List<dl> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        dl dlVar = new dl();
        dlVar.e = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(dlVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(dlVar);
            }
        }
        return arrayList;
    }

    void z() {
        z(0);
    }

    void z(int i) {
        View viewG;
        if (i >= this.f237a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f237a.getFlexDirection();
        if (this.f237a.getAlignItems() == 4) {
            int[] iArr = this.z;
            List<dl> flexLinesInternal = this.f237a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                dl dlVar = flexLinesInternal.get(i2);
                int i3 = dlVar.gz;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = dlVar.pf + i4;
                    if (i4 < this.f237a.getFlexItemCount() && (viewG = this.f237a.g(i5)) != null && viewG.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) viewG.getLayoutParams();
                        if (gVar.m() == -1 || gVar.m() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                z(viewG, dlVar.e, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                g(viewG, dlVar.e, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (dl dlVar2 : this.f237a.getFlexLinesInternal()) {
            for (Integer num : dlVar2.v) {
                View viewG2 = this.f237a.g(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    z(viewG2, dlVar2.e, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    g(viewG2, dlVar2.e, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void z(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - gVar.v()) - gVar.ls()) - this.f237a.z(view), gVar.gz()), gVar.uy());
        long[] jArr = this.m;
        if (jArr != null) {
            measuredWidth = z(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        z(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void g(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - gVar.i()) - gVar.pf()) - this.f237a.z(view), gVar.e()), gVar.fo());
        long[] jArr = this.m;
        if (jArr != null) {
            measuredHeight = g(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        z(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    void z(View view, dl dlVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) view.getLayoutParams();
        int alignItems = this.f237a.getAlignItems();
        if (gVar.m() != -1) {
            alignItems = gVar.m();
        }
        int i5 = dlVar.e;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f237a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - gVar.ls(), i3, i6 - gVar.ls());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + gVar.v(), i3, (i4 - i5) + view.getMeasuredHeight() + gVar.v());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + gVar.v()) - gVar.ls()) / 2;
                if (this.f237a.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f237a.getFlexWrap() != 2) {
                    int iMax = Math.max(dlVar.wp - view.getBaseline(), gVar.v());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((dlVar.wp - view.getMeasuredHeight()) + view.getBaseline(), gVar.ls());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f237a.getFlexWrap() != 2) {
            view.layout(i, i2 + gVar.v(), i3, i4 + gVar.v());
        } else {
            view.layout(i, i2 - gVar.ls(), i3, i4 - gVar.ls());
        }
    }

    void z(View view, dl dlVar, boolean z2, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.g gVar = (com.bytedance.adsdk.ugeno.flexbox.g) view.getLayoutParams();
        int alignItems = this.f237a.getAlignItems();
        if (gVar.m() != -1) {
            alignItems = gVar.m();
        }
        int i5 = dlVar.e;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z2) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - gVar.pf(), i2, ((i3 + i5) - view.getMeasuredWidth()) - gVar.pf(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + gVar.i(), i2, (i3 - i5) + view.getMeasuredWidth() + gVar.i(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + m.z(marginLayoutParams)) - m.g(marginLayoutParams)) / 2;
                if (!z2) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z2) {
            view.layout(i + gVar.i(), i2, i3 + gVar.i(), i4);
        } else {
            view.layout(i - gVar.pf(), i2, i3 - gVar.pf(), i4);
        }
    }

    private void z(int i, int i2, int i3, View view) {
        long[] jArr = this.g;
        if (jArr != null) {
            jArr[i] = g(i2, i3);
        }
        long[] jArr2 = this.m;
        if (jArr2 != null) {
            jArr2[i] = g(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class g implements Comparable<g> {
        int g;
        int z;

        private g() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            int i = this.g;
            int i2 = gVar.g;
            return i != i2 ? i - i2 : this.z - gVar.z;
        }

        public String toString() {
            return "Order{order=" + this.g + ", index=" + this.z + '}';
        }
    }

    static class z {
        int g;
        List<dl> z;

        z() {
        }

        void z() {
            this.z = null;
            this.g = 0;
        }
    }
}
