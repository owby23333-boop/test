package com.bytedance.adsdk.ugeno.component.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class tg {
    static final /* synthetic */ boolean d = true;
    long[] bf;
    int[] e;
    private boolean[] ga;
    private final com.bytedance.adsdk.ugeno.component.flexbox.e tg;
    private long[] vn;

    public static class bf implements Comparable<bf> {
        int bf;
        int e;

        private bf() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(bf bfVar) {
            int i = this.bf;
            int i2 = bfVar.bf;
            return i != i2 ? i - i2 : this.e - bfVar.e;
        }

        public String toString() {
            return "Order{order=" + this.bf + ", index=" + this.e + '}';
        }
    }

    public static class e {
        int bf;
        List<d> e;

        public void e() {
            this.e = null;
            this.bf = 0;
        }
    }

    public tg(com.bytedance.adsdk.ugeno.component.flexbox.e eVar) {
        this.tg = eVar;
    }

    private int d(boolean z) {
        return z ? this.tg.getPaddingTop() : this.tg.getPaddingStart();
    }

    private int ga(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        return z ? bfVar.t() : bfVar.bh();
    }

    private int tg(boolean z) {
        return z ? this.tg.getPaddingBottom() : this.tg.getPaddingEnd();
    }

    private int vn(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        return z ? bfVar.w() : bfVar.s();
    }

    public int bf(long j) {
        return (int) (j >> 32);
    }

    public int e(long j) {
        return (int) j;
    }

    public long bf(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] e(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.tg.getFlexItemCount();
        List<bf> listBf = bf(flexItemCount);
        bf bfVar = new bf();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.component.flexbox.bf)) {
            bfVar.bf = 1;
        } else {
            bfVar.bf = ((com.bytedance.adsdk.ugeno.component.flexbox.bf) layoutParams).d();
        }
        if (i == -1 || i == flexItemCount || i >= this.tg.getFlexItemCount()) {
            bfVar.e = flexItemCount;
        } else {
            bfVar.e = i;
            while (i < flexItemCount) {
                listBf.get(i).e++;
                i++;
            }
        }
        listBf.add(bfVar);
        return e(flexItemCount + 1, listBf, sparseIntArray);
    }

    private List<bf> bf(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) this.tg.e(i2).getLayoutParams();
            bf bfVar2 = new bf();
            bfVar2.bf = bfVar.d();
            bfVar2.e = i2;
            arrayList.add(bfVar2);
        }
        return arrayList;
    }

    private int d(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        if (z) {
            return bfVar.bh();
        }
        return bfVar.t();
    }

    private int tg(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        if (z) {
            return bfVar.s();
        }
        return bfVar.w();
    }

    private void d(int i) {
        boolean[] zArr = this.ga;
        if (zArr == null) {
            this.ga = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.ga = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public boolean bf(SparseIntArray sparseIntArray) {
        int flexItemCount = this.tg.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewE = this.tg.e(i);
            if (viewE != null && ((com.bytedance.adsdk.ugeno.component.flexbox.bf) viewE.getLayoutParams()).d() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void bf(e eVar, int i, int i2) {
        e(eVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<d>) null);
    }

    private int bf(boolean z) {
        if (z) {
            return this.tg.getPaddingEnd();
        }
        return this.tg.getPaddingBottom();
    }

    public int[] e(SparseIntArray sparseIntArray) {
        int flexItemCount = this.tg.getFlexItemCount();
        return e(flexItemCount, bf(flexItemCount), sparseIntArray);
    }

    private int bf(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] e(int i, List<bf> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (bf bfVar : list) {
            int i3 = bfVar.e;
            iArr[i2] = i3;
            sparseIntArray.append(i3, bfVar.bf);
            i2++;
        }
        return iArr;
    }

    private int bf(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        if (z) {
            return bfVar.bf();
        }
        return bfVar.e();
    }

    private void bf(int i, int i2, d dVar, int i3, int i4, boolean z) {
        int i5;
        float f;
        int i6;
        int iMax;
        int i7 = dVar.ga;
        float f2 = dVar.wu;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i3 > i7) {
            return;
        }
        float f4 = (i7 - i3) / f2;
        dVar.ga = i4 + dVar.vn;
        if (!z) {
            dVar.p = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f5 = 0.0f;
        while (i8 < dVar.v) {
            int i10 = dVar.s + i8;
            View viewBf = this.tg.bf(i10);
            if (viewBf == null || viewBf.getVisibility() == 8) {
                i5 = i8;
                f = f3;
                i6 = i7;
            } else {
                com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) viewBf.getLayoutParams();
                int flexDirection = this.tg.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewBf.getMeasuredHeight();
                    long[] jArr = this.vn;
                    if (jArr != null) {
                        measuredHeight = bf(jArr[i10]);
                    }
                    int measuredWidth = viewBf.getMeasuredWidth();
                    long[] jArr2 = this.vn;
                    if (jArr2 != null) {
                        measuredWidth = e(jArr2[i10]);
                    }
                    if (this.ga[i10] || bfVar.ga() <= f3) {
                        i6 = i7;
                        i5 = i8;
                    } else {
                        float fGa = measuredHeight - (bfVar.ga() * f4);
                        if (i8 == dVar.v - 1) {
                            fGa += f5;
                            f5 = f3;
                        }
                        int iRound = Math.round(fGa);
                        if (iRound < bfVar.v()) {
                            iRound = bfVar.v();
                            this.ga[i10] = true;
                            dVar.wu -= bfVar.ga();
                            i6 = i7;
                            i5 = i8;
                            z2 = true;
                        } else {
                            f5 += fGa - iRound;
                            i6 = i7;
                            i5 = i8;
                            double d2 = f5;
                            if (d2 > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                        }
                        int iE = e(i, bfVar, dVar.bh);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewBf.measure(iE, iMakeMeasureSpec);
                        measuredWidth = viewBf.getMeasuredWidth();
                        int measuredHeight2 = viewBf.getMeasuredHeight();
                        e(i10, iE, iMakeMeasureSpec, viewBf);
                        this.tg.e(i10, viewBf);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i9, measuredWidth + bfVar.bh() + bfVar.s() + this.tg.e(viewBf));
                    dVar.ga += measuredHeight + bfVar.t() + bfVar.w();
                    f = 0.0f;
                } else {
                    i6 = i7;
                    i5 = i8;
                    int measuredWidth2 = viewBf.getMeasuredWidth();
                    long[] jArr3 = this.vn;
                    if (jArr3 != null) {
                        measuredWidth2 = e(jArr3[i10]);
                    }
                    int measuredHeight3 = viewBf.getMeasuredHeight();
                    long[] jArr4 = this.vn;
                    if (jArr4 != null) {
                        measuredHeight3 = bf(jArr4[i10]);
                    }
                    if (this.ga[i10]) {
                        f = 0.0f;
                    } else {
                        f = 0.0f;
                        if (bfVar.ga() > 0.0f) {
                            float fGa2 = measuredWidth2 - (bfVar.ga() * f4);
                            if (i5 == dVar.v - 1) {
                                fGa2 += f5;
                                f5 = 0.0f;
                            }
                            int iRound2 = Math.round(fGa2);
                            if (iRound2 < bfVar.p()) {
                                iRound2 = bfVar.p();
                                z2 = true;
                                this.ga[i10] = true;
                                dVar.wu -= bfVar.ga();
                            } else {
                                f5 += fGa2 - iRound2;
                                double d3 = f5;
                                if (d3 > 1.0d) {
                                    iRound2++;
                                    f5 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    iRound2--;
                                    f5 += 1.0f;
                                }
                            }
                            int iBf = bf(i2, bfVar, dVar.bh);
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                            viewBf.measure(iMakeMeasureSpec2, iBf);
                            int measuredWidth3 = viewBf.getMeasuredWidth();
                            int measuredHeight4 = viewBf.getMeasuredHeight();
                            e(i10, iMakeMeasureSpec2, iBf, viewBf);
                            this.tg.e(i10, viewBf);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        }
                    }
                    int iMax2 = Math.max(i9, measuredHeight3 + bfVar.t() + bfVar.w() + this.tg.e(viewBf));
                    dVar.ga += measuredWidth2 + bfVar.bh() + bfVar.s();
                    iMax = iMax2;
                }
                dVar.p = Math.max(dVar.p, iMax);
                i9 = iMax;
            }
            i8 = i5 + 1;
            i7 = i6;
            f3 = f;
        }
        int i11 = i7;
        if (!z2 || i11 == dVar.ga) {
            return;
        }
        bf(i, i2, dVar, i3, i4, true);
    }

    public void e(e eVar, int i, int i2) {
        e(eVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<d>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(e eVar, int i, int i2, int i3, int i4, int i5, List<d> list) {
        int i6;
        e eVar2;
        int i7;
        int i8;
        int i9;
        List<d> list2;
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
        boolean zE = this.tg.e();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<d> arrayList = list == null ? new ArrayList() : list;
        eVar.e = arrayList;
        int i21 = i20 == -1 ? 1 : 0;
        int iE = e(zE);
        int iBf = bf(zE);
        int iD = d(zE);
        int iTg = tg(zE);
        d dVar = new d();
        int i22 = i4;
        dVar.s = i22;
        int i23 = iBf + iE;
        dVar.ga = i23;
        int flexItemCount = this.tg.getFlexItemCount();
        int i24 = i21;
        int i25 = Integer.MIN_VALUE;
        int i26 = 0;
        int iCombineMeasuredStates = 0;
        int i27 = 0;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                eVar2 = eVar;
                break;
            }
            View viewBf = this.tg.bf(i22);
            if (viewBf == null) {
                if (e(i22, flexItemCount, dVar)) {
                    e(arrayList, dVar, i22, i26);
                }
            } else if (viewBf.getVisibility() == 8) {
                dVar.zk++;
                dVar.v++;
                if (e(i22, flexItemCount, dVar)) {
                    e(arrayList, dVar, i22, i26);
                }
            } else {
                if (viewBf instanceof CompoundButton) {
                    e((CompoundButton) viewBf);
                }
                com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) viewBf.getLayoutParams();
                int i28 = flexItemCount;
                if (bfVar.vn() == 4) {
                    dVar.t.add(Integer.valueOf(i22));
                }
                int iE2 = e(bfVar, zE);
                if (bfVar.xu() != -1.0f && mode == 1073741824) {
                    iE2 = Math.round(size * bfVar.xu());
                }
                if (zE) {
                    int iE3 = this.tg.e(i18, i23 + d(bfVar, true) + tg(bfVar, true), iE2);
                    i7 = size;
                    i8 = mode;
                    int iBf2 = this.tg.bf(i19, iD + iTg + ga(bfVar, true) + vn(bfVar, true) + i26, bf(bfVar, true));
                    viewBf.measure(iE3, iBf2);
                    e(i22, iE3, iBf2, viewBf);
                    i9 = iE3;
                } else {
                    i7 = size;
                    i8 = mode;
                    int iE4 = this.tg.e(i19, iD + iTg + ga(bfVar, false) + vn(bfVar, false) + i26, bf(bfVar, false));
                    int iBf3 = this.tg.bf(i18, d(bfVar, false) + i23 + tg(bfVar, false), iE2);
                    viewBf.measure(iE4, iBf3);
                    e(i22, iE4, iBf3, viewBf);
                    i9 = iBf3;
                }
                this.tg.e(i22, viewBf);
                e(viewBf, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewBf.getMeasuredState());
                int i29 = i26;
                int i30 = i23;
                d dVar2 = dVar;
                int i31 = i22;
                list2 = arrayList;
                int i32 = i9;
                if (e(viewBf, i8, i7, dVar.ga, tg(bfVar, zE) + e(viewBf, zE) + d(bfVar, zE), bfVar, i31, i27, arrayList.size())) {
                    if (dVar2.bf() > 0) {
                        e(list2, dVar2, i31 > 0 ? i31 - 1 : 0, i29);
                        i26 = dVar2.p + i29;
                    } else {
                        i26 = i29;
                    }
                    if (zE) {
                        if (bfVar.bf() == -1) {
                            com.bytedance.adsdk.ugeno.component.flexbox.e eVar3 = this.tg;
                            i10 = i2;
                            i22 = i31;
                            view = viewBf;
                            view.measure(i32, eVar3.bf(i10, eVar3.getPaddingTop() + this.tg.getPaddingBottom() + bfVar.t() + bfVar.w() + i26, bfVar.bf()));
                            e(view, i22);
                        } else {
                            i10 = i2;
                            view = viewBf;
                            i22 = i31;
                        }
                    } else {
                        i10 = i2;
                        view = viewBf;
                        i22 = i31;
                        if (bfVar.e() == -1) {
                            com.bytedance.adsdk.ugeno.component.flexbox.e eVar4 = this.tg;
                            view.measure(eVar4.e(i10, eVar4.getPaddingLeft() + this.tg.getPaddingRight() + bfVar.bh() + bfVar.s() + i26, bfVar.e()), i32);
                            e(view, i22);
                        }
                    }
                    dVar = new d();
                    i12 = 1;
                    dVar.v = 1;
                    i11 = i30;
                    dVar.ga = i11;
                    dVar.s = i22;
                    i14 = Integer.MIN_VALUE;
                    i13 = 0;
                } else {
                    i10 = i2;
                    view = viewBf;
                    i22 = i31;
                    dVar = dVar2;
                    i11 = i30;
                    i12 = 1;
                    dVar.v++;
                    i13 = i27 + 1;
                    i26 = i29;
                    i14 = i25;
                }
                dVar.l = (dVar.l ? 1 : 0) | (bfVar.tg() != 0.0f ? i12 : 0);
                dVar.f = (dVar.f ? 1 : 0) | (bfVar.ga() != 0.0f ? i12 : 0);
                int[] iArr = this.e;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                dVar.ga += e(view, zE) + d(bfVar, zE) + tg(bfVar, zE);
                dVar.m += bfVar.tg();
                dVar.wu += bfVar.ga();
                this.tg.e(view, i22, i13, dVar);
                int iMax = Math.max(i14, bf(view, zE) + ga(bfVar, zE) + vn(bfVar, zE) + this.tg.e(view));
                dVar.p = Math.max(dVar.p, iMax);
                if (zE) {
                    if (this.tg.getFlexWrap() != 2) {
                        dVar.xu = Math.max(dVar.xu, view.getBaseline() + bfVar.t());
                    } else {
                        dVar.xu = Math.max(dVar.xu, (view.getMeasuredHeight() - view.getBaseline()) + bfVar.w());
                    }
                }
                i15 = i28;
                if (e(i22, i15, dVar)) {
                    e(list2, dVar, i22, i26);
                    i26 += dVar.p;
                }
                i16 = i5;
                if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).w < i16 || i22 < i16 || i24 != 0) {
                    i17 = i3;
                } else {
                    i26 = -dVar.e();
                    i17 = i3;
                    i24 = i12;
                }
                if (i26 > i17 && i24 != 0) {
                    eVar2 = eVar;
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
        eVar2.bf = i6;
    }

    private int bf(int i, com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, int i2) {
        com.bytedance.adsdk.ugeno.component.flexbox.e eVar = this.tg;
        int iBf = eVar.bf(i, eVar.getPaddingTop() + this.tg.getPaddingBottom() + bfVar.t() + bfVar.w() + i2, bfVar.bf());
        int size = View.MeasureSpec.getSize(iBf);
        if (size > bfVar.m()) {
            return View.MeasureSpec.makeMeasureSpec(bfVar.m(), View.MeasureSpec.getMode(iBf));
        }
        return size < bfVar.v() ? View.MeasureSpec.makeMeasureSpec(bfVar.v(), View.MeasureSpec.getMode(iBf)) : iBf;
    }

    public void bf(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.tg.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        }
        List<d> flexLinesInternal = this.tg.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.tg.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).p = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.tg.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    d dVar = new d();
                    dVar.p = i5;
                    flexLinesInternal.add(0, dVar);
                    return;
                }
                if (alignContent == 2) {
                    this.tg.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i4 < size4) {
                        arrayList.add(flexLinesInternal.get(i4));
                        if (i4 != flexLinesInternal.size() - 1) {
                            d dVar2 = new d();
                            if (i4 == flexLinesInternal.size() - 2) {
                                dVar2.p = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                dVar2.p = Math.round(size3);
                            }
                            int i6 = dVar2.p;
                            f += size3 - i6;
                            if (f > 1.0f) {
                                dVar2.p = i6 + 1;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                dVar2.p = i6 - 1;
                                f += 1.0f;
                            }
                            arrayList.add(dVar2);
                        }
                        i4++;
                    }
                    this.tg.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.tg.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    d dVar3 = new d();
                    dVar3.p = size5;
                    for (d dVar4 : flexLinesInternal) {
                        arrayList2.add(dVar3);
                        arrayList2.add(dVar4);
                        arrayList2.add(dVar3);
                    }
                    this.tg.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        d dVar5 = flexLinesInternal.get(i4);
                        float f3 = dVar5.p + size6;
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
                        dVar5.p = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private void e(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) compoundButton.getLayoutParams();
        int iP = bfVar.p();
        int iV = bfVar.v();
        Drawable drawableE = com.bytedance.adsdk.ugeno.tg.tg.e(compoundButton);
        int minimumWidth = drawableE == null ? 0 : drawableE.getMinimumWidth();
        int minimumHeight = drawableE != null ? drawableE.getMinimumHeight() : 0;
        if (iP == -1) {
            iP = minimumWidth;
        }
        bfVar.e(iP);
        if (iV == -1) {
            iV = minimumHeight;
        }
        bfVar.bf(iV);
    }

    private int e(boolean z) {
        if (z) {
            return this.tg.getPaddingStart();
        }
        return this.tg.getPaddingTop();
    }

    private int e(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private void bf(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - bfVar.bh()) - bfVar.s()) - this.tg.e(view), bfVar.p()), bfVar.zk());
        long[] jArr = this.vn;
        if (jArr != null) {
            measuredHeight = bf(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        e(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.tg.e(i2, view);
    }

    private int e(com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, boolean z) {
        if (z) {
            return bfVar.e();
        }
        return bfVar.bf();
    }

    private boolean e(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, int i5, int i6, int i7) {
        if (this.tg.getFlexWrap() == 0) {
            return false;
        }
        if (bfVar.wu()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.tg.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iE = this.tg.e(view, i5, i6);
        if (iE > 0) {
            i4 += iE;
        }
        return i2 < i3 + i4;
    }

    private boolean e(int i, int i2, d dVar) {
        return i == i2 - 1 && dVar.bf() != 0;
    }

    private void e(List<d> list, d dVar, int i, int i2) {
        dVar.bh = i2;
        this.tg.e(dVar);
        dVar.w = i;
        list.add(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.component.flexbox.bf r0 = (com.bytedance.adsdk.ugeno.component.flexbox.bf) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.p()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.p()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.zk()
            if (r1 <= r3) goto L26
            int r1 = r0.zk()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.v()
            if (r2 >= r5) goto L32
            int r2 = r0.v()
            goto L3e
        L32:
            int r5 = r0.m()
            if (r2 <= r5) goto L3d
            int r2 = r0.m()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.e(r8, r1, r0, r7)
            com.bytedance.adsdk.ugeno.component.flexbox.e r0 = r6.tg
            r0.e(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.component.flexbox.tg.e(android.view.View, int):void");
    }

    public void e(int i, int i2) {
        e(i, i2, 0);
    }

    public void e(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        d(this.tg.getFlexItemCount());
        if (i3 >= this.tg.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.tg.getFlexDirection();
        int flexDirection2 = this.tg.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = this.tg.getLargestMainSize();
            }
            paddingLeft = this.tg.getPaddingTop();
            paddingRight = this.tg.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.tg.getLargestMainSize();
            if (mode2 != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.tg.getPaddingLeft();
            paddingRight = this.tg.getPaddingRight();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.e;
        List<d> flexLinesInternal = this.tg.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            d dVar = flexLinesInternal.get(i5);
            int i6 = dVar.ga;
            if (i6 < size && dVar.l) {
                e(i, i2, dVar, size, i4, false);
            } else if (i6 > size && dVar.f) {
                bf(i, i2, dVar, size, i4, false);
            }
        }
    }

    private void e(int i, int i2, d dVar, int i3, int i4, boolean z) {
        int i5;
        float f;
        int i6;
        int iMax;
        double d2;
        double d3;
        float f2 = dVar.m;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i3 < (i5 = dVar.ga)) {
            return;
        }
        float f4 = (i3 - i5) / f2;
        dVar.ga = i4 + dVar.vn;
        if (!z) {
            dVar.p = Integer.MIN_VALUE;
        }
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        float f5 = 0.0f;
        while (i7 < dVar.v) {
            int i9 = dVar.s + i7;
            View viewBf = this.tg.bf(i9);
            if (viewBf == null || viewBf.getVisibility() == 8) {
                f = f3;
                i6 = i5;
            } else {
                com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) viewBf.getLayoutParams();
                int flexDirection = this.tg.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewBf.getMeasuredHeight();
                    long[] jArr = this.vn;
                    if (jArr != null) {
                        measuredHeight = bf(jArr[i9]);
                    }
                    int measuredWidth = viewBf.getMeasuredWidth();
                    long[] jArr2 = this.vn;
                    if (jArr2 != null) {
                        measuredWidth = e(jArr2[i9]);
                    }
                    if (this.ga[i9] || bfVar.tg() <= f3) {
                        i6 = i5;
                    } else {
                        float fTg = measuredHeight + (bfVar.tg() * f4);
                        if (i7 == dVar.v - 1) {
                            fTg += f5;
                            f5 = f3;
                        }
                        int iRound = Math.round(fTg);
                        if (iRound > bfVar.m()) {
                            iRound = bfVar.m();
                            this.ga[i9] = true;
                            dVar.m -= bfVar.tg();
                            i6 = i5;
                            z2 = true;
                        } else {
                            f5 += fTg - iRound;
                            i6 = i5;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                iRound++;
                                d3 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound--;
                                d3 = d4 + 1.0d;
                            }
                            f5 = (float) d3;
                        }
                        int iE = e(i, bfVar, dVar.bh);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewBf.measure(iE, iMakeMeasureSpec);
                        measuredWidth = viewBf.getMeasuredWidth();
                        int measuredHeight2 = viewBf.getMeasuredHeight();
                        e(i9, iE, iMakeMeasureSpec, viewBf);
                        this.tg.e(i9, viewBf);
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i8, measuredWidth + bfVar.bh() + bfVar.s() + this.tg.e(viewBf));
                    dVar.ga += measuredHeight + bfVar.t() + bfVar.w();
                    f = 0.0f;
                } else {
                    i6 = i5;
                    int measuredWidth2 = viewBf.getMeasuredWidth();
                    long[] jArr3 = this.vn;
                    if (jArr3 != null) {
                        measuredWidth2 = e(jArr3[i9]);
                    }
                    int measuredHeight3 = viewBf.getMeasuredHeight();
                    long[] jArr4 = this.vn;
                    if (jArr4 != null) {
                        measuredHeight3 = bf(jArr4[i9]);
                    }
                    if (this.ga[i9]) {
                        f = 0.0f;
                    } else {
                        f = 0.0f;
                        if (bfVar.tg() > 0.0f) {
                            float fTg2 = measuredWidth2 + (bfVar.tg() * f4);
                            if (i7 == dVar.v - 1) {
                                fTg2 += f5;
                                f5 = 0.0f;
                            }
                            int iRound2 = Math.round(fTg2);
                            if (iRound2 > bfVar.zk()) {
                                iRound2 = bfVar.zk();
                                z2 = true;
                                this.ga[i9] = true;
                                dVar.m -= bfVar.tg();
                            } else {
                                f5 += fTg2 - iRound2;
                                double d5 = f5;
                                if (d5 > 1.0d) {
                                    iRound2++;
                                    d2 = d5 - 1.0d;
                                } else if (d5 < -1.0d) {
                                    iRound2--;
                                    d2 = d5 + 1.0d;
                                }
                                f5 = (float) d2;
                            }
                            int iBf = bf(i2, bfVar, dVar.bh);
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                            viewBf.measure(iMakeMeasureSpec2, iBf);
                            int measuredWidth3 = viewBf.getMeasuredWidth();
                            int measuredHeight4 = viewBf.getMeasuredHeight();
                            e(i9, iMakeMeasureSpec2, iBf, viewBf);
                            this.tg.e(i9, viewBf);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        }
                    }
                    int iMax2 = Math.max(i8, measuredHeight3 + bfVar.t() + bfVar.w() + this.tg.e(viewBf));
                    dVar.ga += measuredWidth2 + bfVar.bh() + bfVar.s();
                    iMax = iMax2;
                }
                dVar.p = Math.max(dVar.p, iMax);
                i8 = iMax;
            }
            i7++;
            i5 = i6;
            f3 = f;
        }
        int i10 = i5;
        if (!z2 || i10 == dVar.ga) {
            return;
        }
        e(i, i2, dVar, i3, i4, true);
    }

    private int e(int i, com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar, int i2) {
        com.bytedance.adsdk.ugeno.component.flexbox.e eVar = this.tg;
        int iE = eVar.e(i, eVar.getPaddingLeft() + this.tg.getPaddingRight() + bfVar.bh() + bfVar.s() + i2, bfVar.e());
        int size = View.MeasureSpec.getSize(iE);
        if (size > bfVar.zk()) {
            return View.MeasureSpec.makeMeasureSpec(bfVar.zk(), View.MeasureSpec.getMode(iE));
        }
        return size < bfVar.p() ? View.MeasureSpec.makeMeasureSpec(bfVar.p(), View.MeasureSpec.getMode(iE)) : iE;
    }

    private List<d> e(List<d> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        dVar.p = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(dVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public void e() {
        e(0);
    }

    public void e(int i) {
        View viewBf;
        if (i >= this.tg.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.tg.getFlexDirection();
        if (this.tg.getAlignItems() == 4) {
            int[] iArr = this.e;
            List<d> flexLinesInternal = this.tg.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                d dVar = flexLinesInternal.get(i2);
                int i3 = dVar.v;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = dVar.s + i4;
                    if (i4 < this.tg.getFlexItemCount() && (viewBf = this.tg.bf(i5)) != null && viewBf.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) viewBf.getLayoutParams();
                        if (bfVar.vn() == -1 || bfVar.vn() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                bf(viewBf, dVar.p, i5);
                            } else {
                                e(viewBf, dVar.p, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (d dVar2 : this.tg.getFlexLinesInternal()) {
            for (Integer num : dVar2.t) {
                View viewBf2 = this.tg.bf(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    bf(viewBf2, dVar2.p, num.intValue());
                } else {
                    e(viewBf2, dVar2.p, num.intValue());
                }
            }
        }
    }

    private void e(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - bfVar.t()) - bfVar.w()) - this.tg.e(view), bfVar.v()), bfVar.m());
        long[] jArr = this.vn;
        if (jArr != null) {
            measuredWidth = e(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        e(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.tg.e(i2, view);
    }

    public void e(View view, d dVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) view.getLayoutParams();
        int alignItems = this.tg.getAlignItems();
        if (bfVar.vn() != -1) {
            alignItems = bfVar.vn();
        }
        int i5 = dVar.p;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.tg.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - bfVar.w(), i3, i6 - bfVar.w());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + bfVar.t(), i3, (i4 - i5) + view.getMeasuredHeight() + bfVar.t());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + bfVar.t()) - bfVar.w()) / 2;
                if (this.tg.getFlexWrap() != 2) {
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
                if (this.tg.getFlexWrap() != 2) {
                    int iMax = Math.max(dVar.xu - view.getBaseline(), bfVar.t());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((dVar.xu - view.getMeasuredHeight()) + view.getBaseline(), bfVar.w());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.tg.getFlexWrap() != 2) {
            view.layout(i, i2 + bfVar.t(), i3, i4 + bfVar.t());
        } else {
            view.layout(i, i2 - bfVar.w(), i3, i4 - bfVar.w());
        }
    }

    public void e(View view, d dVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.component.flexbox.bf bfVar = (com.bytedance.adsdk.ugeno.component.flexbox.bf) view.getLayoutParams();
        int alignItems = this.tg.getAlignItems();
        if (bfVar.vn() != -1) {
            alignItems = bfVar.vn();
        }
        int i5 = dVar.p;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - bfVar.s(), i2, ((i3 + i5) - view.getMeasuredWidth()) - bfVar.s(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + bfVar.bh(), i2, (i3 - i5) + view.getMeasuredWidth() + bfVar.bh(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.tg.ga.e(marginLayoutParams)) - com.bytedance.adsdk.ugeno.tg.ga.bf(marginLayoutParams)) / 2;
                if (!z) {
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
        if (!z) {
            view.layout(i + bfVar.bh(), i2, i3 + bfVar.bh(), i4);
        } else {
            view.layout(i - bfVar.s(), i2, i3 - bfVar.s(), i4);
        }
    }

    private void e(int i, int i2, int i3, View view) {
        long[] jArr = this.bf;
        if (jArr != null) {
            jArr[i] = bf(i2, i3);
        }
        long[] jArr2 = this.vn;
        if (jArr2 != null) {
            jArr2[i] = bf(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
