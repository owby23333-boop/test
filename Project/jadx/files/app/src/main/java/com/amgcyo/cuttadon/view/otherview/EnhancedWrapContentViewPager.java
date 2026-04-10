package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class EnhancedWrapContentViewPager extends ViewPager {
    public EnhancedWrapContentViewPager(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            super.onMeasure(i2, i3);
            int i4 = 0;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i4) {
                    i4 = measuredHeight;
                }
            }
            i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public EnhancedWrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
