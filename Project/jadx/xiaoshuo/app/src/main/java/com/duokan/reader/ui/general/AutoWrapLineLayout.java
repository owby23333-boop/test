package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.yuewen.rt2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AutoWrapLineLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5340b;
    public List<Integer> c;

    public AutoWrapLineLayout(Context context) {
        super(context);
        this.f5339a = 0;
        this.f5340b = 0;
        this.c = new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Integer> it = this.c.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue() + i5;
            int iMax = 0;
            int measuredWidth = 0;
            while (i5 < iIntValue) {
                View childAt = getChildAt(i5);
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                childAt.layout(measuredWidth, i6, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i6);
                measuredWidth += childAt.getMeasuredWidth() + this.f5340b;
                i5++;
            }
            i6 += iMax + this.f5339a;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.clear();
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int iMax = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            measureChild(childAt, i, i2);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            if (measuredWidth > size) {
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight();
            }
            if (i5 + measuredWidth <= size) {
                i5 += measuredWidth + this.f5340b;
                iMax = Math.max(measuredHeight, iMax);
                i4++;
            } else {
                this.c.add(Integer.valueOf(i4));
                i6 += iMax;
                i4 = 1;
                iMax = measuredHeight;
                i5 = measuredWidth + this.f5340b;
            }
        }
        this.c.add(Integer.valueOf(i4));
        Iterator<Integer> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 0) {
                this.c.remove(i3);
            }
            i3++;
        }
        setMeasuredDimension(size, i6 + (this.f5339a * (this.c.size() - 1)) + iMax);
    }

    public void setHorizontalGap(int i) {
        this.f5340b = i;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f5339a = i;
        requestLayout();
    }

    public AutoWrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5339a = 0;
        this.f5340b = 0;
        this.c = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rt2.t.r5);
        this.f5340b = typedArrayObtainStyledAttributes.getDimensionPixelSize(rt2.t.s5, 0);
        this.f5339a = typedArrayObtainStyledAttributes.getDimensionPixelSize(rt2.t.t5, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AutoWrapLineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5339a = 0;
        this.f5340b = 0;
        this.c = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rt2.t.r5);
        this.f5340b = typedArrayObtainStyledAttributes.getDimensionPixelSize(rt2.t.s5, 0);
        this.f5339a = typedArrayObtainStyledAttributes.getDimensionPixelSize(rt2.t.t5, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
