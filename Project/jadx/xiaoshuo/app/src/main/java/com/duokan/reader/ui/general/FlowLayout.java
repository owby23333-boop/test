package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.yuewen.rt2;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5446b;
    public int c;
    public Set<View> d;

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    public final void b(Set<View> set, int i) {
        for (View view : set) {
            int height = (i - view.getHeight()) / 2;
            view.layout(view.getLeft(), view.getTop() + height, view.getRight(), view.getBottom() + height);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getShowViewCount() {
        return this.f5446b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i7 = this.c;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i15 = childCount;
            int i16 = marginLayoutParams.leftMargin + measuredWidth2 + marginLayoutParams.rightMargin;
            int i17 = i9 + i16;
            if (i17 > measuredWidth) {
                i11++;
                if (i11 >= this.f5445a) {
                    break;
                }
                i12 += i10;
                int iMax = Math.max(0, measuredHeight);
                int i18 = marginLayoutParams.leftMargin;
                childAt.layout(i18 + 0, marginLayoutParams.topMargin + i12, i18 + 0 + measuredWidth2, measuredHeight + i12);
                this.d.clear();
                i6 = measuredWidth;
                i14 = i16;
                i10 = iMax;
            } else {
                int iMax2 = Math.max(measuredHeight, i10);
                if (i7 == 16) {
                    i5 = (iMax2 - measuredHeight) / 2;
                    if (i10 != iMax2) {
                        b(this.d, iMax2);
                    }
                } else {
                    i5 = 0;
                }
                int i19 = marginLayoutParams.leftMargin;
                i6 = measuredWidth;
                int i20 = i5 + i12;
                childAt.layout(i14 + i19, marginLayoutParams.topMargin + i20, i14 + i19 + measuredWidth2, i20 + measuredHeight);
                i10 = iMax2;
                i14 = i17;
            }
            this.d.add(childAt);
            i13++;
            i8++;
            childCount = i15;
            measuredWidth = i6;
            i9 = i14;
        }
        this.f5446b = i13;
        this.d.clear();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int i3 = 0;
        int iMax = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i7 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i3 += i7;
            if (i3 > size) {
                i4++;
                if (i4 >= this.f5445a) {
                    break;
                }
                i5 += iMax;
                iMax = Math.max(0, measuredHeight);
                i3 = i7;
            } else {
                iMax = Math.max(measuredHeight, iMax);
            }
        }
        int i8 = i5 + iMax;
        if (mode != 1073741824) {
            size = i3 + getPaddingLeft() + getPaddingRight();
        }
        setMeasuredDimension(size, i8);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5445a = Integer.MAX_VALUE;
        this.f5446b = 0;
        this.d = new HashSet();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rt2.t.lk);
            this.f5445a = typedArrayObtainStyledAttributes.getInt(rt2.t.pk, this.f5445a);
            this.c = typedArrayObtainStyledAttributes.getInt(rt2.t.mk, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
