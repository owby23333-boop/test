package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.a;
import com.bytedance.adsdk.ugeno.m.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f235a;
    private int dl;
    private Drawable e;
    private int fo;
    private a.z fv;
    private int g;
    private int gc;
    private Drawable gz;
    private int[] i;
    private int kb;
    private List<dl> ls;
    private int m;
    private com.bytedance.adsdk.ugeno.dl p;
    private a pf;
    private int uy;
    private SparseIntArray v;
    private int wp;
    private int z;

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int z(View view) {
        return 0;
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.m = -1;
        this.pf = new a(this);
        this.ls = new ArrayList();
        this.fv = new a.z();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            z(iArrZ[0], iArrZ[1]);
        } else {
            z(i, i2);
        }
        com.bytedance.adsdk.ugeno.dl dlVar2 = this.p;
        if (dlVar2 != null) {
            dlVar2.dl();
        }
    }

    private void z(int i, int i2) {
        if (this.v == null) {
            this.v = new SparseIntArray(getChildCount());
        }
        if (this.pf.g(this.v)) {
            this.i = this.pf.z(this.v);
        }
        int i3 = this.z;
        if (i3 == 0 || i3 == 1) {
            g(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                dl(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.z);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public View z(int i) {
        return getChildAt(i);
    }

    public View dl(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.i;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public View g(int i) {
        return dl(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.v == null) {
            this.v = new SparseIntArray(getChildCount());
        }
        this.i = this.pf.z(view, i, layoutParams, this.v);
        super.addView(view, i, layoutParams);
    }

    private void g(int i, int i2) {
        this.ls.clear();
        this.fv.z();
        this.pf.z(this.fv, i, i2);
        this.ls = this.fv.z;
        this.pf.z(i, i2);
        if (this.f235a == 3) {
            for (dl dlVar : this.ls) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < dlVar.gz; i3++) {
                    View viewDl = dl(dlVar.pf + i3);
                    if (viewDl != null && viewDl.getVisibility() != 8) {
                        z zVar = (z) viewDl.getLayoutParams();
                        if (this.g != 2) {
                            iMax = Math.max(iMax, viewDl.getMeasuredHeight() + Math.max(dlVar.wp - viewDl.getBaseline(), zVar.topMargin) + zVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewDl.getMeasuredHeight() + zVar.topMargin + Math.max((dlVar.wp - viewDl.getMeasuredHeight()) + viewDl.getBaseline(), zVar.bottomMargin));
                        }
                    }
                }
                dlVar.e = iMax;
            }
        }
        this.pf.g(i, i2, getPaddingTop() + getPaddingBottom());
        this.pf.z();
        z(this.z, i, i2, this.fv.g);
    }

    private void dl(int i, int i2) {
        this.ls.clear();
        this.fv.z();
        this.pf.g(this.fv, i, i2);
        this.ls = this.fv.z;
        this.pf.z(i, i2);
        this.pf.g(i, i2, getPaddingLeft() + getPaddingRight());
        this.pf.z();
        z(this.z, i, i2, this.fv.g);
    }

    private void z(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getLargestMainSize() {
        Iterator<dl> it = this.ls.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().gc);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.ls.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            dl dlVar = this.ls.get(i4);
            if (a(i4)) {
                if (z()) {
                    i2 = this.kb;
                } else {
                    i2 = this.wp;
                }
                i3 += i2;
            }
            if (m(i4)) {
                if (z()) {
                    i = this.kb;
                } else {
                    i = this.wp;
                }
                i3 += i;
            }
            i3 += dlVar.e;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public boolean z() {
        int i = this.z;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        boolean z3;
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.a();
        }
        int iZ = e.z(this);
        int i5 = this.z;
        if (i5 == 0) {
            z(iZ == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            z(iZ != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z3 = iZ == 1;
            z(this.g == 2 ? !z3 : z3, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z3 = iZ == 1;
            z(this.g == 2 ? !z3 : z3, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.z);
        }
        com.bytedance.adsdk.ugeno.dl dlVar2 = this.p;
        if (dlVar2 != null) {
            dlVar2.z(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.z(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.z(boolean, boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gz == null && this.e == null) {
            return;
        }
        if (this.fo == 0 && this.uy == 0) {
            return;
        }
        int iZ = e.z(this);
        int i = this.z;
        if (i == 0) {
            z(canvas, iZ == 1, this.g == 2);
            return;
        }
        if (i == 1) {
            z(canvas, iZ != 1, this.g == 2);
            return;
        }
        if (i == 2) {
            boolean z2 = iZ == 1;
            if (this.g == 2) {
                z2 = !z2;
            }
            g(canvas, z2, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z3 = iZ == 1;
        if (this.g == 2) {
            z3 = !z3;
        }
        g(canvas, z3, true);
    }

    private void z(Canvas canvas, boolean z2, boolean z3) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.ls.size();
        for (int i3 = 0; i3 < size; i3++) {
            dl dlVar = this.ls.get(i3);
            for (int i4 = 0; i4 < dlVar.gz; i4++) {
                int i5 = dlVar.pf + i4;
                View viewDl = dl(i5);
                if (viewDl != null && viewDl.getVisibility() != 8) {
                    z zVar = (z) viewDl.getLayoutParams();
                    if (a(i5, i4)) {
                        if (z2) {
                            left = viewDl.getRight() + zVar.rightMargin;
                        } else {
                            left = (viewDl.getLeft() - zVar.leftMargin) - this.wp;
                        }
                        z(canvas, left, dlVar.g, dlVar.e);
                    }
                    if (i4 == dlVar.gz - 1 && (this.uy & 4) > 0) {
                        if (z2) {
                            right = (viewDl.getLeft() - zVar.leftMargin) - this.wp;
                        } else {
                            right = viewDl.getRight() + zVar.rightMargin;
                        }
                        z(canvas, right, dlVar.g, dlVar.e);
                    }
                }
            }
            if (a(i3)) {
                if (z3) {
                    i2 = dlVar.f238a;
                } else {
                    i2 = dlVar.g - this.kb;
                }
                g(canvas, paddingLeft, i2, iMax);
            }
            if (m(i3) && (this.fo & 4) > 0) {
                if (z3) {
                    i = dlVar.g - this.kb;
                } else {
                    i = dlVar.f238a;
                }
                g(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void g(Canvas canvas, boolean z2, boolean z3) {
        int i;
        int i2;
        int bottom;
        int top2;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.ls.size();
        for (int i3 = 0; i3 < size; i3++) {
            dl dlVar = this.ls.get(i3);
            for (int i4 = 0; i4 < dlVar.gz; i4++) {
                int i5 = dlVar.pf + i4;
                View viewDl = dl(i5);
                if (viewDl != null && viewDl.getVisibility() != 8) {
                    z zVar = (z) viewDl.getLayoutParams();
                    if (a(i5, i4)) {
                        if (z3) {
                            top2 = viewDl.getBottom() + zVar.bottomMargin;
                        } else {
                            top2 = (viewDl.getTop() - zVar.topMargin) - this.kb;
                        }
                        g(canvas, dlVar.z, top2, dlVar.e);
                    }
                    if (i4 == dlVar.gz - 1 && (this.fo & 4) > 0) {
                        if (z3) {
                            bottom = (viewDl.getTop() - zVar.topMargin) - this.kb;
                        } else {
                            bottom = viewDl.getBottom() + zVar.bottomMargin;
                        }
                        g(canvas, dlVar.z, bottom, dlVar.e);
                    }
                }
            }
            if (a(i3)) {
                if (z2) {
                    i2 = dlVar.dl;
                } else {
                    i2 = dlVar.z - this.wp;
                }
                z(canvas, i2, paddingTop, iMax);
            }
            if (m(i3) && (this.uy & 4) > 0) {
                if (z2) {
                    i = dlVar.z - this.wp;
                } else {
                    i = dlVar.dl;
                }
                z(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void z(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.gz;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.wp + i, i3 + i2);
        this.gz.draw(canvas);
    }

    private void g(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.e;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.kb + i2);
        this.e.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof z;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof z) {
            return new z((z) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new z((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new z(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getFlexDirection() {
        return this.z;
    }

    public void setFlexDirection(int i) {
        if (this.z != i) {
            this.z = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getFlexWrap() {
        return this.g;
    }

    public void setFlexWrap(int i) {
        if (this.g != i) {
            this.g = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.dl;
    }

    public void setJustifyContent(int i) {
        if (this.dl != i) {
            this.dl = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getAlignItems() {
        return this.f235a;
    }

    public void setAlignItems(int i) {
        if (this.f235a != i) {
            this.f235a = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getAlignContent() {
        return this.gc;
    }

    public void setAlignContent(int i) {
        if (this.gc != i) {
            this.gc = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int getMaxLine() {
        return this.m;
    }

    public void setMaxLine(int i) {
        if (this.m != i) {
            this.m = i;
            requestLayout();
        }
    }

    public List<dl> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.ls.size());
        for (dl dlVar : this.ls) {
            if (dlVar.g() != 0) {
                arrayList.add(dlVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int z(View view, int i, int i2) {
        int i3;
        int i4;
        if (z()) {
            i3 = a(i, i2) ? 0 + this.wp : 0;
            if ((this.uy & 4) <= 0) {
                return i3;
            }
            i4 = this.wp;
        } else {
            i3 = a(i, i2) ? 0 + this.kb : 0;
            if ((this.fo & 4) <= 0) {
                return i3;
            }
            i4 = this.kb;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public void z(dl dlVar) {
        if (z()) {
            if ((this.uy & 4) > 0) {
                dlVar.gc += this.wp;
                dlVar.m += this.wp;
                return;
            }
            return;
        }
        if ((this.fo & 4) > 0) {
            dlVar.gc += this.kb;
            dlVar.m += this.kb;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int z(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public int g(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public void z(View view, int i, int i2, dl dlVar) {
        if (a(i, i2)) {
            if (z()) {
                dlVar.gc += this.wp;
                dlVar.m += this.wp;
            } else {
                dlVar.gc += this.kb;
                dlVar.m += this.kb;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public void setFlexLines(List<dl> list) {
        this.ls = list;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.z
    public List<dl> getFlexLinesInternal() {
        return this.ls;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.e;
    }

    public Drawable getDividerDrawableVertical() {
        return this.gz;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.e) {
            return;
        }
        this.e = drawable;
        if (drawable != null) {
            this.kb = drawable.getIntrinsicHeight();
        } else {
            this.kb = 0;
        }
        g();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.gz) {
            return;
        }
        this.gz = drawable;
        if (drawable != null) {
            this.wp = drawable.getIntrinsicWidth();
        } else {
            this.wp = 0;
        }
        g();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.uy;
    }

    public int getShowDividerHorizontal() {
        return this.fo;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.uy) {
            this.uy = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.fo) {
            this.fo = i;
            requestLayout();
        }
    }

    private void g() {
        if (this.e == null && this.gz == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean a(int i, int i2) {
        return gc(i, i2) ? z() ? (this.uy & 1) != 0 : (this.fo & 1) != 0 : z() ? (this.uy & 2) != 0 : (this.fo & 2) != 0;
    }

    private boolean gc(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewDl = dl(i - i3);
            if (viewDl != null && viewDl.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean a(int i) {
        if (i >= 0 && i < this.ls.size()) {
            if (gc(i)) {
                return z() ? (this.fo & 1) != 0 : (this.uy & 1) != 0;
            }
            if (z()) {
                return (this.fo & 2) != 0;
            }
            if ((this.uy & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean gc(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.ls.get(i2).g() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean m(int i) {
        if (i >= 0 && i < this.ls.size()) {
            for (int i2 = i + 1; i2 < this.ls.size(); i2++) {
                if (this.ls.get(i2).g() > 0) {
                    return false;
                }
            }
            if (z()) {
                return (this.fo & 4) != 0;
            }
            if ((this.uy & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class z extends ViewGroup.MarginLayoutParams implements g {
        public static final Parcelable.Creator<z> CREATOR = new Parcelable.Creator<z>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.z.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public z createFromParcel(Parcel parcel) {
                return new z(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public z[] newArray(int i) {
                return new z[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f236a;
        private float dl;
        private int e;
        private int fo;
        private float g;
        private float gc;
        private int gz;
        private int m;
        private boolean uy;
        private int z;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public z(z zVar) {
            super((ViewGroup.MarginLayoutParams) zVar);
            this.z = 1;
            this.g = 0.0f;
            this.dl = 0.0f;
            this.f236a = -1;
            this.gc = -1.0f;
            this.m = -1;
            this.e = -1;
            this.gz = 16777215;
            this.fo = 16777215;
            this.z = zVar.z;
            this.g = zVar.g;
            this.dl = zVar.dl;
            this.f236a = zVar.f236a;
            this.gc = zVar.gc;
            this.m = zVar.m;
            this.e = zVar.e;
            this.gz = zVar.gz;
            this.fo = zVar.fo;
            this.uy = zVar.uy;
        }

        public z(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.z = 1;
            this.g = 0.0f;
            this.dl = 0.0f;
            this.f236a = -1;
            this.gc = -1.0f;
            this.m = -1;
            this.e = -1;
            this.gz = 16777215;
            this.fo = 16777215;
        }

        public z(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.z = 1;
            this.g = 0.0f;
            this.dl = 0.0f;
            this.f236a = -1;
            this.gc = -1.0f;
            this.m = -1;
            this.e = -1;
            this.gz = 16777215;
            this.fo = 16777215;
        }

        public z(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.z = 1;
            this.g = 0.0f;
            this.dl = 0.0f;
            this.f236a = -1;
            this.gc = -1.0f;
            this.m = -1;
            this.e = -1;
            this.gz = 16777215;
            this.fo = 16777215;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int z() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int g() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int dl() {
            return this.z;
        }

        public void dl(int i) {
            this.z = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public float a() {
            return this.g;
        }

        public void z(float f) {
            this.g = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public float gc() {
            return this.dl;
        }

        public void g(float f) {
            this.dl = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int m() {
            return this.f236a;
        }

        public void a(int i) {
            this.f236a = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int e() {
            return this.m;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public void z(int i) {
            this.m = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int gz() {
            return this.e;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public void g(int i) {
            this.e = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int fo() {
            return this.gz;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int uy() {
            return this.fo;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public boolean kb() {
            return this.uy;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public float wp() {
            return this.gc;
        }

        public void dl(float f) {
            this.gc = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int i() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int v() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int pf() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.g
        public int ls() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.z);
            parcel.writeFloat(this.g);
            parcel.writeFloat(this.dl);
            parcel.writeInt(this.f236a);
            parcel.writeFloat(this.gc);
            parcel.writeInt(this.m);
            parcel.writeInt(this.e);
            parcel.writeInt(this.gz);
            parcel.writeInt(this.fo);
            parcel.writeByte(this.uy ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected z(Parcel parcel) {
            super(0, 0);
            this.z = 1;
            this.g = 0.0f;
            this.dl = 0.0f;
            this.f236a = -1;
            this.gc = -1.0f;
            this.m = -1;
            this.e = -1;
            this.gz = 16777215;
            this.fo = 16777215;
            this.z = parcel.readInt();
            this.g = parcel.readFloat();
            this.dl = parcel.readFloat();
            this.f236a = parcel.readInt();
            this.gc = parcel.readFloat();
            this.m = parcel.readInt();
            this.e = parcel.readInt();
            this.gz = parcel.readInt();
            this.fo = parcel.readInt();
            this.uy = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.p = dlVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.z(z2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }
}
